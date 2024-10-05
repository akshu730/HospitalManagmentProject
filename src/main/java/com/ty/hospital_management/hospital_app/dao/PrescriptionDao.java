package com.ty.hospital_management.hospital_app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital_management.hospital_app.entity.Prescription;
import com.ty.hospital_management.hospital_app.repository.PrescriptionJpa;

@Repository
public class PrescriptionDao {

	@Autowired
	private PrescriptionJpa jpa;

	public Prescription getPrescription(int id) {
		Optional<Prescription> pre = jpa.findById(id);
		return pre.isPresent() ? pre.get() : null;
	}

	public boolean deletePrescription(int id) {
		Prescription pre = getPrescription(id);
		if (pre != null) {
			jpa.deleteById(id);
			return true;
		}
		return false;
	}

	public Prescription savePrescription(Prescription pre) {
		return jpa.save(pre);
	}

	public Prescription updatePrescription(int id, Prescription pre) {
		Prescription p = getPrescription(id);
		if (p != null) {
			pre.setPrescriptionId(id);
			pre.setPatient(p.getPatient());
			return jpa.save(pre);
		}
		return null;
	}
}
