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

	private String role;

	@OneToMany(mappedBy = "userEnrolled", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Enrollements> enrolled = new HashSet<>();

	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Course> publishedCourses = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "favourite_courses", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "courseId"))
	private Set<Course> favourites = new HashSet<>();

}
