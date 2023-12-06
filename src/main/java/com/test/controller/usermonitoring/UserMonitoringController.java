package com.test.controller.usermonitoring;

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
import com.test.controller.usermonitoring.dto.UserMonitoringDTO;
import com.test.mapper.usermonitoring.IUserMonitoringMapper;
import com.test.services.models.PaginatorCommand;
import com.test.services.usermonitoring.IUserMonitoringService;
import com.test.util.auth.AuthUtil;
import com.test.util.messages.MessagesEnum;
import com.test.util.pager.CustomPage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = { "/user-monitoring" })
@RestController
public class UserMonitoringController {

	private final IUserMonitoringService userMonitoringService;
	private final IUserMonitoringMapper userMonitoringMapper = Mappers.getMapper(IUserMonitoringMapper.class);

	@PreAuthorize("hasAnyAuthority('Admin', 'User')")
	@GetMapping(path = { "/my-monitoring" })
	ResponseEntity<ResponseMessage<CustomPage<UserMonitoringDTO>>> findEachOne(
			@RequestParam(name = RestConstants.PAGE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_PAGE) Integer page,
			@RequestParam(name = RestConstants.SIZE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_SIZE) Integer size) {

		var command = new PaginatorCommand(page, size);

		var userInfo = AuthUtil.getDataFromSession();

		var responsePage = this.userMonitoringService.findById(command, userInfo.getId());

		return ResponseMessageBuilder.buildResponse(userMonitoringMapper.toDtoPage(responsePage),
				MessagesEnum.SUCCESSFULLY_OPERATION);
	}

	@PreAuthorize("hasAnyAuthority('Admin')")
	@GetMapping(path = { "/all" })
	ResponseEntity<ResponseMessage<CustomPage<UserMonitoringDTO>>> findAll(
			@RequestParam(name = RestConstants.PAGE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_PAGE) Integer page,
			@RequestParam(name = RestConstants.SIZE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_SIZE) Integer size) {

		var command = new PaginatorCommand(page, size);

		var responsePage = this.userMonitoringService.getAll(command);

		return ResponseMessageBuilder.buildResponse(userMonitoringMapper.toDtoPage(responsePage),
				MessagesEnum.SUCCESSFULLY_OPERATION);
	}
}
