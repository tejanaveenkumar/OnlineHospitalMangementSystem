package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Doctor;
@Component
public class DoctorValidation implements Validator {

	/*@Autowired
	private IDoctorService service;*/
	@Override
	public boolean supports(Class<?> clazz) {
		return Doctor.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
Doctor doc=(Doctor)target;
if(!Pattern.compile("[A-Z]{3,15}").matcher(doc.getDoctor_Name()).matches()) {
	errors.rejectValue("doctor_Name", null, "please enter the doctor name");
}
if(!Pattern.compile("[A-Za-z]{3,15}").matcher(doc.getAddress()).matches()) {
	errors.rejectValue("address", null, "please enter the Address");
}
if(doc.getGender() == null || "".equals(doc.getGender())) {
	errors.rejectValue("gender", null,"Please choose one gender");
}
if(!Pattern.compile("[0-9]{3,10}").matcher(doc.getContact_Num()).matches()) {
	errors.rejectValue("contact_Num", null, "please enter the number");
}
if(!Pattern.compile("[A-Za-z]{3,15}").matcher(doc.getSpecialization()).matches()) {
	errors.rejectValue("specialization", null, "please enter the Specialization");
}
if(doc.getService_Charges() <= 0 ) {
	errors.rejectValue("service_Charges", null, "Enter service charges");
}



	}

}
