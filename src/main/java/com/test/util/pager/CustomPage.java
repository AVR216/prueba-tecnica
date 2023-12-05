package com.test.util.pager;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class used to select only some of the many values provided by the Page class.
 * 
 * @author Jhon Villalba
 *
 * @param <T> Parameter used to define a generic list
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomPage<T> {

	private List<T> content;
	private Integer pagerNumber;
	private Integer pageSize;
	private Long totalElements;
	private Integer totalPages;
	private Boolean isLast;

}
