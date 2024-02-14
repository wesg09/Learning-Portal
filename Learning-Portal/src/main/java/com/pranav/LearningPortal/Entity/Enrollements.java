package com.pranav.LearningPortal.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "enrollment")
public class Enrollements {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long enrollmentId;

	@ManyToOne()
	private User userEnrolled;

	@ManyToOne()
	private Course courseEnrolled;

}
