package com.test.controllers.session;

import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.configuration.http.ResponseMessage;
import com.test.configuration.http.ResponseMessageBuilder;
import com.test.controllers.constants.RestConstants;
import com.test.controllers.session.dto.SessionDTO;
import com.test.mapper.session.ISessionMapper;
import com.test.services.models.PaginatorCommand;
import com.test.services.session.ISessionService;
import com.test.util.messages.MessagesEnum;
import com.test.util.pager.CustomPage;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = { "/session" })
@RequiredArgsConstructor
public class SessionController {

	private final ISessionService sessionService;
	private final ISessionMapper sessionMapper = Mappers.getMapper(ISessionMapper.class);

	@GetMapping
	ResponseEntity<ResponseMessage<CustomPage<SessionDTO>>> findAll(
			@RequestParam(name = RestConstants.PAGE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_PAGE) Integer page,
			@RequestParam(name = RestConstants.SIZE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_SIZE) Integer size) {

		var command = new PaginatorCommand(page, size);

		var responsePage = this.sessionService.getAll(command);

		return ResponseMessageBuilder.buildResponse(sessionMapper.toDtoPage(responsePage),
				MessagesEnum.SUCCESSFULLY_OPERATION);
	}
}
