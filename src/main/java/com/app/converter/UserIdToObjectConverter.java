package com.app.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.app.model.Patient;
import com.app.service.IPatientService;



@Component
public class UserIdToObjectConverter implements Converter<Object, Patient> {
	@Autowired
	private IPatientService service; 
	
	@Override
	public Patient convert(Object wid) {
		try {
		int id=Integer.parseInt((String)wid);
		return service.getOneByPatient(id);
		}catch(Exception e) {
			return new Patient();
		}
	}
}
