package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IPatientDao;
import com.app.model.Doctors_Appointment;
import com.app.model.Patient;

@Repository
public class PatientDaoImpl implements IPatientDao {
@Autowired
	private HibernateTemplate ht;

	public Integer savePatient(Patient patient) {
		return (Integer) ht.save(patient);
	}

	
	public void updatePatient(Patient patient) {
ht.update(patient);
	}

	public void deletePatient(Integer patient_id) {
Patient p=new Patient();
p.setPatient_Id(patient_id);
ht.delete(p);
	}

	public Patient getOneByPatient(Integer patient_id) {
		return ht.get(Patient.class, patient_id);
	}

	public List<Patient> getAllPatients() {
		return ht.loadAll(Patient.class);
	}


	@Override
	public boolean isPatientAlreadyExit(String patient_Name) {
	@SuppressWarnings("unchecked")
	List<Long> countList=(List<Long>)ht.findByCriteria(DetachedCriteria.forClass(Patient.class)
				.setProjection(Projections.rowCount()).add(Restrictions.eq("patient_Name", patient_Name)));
		return countList.get(0)!=0?true:false;
	}


	@Override
	public boolean isConnectedToPatient(Integer patient_Id) {
		@SuppressWarnings("unchecked")
		List<Long> countList=(List<Long>)
		ht.findByCriteria(DetachedCriteria.forClass(Doctors_Appointment.class)
				.setProjection(Projections.rowCount())
				.add(Restrictions.eq("patient.patient_Id", patient_Id)));
		return countList.get(0)!=0?true:false;
	}

}
