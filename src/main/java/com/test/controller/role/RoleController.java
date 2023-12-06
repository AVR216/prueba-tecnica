package com.test.controller.role;

import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.config.http.ResponseMessage;
import com.test.config.http.ResponseMessageBuilder;
import com.test.controller.constants.RestConstants;
import com.test.controller.role.dto.RoleDTO;
import com.test.mapper.role.IRoleMapper;
import com.test.security.model.CustomUserDetail;
import com.test.services.models.PaginatorCommand;
import com.test.services.role.IRoleService;
import com.test.util.messages.MessagesEnum;
import com.test.util.pager.CustomPage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = { "/role" })
@RequiredArgsConstructor
public class RoleController {

	private final IRoleService roleService;
	private final IRoleMapper roleMapper = Mappers.getMapper(IRoleMapper.class);

	@PreAuthorize("hasAuthority('Admin')")
	@GetMapping
	ResponseEntity<ResponseMessage<CustomPage<RoleDTO>>> findAll(
			@RequestParam(name = RestConstants.PAGE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_PAGE) Integer page,
			@RequestParam(name = RestConstants.SIZE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_SIZE) Integer size) {

		var userContext = SecurityContextHolder.getContext().getAuthentication();

		var custom = (CustomUserDetail) userContext.getPrincipal();

		var role = getRole(custom);
		
		log.info(role);

		var command = new PaginatorCommand(page, size);

		var responsePage = this.roleService.findAll(command);

		return ResponseMessageBuilder.buildResponse(roleMapper.toDtoPage(responsePage),
				MessagesEnum.SUCCESSFULLY_OPERATION);
	}
	
	private String getRole( CustomUserDetail customUserDetail) {
		return customUserDetail.getAuthorities().stream().findFirst().orElseThrow().toString();
	}
}
