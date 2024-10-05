package com.ty.hospital_management.hospital_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital_management.hospital_app.entity.Branch;
import com.ty.hospital_management.hospital_app.entity.Patients;
import com.ty.hospital_management.hospital_app.repository.PatientJpa;

@Repository
public class PatientDao {

	@Autowired
	private PatientJpa jpaP;

	public Patients savePatient(Patients patient) {
		return jpaP.save(patient);
	}

	public Patients getPatient(int id) {
		Optional<Patients> opt = jpaP.findById(id);
		Patients patient = opt.isPresent() ? opt.get() : null;
		return patient;
	}

	public boolean deletePatient(int id) {
		Patients patient = getPatient(id);
		if (patient != null) {
			jpaP.deleteById(id);
			return true;
		}
		return false;
	}

	public Patients updatePatient(int id, Patients patient) {
		Patients p = getPatient(id);
		if (p != null) {
			patient.setPatientId(id);
			List<Branch> branches = p.getBranches();
			patient.setBranches(branches);
			Patients saved_patient = savePatient(patient);
			return saved_patient;
		}
		return null;
	}
}
