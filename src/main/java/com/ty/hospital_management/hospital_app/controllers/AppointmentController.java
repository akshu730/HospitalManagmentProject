package com.ty.hospital_management.hospital_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital_management.hospital_app.entity.Appointment;
import com.ty.hospital_management.hospital_app.response.ResponseStructure;
import com.ty.hospital_management.hospital_app.service.AppointmentService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("appointments")
public class AppointmentController {

	@Autowired
	AppointmentService as;

	@PostMapping("save/patientId/{id}")
	public ResponseEntity<ResponseStructure<Appointment>> saveAppointment(@PathVariable int id,
			@RequestBody Appointment appoint) {
		System.out.println(appoint.getDoctorName());
		return as.saveAppointment(id, appoint);
	}

	@GetMapping("get/appointmentId/{id}")
	public ResponseEntity<ResponseStructure<Appointment>> getAppointment(@PathVariable int id) {
		return as.getAppointment(id);
	}
	
	@DeleteMapping("delete/appointmentId/{id}")
	public ResponseEntity<ResponseStructure<Appointment>> deleteAppointment(@PathVariable int id) {
		return as.removeAppointment(id);
	}
	
	@PutMapping("update/appointmentId/{id}")
	public ResponseEntity<ResponseStructure<Appointment>> updateAppointment(@PathVariable int id,@RequestBody Appointment appoint) {
		return as.updateAppointment(id, appoint);
	}
}
