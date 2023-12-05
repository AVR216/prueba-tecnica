package com.test.controllers.user;

import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.configuration.http.ResponseMessage;
import com.test.configuration.http.ResponseMessageBuilder;
import com.test.controllers.constants.RestConstants;
import com.test.controllers.user.dto.UserDTO;
import com.test.mapper.user.IUserMapper;
import com.test.services.models.PaginatorCommand;
import com.test.services.user.IUserService;
import com.test.util.messages.MessagesEnum;
import com.test.util.pager.CustomPage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = { "/user" })
@RestController
public class UserController {

	private final IUserService userService;
	private final IUserMapper userMapper = Mappers.getMapper(IUserMapper.class);

	@GetMapping
	ResponseEntity<ResponseMessage<CustomPage<UserDTO>>> findAll(
			@RequestParam(name = RestConstants.PAGE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_PAGE) Integer page,
			@RequestParam(name = RestConstants.SIZE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_SIZE) Integer size) {

		var command = new PaginatorCommand(page, size);

		var responsePage = this.userService.findAll(command);

		return ResponseMessageBuilder.buildResponse(userMapper.toDtoPage(responsePage),
				MessagesEnum.SUCCESSFULLY_OPERATION);
	}
}
