package com.pranav.LearningPortal.Services;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.LearningPortal.DTO.UserDTO;
import com.pranav.LearningPortal.Entity.Course;
import com.pranav.LearningPortal.Entity.User;
import com.pranav.LearningPortal.Repository.CourseRepo;
import com.pranav.LearningPortal.Repository.UserRepo;

@Service
public class FavouriteService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private ModelMapper modelMapper;

	public UserDTO makeCourseFav(Long userId, Long courseId) {
		logger.info("Received request to mark course {} as favorite for user {}", courseId, userId);
		User user = userRepo.findById(userId).get();
		Course course = courseRepo.findById(courseId).get();
		logger.info("User found: {}", user);
		logger.info("Course found: {}", course);

		// Add the course to the user's courses list
		user.getFavourites().add(course);

		// Save the updated user entity, which will automatically persist the change to the enrolled_courses table
		userRepo.save(user);
		logger.info("Course marked as favorite successfully");
		return this.modelMapper.map(user, UserDTO.class);
	}
}
