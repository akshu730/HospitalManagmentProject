package com.ty.hospital_management.hospital_app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prescriptionId;
	private String dateOfPrescription;
	
	@ManyToMany
	@JoinTable(name = "medical_prescription",joinColumns = @JoinColumn(name="prescription_id"),
				inverseJoinColumns = @JoinColumn(name="medical_id"))
	private List<MedicalItem> medicalItems;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	@JsonIgnore
	private Patients patient;
}
