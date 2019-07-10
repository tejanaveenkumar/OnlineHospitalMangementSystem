package com.app.dao;

import java.util.List;

import com.app.model.Appointment;

public interface IAppoinmentDao {

	public Integer saveAppoinment(Appointment appoinment);
	public void updateAppoinmenr(Appointment appoinment);
	public void deleteAppoinment(Integer appo_id);
	public Appointment getOneByIdAppoinment(Integer appo_id);
	public List<Appointment> getAllAppoinments();
}
