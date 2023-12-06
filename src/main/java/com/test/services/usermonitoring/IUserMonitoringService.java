package com.test.services.usermonitoring;

import java.time.LocalDateTime;

import com.test.persistence.entities.usermonitoring.UserMonitoringEntity;
import com.test.services.models.PaginatorCommand;
import com.test.util.pager.CustomPage;

public interface IUserMonitoringService {

	/**
	 * Method to get all registers
	 * 
	 * @param command
	 * @return a CustomPage
	 */
	CustomPage<UserMonitoringEntity> getAll(PaginatorCommand command);

	/**
	 * Method to find registers by user Id
	 * 
	 * @param command
	 * @param id
	 * @return CustomPage
	 */
	CustomPage<UserMonitoringEntity> findById(PaginatorCommand command, String id);

	/**
	 * Method to get registers filtering by email and date
	 * 
	 * @param command
	 * @param email
	 * @param startDate
	 * @param endDate
	 * @return CustomPage
	 */
	CustomPage<UserMonitoringEntity> findByDateAndEmail(PaginatorCommand command, String email, LocalDateTime startDate,
			LocalDateTime endDate);
}
