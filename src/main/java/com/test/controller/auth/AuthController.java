package com.test.controller.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.controller.auth.dto.UserLoginDTO;
import com.test.services.auth.IAuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = { "/signin" })
@RequiredArgsConstructor
public class AuthController {

	private final IAuthService authService;

	@PostMapping
	ResponseEntity<Map<String, Object>> signin(@RequestBody UserLoginDTO loginInfo) {

		var token = this.authService.getSession(loginInfo.getEmail().trim());

		var response = new HashMap<String, Object>();
		response.put("token", token);

		return ResponseEntity.ok(response);
	}

}
