package com.test.persistence.repositories.session;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.test.persistence.entities.session.SessionEntity;

@Repository
public interface ISessionRepository extends PagingAndSortingRepository<SessionEntity, String> {

}
