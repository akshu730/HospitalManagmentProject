package com.ty.hospital_management.hospital_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital_management.hospital_app.entity.Prescription;

public interface PrescriptionJpa extends JpaRepository<Prescription, Integer> {

}
