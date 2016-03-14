package com.billing.security;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

public class CsrfTokenResponseHeaderBindingFilter extends OncePerRequestFilter {
	protected static final String REQUEST_ATTRIBUTE_NAME = "_csrf";
	protected static final String RESPONSE_HEADER_NAME = "X-CSRF-HEADER";
	protected static final String RESPONSE_PARAM_NAME = "X-CSRF-PARAM";
	protected static final String RESPONSE_TOKEN_NAME = "X-CSRF-TOKEN";

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		if (token != null) {
			response.setHeader("X-CSRF-HEADER", token.getHeaderName());
			response.setHeader("X-CSRF-PARAM", token.getParameterName());
			response.setHeader("X-CSRF-TOKEN", token.getToken());
		}
		filterChain.doFilter(request, response);
	}
}
