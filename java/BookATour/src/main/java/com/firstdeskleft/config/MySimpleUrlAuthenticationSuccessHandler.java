/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firstdeskleft.config;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author User
 */
public class MySimpleUrlAuthenticationSuccessHandler
        implements AuthenticationSuccessHandler {

    protected Log logger = LogFactory.getLog(this.getClass());

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
            HttpServletResponse response, Authentication authentication)
            throws IOException {

        System.out.println("___________________________________");
        System.out.println("onAuthenticationSuccess:::request :::" + request);
        System.out.println("onAuthenticationSuccess:::response :::" + response);
        System.out.println("onAuthenticationSuccess:::authentication :::" + authentication);
        System.out.println("___________________________________");

        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }

    protected void handle(HttpServletRequest request,
            HttpServletResponse response, Authentication authentication)
            throws IOException {

        System.out.println("___________________________________");
        System.out.println("handle :::request :::" + request);
        System.out.println("handle :::response :::" + response);
        System.out.println("handle :::authentication :::" + authentication);
        System.out.println("___________________________________");

        String targetUrl = determineTargetUrl(authentication);

        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {

        System.out.println("______________________________________");
        System.out.println("determineTargetUrl:::authentication" + authentication);
        System.out.println("______________________________________");

        boolean isGuide = false;
        boolean isCustomer = false;
        boolean isAdmin = false;

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_GUIDE")) {
                isGuide = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_CUSTOMER")) {
                isCustomer = true;
                break;
            }
        }

        if (isAdmin) {
            return "/HomeAdmin";
        } else if (isGuide) {
            return "/HomeGuide";
        } else if (isCustomer) {
            return "/HomeCustomer";
        } else {
            throw new IllegalStateException();
        }
    }

    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        
        System.out.println("______________________________________________");
        System.out.println("clearAuthenticationAttributes:::request" + request);
        System.out.println("______________________________________________");
        
        HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}
