package com.test.security.jwt;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.config.http.ResponseMessage;
import com.test.util.messages.MessagesEnum;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {

	private JwtTokenProvider jwtTokenProvider;

	private static final ObjectMapper mapper = new ObjectMapper();

	public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = request.getHeader("Authorization");

		try {
			if (token != null) {
				var auth = jwtTokenProvider.getAuthentication(token);
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
			filterChain.doFilter(request, response);
		} catch (Exception e) {
			log.error("Auth error", e);
			response.setStatus(MessagesEnum.JWT_USER_NOT_VALID.getCode());
			response.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
			response.getWriter().write(buildErrorResponse(MessagesEnum.JWT_USER_NOT_VALID.name(),
					MessagesEnum.JWT_USER_NOT_VALID.getMessage()));
		}
	}

	private String buildErrorResponse(String errorCode, String errorMessage) {
		try {
			var response = new ResponseMessage<Void>();
			response.setCode(errorCode);
			response.setMessage(errorMessage);
			return mapper.writeValueAsString(response);
		} catch (JsonProcessingException e) {
			return e.getMessage();
		}
	}
}
