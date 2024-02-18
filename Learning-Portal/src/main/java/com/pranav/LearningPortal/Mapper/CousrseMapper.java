package com.pranav.LearningPortal.Mapper;

import org.mapstruct.Mapper;

import com.pranav.LearningPortal.DTO.CourseDTO;
import com.pranav.LearningPortal.Entity.Course;

@Mapper
public interface CousrseMapper {

	CourseDTO courseToDto(Course course);

	Course dtoToCourse(CourseDTO courseDto);
}
