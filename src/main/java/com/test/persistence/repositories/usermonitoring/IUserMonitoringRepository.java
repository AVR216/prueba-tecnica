package com.test.persistence.repositories.usermonitoring;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.persistence.entities.usermonitoring.UserMonitoringEntity;
import com.test.persistence.repositories.usermonitoring.constants.UsermonitoringRepositoryConstants;

@Repository
public interface IUserMonitoringRepository extends PagingAndSortingRepository<UserMonitoringEntity, String> {

	@Query(value = UsermonitoringRepositoryConstants.CUSTOM_FIND_ALL)
	Page<UserMonitoringEntity> customFindAll(Pageable pageable);

	@Query(value = UsermonitoringRepositoryConstants.FIND_BY_USER_ID)
	Page<UserMonitoringEntity> findByUserId(Pageable pageable, @Param("userId") String userId);

	@Query(value = UsermonitoringRepositoryConstants.FIND_BY_DATE_AND_EMAIL)
	Page<UserMonitoringEntity> findByDateAndEmail(Pageable pageable, @Param("email") String email,
			@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
