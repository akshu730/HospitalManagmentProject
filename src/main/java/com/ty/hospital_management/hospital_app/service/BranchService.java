package com.ty.hospital_management.hospital_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.hospital_management.hospital_app.dao.BranchDao;
import com.ty.hospital_management.hospital_app.dao.HospitalDao;
import com.ty.hospital_management.hospital_app.entity.Branch;
import com.ty.hospital_management.hospital_app.entity.Hospital;
import com.ty.hospital_management.hospital_app.response.ResponseStructure;

@Service
public class BranchService {

	@Autowired
	private HospitalDao daoH;

	@Autowired
	private BranchDao daoB;

	public ResponseStructure<Hospital> saveBranch(int id, Branch branch) {
		Optional<Hospital> h = daoH.getHospitalById(id);
		Hospital hospital = h.isPresent() ? h.get() : null;
		ResponseStructure<Hospital> hs = new ResponseStructure<Hospital>();
		if (hospital != null) {
			daoB.saveBranch(branch);
			branch.setHospital(hospital);
			hospital.getHospitalBranches().add(branch);
			daoH.saveHospital(hospital);
			hs.setData(hospital);
			hs.setMessage("Success");
			hs.setValue(HttpStatus.OK.value());
			return hs;
		} else {
			hs.setData(null);
			hs.setMessage("Hospital not found");
			hs.setValue(HttpStatus.NOT_FOUND.value());
			return hs;
		}
	}

	public ResponseStructure<Branch> getBranch(int id) {

		ResponseStructure<Branch> rs = new ResponseStructure<Branch>();
		Branch b = daoB.getBranch(id);
		if (b != null) {
			rs.setData(b);
			rs.setMessage("Success");
			rs.setValue(HttpStatus.OK.value());
			return rs;
		} else {
			rs.setData(null);
			rs.setMessage("Branch Not found");
			rs.setValue(HttpStatus.NOT_FOUND.value());
			return rs;
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> updateBranch(int id, Branch branch) {
		ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
		Branch b = daoB.modifyBranch(id, branch);
		if (b != null) {

			responseStructure.setData(b);
			responseStructure.setMessage("Success");
			responseStructure.setValue(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setData(b);
			responseStructure.setMessage("Not found");
			responseStructure.setValue(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Branch>> deleteBranch(int id) {

		Branch branch = daoB.getBranch(id);
		if (daoB.deleteBranch(id)) {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setData(branch);
			responseStructure.setValue(HttpStatus.OK.value());
			responseStructure.setMessage("success");

			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.OK);
		} else {
			ResponseStructure<Branch> responseStructure = new ResponseStructure<Branch>();
			responseStructure.setData(null);
			responseStructure.setValue(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("not found");

			return new ResponseEntity<ResponseStructure<Branch>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

	public List<Branch> getAllBranches() {
		List<Branch> list = daoB.getAllBranches();
		ResponseStructure<Branch> rs = new ResponseStructure<Branch>();
		return (list != null) ? list : null;
	}
}
