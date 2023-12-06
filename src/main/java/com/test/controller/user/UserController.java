package com.test.controller.user;

import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.config.http.ResponseMessage;
import com.test.config.http.ResponseMessageBuilder;
import com.test.controller.constants.RestConstants;
import com.test.controller.user.dto.UserDTO;
import com.test.mapper.user.IUserMapper;
import com.test.security.model.CustomUserDetail;
import com.test.services.models.PaginatorCommand;
import com.test.services.user.IUserService;
import com.test.util.auth.AuthUtil;
import com.test.util.messages.MessagesEnum;
import com.test.util.pager.CustomPage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = { "/user" })
@RestController
public class UserController {

	private final IUserService userService;
	private final IUserMapper userMapper = Mappers.getMapper(IUserMapper.class);

	@GetMapping(path = { "/" })
	ResponseEntity<ResponseMessage<CustomPage<UserDTO>>> findAllForUser(
			@RequestParam(name = RestConstants.PAGE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_PAGE) Integer page,
			@RequestParam(name = RestConstants.SIZE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_SIZE) Integer size) {

		var command = new PaginatorCommand(page, size);
		
		var dataFromSession = AuthUtil.getDataFromSession();
		
		var responsePage = this.userService.findAll(command, dataFromSession);

		return ResponseMessageBuilder.buildResponse(userMapper.toDtoPage(responsePage),
				MessagesEnum.SUCCESSFULLY_OPERATION);

	}
}
