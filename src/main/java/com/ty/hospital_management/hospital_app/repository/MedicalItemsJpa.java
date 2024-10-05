package com.ty.hospital_management.hospital_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital_management.hospital_app.entity.MedicalItem;

public interface MedicalItemsJpa extends JpaRepository<MedicalItem, Integer> {

}
