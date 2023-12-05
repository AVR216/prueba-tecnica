package com.test.controllers.country;

import org.mapstruct.factory.Mappers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.configuration.http.ResponseMessage;
import com.test.configuration.http.ResponseMessageBuilder;
import com.test.controllers.constants.RestConstants;
import com.test.controllers.country.dto.CountryDTO;
import com.test.mapper.country.ICountryMapper;
import com.test.services.country.ICountryService;
import com.test.services.models.PaginatorCommand;
import com.test.util.messages.MessagesEnum;
import com.test.util.pager.CustomPage;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = { "/country" })
@RequiredArgsConstructor
public class CountryController {

	private final ICountryService countryService;
	private final ICountryMapper countryMapper = Mappers.getMapper(ICountryMapper.class);

	@GetMapping
	ResponseEntity<ResponseMessage<CustomPage<CountryDTO>>> findAll(
			@RequestParam(name = RestConstants.PAGE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_PAGE) Integer page,
			@RequestParam(name = RestConstants.SIZE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_SIZE) Integer size) {

		var command = new PaginatorCommand(page, size);

		var responsePage = this.countryService.getAll(command);

		return ResponseMessageBuilder.buildResponse(countryMapper.toDtoPage(responsePage),
				MessagesEnum.SUCCESSFULLY_OPERATION);
	}
}
