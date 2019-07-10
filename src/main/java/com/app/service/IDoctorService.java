package com.app.service;

import java.util.List;

import com.app.model.Doctor;

public interface IDoctorService {
	public Integer saveDoctor(Doctor doctor);
	public void updateDoctor(Doctor doctor);
	public void deleteDoctor(Integer doc_Id);
	public Doctor getOneByDoctorId(Integer doc_Id);
	public List<Doctor> getAllDoctor();
}
