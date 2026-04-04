package com.spring.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long>{
	
	UserEntity findByUsernameAndIsActive(String username, Boolean isActive);
	
	

}
