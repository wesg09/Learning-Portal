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

	//	public CourseDTO() {
	//		super();
	//	}
	//
	//	public CourseDTO(long courseId, String courseName, String description, User author, CourseCategory category) {
	//		super();
	//		this.courseId = courseId;
	//		this.courseName = courseName;
	//		this.description = description;
	//		this.author = author;
	//		this.category = category;
	//	}
	//
	//	public long getCourseId() {
	//		return courseId;
	//	}
	//
	//	public void setCourseId(long courseId) {
	//		this.courseId = courseId;
	//	}
	//
	//	public String getCourseName() {
	//		return courseName;
	//	}
	//
	//	public void setCourseName(String courseName) {
	//		this.courseName = courseName;
	//	}
	//
	//	public String getDescription() {
	//		return description;
	//	}
	//
	//	public void setDescription(String description) {
	//		this.description = description;
	//	}
	//
	//	public User getAuthor() {
	//		return author;
	//	}
	//
	//	public void setAuthor(User author) {
	//		this.author = author;
	//	}
	//
	//	public CourseCategory getCategory() {
	//		return category;
	//	}
	//
	//	public void setCategory(CourseCategory category) {
	//		this.category = category;
	//	}

}
