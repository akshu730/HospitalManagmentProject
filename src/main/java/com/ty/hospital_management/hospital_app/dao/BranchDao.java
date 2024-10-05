package com.ty.hospital_management.hospital_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital_management.hospital_app.entity.Branch;
import com.ty.hospital_management.hospital_app.entity.Hospital;
import com.ty.hospital_management.hospital_app.repository.BranchJpa;
import com.ty.hospital_management.hospital_app.repository.HospitalJpa;

@Repository
public class BranchDao {

	@Autowired
	private BranchJpa jpa;

	@Autowired
	private HospitalJpa jpaH;

	public Branch saveBranch(Branch branch) {
		return jpa.save(branch);
	}

	public boolean deleteBranch(int id) {
		Branch b = getBranch(id);
		if (b != null) {
			jpa.deleteById(id);
			return true;
		} else
			return false;
	}

	public Branch getBranch(int id) {
		Optional<Branch> o = jpa.findById(id);
		Branch branch = o.isPresent() ? o.get() : null;
		return branch;
	}

	public Branch modifyBranch(int id, Branch branch) {

		Branch b = getBranch(id);
		if (b != null) {
			Hospital h = b.getHospital();
			branch.setBranchId(id);
			branch.setHospital(h);
			Branch saved_branch = saveBranch(branch);
//			h.getHospitalBranches().add(saved_branch);
//			jpaH.save(h);
//			saved_branch.setHospital(h);
			return saved_branch;
		}
		return null;
	}

	public List<Branch> getAllBranches() {
		return jpa.findAll();
	}
}
