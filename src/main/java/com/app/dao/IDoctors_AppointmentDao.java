package com.app.dao;

import java.util.List;

import com.app.model.Doctors_Appointment;

public interface IDoctors_AppointmentDao {

	public Integer saveDoctAppoint(Doctors_Appointment doctors_Appointment);
	public void updateDoctAppoint(Doctors_Appointment doctors_Appointment);
	public void deleteDoctAppoint(Integer id);
	public Doctors_Appointment getOneByIdDoctAppoint(Integer id);
	public List<Doctors_Appointment> getAllDoctAppoints();
	
}
