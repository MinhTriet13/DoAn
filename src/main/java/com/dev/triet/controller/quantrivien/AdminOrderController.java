package com.dev.triet.controller.quantrivien;


import com.dev.triet.controller.BaseController;
import com.dev.triet.dto.OrderSearchModel;
import com.dev.triet.repository.OrderProductRepository;
import com.dev.triet.service.SaleorderProductsService;
import com.dev.triet.service.SaleorderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminOrderController extends BaseController {
	
	private final SaleorderService saleorderService;

	private final SaleorderProductsService saleorderProductsService;

	private final OrderProductRepository orderProductRepository;

	public AdminOrderController(SaleorderService saleorderService, SaleorderProductsService saleorderProductsService, OrderProductRepository orderProductRepository) {
		this.saleorderService = saleorderService;
		this.saleorderProductsService = saleorderProductsService;
		this.orderProductRepository = orderProductRepository;
	}

	@RequestMapping(value = { "/admin/order" }, method = RequestMethod.GET)
	public String adminOrder(final Model model, final HttpServletRequest request) {
		
		OrderSearchModel searchModel = new OrderSearchModel();
		searchModel.keyword = request.getParameter("keyword");
		searchModel.setPage(getCurrentPage(request));
		
		model.addAttribute("orderWithPaging", saleorderService.search(searchModel));
		model.addAttribute("searchModel", searchModel);

		return "quantrivien/order";
	}
	
	
	@RequestMapping(value = { "/admin/order-product" }, method = RequestMethod.GET)
	public String adminOrderProduct(final Model model, final HttpServletRequest request){
		
		OrderSearchModel searchModel1 = new OrderSearchModel();
		searchModel1.keyword = request.getParameter("keyword");
		searchModel1.setPage(getCurrentPage(request));

		model.addAttribute("orderProductWithPaging", saleorderProductsService.search(searchModel1));
		model.addAttribute("searchModel1", searchModel1);

		return "quantrivien/order-product";
	}

	@GetMapping("/delete-orderProduct/{id}")
	public String deleteOrderProduct(@PathVariable("id") Integer id) {
		orderProductRepository.deleteById(id);
		return "redirect:/admin/order-product";
	}
}


