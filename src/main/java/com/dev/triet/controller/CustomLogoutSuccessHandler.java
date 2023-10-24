package com.dev.triet.controller;

import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class CustomLogoutSuccessHandler extends
        SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {

//    @Autowired
//    private AuditService auditService;
//
//    @Override
//    public void onLogoutSuccess(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            Authentication authentication)
//            throws IOException, ServletException {
//
//        String refererUrl = request.getHeader("Referer");
//        auditService.track("Logout from: " + refererUrl);
//
//        super.onLogoutSuccess(request, response, authentication);
//    }
}
