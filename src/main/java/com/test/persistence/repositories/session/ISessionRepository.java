package com.test.persistence.repositories.session;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.persistence.entities.session.SessionEntity;
import com.test.persistence.repositories.session.constants.SessionRepositoryConstants;

@Repository
public interface ISessionRepository extends PagingAndSortingRepository<SessionEntity, String> {

	@Query(value = SessionRepositoryConstants.FIND_BY_TOKEN)
	Optional<SessionEntity> findBySessionToken(@Param("token") String sessionToken);

	Optional<SessionEntity> findByUserId(String userId);
}
