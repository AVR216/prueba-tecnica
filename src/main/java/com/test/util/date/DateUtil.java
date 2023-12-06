package com.test.util.date;

import java.time.LocalDate;

import com.test.util.messages.ExceptionBuilder;
import com.test.util.messages.MessagesEnum;

public class DateUtil {

	private DateUtil() {
	}

	public static void endDateBefore(LocalDate startDate, LocalDate endDate) {
		if (startDate.isAfter(endDate)) {
			throw ExceptionBuilder.buildException(MessagesEnum.INVALID_DATE);
		}
	}
}
