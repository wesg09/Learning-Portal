package com.pranav.LearningPortal.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.LearningPortal.Entity.Course;
import com.pranav.LearningPortal.Entity.User;
import com.pranav.LearningPortal.Repository.CourseRepo;
import com.pranav.LearningPortal.Repository.UserRepo;

@Service
public class EnrollmentService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	//	@Autowired
	//	private EnrollmentRepo enrollmentRepo;

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CourseRepo courseRepo;

	//	@Autowired
	//	private ModelMapper modelMapper;

	//	public EnrollmentDTO createEnrollment(EnrollmentDTO enrollmentDto) {
	//		Enrollements enroll = this.modelMapper.map(enrollmentDto, Enrollements.class);
	//		Enrollements savedEnroll = enrollmentRepo.save(enroll);
	//		EnrollmentDTO savedEnrollmentDto = this.modelMapper.map(savedEnroll, EnrollmentDTO.class);
	//		return savedEnrollmentDto;
	//	}

	public void enrollCourse(Long userId, Long courseId) {
		logger.info("Received request to enroll user {} in course {}", userId, courseId);
		User user = userRepo.findById(userId).get();
		Course course = courseRepo.findById(courseId).get();

		// Add the course to the user's courses list
		user.getPublishedCourses().add(course);
		logger.info("User enrolled in course successfully");

	}

}
