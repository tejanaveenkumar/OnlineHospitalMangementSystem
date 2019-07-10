package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Doctors_Appointment;
import com.app.model.Patient;
import com.app.service.IAppoinmentService;
import com.app.service.IDoctorsAppointService;
import com.app.service.IPatientService;

@Controller
@RequestMapping("/doctappoint")
public class DoctorsAppointController {
	@Autowired
	private IDoctorsAppointService service;
	@Autowired
	private IPatientService patientservice;
	@SuppressWarnings("unused")
	@Autowired
	private IAppoinmentService appointservice;
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		map.addAttribute("doctors_Appointment",new  Doctors_Appointment());
		System.out.println("controller");
		
		//////////patient details
		List<Patient> patients=patientservice.getAllPatients();
		map.addAttribute("patients", patients);
		/*//////////appointment details
		List<Appointment> appointments=appointservice.getAllAppoinments();
		map.addAttribute("appointments", appointments);*/
		return "DoctAppointRegister";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String showData(@ModelAttribute Doctors_Appointment doctors_Appointment,ModelMap map) {
		Integer id=service.saveDoctAppoint(doctors_Appointment);
		String msg="Doctors_Appointment  '"+id+"' saved";
		map.addAttribute("message", msg);
		map.addAttribute("doctors_Appointment",new  Doctors_Appointment());
		System.out.println("inserted");
		//////////patient details
		List<Patient> patients=patientservice.getAllPatients();
		map.addAttribute("patients", patients);
/*//////////appointment details
		List<Appointment> appointments=appointservice.getAllAppoinments();
		map.addAttribute("appointments", appointments);*/
System.out.println("doctot register  inserted successfully");
		return "DoctAppointRegister";	
	}
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<Doctors_Appointment> doctsappoints=service.getAllDoctAppoints();
		map.addAttribute("doctsappoints", doctsappoints);
		return "DoctAppointData";
	}
	@RequestMapping("/delete")
	public String deleteData(@RequestParam("id") Integer id,ModelMap map) {
		service.deleteDoctAppoint(id);;
		String msg=" Doctors_Appointment'"+id+"'deleted";
		List<Doctors_Appointment> doctsappoints=service.getAllDoctAppoints();
		map.addAttribute("message", msg);
		map.addAttribute("doctsappoints", doctsappoints);
		return "DoctAppointData";
	}
	@RequestMapping("edit")
	public String editData(@RequestParam("id") Integer id,ModelMap map) {
		Doctors_Appointment doctors_Appointment=service.getOneByIdDoctAppoint(id);
		map.addAttribute("doctors_Appointment", doctors_Appointment);
		//////////patient details
		List<Patient> patients =patientservice.getAllPatients();
		map.addAttribute("patients", patients);
/*//////////appointment details
		List<Appointment> appointments=appointservice.getAllAppoinments();
		map.addAttribute("appointments", appointments);*/
		return "DoctAppointEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateData(@ModelAttribute Doctors_Appointment doctors_Appointment,ModelMap map) {
		service.updateDoctAppoint(doctors_Appointment);
		String msg="Doctors_Appointment '"+doctors_Appointment.getId()+"' updated";
		List<Doctors_Appointment> doctsappoints=service.getAllDoctAppoints();
		map.addAttribute("message", msg);
		map.addAttribute("doctsappoints", doctsappoints);
		return "DoctAppointData";
	}
}