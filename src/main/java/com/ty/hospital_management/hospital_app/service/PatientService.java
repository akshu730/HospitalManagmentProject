package com.ty.hospital_management.hospital_app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_management.hospital_app.dao.BranchDao;
import com.ty.hospital_management.hospital_app.dao.PatientDao;
import com.ty.hospital_management.hospital_app.entity.Branch;
import com.ty.hospital_management.hospital_app.entity.Patients;
import com.ty.hospital_management.hospital_app.response.ResponseStructure;

@Service
public class PatientService {

	@Autowired
	private PatientDao daoP;

	@Autowired
	private BranchDao daoB;

	public ResponseEntity<ResponseStructure<Patients>> savePatient(int id, Patients patient) {
		Branch b = daoB.getBranch(id);
		ResponseStructure<Patients> rs = new ResponseStructure<Patients>();
		if (b != null) {
			if (b.getPatients() == null) {
				b.setPatients(new ArrayList<Patients>());
				b.getPatients().add(patient);
				if (patient.getBranches() == null) {
					patient.setBranches(new ArrayList<Branch>());
					patient.getBranches().add(b);
					daoP.savePatient(patient);

				} else {
					patient.getBranches().add(b);
					daoP.savePatient(patient);
				}

			} else {
				b.getPatients().add(patient);
				if (patient.getBranches() == null) {
					patient.setBranches(new ArrayList<Branch>());
					patient.getBranches().add(b);
					daoP.savePatient(patient);
				} else {
					patient.getBranches().add(b);
					daoP.savePatient(patient);
				}
			}
			rs.setData(patient);
			rs.setMessage("Success");
			rs.setValue(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Patients>>(rs, HttpStatus.OK);
		} else {
			rs.setData(null);
			rs.setMessage("Branch not found!");
			rs.setValue(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Patients>>(rs, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<Patients>> deletePatient(int id) {
		Patients patient = daoP.getPatient(id);
		ResponseStructure<Patients> rs = new ResponseStructure<Patients>();
		if (daoP.deletePatient(id)) {
			rs.setData(patient);
			rs.setMessage("This patient is deleted successfully!!");
			rs.setValue(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Patients>>(rs, HttpStatus.OK);
		} else {
			rs.setData(patient);
			rs.setMessage("Not found");
			rs.setValue(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Patients>>(rs, HttpStatus.OK);
		}

	}

	public ResponseEntity<ResponseStructure<Patients>> modifyPatient(int id, Patients patient) {
		ResponseStructure<Patients> rs = new ResponseStructure<Patients>();
		Patients p = daoP.updatePatient(id, patient);
		if (p != null) {
			rs.setData(p);
			rs.setMessage("Successfull!!");
			rs.setValue(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Patients>>(rs, HttpStatus.OK);
		} else {
			rs.setData(p);
			rs.setMessage("NotFound!!");
			rs.setValue(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Patients>>(rs, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<ResponseStructure<Patients>> getPatient(int id) {
		ResponseStructure<Patients> rs = new ResponseStructure<Patients>();
		Patients patient = daoP.getPatient(id);
		if (patient != null) {
			rs.setData(patient);
			rs.setMessage("Successfull!!");
			rs.setValue(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Patients>>(rs, HttpStatus.OK);
		} else {
			rs.setData(patient);
			rs.setMessage("Not found!!");
			rs.setValue(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Patients>>(rs, HttpStatus.NOT_FOUND);
		}
	}
}
