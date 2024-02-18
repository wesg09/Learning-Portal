package com.pranav.LearningPortal.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.LearningPortal.DTO.CourseDTO;
import com.pranav.LearningPortal.Entity.User;
import com.pranav.LearningPortal.Services.CourseService;
import com.pranav.LearningPortal.Services.UserService;

@RestController
@RequestMapping("/courses")
public class CourseController {

	private CourseService courseService;
	private UserService userService;

	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}

	@GetMapping("/")
	public ResponseEntity<List<CourseDTO>> getAllCourses() {
		logger.info("Received request to get all courses");
		List<CourseDTO> courses = this.courseService.getAllCourses();
		logger.info("Retrieved {} courses", courses.size());
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

	@GetMapping("/{courseId}")
	public ResponseEntity<CourseDTO> getCoursesById(@PathVariable Integer courseId) {
		logger.info("Received request to get course by ID: {}", courseId);
		CourseDTO course = this.courseService.getCourseById(courseId);
		logger.info("Retrieved course: {}", course);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}

	@PostMapping("/{userId}")
	public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO course, @PathVariable Long userId) {
		logger.info("Received request to create course: {} by user {}", course.getCourseName(), userId);
		CourseDTO newCourse = this.courseService.createCourse(course);
		User user = userService.dtoToUser(userService.getUserById(userId));
		newCourse.setAuthor(user);
		logger.info("Course created successfully: {}", newCourse);
		return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
	}

	@DeleteMapping("/{courseId}/{userId}")
	public ResponseEntity<?> deleteCourse(@PathVariable Long courseId, @PathVariable Long userId) {
		logger.info("Received request to delete course ID: {} by user {}", courseId, userId);
		courseService.deleteCourse(courseId);
		logger.info("Course deleted successfully");
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
