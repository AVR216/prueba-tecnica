package com.test.persistence.repositories.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.test.persistence.entities.user.UserEntity;
import com.test.persistence.repositories.user.constants.UserRepositoryConstants;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<UserEntity, String> {

	@Query(value = UserRepositoryConstants.CUSTOM_FIND_ALL)
	Page<UserEntity> customFindAll(Pageable pageable);

}
