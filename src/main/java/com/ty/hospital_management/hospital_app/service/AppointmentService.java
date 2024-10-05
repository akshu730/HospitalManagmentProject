package com.ty.hospital_management.hospital_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_management.hospital_app.dao.AppointmentDao;
import com.ty.hospital_management.hospital_app.dao.PatientDao;
import com.ty.hospital_management.hospital_app.entity.Appointment;
import com.ty.hospital_management.hospital_app.entity.Patients;
import com.ty.hospital_management.hospital_app.response.ResponseStructure;

@Service
public class AppointmentService {

	@Autowired
	AppointmentDao daoA;

	@Autowired
	PatientDao daoP;

	public ResponseEntity<ResponseStructure<Appointment>> saveAppointment(int id, Appointment appoint) {
		Patients patient = daoP.getPatient(id);
		ResponseStructure<Appointment> rs = new ResponseStructure<Appointment>();
		if (patient != null) {
			System.out.println(appoint.getAppointmentDate());
			System.out.println(appoint.getAppointmentTime());
			System.out.println(appoint.getDoctorName());
			patient.getAppointments().add(appoint);
			appoint.setPatient(patient);
			daoA.saveAppointment(appoint);
			rs.setData(appoint);
			rs.setMessage("Successfully saved");
			rs.setValue(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Appointment>>(rs, HttpStatus.OK);
		} else {
			rs.setData(null);
			rs.setMessage("Patient not found");
			rs.setValue(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Appointment>>(rs, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<Appointment>> removeAppointment(int id) {
		Appointment appoint = daoA.getAppointment(id);
		ResponseStructure<Appointment> rs = new ResponseStructure<Appointment>();
		if (daoA.deleteAppointment(id)) {
			rs.setData(appoint);
			rs.setMessage("Successfully removed");
			rs.setValue(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Appointment>>(rs, HttpStatus.OK);
		} else {
			rs.setData(appoint);
			rs.setMessage("Not found!!");
			rs.setValue(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Appointment>>(rs, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Appointment>> getAppointment(int id) {
		Appointment appoint = daoA.getAppointment(id);
		ResponseStructure<Appointment> rs = new ResponseStructure<Appointment>();
		if (appoint != null) {
			rs.setData(appoint);
			rs.setMessage("Successfull");
			rs.setValue(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Appointment>>(rs, HttpStatus.OK);
		} else {
			rs.setData(null);
			rs.setMessage("Appointment not found");
			rs.setValue(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Appointment>>(rs, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Appointment>> updateAppointment(int id, Appointment appoint) {
		ResponseStructure<Appointment> rs = new ResponseStructure<Appointment>();
		Appointment a = daoA.updateAppointment(id, appoint);
		if (a != null) {
			rs.setData(a);
			rs.setMessage("Successfull");
			rs.setValue(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Appointment>>(rs, HttpStatus.OK);
		} else {
			rs.setData(a);
			rs.setMessage("Not found");
			rs.setValue(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Appointment>>(rs, HttpStatus.NOT_FOUND);
		}
	}
}
