package com.ty.hospital_management.hospital_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long appointmentId;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	@JsonIgnore
	private Patients patient;
	private String appointmentDate;
	private String appointmentTime;
	private String doctorName;
	private String status; // scheduled
	
}
