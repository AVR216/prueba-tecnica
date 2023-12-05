package com.test.persistence.repositories.role;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.test.persistence.entities.role.RoleEntity;

@Repository
public interface IRoleRepository extends PagingAndSortingRepository<RoleEntity, String>{

}
