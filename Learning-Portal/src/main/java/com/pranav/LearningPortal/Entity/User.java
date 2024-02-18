package com.pranav.LearningPortal.Entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usertable")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	private String userName;

	private String email;

	private String password;

	private String role;

	@OneToMany(mappedBy = "userEnrolled", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Enrollements> enrolled = new HashSet<>();

	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Course> publishedCourses = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "favourite_courses", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "courseId"))
	private Set<Course> favourites = new HashSet<>();

	//	public User(long userId, String userName, String email, String password, String role, Set<Enrollements> enrolled,
	//			Set<Course> publishedCourses, Set<Course> favourites) {
	//		super();
	//		this.userId = userId;
	//		this.userName = userName;
	//		this.email = email;
	//		this.password = password;
	//		this.role = role;
	//		this.enrolled = enrolled;
	//		this.publishedCourses = publishedCourses;
	//		this.favourites = favourites;
	//	}
	//
	//	public long getUserId() {
	//		return userId;
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
	//	public String getRole() {
	//		return role;
	//	}
	//
	//	public void setRole(String role) {
	//		this.role = role;
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
	//	public Set<Course> getPublishedCourses() {
	//		return publishedCourses;
	//	}
	//
	//	public void setPublishedCourses(Set<Course> publishedCourses) {
	//		this.publishedCourses = publishedCourses;
	//	}
	//
	//	public Set<Course> getFavourites() {
	//		return favourites;
	//	}
	//
	//	public void setFavourites(Set<Course> favourites) {
	//		this.favourites = favourites;
	//	}
	//
	//	public User() {
	//		super();
	//	}

}
