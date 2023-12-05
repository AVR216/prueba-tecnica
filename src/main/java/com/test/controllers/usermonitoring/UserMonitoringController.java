package com.test.controllers.usermonitoring;

import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.configuration.http.ResponseMessage;
import com.test.configuration.http.ResponseMessageBuilder;
import com.test.controllers.constants.RestConstants;
import com.test.controllers.usermonitoring.dto.UserMonitoringDTO;
import com.test.mapper.usermonitoring.IUserMonitoringMapper;
import com.test.services.models.PaginatorCommand;
import com.test.services.usermonitoring.IUserMonitoringService;
import com.test.util.messages.MessagesEnum;
import com.test.util.pager.CustomPage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(path = { "/user-monitoring" })
@RestController
public class UserMonitoringController {

	private final IUserMonitoringService userMonitoringService;
	private final IUserMonitoringMapper userMonitoringMapper = Mappers.getMapper(IUserMonitoringMapper.class);

	@GetMapping
	ResponseEntity<ResponseMessage<CustomPage<UserMonitoringDTO>>> findAll(
			@RequestParam(name = RestConstants.PAGE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_PAGE) Integer page,
			@RequestParam(name = RestConstants.SIZE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_SIZE) Integer size) {

		var command = new PaginatorCommand(page, size);

		var responsePage = this.userMonitoringService.getAll(command);

		return ResponseMessageBuilder.buildResponse(userMonitoringMapper.toDtoPage(responsePage),
				MessagesEnum.SUCCESSFULLY_OPERATION);
	}
}
