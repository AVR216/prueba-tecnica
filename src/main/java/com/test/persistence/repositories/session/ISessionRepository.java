package com.test.persistence.repositories.session;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.persistence.entities.session.SessionEntity;

@Repository
public interface ISessionRepository extends PagingAndSortingRepository<SessionEntity, String> {

	@Query(value = "SELECT s FROM SessionEntity s JOIN FETCH s.user su JOIN FETCH su.role WHERE s.sessionToken = :token")
	Optional<SessionEntity> findBySessionToken(@Param("token")String sessionToken);
	
	Optional<SessionEntity> findByUserId(String userId);
}
