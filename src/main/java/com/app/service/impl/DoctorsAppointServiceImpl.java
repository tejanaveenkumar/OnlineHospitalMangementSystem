package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDoctors_AppointmentDao;
import com.app.model.Doctors_Appointment;
import com.app.service.IDoctorsAppointService;

@Service
public class DoctorsAppointServiceImpl implements IDoctorsAppointService {
@Autowired
	private IDoctors_AppointmentDao  dao;
@Transactional
	public Integer saveDoctAppoint(Doctors_Appointment doctors_Appointment) {
		return dao.saveDoctAppoint(doctors_Appointment);
	}
@Transactional
	public void updateDoctAppoint(Doctors_Appointment doctors_Appointment) {
		dao.updateDoctAppoint(doctors_Appointment);
	}
@Transactional
	public void deleteDoctAppoint(Integer id) {
dao.deleteDoctAppoint(id);		
	}
@Transactional(readOnly=true)
	public Doctors_Appointment getOneByIdDoctAppoint(Integer id) {
		return dao.getOneByIdDoctAppoint(id);
	}
@Transactional(readOnly=true)
	public List<Doctors_Appointment> getAllDoctAppoints() {
		return dao.getAllDoctAppoints();
	}

}
