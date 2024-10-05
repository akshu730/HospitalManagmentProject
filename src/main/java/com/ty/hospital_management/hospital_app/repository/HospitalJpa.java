package com.ty.hospital_management.hospital_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital_management.hospital_app.entity.Hospital;

public interface HospitalJpa extends JpaRepository<Hospital, Integer> {

}
