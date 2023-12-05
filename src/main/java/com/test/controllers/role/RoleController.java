package com.test.controllers.role;

import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.configuration.http.ResponseMessage;
import com.test.configuration.http.ResponseMessageBuilder;
import com.test.controllers.constants.RestConstants;
import com.test.controllers.role.dto.RoleDTO;
import com.test.mapper.role.IRoleMapper;
import com.test.services.models.PaginatorCommand;
import com.test.services.role.IRoleService;
import com.test.util.messages.MessagesEnum;
import com.test.util.pager.CustomPage;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = { "/role" })
@RequiredArgsConstructor
public class RoleController {

	private final IRoleService roleService;
	private final IRoleMapper roleMapper = Mappers.getMapper(IRoleMapper.class);

	@GetMapping
	ResponseEntity<ResponseMessage<CustomPage<RoleDTO>>> findAll(
			@RequestParam(name = RestConstants.PAGE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_PAGE) Integer page,
			@RequestParam(name = RestConstants.SIZE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_SIZE) Integer size) {

		var command = new PaginatorCommand(page, size);

		var responsePage = this.roleService.findAll(command);

		return ResponseMessageBuilder.buildResponse(roleMapper.toDtoPage(responsePage),
				MessagesEnum.SUCCESSFULLY_OPERATION);
	}
}
