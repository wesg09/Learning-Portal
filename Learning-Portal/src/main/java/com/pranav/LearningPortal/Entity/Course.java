package com.pranav.LearningPortal.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long courseId;

	private String courseName;

	private String description;

	@ManyToOne(fetch = FetchType.EAGER)
	private CourseCategory category;

	@OneToMany(mappedBy = "courseEnrolled", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Enrollements> enrolled = new HashSet<>();

	@ManyToOne(fetch = FetchType.EAGER)
	private User author;

	@ManyToMany(mappedBy = "favourites", fetch = FetchType.LAZY)
	private Set<User> favUsers = new HashSet<>();

	//	public Course(long courseId, String courseName, String description, CourseCategory category,
	//			Set<Enrollements> enrolled, User author, Set<User> favUsers) {
	//		super();
	//		this.courseId = courseId;
	//		this.courseName = courseName;
	//		this.description = description;
	//		this.category = category;
	//		this.enrolled = enrolled;
	//		this.author = author;
	//		this.favUsers = favUsers;
	//	}
	//
	//	public Course() {
	//		super();
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
	//	public CourseCategory getCategory() {
	//		return category;
	//	}
	//
	//	public void setCategory(CourseCategory category) {
	//		this.category = category;
	//	}
	//
	//	public Set<Enrollements> getEnrolled() {
	//		return enrolled;
	//	}
	//
	//	public void setEnrolled(Set<Enrollements> enrolled) {
	//		this.enrolled = enrolled;
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
	//	public Set<User> getFavUsers() {
	//		return favUsers;
	//	}
	//
	//	public void setFavUsers(Set<User> favUsers) {
	//		this.favUsers = favUsers;
	//	}

}
