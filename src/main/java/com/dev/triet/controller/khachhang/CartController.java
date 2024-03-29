package com.dev.triet.controller.khachhang;

import com.dev.triet.controller.BaseController;
import com.dev.triet.dto.Cart;
import com.dev.triet.dto.CartItem;
import com.dev.triet.entities.Product;
import com.dev.triet.entities.Saleorder;
import com.dev.triet.entities.SaleorderProducts;
import com.dev.triet.entities.User;
import com.dev.triet.service.ProductService;
import com.dev.triet.service.SaleorderService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CartController extends BaseController {

	private final ProductService productService;
	
	private final SaleorderService saleOrderService;

	public CartController(ProductService productService, SaleorderService saleOrderService) {
		this.productService = productService;
		this.saleOrderService = saleOrderService;
	}

	@RequestMapping(value = { "/cart/checkout" }, method = RequestMethod.POST)
	public String cartFinish( final HttpServletRequest request) {

		// Thông tin khách hàng
		String customerFullName = request.getParameter("customer_name");
		String customerAddress = request.getParameter("customer_address");
		String customerEmail = request.getParameter("customer_email");
		String customerPhone = request.getParameter("customer_phone");

		// tạo hóa đơn
		Saleorder saleOrder = new Saleorder();
		
//		 kiểm tra xem khách hàng có phải đã login hay chưa?
		if(super.isLogined()) {
			User userLogined = super.getUserLogined();
			saleOrder.setUser(userLogined); //khóa ngoại user_id
			saleOrder.setCustomer_name(userLogined.getUsername());
			saleOrder.setCustomer_email(userLogined.getEmail());
			saleOrder.setCustomer_address(userLogined.getAddress());
//			saleOrder.setCustomer_phone("");
		} else {
			saleOrder.setCustomer_name(customerFullName);
			saleOrder.setCustomer_email(customerEmail);
			saleOrder.setCustomer_address(customerAddress);
			saleOrder.setCustomer_phone(customerPhone);	
		}		

		// mã hóa đơn
		saleOrder.setCode(String.valueOf(System.currentTimeMillis()));

//		if(getUserLogined() != null) {
//			
//		}

		// kết các sản phẩm trong giỏ hàng cho hóa đơn
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart != null) {
			for (CartItem cartItem : cart.getCartItems()) {
				SaleorderProducts saleOrderProducts = new SaleorderProducts();
				saleOrderProducts.setProduct(productService.getById(cartItem.getProductId()));
				saleOrderProducts.setQuality(cartItem.getQuanlity());

				// sử dụng hàm tiện ích add hoặc remove đới với các quan hệ onetomany
				saleOrder.addSaleOrderProducts(saleOrderProducts);
			}
		}

		// lưu vào cơ sở dữ liệu
		saleOrderService.saveOrUpdate(saleOrder);

		// xóa dữ liệu giỏ hàng trong session
		session.setAttribute("cart", null);
		session.setAttribute("totalItems", "0");

		return "redirect:/home";
	}
	
	@RequestMapping(value = { "/cart/view" }, method = RequestMethod.GET)
	public String cartView() {
		return "khachhang/cart";
	}
	
	@GetMapping("cart/remove/{productId}")
	public String removeProduct(final HttpServletRequest request, @PathVariable("productId") int productId) {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		List<CartItem> cartItem = cart.getCartItems();
		
		var index = 0;
		for (int i = 0; i < cartItem.size();i++) {
			if(cartItem.get(i).getProductId() == productId) {
				index = i;
				break;
			}
		}
		cartItem.remove(index);
		this.calculateTotalPrice(request);
		return "redirect:/cart/view";
	}
	
	@RequestMapping(value = { "/ajax/updateQuanlityCart" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_UpdateQuanlityCart( final HttpServletRequest request, final @RequestBody CartItem cartItem) {

		// để lấy session sử dụng thông qua request
		// session tương tự như kiểu Map và được lưu trên main memory.
		HttpSession session = request.getSession();

		// Lấy thông tin giỏ hàng.
		Cart cart = null;
		// kiểm tra xem session có tồn tại đối tượng nào tên là "cart"
		if (session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		// Lấy danh sách sản phẩm có trong giỏ hàng
		List<CartItem> cartItems = cart.getCartItems();

		// kiểm tra nếu có trong giỏ hàng thì tăng số lượng
		int currentProductQuality = 0;
		for (CartItem item : cartItems) {
			if (item.getProductId() == cartItem.getProductId()) {
				currentProductQuality = item.getQuanlity() + 1;
				item.setQuanlity(currentProductQuality);
			}
		}

		// tính tổng tiền
		this.calculateTotalPrice(request);
		
		// trả về kết quả
		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("code", 200);
		jsonResult.put("status", "TC");
		jsonResult.put("totalItems", getTotalItems(request));
		jsonResult.put("currentProductQuality", currentProductQuality);

		session.setAttribute("totalItems", getTotalItems(request));
		return ResponseEntity.ok(jsonResult);
	}
	
	@RequestMapping(value = { "/ajax/truQuanlityCart" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_TruQuanlityCart( final HttpServletRequest request, final @RequestBody CartItem cartItem) {

		HttpSession session = request.getSession();

		Cart cart = null;

		if (session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		List<CartItem> cartItems = cart.getCartItems();

		int ciProductQuality = 0;
		for (CartItem item : cartItems) {
			if (item.getProductId() == cartItem.getProductId()) {
				ciProductQuality = item.getQuanlity() - 1;
				item.setQuanlity(ciProductQuality);
			}
		}

		this.calculateTotalPrice(request);

		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("code", 200);
		jsonResult.put("status", "TC");
		jsonResult.put("totalItems", getTotalItems(request));
		jsonResult.put("ciProductQuality", ciProductQuality);

		session.setAttribute("totalItems", getTotalItems(request));
		return ResponseEntity.ok(jsonResult);
	}
	
		
	@RequestMapping(value = { "/ajax/addToCart" }, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> ajax_AddToCart( final HttpServletRequest request, final @RequestBody CartItem cartItem) {

		HttpSession session = request.getSession();


		Cart cart = null;

		if (session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		List<CartItem> cartItems = cart.getCartItems();

		boolean isExists = false;
		for (CartItem item : cartItems) {
			if (item.getProductId() == cartItem.getProductId()) {
				isExists = true;
				item.setQuanlity(item.getQuanlity() + cartItem.getQuanlity());
			}
		}

		if (!isExists) {
			Product productInDb = productService.getById(cartItem.getProductId());

			cartItem.setProductName(productInDb.getTitle());
			cartItem.setPriceUnit(productInDb.getPrice());

			cart.getCartItems().add(cartItem);
		}

		this.calculateTotalPrice(request);

		Map<String, Object> jsonResult = new HashMap<String, Object>();
		jsonResult.put("code", 200);
		jsonResult.put("status", "TC");
		jsonResult.put("totalItems", getTotalItems(request));

		session.setAttribute("totalItems", getTotalItems(request));
		return ResponseEntity.ok(jsonResult);
	}
	
	private int getTotalItems(final HttpServletRequest request) {
		HttpSession httpSession = request.getSession();

		if (httpSession.getAttribute("cart") == null) {
			return 0;
		}

		Cart cart = (Cart) httpSession.getAttribute("cart");
		List<CartItem> cartItems = cart.getCartItems();

		int total = 0;
		for (CartItem item : cartItems) {
			total += item.getQuanlity();
		}

		return total;
	}

	//
	private void calculateTotalPrice(final HttpServletRequest request) {

		HttpSession session = request.getSession();

		Cart cart = null;
		if (session.getAttribute("cart") != null) {
			cart = (Cart) session.getAttribute("cart");
		} else {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		// Lấy danh sách sản phẩm có trong giỏ hàng
		List<CartItem> cartItems = cart.getCartItems();
		BigDecimal total = BigDecimal.ZERO;
		
		for(CartItem ci : cartItems) {
			total = total.add(ci.getPriceUnit().multiply(BigDecimal.valueOf(ci.getQuanlity())));
		}

		cart.setTotalPrice(total);
	}
}
