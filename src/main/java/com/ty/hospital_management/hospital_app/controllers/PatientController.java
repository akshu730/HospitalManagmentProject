package com.ty.hospital_management.hospital_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital_management.hospital_app.entity.Patients;
import com.ty.hospital_management.hospital_app.response.ResponseStructure;
import com.ty.hospital_management.hospital_app.service.PatientService;

@RestController
@RequestMapping("patients")
public class PatientController {

	@Autowired
	private PatientService ps;

	@PostMapping("save/branchId/{id}")
	public ResponseEntity<ResponseStructure<Patients>> savePatient(@PathVariable int id,
			@RequestBody Patients patient) {
		return ps.savePatient(id, patient);
	}

	@DeleteMapping("delete/patientId/{id}")
	public ResponseEntity<ResponseStructure<Patients>> deletePatient(@PathVariable int id) {
		return ps.deletePatient(id);
	}

	@PutMapping("modify/patientId/{id}")
	public ResponseEntity<ResponseStructure<Patients>> updatePatient(@PathVariable int id,
			@RequestBody Patients patient) {
		return ps.modifyPatient(id, patient);
	}
	
	@GetMapping("get/patientId/{id}")
	public ResponseEntity<ResponseStructure<Patients>> getPatient(@PathVariable int id) {
		return ps.getPatient(id);
	}
}
