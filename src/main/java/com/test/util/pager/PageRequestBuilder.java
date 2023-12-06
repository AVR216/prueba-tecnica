package com.test.util.pager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.test.services.models.PaginatorCommand;

/**
 * Clase used to build a CustomPage
 * 
 * @author jhonvillalba
 *
 */
public class PageRequestBuilder {

	private PageRequestBuilder() {

	}

	public static Pageable buildPageRequest(PaginatorCommand command) {
		return PageRequest.of(command.getPage(), command.getSize());
	}

	public static <T> CustomPage<T> buildCustomPage(Page<T> page, PaginatorCommand command) {
		return new CustomPage<>(page.getContent(), command.getPage(), command.getSize(), page.getTotalElements(),
				page.getTotalPages(), page.isLast());
	}
}
