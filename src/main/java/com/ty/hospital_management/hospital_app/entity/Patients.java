package com.ty.hospital_management.hospital_app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patients {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;
	private String patientName;
	private int patientAge;
	private char patientGender;
	
	@Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$")
	private String patientEmail;
	private String patientAddress;
	private String patientBloodGroup;
	
	@Max(value = 999999999)
	@Min(value = 600000000)
	private long patientPhoneNo;
	
	@OneToMany(mappedBy = "patient",cascade = CascadeType.REMOVE)
	private List<Prescription> prescriptions;
	
	@ManyToMany(mappedBy = "patients",
				cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	@JsonIgnore
	List<Branch> branches;
	
	@OneToMany(cascade = CascadeType.REMOVE,mappedBy = "patient")
	List<Appointment> appointments;
	
}
