package com.dev.triet.controller.khachhang;

import com.dev.triet.controller.BaseController;
import com.dev.triet.dto.ProductSearchModel;
import com.dev.triet.entities.Product;
import com.dev.triet.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CollectionController extends BaseController {

	private final ProductService productService;

	public CollectionController(ProductService productService) {
		this.productService = productService;
	}

	@RequestMapping(value = { "/collection" }, method = RequestMethod.GET)
	public String allProductView(final Model model, final HttpServletRequest request) {
		ProductSearchModel searchModel = new ProductSearchModel();
		searchModel.keyword = request.getParameter("keyword");

		model.addAttribute("productsWithPaging", productService.search(searchModel));
		model.addAttribute("searchModel", searchModel);
		return "khachhang/collection";
	}

	@RequestMapping(value = { "/products/{categoryId}" }, method = RequestMethod.GET)
	public String descriptionProduct(final Model model, @PathVariable("categoryId") int categoryId){
		List<Product> products = productService.getProductsByCategory(categoryId);
		model.addAttribute("products", products);

		return "khachhang/products";
	}


}
