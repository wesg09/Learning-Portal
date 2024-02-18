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

import com.pranav.LearningPortal.DTO.UserDTO;
import com.pranav.LearningPortal.Services.EnrollmentService;
import com.pranav.LearningPortal.Services.FavouriteService;
import com.pranav.LearningPortal.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private UserService userService;
	private FavouriteService favService;
	private EnrollmentService enrollService;

	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUsers() {
		logger.info("Received request to get all users");
		List<UserDTO> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
		logger.info("Received request to create user: {}", user.getUserName());
		UserDTO createUserDto = userService.createUser(user);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
		logger.info("Received request to delete user: {}", userId);
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
		logger.info("Received request to get user by id: {}", userId);
		UserDTO userDto = userService.getUserById(userId);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	@PostMapping("/{userId}/enroll/{courseId}")
	public ResponseEntity<UserDTO> enrollCourse(@PathVariable Long userId, @PathVariable Long courseId) {
		logger.info("Received request to enroll user {} in course {}", userId, courseId);
		enrollService.enrollCourse(userId, courseId);
		UserDTO userDto = userService.getUserById(userId);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	@PostMapping("/{userId}/makefav/{courseId}")
	public ResponseEntity<UserDTO> makeCourseFav(@PathVariable Long userId, @PathVariable Long courseId) {
		logger.info("Received request to make course {} favorite for user {}", courseId, userId);
		UserDTO userDto = favService.makeCourseFav(userId, courseId);
		return new ResponseEntity<>(userDto, HttpStatus.OK);
	}

}
