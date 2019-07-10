package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDoctors_AppointmentDao;
import com.app.model.Doctors_Appointment;

@Repository
public class DoctorAppointDaoImpl implements IDoctors_AppointmentDao {
@Autowired
	private HibernateTemplate ht;
	public Integer saveDoctAppoint(Doctors_Appointment doctors_Appointment) {
		return (Integer) ht.save(doctors_Appointment);
	}

	public void updateDoctAppoint(Doctors_Appointment doctors_Appointment) {
ht.update(doctors_Appointment);
	}

	public void deleteDoctAppoint(Integer id) {
Doctors_Appointment d=new Doctors_Appointment();
d.setId(id);
ht.delete(d);
	}
	public Doctors_Appointment getOneByIdDoctAppoint(Integer id) {
		return ht.get(Doctors_Appointment.class, id);
	}

	public List<Doctors_Appointment> getAllDoctAppoints() {
		return ht.loadAll(Doctors_Appointment.class);
	}

}
