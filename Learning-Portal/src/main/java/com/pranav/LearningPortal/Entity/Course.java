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

}
