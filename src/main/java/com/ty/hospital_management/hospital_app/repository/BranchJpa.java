package com.ty.hospital_management.hospital_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.hospital_management.hospital_app.entity.Branch;

public interface BranchJpa extends JpaRepository<Branch, Integer> {

}
