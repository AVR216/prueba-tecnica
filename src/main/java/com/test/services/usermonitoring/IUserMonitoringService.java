package com.test.services.usermonitoring;

import com.test.persistence.entities.usermonitoring.UserMonitoringEntity;
import com.test.services.models.PaginatorCommand;
import com.test.util.pager.CustomPage;

public interface IUserMonitoringService {

	CustomPage<UserMonitoringEntity> getAll(PaginatorCommand command);

	CustomPage<UserMonitoringEntity> findById(PaginatorCommand command, String id);
}
