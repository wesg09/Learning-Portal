package com.pranav.LearningPortal.Mapper;

import org.mapstruct.Mapper;

import com.pranav.LearningPortal.DTO.EnrollmentDTO;
import com.pranav.LearningPortal.Entity.Enrollements;

@Mapper
public interface EnrollmentMapper {

	EnrollmentDTO enrollementToDto(Enrollements enrollements);

	Enrollements dtoToEnrollements(EnrollmentDTO enrollmentDto);

}
