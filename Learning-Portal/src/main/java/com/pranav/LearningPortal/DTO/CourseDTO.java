package com.pranav.LearningPortal.DTO;

import com.pranav.LearningPortal.Entity.CourseCategory;
import com.pranav.LearningPortal.Entity.User;

import lombok.Data;

@Data
public class CourseDTO {
	private long courseId;
	private String courseName;
	private String description;
	private User author;
	private CourseCategory category;

}
