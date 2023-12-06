package com.test.services.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class used to build a PageRequest
 * 
 * @author jhonvillalba
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginatorCommand {

	private Integer page;
	private Integer size;

}
