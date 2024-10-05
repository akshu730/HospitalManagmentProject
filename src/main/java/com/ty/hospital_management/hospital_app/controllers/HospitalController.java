package com.ty.hospital_management.hospital_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospital_management.hospital_app.entity.Hospital;
import com.ty.hospital_management.hospital_app.response.ResponseStructure;
import com.ty.hospital_management.hospital_app.service.HospitalService;

@RestController
@RequestMapping("hospitals")
public class HospitalController {

	@Autowired
	private HospitalService hs;

	@PostMapping("save")
	public ResponseStructure<Hospital> saveHospital(@RequestBody Hospital hospital) {
		return hs.saveHospital(hospital);
	}

	@GetMapping("get")
	public Hospital getHospital(@RequestParam int id) {
		return hs.findHospitalById(id);
	}

	@PutMapping("update")
	public Hospital updateHospital(@RequestParam int id, @RequestBody Hospital hospital) {
		return hs.modifyHospital(id, hospital);
	}

	@DeleteMapping("delete")
	public Hospital removeHospital(@RequestParam int id) {
		return hs.removeHospital(id);
	}

	@GetMapping("getAll")
	public List<Hospital> getAll() {
		return hs.getAll();
	}
}
