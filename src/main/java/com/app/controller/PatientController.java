package com.app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Patient;
import com.app.service.IPatientService;
import com.app.validator.PatientValidator;
import com.app.view.PatientExcelView;
import com.app.view.PatientPdfView;

@Controller
@RequestMapping("/patient")
public class PatientController {
	private static final Logger log=Logger.getLogger(Patient.class);
	@Autowired
private IPatientService service;
@Autowired
private PatientValidator validator;

	@RequestMapping("/register")
	public String showReg(ModelMap map) {
	map.addAttribute("patient", new Patient());
		return "PatientRegister";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String showData(@ModelAttribute Patient patient,Errors errors,ModelMap map) {
		log.info("enter into save method");
		validator.validate(patient, errors);
		log.info("validation completed");
		if(!errors.hasErrors()) {
			try {
				Integer patient_Id=service.savePatient(patient);
log.debug("patient created id:"+patient_Id);
			} catch (Exception e) {
				log.error("Exception"+e.getMessage());
				map.addAttribute("message", "problem in operation");
			}
		}
		log.info("About to leave save code");
		map.addAttribute("patient", new Patient());
		return "PatientRegister";
	}
	@RequestMapping("/all")
public String showData(ModelMap map) {
		List<Patient> patients=service.getAllPatients();
		map.addAttribute("patients", patients);
		return "PatientData";
	}
	/*@RequestMapping("/delete")
	public String deleteData(@RequestParam("id") Integer patient_Id,ModelMap map) {
		service.deletePatient(patient_Id);
		String msg="Patient '"+patient_Id+"'deleted";
		List<Patient> patients=service.getAllPatients();
		map.addAttribute("message", msg);
		map.addAttribute("patients", patients);
		return "PatientData";
	}*/
@RequestMapping("/delete")	
public String deleteData(@RequestParam("id") Integer patient_Id,ModelMap map) {
	String message=null;
	try {
	     if(service.isConnectedToPatient(patient_Id)) {
	    	 message="Patient '"+patient_Id+"' Used in other Operations can't be deleted ";
	     }else {
	    	 service.deletePatient(patient_Id);
				message="Patient '"+patient_Id+"' deleted successfully";

	     }

	} catch (HibernateOptimisticLockingFailureException e) {
		message="Patient '"+patient_Id+"' Not Found";
	}
	map.addAttribute("message",message );
	List<Patient> patients=service.getAllPatients();
	map.addAttribute("patients", patients);
	return "PatientData";
}
@RequestMapping("edit")
	public String editData(@RequestParam("id") Integer patient_Id,ModelMap map) {
		Patient patient=service.getOneByPatient(patient_Id);
		map.addAttribute("patient", patient);
		return "PatientEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateData(@ModelAttribute Patient patient,ModelMap map) {
		service.updatePatient(patient);
		String msg="Patient '"+patient.getPatient_Id()+"'updated";
		List<Patient> patients=service.getAllPatients();		
		map.addAttribute("message", msg);
		map.addAttribute("patients", patients);
		return "PatientData";
	}
	
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<Patient> patients=service.getAllPatients();
		ModelAndView mav=new ModelAndView();
		mav.setView(new PatientExcelView());
		mav.addObject("patients", patients);
		return mav;
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		ModelAndView mav=new ModelAndView();
		List<Patient> patients=service.getAllPatients();
		mav.setView(new PatientPdfView());
		mav.addObject("patients", patients);
		return mav;
		
	}
}








