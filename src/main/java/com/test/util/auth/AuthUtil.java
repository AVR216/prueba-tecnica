package com.test.util.auth;

import org.springframework.security.core.context.SecurityContextHolder;
import com.test.persistence.entities.role.RoleEnum;
import com.test.security.model.CustomUserDetail;
import com.test.services.models.UserData;

public class AuthUtil {

	private AuthUtil() {

	}

	public static UserData getDataFromSession() {

		var userContext = SecurityContextHolder.getContext().getAuthentication();
		var custom = (CustomUserDetail) userContext.getPrincipal();
		var role = getRole(custom);

		return new UserData(RoleEnum.valueOf(role), custom.getUserId());
	}

	private static String getRole(CustomUserDetail customUserDetail) {
		return customUserDetail.getAuthorities().stream().findFirst().orElseThrow().toString();
	}
}
