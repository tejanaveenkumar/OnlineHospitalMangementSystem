package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IAppoinmentDao;
import com.app.model.Appointment;

@Repository
public class AppoinmentDaoImpl implements IAppoinmentDao {
@Autowired
	private HibernateTemplate ht;
	
	public Integer saveAppoinment(Appointment appoinment) {
		return (Integer) ht.save(appoinment);
	}

	public void updateAppoinmenr(Appointment appoinment) {
ht.update(appoinment);		
	}

	
	public void deleteAppoinment(Integer appo_id) {
Appointment appoint=new Appointment();
appoint.setId(appo_id);
ht.delete(appoint);
	}

	public Appointment getOneByIdAppoinment(Integer appo_id) {
		return ht.get(Appointment.class, appo_id);
	}

	public List<Appointment> getAllAppoinments() {
		return ht.loadAll(Appointment.class);
	}

}
