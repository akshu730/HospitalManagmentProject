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

import com.ty.hospital_management.hospital_app.entity.Prescription;
import com.ty.hospital_management.hospital_app.response.ResponseStructure;
import com.ty.hospital_management.hospital_app.service.PrescriptionService;

@RestController
@RequestMapping("prescriptions")
public class PrescriptionController {

	@Autowired
	private PrescriptionService ps;

	@PostMapping("save/patientId/{id}")
	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(@PathVariable int id,
			@RequestBody Prescription pre) {
		return ps.savePrescription(id, pre);
	}

	@DeleteMapping("delete/prescriptionId/{id}")
	public ResponseEntity<ResponseStructure<Prescription>> deletePrescription(@PathVariable int id) {
		return ps.deletePrescription(id);
	}

	@PutMapping("update/prescriptionId/{id}")
	public ResponseEntity<ResponseStructure<Prescription>> updatePrescription(@PathVariable int id,
			@RequestBody Prescription pre) {
		return ps.updatePrescription(id, pre);
	}

	@GetMapping("get/prescriptionId/{id}")
	public ResponseEntity<ResponseStructure<Prescription>> getPrescription(@PathVariable int id) {
		return ps.getPrescription(id);
	}
}
