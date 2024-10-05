package com.ty.hospital_management.hospital_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospital_management.hospital_app.dao.HospitalDao;
import com.ty.hospital_management.hospital_app.entity.Hospital;
import com.ty.hospital_management.hospital_app.response.ResponseStructure;

@Service
public class HospitalService {

	@Autowired
	private HospitalDao daoH;

	public ResponseStructure<Hospital> saveHospital(Hospital hospital) {
		Hospital h = daoH.saveHospital(hospital);
		ResponseStructure<Hospital> rs = new ResponseStructure<Hospital>();
		rs.setData(h);
		rs.setMessage("Success");
		rs.setValue(HttpStatus.OK.value());
		return rs;
	}

	public Hospital findHospitalById(int id) {
		Optional<Hospital> h = daoH.getHospitalById(id);
		return h.isPresent() ? h.get() : null;
	}

	public Hospital modifyHospital(int id, Hospital hospital) {
		Hospital hospitalToBeModified = findHospitalById(id);
		if (hospitalToBeModified != null) {
			hospital.setHospitalId(id);
			daoH.saveHospital(hospital);
			return hospital;
		} else {
			throw new NullPointerException();
		}
	}

	public Hospital removeHospital(int id) {
		Optional<Hospital> o = daoH.removeHospitalById(id);
		if (o.isPresent()) {
			return o.get();
		} else {
			return null;
		}
	}

	public List<Hospital> getAll() {
		return daoH.getAll();
	}
}
