package com.ty.hospital_management.hospital_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital_management.hospital_app.entity.Branch;
import com.ty.hospital_management.hospital_app.entity.Hospital;
import com.ty.hospital_management.hospital_app.response.ResponseStructure;
import com.ty.hospital_management.hospital_app.service.BranchService;

@RestController
@RequestMapping("branches")
public class BranchController {

	@Autowired
	private BranchService bs;

	@PostMapping("save/hospitalId/{id}")
	public ResponseStructure<Hospital> saveBranch(@PathVariable int id, @RequestBody Branch branch) {
		return bs.saveBranch(id, branch);
	}

	@GetMapping("get/branchId/{id}")
	public ResponseStructure<Branch> getBranch(@PathVariable int id) {
		return bs.getBranch(id);
	}

	@DeleteMapping("delete/branchId/{id}")
	public ResponseEntity<ResponseStructure<Branch>> removeBranch(@PathVariable int id) {
		return bs.deleteBranch(id);
	}

	@PutMapping("update/branchId/{id}")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@PathVariable int id, @RequestBody Branch branch) {
		return bs.updateBranch(id, branch);
	}
	
	@GetMapping("getAll")
	public List<Branch> getAll(){
		return bs.getAllBranches();
	}

}
