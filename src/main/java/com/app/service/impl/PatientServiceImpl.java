package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IPatientDao;
import com.app.model.Patient;
import com.app.service.IPatientService;
@Service
public class PatientServiceImpl implements IPatientService{
@Autowired
	private IPatientDao dao;
	
    @Transactional
	public Integer savePatient(Patient patient) {
		return dao.savePatient(patient);
	}

	@Transactional
	public void updatePatient(Patient patient) {
		dao.updatePatient(patient);
	}

	@Transactional
	public void deletePatient(Integer patient_id) {
dao.deletePatient(patient_id);		
	}

	@Transactional(readOnly=true)
	public Patient getOneByPatient(Integer patient_id) {
		return dao.getOneByPatient(patient_id);
	}

	@Transactional(readOnly=true)
	public List<Patient> getAllPatients() {
		return dao.getAllPatients();
	}

	@Transactional(readOnly=true)
	public boolean isPatientAlreadyExit(String patient_Name) {
		return dao.isPatientAlreadyExit(patient_Name);
	}

	@Transactional(readOnly=true)
	public boolean isConnectedToPatient(Integer patient_Id) {		
		return dao.isConnectedToPatient(patient_Id);
	}

}
