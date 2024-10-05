package com.ty.hospital_management.hospital_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_management.hospital_app.dao.PatientDao;
import com.ty.hospital_management.hospital_app.dao.PrescriptionDao;
import com.ty.hospital_management.hospital_app.entity.Patients;
import com.ty.hospital_management.hospital_app.entity.Prescription;
import com.ty.hospital_management.hospital_app.response.ResponseStructure;

@Service
public class PrescriptionService {

	@Autowired
	private PatientDao daoPa;

	@Autowired
	private PrescriptionDao daoPr;

	private ResponseEntity<ResponseStructure<Prescription>> getResponseEntity(Prescription pre, String message,
			HttpStatus hs) {
		ResponseStructure<Prescription> rs = new ResponseStructure<Prescription>();
		rs.setData(pre);
		rs.setMessage(message);
		rs.setValue(hs.value());
		return new ResponseEntity<ResponseStructure<Prescription>>(rs, hs);
	}

	public ResponseEntity<ResponseStructure<Prescription>> getPrescription(int id) {
		Prescription pre = daoPr.getPrescription(id);
		if (pre != null) {
			return getResponseEntity(pre, "Successfull!!", HttpStatus.OK);
		}
		return getResponseEntity(pre, "Prescription not found!!", HttpStatus.NOT_FOUND);

	}

	public ResponseEntity<ResponseStructure<Prescription>> savePrescription(int id, Prescription pre) {
		Patients patient = daoPa.getPatient(id);
		if (patient != null) {
			patient.getPrescriptions().add(pre);
			pre.setPatient(patient);
			daoPr.savePrescription(pre);
			return getResponseEntity(pre, "Successfull", HttpStatus.OK);
		} else {
			return getResponseEntity(null, "Patient not found!!", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Prescription>> deletePrescription(int id) {
		Prescription pre = daoPr.getPrescription(id);
		if (daoPr.deletePrescription(id)) {
			return getResponseEntity(pre, "Successfull!!", HttpStatus.OK);
		}

		return getResponseEntity(pre, "Prescription not found!!", HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<ResponseStructure<Prescription>> updatePrescription(int id, Prescription pre) {
		Prescription p = daoPr.updatePrescription(id, pre);
		if (p != null) {
			return getResponseEntity(pre, "Sunccessfull!!", HttpStatus.OK);
		}

		return getResponseEntity(p, "Prescription not found!!", HttpStatus.NOT_FOUND);
	}
}
