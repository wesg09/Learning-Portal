package com.pranav.LearningPortal.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.LearningPortal.DTO.CourseDTO;
import com.pranav.LearningPortal.Entity.Course;
import com.pranav.LearningPortal.Repository.CourseRepo;

@Service
public class CourseService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private ModelMapper modelMapper;

	public CourseDTO createCourse(CourseDTO courseDto) {
		logger.info("Received request to create course: {}", courseDto.getCourseName());
		Course course = this.modelMapper.map(courseDto, Course.class);
		Course savedCourse = courseRepo.save(course);
		logger.info("Course created successfully: {}", savedCourse);
		CourseDTO savedCourseDto = this.modelMapper.map(savedCourse, CourseDTO.class);
		return savedCourseDto;
	}

	public CourseDTO courseToDto(Course course) {
		return this.modelMapper.map(course, CourseDTO.class);
	}

	public List<CourseDTO> getAllCourses() {
		logger.info("All courses are retrieved");
		List<Course> courses = courseRepo.findAll();
		return courses.stream().map(course -> this.courseToDto(course)).collect(Collectors.toList());
	}

	public void deleteCourse(long courseId) {
		logger.info("Received request to delete course ID: {} ", courseId);
		courseRepo.deleteById(courseId);
		logger.info("Deleted");
	}

	public CourseDTO updateCourse(CourseDTO course) {
		logger.info("Received request to update course");
		Course existingCourse = courseRepo.findById(course.getCourseId()).get();

		existingCourse.setAuthor(course.getAuthor());
		existingCourse.setCategory(course.getCategory());
		existingCourse.setDescription(course.getDescription());
		existingCourse.setCourseName(course.getCourseName());
		Course updatedCourse = courseRepo.save(existingCourse);
		logger.info("Course updated successfully: {}", updatedCourse);
		return courseToDto(updatedCourse);
	}

	public CourseDTO getCourseById(long courseid) {
		Course course = courseRepo.findById(courseid).get();
		logger.error("Course with ID {} is retrieved", courseid);
		return courseToDto(course);
	}

}
