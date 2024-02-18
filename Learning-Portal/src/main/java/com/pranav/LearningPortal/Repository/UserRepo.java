package com.pranav.LearningPortal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pranav.LearningPortal.Entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	@Query(value = "SELECT userName FROM usertable ORDER BY userName", nativeQuery = true)
	public List<String> findAllSortedByNameUsingNative();

}
