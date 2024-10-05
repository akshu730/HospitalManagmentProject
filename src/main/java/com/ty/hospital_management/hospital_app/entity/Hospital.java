package com.ty.hospital_management.hospital_app.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CurrentTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hospitalId;
	
	private String hospitalName;
	
	@Max(value = 999999999)
	@Min(value = 600000000)
	private long hospitalPhone;
	
	@Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$")
	private String hospitalEmail;
	
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.REMOVE ,fetch = FetchType.LAZY,
				mappedBy = "hospital")
	private List<Branch> hospitalBranches;
	
	private String hospitalAddress;
	
	@CurrentTimestamp
	private LocalDateTime creationTime;
	
}
