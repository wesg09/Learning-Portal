package com.pranav.LearningPortal.Mapper;

import org.mapstruct.Mapper;

import com.pranav.LearningPortal.DTO.UserDTO;
import com.pranav.LearningPortal.Entity.User;

@Mapper
public interface UserMapper {

	UserDTO userToDto(User user);

	User dtoToUser(UserDTO userDto);

}
