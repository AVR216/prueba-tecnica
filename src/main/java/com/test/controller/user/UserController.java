package com.test.controller.user;

import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.config.http.ResponseMessage;
import com.test.config.http.ResponseMessageBuilder;
import com.test.controller.constants.RestConstants;
import com.test.controller.user.dto.UserDTO;
import com.test.mapper.user.IUserMapper;
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

	@PreAuthorize("hasAnyAuthority('Admin', 'Manager', 'User')")
	@GetMapping(path = { "/my-data" })
	ResponseEntity<ResponseMessage<UserDTO>> findAllForUser(
			@RequestParam(name = RestConstants.PAGE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_PAGE) Integer page,
			@RequestParam(name = RestConstants.SIZE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_SIZE) Integer size) {

		var dataFromSession = AuthUtil.getDataFromSession();

		var responsePage = this.userService.userData(dataFromSession.getId());

		return ResponseMessageBuilder.buildResponse(userMapper.toUserDto(responsePage),
				MessagesEnum.SUCCESSFULLY_OPERATION);

	}

	@PreAuthorize("hasAnyAuthority('Admin', 'Manager')")
	@GetMapping(path = { "/all" })
	ResponseEntity<ResponseMessage<CustomPage<UserDTO>>> findAll(
			@RequestParam(name = RestConstants.PAGE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_PAGE) Integer page,
			@RequestParam(name = RestConstants.SIZE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_SIZE) Integer size) {

		var command = new PaginatorCommand(page, size);

		var responsePage = this.userService.findAll(command);

		return ResponseMessageBuilder.buildResponse(userMapper.toDtoPage(responsePage),
				MessagesEnum.SUCCESSFULLY_OPERATION);

	}

	@PreAuthorize("hasAnyAuthority('Admin')")
	@GetMapping(path = { "/by-email" })
	ResponseEntity<ResponseMessage<UserDTO>> findUserByEmail(
			@RequestParam(name = RestConstants.PAGE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_PAGE) Integer page,
			@RequestParam(name = RestConstants.SIZE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_SIZE) Integer size,
			@RequestParam(name = RestConstants.EMAIL_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_SIZE) String email) {

		var user = this.userService.findByEmail(email.trim());

		return ResponseMessageBuilder.buildResponse(userMapper.toUserDto(user), MessagesEnum.SUCCESSFULLY_OPERATION);

	}
}
