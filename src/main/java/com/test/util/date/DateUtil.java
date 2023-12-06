package com.test.util.date;

import java.time.LocalDate;

import com.test.util.messages.ExceptionBuilder;
import com.test.util.messages.MessagesEnum;

/**
 * Utility class to validate two dates
 * 
 * @author jhonvillalba
 *
 */

public class DateUtil {

	private DateUtil() {
	}

	public static void endDateBefore(LocalDate startDate, LocalDate endDate) {
		if (startDate.isAfter(endDate)) {
			throw ExceptionBuilder.buildException(MessagesEnum.INVALID_DATE);
		}
	}
}
