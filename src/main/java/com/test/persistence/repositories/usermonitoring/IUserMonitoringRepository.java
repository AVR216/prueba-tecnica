package com.test.persistence.repositories.usermonitoring;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.persistence.entities.usermonitoring.UserMonitoringEntity;

@Repository
public interface IUserMonitoringRepository extends PagingAndSortingRepository<UserMonitoringEntity, String> {

	@Query(value = "SELECT ume FROM UserMonitoringEntity ume JOIN FETCH ume.user")
	Page<UserMonitoringEntity> customFindAll(Pageable pageable);

	@Query(value = "SELECT ume FROM UserMonitoringEntity ume JOIN FETCH ume.user u WHERE u.id = :userId")
	Page<UserMonitoringEntity> findByUserId(Pageable pageable, @Param("userId") String userId);
}
