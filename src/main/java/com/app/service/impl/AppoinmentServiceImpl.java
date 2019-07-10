package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAppoinmentDao;
import com.app.model.Appointment;
import com.app.service.IAppoinmentService;
@Service
public class AppoinmentServiceImpl  implements IAppoinmentService{
@Autowired
	private IAppoinmentDao dao;
	@Transactional
	public Integer saveAppoinment(Appointment appoinment) {
		
	return dao.saveAppoinment(appoinment);
	}

	@Transactional
	public void updateAppoinmenr(Appointment appoinment) {
		dao.updateAppoinmenr(appoinment);
		
	}

	@Transactional
	public void deleteAppoinment(Integer appo_id) {
		 dao.deleteAppoinment(appo_id);
		}

	@Transactional(readOnly=true)
	public Appointment getOneByIdAppoinment(Integer appo_id) {
		return dao.getOneByIdAppoinment(appo_id);
	}

	@Transactional(readOnly=true)
	public List<Appointment> getAllAppoinments() {
	return dao.getAllAppoinments();
	}

}
