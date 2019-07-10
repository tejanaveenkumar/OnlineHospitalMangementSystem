package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Patient;
import com.app.service.IPatientService;
@Component
public class PatientValidator implements Validator{
@Autowired
	private IPatientService service;
	@Override
	public boolean supports(Class<?> clazz) {
		return Patient.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Patient p=(Patient)target;
		if(!Pattern.compile("[A-Z]{3,10}").matcher(p.getPatient_Name()).matches()) {
		errors.rejectValue("patient_Name", null, "please Enter Valid code(3 to 10 Uppercase only Ex:SRINIVAS)");
	}else if(service.isPatientAlreadyExit(p.getPatient_Name())) {
		errors.rejectValue("patient_Name", null, "Patient Already Exist Please use another one");

	}
		
		
		/*if(!Pattern.compile("^(?:(?:31(\\\\/|-|\\\\.)(?:0?[13578]|1[02]|(?:Jan|Mar|May|Jul|Aug|Oct|Dec)))\\\\1|(?:(?:29|30)(\\\\/|-|\\\\.)(?:0?[1,3-9]|1[0-2]|(?:Jan|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec))\\\\2))(?:(?:1[6-9]|[2-9]\\\\d)?\\\\d{2})$|^(?:29(\\\\/|-|\\\\.)(?:0?2|(?:Feb))\\\\3(?:(?:(?:1[6-9]|[2-9]\\\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\\\d|2[0-8])(\\\\/|-|\\\\.)(?:(?:0?[1-9]|(?:Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep))|(?:1[0-2]|(?:Oct|Nov|Dec)))\\\\4(?:(?:1[6-9]|[2-9]\\\\d)?\\\\d{2})$").matcher(p.getDob()).matches()) {
			errors.rejectValue("dob", null, "please Enter date of birth");
		}*/
		///radio  box
		if(p.getSex() == null || "".equals(p.getSex())) {
			errors.rejectValue("sex", null,"Please choose one gender");
		}
		//text area
		if("".equals(p.getAddress().trim())) {
			errors.rejectValue("address", null, "Please enter Address");
		}
		//text 
		if(!Pattern.compile("[A-Za-z]{3,15}").matcher(p.getCity()).matches()) {
			errors.rejectValue("city", null, "please Enter city");
		}
		if(!Pattern.compile("[A-Za-z]{3,15}").matcher(p.getState()).matches()) {
			errors.rejectValue("state", null, "please Enter State");
		}
		//check boxes and multi-select dropdown
				if(p.getService_type()==null || p.getService_type().isEmpty()) {
					errors.rejectValue("service_type", null,"Please choose at least one option service_type");
				}
		
		
		
}
	
	
	
}