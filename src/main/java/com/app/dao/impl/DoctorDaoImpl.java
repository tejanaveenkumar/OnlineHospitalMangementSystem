package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDoctorDao;
import com.app.model.Doctor;

@Repository
public class DoctorDaoImpl implements IDoctorDao {
@Autowired
	private HibernateTemplate ht;
	
	public Integer saveDoctor(Doctor doctor) {
		return (Integer) ht.save(doctor);
	}

	public void updateDoctor(Doctor doctor) {
ht.update(doctor);
	}

	public void deleteDoctor(Integer doc_Id) {
Doctor d=new Doctor();
d.setDoc_Id(doc_Id);
ht.delete(d);
	}

	public Doctor getOneByDoctorId(Integer doc_Id) {
		return ht.get(Doctor.class, doc_Id);
	}

	public List<Doctor> getAllDoctor() {
		return ht.loadAll(Doctor.class);
	}

}
