package com.pranav.LearningPortal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.LearningPortal.Entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
