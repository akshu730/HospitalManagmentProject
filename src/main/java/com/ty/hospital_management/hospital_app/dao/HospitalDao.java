package com.ty.hospital_management.hospital_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital_management.hospital_app.entity.Hospital;
import com.ty.hospital_management.hospital_app.repository.HospitalJpa;

@Repository
public class HospitalDao {

	@Autowired
	private HospitalJpa hr;

	public Hospital saveHospital(Hospital h) {
		return hr.save(h);
	}

	public Optional<Hospital> getHospitalById(int id) {
		return hr.findById(id);
	}

	public Optional<Hospital> removeHospitalById(int id) {
		Optional<Hospital> o = getHospitalById(id);
		if (o.isPresent()) {
			hr.deleteById(id);
			return o;
		}

		return null;
	}

	public Hospital updateHospitalByEntity(Hospital hospital) {
		return hr.save(hospital);
	}

	public List<Hospital> getAll() {
		return hr.findAll();
	}
}
