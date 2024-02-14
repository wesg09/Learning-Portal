package com.pranav.LearningPortal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.LearningPortal.Entity.Course;

public interface CourseRepo extends JpaRepository<Course, Long> {

}
