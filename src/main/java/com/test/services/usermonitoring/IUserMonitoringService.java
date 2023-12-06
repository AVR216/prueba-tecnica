package com.test.services.usermonitoring;

import java.time.LocalDateTime;

import com.test.persistence.entities.usermonitoring.UserMonitoringEntity;
import com.test.services.models.PaginatorCommand;
import com.test.util.pager.CustomPage;

public interface IUserMonitoringService {

	CustomPage<UserMonitoringEntity> getAll(PaginatorCommand command);

	CustomPage<UserMonitoringEntity> findById(PaginatorCommand command, String id);

	CustomPage<UserMonitoringEntity> findByDateAndEmail(PaginatorCommand command, String email, LocalDateTime startDate,
			LocalDateTime endDate);
}
