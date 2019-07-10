package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Appointment;
import com.app.service.IAppoinmentService;

@Controller
@RequestMapping("/appoinment")
public class AppoinmentController {
	@Autowired
	private IAppoinmentService service;
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		map.addAttribute("appoinment",new Appointment());
		return "AppoinmentRegister";	
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String showData(@ModelAttribute Appointment appoinment,ModelMap map) {
		Integer id=service.saveAppoinment(appoinment);
		String msg="Appointment  '"+id+"'saved";
		map.addAttribute("message", msg);
		map.addAttribute("appoinment",new Appointment());
		return "AppoinmentRegister";	
	}
	@RequestMapping("/all")
	public String showData(ModelMap map) {
			List<Appointment> appoinments=service.getAllAppoinments();
			map.addAttribute("appoinments", appoinments);
			return "AppoinmentData";
		}
	@RequestMapping("/delete")
	public String deleteData(@RequestParam("id") Integer appo_id,ModelMap map) {
		service.deleteAppoinment(appo_id);;
		String msg="Appoinment '"+appo_id+"'deleted";
		List<Appointment> appoinments=service.getAllAppoinments();
		map.addAttribute("message", msg);
		map.addAttribute("appoinments", appoinments);
		return "AppoinmentData";
	}
	@RequestMapping("edit")
	public String editData(@RequestParam("id") Integer appo_id,ModelMap map) {
		Appointment appointment=service.getOneByIdAppoinment(appo_id);
		map.addAttribute("appointment", appointment);
		return "AppoinmentEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateData(@ModelAttribute Appointment appointment,ModelMap map) {
		service.updateAppoinmenr(appointment);;
		String msg="Appoinment '"+appointment.getId()+"'updated";
		List<Appointment> appoinments=service.getAllAppoinments();
		map.addAttribute("message", msg);
		map.addAttribute("appoinments", appoinments);
		return "AppoinmentData";
	}
}
