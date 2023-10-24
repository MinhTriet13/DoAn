package com.dev.triet.controller.quantrivien;


import com.dev.triet.controller.BaseController;
import com.dev.triet.dto.UserSearchModel;
import com.dev.triet.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminUserController extends BaseController {

	private final UserService userService;

	public AdminUserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = { "/admin/user/list","/admin/user" }, method = RequestMethod.GET)
	public String adminProductList(final Model model, final HttpServletRequest request) {
		
		UserSearchModel searchModel = new UserSearchModel();
		searchModel.keyword = request.getParameter("keyword");
		searchModel.setPage(getCurrentPage(request));
		searchModel.roleId = super.getInteger(request, "roleId");
		
		model.addAttribute("userWithPaging", userService.search(searchModel));
		model.addAttribute("searchModel", searchModel);
		
		return "quantrivien/user";
	}

	

}
