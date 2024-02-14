package com.pranav.LearningPortal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.LearningPortal.Entity.CourseCategory;

public interface CategoryRepo extends JpaRepository<CourseCategory, Long> {

}
