package com.pranav.LearningPortal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.LearningPortal.Entity.Enrollements;
import com.pranav.LearningPortal.Entity.User;

public interface EnrollmentRepo extends JpaRepository<Enrollements, Long> {

}
