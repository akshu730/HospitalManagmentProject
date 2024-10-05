package com.ty.hospital_management.hospital_app.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospital_management.hospital_app.entity.Appointment;
import com.ty.hospital_management.hospital_app.repository.AppointmentJpa;

@Repository
public class AppointmentDao {

	@Autowired
	AppointmentJpa jpa;

	public Appointment saveAppointment(Appointment appoint) {
		return jpa.save(appoint);
	}

	public Appointment getAppointment(int id) {
		Optional<Appointment> o = jpa.findById(id);
		return o.isPresent() ? o.get() : null;
	}
	
	public boolean deleteAppointment(int id) {
		Appointment appoint = getAppointment(id);
		if(appoint!=null)
		{
			jpa.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Appointment updateAppointment(int id,Appointment appoint) {
		Appointment a = getAppointment(id);
		if(a!=null)
		{
			appoint.setAppointmentId(id);
			appoint.setPatient(a.getPatient());
			return jpa.save(appoint);
		}
		return null;
	}
}
