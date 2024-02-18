package com.pranav.LearningPortal.DTO;

import java.util.ArrayList;
import java.util.List;

import com.pranav.LearningPortal.Entity.Course;

import lombok.Data;

@Data
public class UserDTO {
	private long userId;
	private String userName;
	private String email;
	private String password;

	private List<Course> courses = new ArrayList<Course>();
	private List<Course> favcourses = new ArrayList<Course>();

	//	public long getUserId() {
	//		return userId;
	//	}
	//
	//	public UserDTO(long userId, String userName, String email, String password, List<Course> courses,
	//			List<Course> favcourses) {
	//		super();
	//		this.userId = userId;
	//		this.userName = userName;
	//		this.email = email;
	//		this.password = password;
	//		this.courses = courses;
	//		this.favcourses = favcourses;
	//	}
	//
	//	public UserDTO() {
	//		super();
	//	}
	//
	//	public void setUserId(long userId) {
	//		this.userId = userId;
	//	}
	//
	//	public String getUserName() {
	//		return userName;
	//	}
	//
	//	public void setUserName(String userName) {
	//		this.userName = userName;
	//	}
	//
	//	public String getEmail() {
	//		return email;
	//	}
	//
	//	public void setEmail(String email) {
	//		this.email = email;
	//	}
	//
	//	public String getPassword() {
	//		return password;
	//	}
	//
	//	public void setPassword(String password) {
	//		this.password = password;
	//	}
	//
	//	public List<Course> getCourses() {
	//		return courses;
	//	}
	//
	//	public void setCourses(List<Course> courses) {
	//		this.courses = courses;
	//	}
	//
	//	public List<Course> getFavcourses() {
	//		return favcourses;
	//	}
	//
	//	public void setFavcourses(List<Course> favcourses) {
	//		this.favcourses = favcourses;
	//	}

}