package com.test.services.usermonitoring.imp;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.persistence.entities.usermonitoring.UserMonitoringEntity;
import com.test.persistence.repositories.usermonitoring.IUserMonitoringRepository;
import com.test.services.models.PaginatorCommand;
import com.test.services.usermonitoring.IUserMonitoringService;
import com.test.util.pager.CustomPage;
import com.test.util.pager.PageRequestBuilder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserMonitoringService implements IUserMonitoringService {

	private final IUserMonitoringRepository userMonitoringRepository;

	@Transactional(readOnly = true)
	@Override
	public CustomPage<UserMonitoringEntity> getAll(PaginatorCommand command) {

		var page = this.userMonitoringRepository.customFindAll(PageRequestBuilder.buildPageRequest(command));

		return PageRequestBuilder.buildCustomPage(page, command);
	}

	@Transactional(readOnly = true)
	@Override
	public CustomPage<UserMonitoringEntity> findById(PaginatorCommand command, String id) {
		var page = this.userMonitoringRepository.findByUserId(PageRequestBuilder.buildPageRequest(command), id);
		return PageRequestBuilder.buildCustomPage(page, command);
	}

	@Transactional(readOnly = true)
	@Override
	public CustomPage<UserMonitoringEntity> findByDateAndEmail(PaginatorCommand command, String email,
			LocalDateTime startDate, LocalDateTime endDate) {

		var page = this.userMonitoringRepository.findByDateAndEmail(PageRequestBuilder.buildPageRequest(command), email,
				startDate, endDate);

		return PageRequestBuilder.buildCustomPage(page, command);
	}

}
