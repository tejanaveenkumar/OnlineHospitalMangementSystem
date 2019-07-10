package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDoctorDao;
import com.app.model.Doctor;
import com.app.service.IDoctorService;
@Service
public class DoctorServiceImpl implements IDoctorService {
@Autowired
	private IDoctorDao dao;

@Transactional
	public Integer saveDoctor(Doctor doctor) {
		return dao.saveDoctor(doctor);
	}
@Transactional
	public void updateDoctor(Doctor doctor) {
dao.updateDoctor(doctor);
	}
@Transactional
	public void deleteDoctor(Integer doc_Id) {
dao.deleteDoctor(doc_Id);
	}
@Transactional(readOnly=true)
	public Doctor getOneByDoctorId(Integer doc_Id) {
		return dao.getOneByDoctorId(doc_Id);
	}
@Transactional(readOnly=true)
	public List<Doctor> getAllDoctor() {
		return dao.getAllDoctor();
	}

}
