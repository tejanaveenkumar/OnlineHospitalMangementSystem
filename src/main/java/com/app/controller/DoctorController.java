package com.app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Doctor;
import com.app.service.IDoctorService;
import com.app.validator.DoctorValidation;
import com.app.view.DoctorExcelView;
import com.app.view.DoctorPdfView;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
	private static final Logger log=Logger.getLogger(Doctor.class);
	@Autowired
	private IDoctorService service;
@Autowired
private DoctorValidation validator;
@RequestMapping("/register")
public String showReg(ModelMap map) {
	map.addAttribute("doctor",new Doctor());
	return "DoctorRegister";	
}
@RequestMapping(value="/insert",method=RequestMethod.POST)
public String showData(@ModelAttribute Doctor doctor,Errors errors,ModelMap map) {
	log.info("enter into save method");
	validator.validate(doctor, errors);
	log.info("validation completed");
	if(!errors.hasErrors()) {
		try {
			Integer doc_Id=service.saveDoctor(doctor);
log.debug("doctor created id:"+doc_Id);
		} catch (Exception e) {
			log.error("Exception"+e.getMessage());
			map.addAttribute("message", "problem in operation");
			}
	}
	log.info("About to leave save code");
	map.addAttribute("doctor",new Doctor());
	return "DoctorRegister";	
}
@RequestMapping("/all")
public String getAllData(ModelMap map) {
	List<Doctor> doctors=service.getAllDoctor();
	map.addAttribute("doctors", doctors);
	map.addAttribute("doctor",new Doctor());
	return "DoctorData";
}
@RequestMapping("/delete")
public String deleteData(@RequestParam("id") Integer doc_Id,ModelMap map) {
	service.deleteDoctor(doc_Id);
	String msg="doctor '"+doc_Id+"'deleted";
	List<Doctor> doctors=service.getAllDoctor();
	map.addAttribute("message", msg);
	map.addAttribute("doctors", doctors);
	return "DoctorData";
}
@RequestMapping("edit")
public String editData(@RequestParam("id") Integer doc_Id,ModelMap map) {
	Doctor doctor=service.getOneByDoctorId(doc_Id);
	map.addAttribute("doctor", doctor);
	return "DoctorEdit";
}
@RequestMapping(value="/update",method=RequestMethod.POST)
public String updateData(@ModelAttribute Doctor doctor,ModelMap map) {
	service.updateDoctor(doctor);
	String msg="Doctor'"+doctor.getDoc_Id()+"'updated";
	List<Doctor> doctors=service.getAllDoctor();		
	map.addAttribute("message", msg);
	map.addAttribute("doctors", doctors);
	return "DoctorData";
}
@RequestMapping("/excel")
public ModelAndView mav() {
	ModelAndView mav=new ModelAndView();
	List<Doctor> doctors=service.getAllDoctor();
	mav.setView(new DoctorExcelView());
	mav.addObject("doctors", doctors);
return mav;	
}
@RequestMapping("/pdf")
public ModelAndView mava() {
	ModelAndView mav=new ModelAndView();
	List<Doctor> doctors=service.getAllDoctor();
	mav.setView(new DoctorPdfView());
mav.addObject("doctors", doctors);
return mav;
}
}
