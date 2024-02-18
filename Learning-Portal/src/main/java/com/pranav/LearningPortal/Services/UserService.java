package com.pranav.LearningPortal.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.pranav.LearningPortal.DTO.UserDTO;
import com.pranav.LearningPortal.Entity.User;
import com.pranav.LearningPortal.Repository.UserRepo;

public class UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	public UserDTO userToDto(User user) {
		return this.modelMapper.map(user, UserDTO.class);
	}

	public User dtoToUser(UserDTO userDto) {
		return this.modelMapper.map(userDto, User.class);
	}

	public UserDTO getUserById(long id) {
		logger.info("Received request to get user with ID: {}", id);
		User user = userRepo.findById(id).get();
		logger.info("User found: {}", user);
		return userToDto(user);
	}

	public UserDTO createUser(UserDTO userDto) {
		logger.info("Received request to create user: {}", userDto.getUserName());
		User user = dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		logger.info("User created successfully: {}", savedUser);
		return this.userToDto(savedUser);
	}

	public List<UserDTO> getAllUsers() {
		logger.info("Received request to get all users");
		List<User> users = userRepo.findAll();
		logger.info("Found {} users", users.size());
		return users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
	}

	public UserDTO updateUser(UserDTO user) {
		logger.info("Received request to update user ");
		User existingUser = userRepo.findById(user.getUserId()).get();
		logger.info("User found: {}", existingUser);
		existingUser.setUserName(user.getUserName());
		existingUser.setPassword(user.getPassword());
		User updatedUser = userRepo.save(existingUser);
		logger.info("User updated successfully: {}", updatedUser);
		return userToDto(updatedUser);
	}

	public void deleteUser(long userId) {
		logger.info("Received request to delete user with ID: {}", userId);
		userRepo.deleteById(userId);
		logger.info("User deleted successfully");
	}

	public List<String> findAllSortedByName() {
		List<String> users = userRepo.findAllSortedByNameUsingNative();
		return users;
	}
}
