package com.ty.hospital_management.hospital_app.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class MedicalItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicalItemId;
	private String name;
	
	@ManyToMany(mappedBy = "medicalItems")
	private List<Prescription> prescriptions;
}
