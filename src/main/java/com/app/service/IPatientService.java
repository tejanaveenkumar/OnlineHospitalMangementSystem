package com.app.service;

import java.util.List;

import com.app.model.Patient;

public interface IPatientService {
	public Integer savePatient(Patient patient);
	public void updatePatient(Patient patient);
	public void deletePatient(Integer patient_id);
	public Patient getOneByPatient(Integer patient_id);
	public List<Patient> getAllPatients();
	public boolean isPatientAlreadyExit(String patient_Name);
	public boolean isConnectedToPatient(Integer patient_Id);
}
