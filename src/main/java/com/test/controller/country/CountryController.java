package com.test.controller.country;

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
import com.test.controller.country.dto.CountryDTO;
import com.test.mapper.country.ICountryMapper;
import com.test.services.country.ICountryService;
import com.test.services.models.PaginatorCommand;
import com.test.util.auth.AuthUtil;
import com.test.util.messages.MessagesEnum;
import com.test.util.pager.CustomPage;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = { "/country" })
@RequiredArgsConstructor
public class CountryController {

	private final ICountryService countryService;
	private final ICountryMapper countryMapper = Mappers.getMapper(ICountryMapper.class);

	@PreAuthorize("hasAnyAuthority('Admin', 'Manager')")
	@GetMapping(path = { "/all-countries" })
	ResponseEntity<ResponseMessage<CustomPage<CountryDTO>>> findAllCountries(
			@RequestParam(name = RestConstants.PAGE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_PAGE) Integer page,
			@RequestParam(name = RestConstants.SIZE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_SIZE) Integer size) {

		var command = new PaginatorCommand(page, size);

		var responsePage = this.countryService.getAll(command);

		return ResponseMessageBuilder.buildResponse(countryMapper.toDtoPage(responsePage),
				MessagesEnum.SUCCESSFULLY_OPERATION);

	}

	@PreAuthorize("hasAnyAuthority('Admin', 'Manager', 'User')")
	@GetMapping(path = { "/my-countries" })
	ResponseEntity<ResponseMessage<CustomPage<CountryDTO>>> findAllById(
			@RequestParam(name = RestConstants.PAGE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_PAGE) Integer page,
			@RequestParam(name = RestConstants.SIZE_PARAM_NAME, required = false, defaultValue = RestConstants.DEFAULT_SIZE) Integer size) {

		var command = new PaginatorCommand(page, size);

		var userData = AuthUtil.getDataFromSession();

		var responsePage = this.countryService.findAllById(command, userData.getId());

		return ResponseMessageBuilder.buildResponse(countryMapper.toDtoPage(responsePage),
				MessagesEnum.SUCCESSFULLY_OPERATION);
	}
}
