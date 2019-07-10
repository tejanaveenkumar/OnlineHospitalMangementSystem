package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.BillingForm;
import com.app.service.IBillingFormService;

@Controller
@RequestMapping("/billing")
public class BillingFormController {
@Autowired
private IBillingFormService service;
@RequestMapping("/register")
public String showReg(ModelMap map) {
	map.addAttribute("billing",new BillingForm() );
	return "BillingRegister";
}
@RequestMapping(value="/insert",method=RequestMethod.POST)
public String showData(@ModelAttribute BillingForm billing,ModelMap map) {
	Integer id=service.saveBilling(billing);
	String msg="BillingForm '"+id+"'saved";
	map.addAttribute("message", msg);
	map.addAttribute("billing",new BillingForm() );
	return "BillingRegister";	
}
@RequestMapping("/all")
public String getAllData(ModelMap map) {
	List<BillingForm> billings=service.getAllBilling();
	map.addAttribute("billings", billings);
	map.addAttribute("billing",new BillingForm() );
	return "BillingData";
}
@RequestMapping("/delete")
public String deleteData(@RequestParam("id") Integer id,ModelMap map) {
	service.deleteBilling(id);
	String msg="BillingForm '"+id+"'deleted";
	List<BillingForm> billings=service.getAllBilling();
	map.addAttribute("message", msg);
	map.addAttribute("billings", billings);
	return "BillingData";
}
@RequestMapping("edit")
public String editData(@RequestParam("id") Integer id,ModelMap map) {
	BillingForm  billingForm=service.getOneByBilling(id);
	map.addAttribute("billingForm", billingForm);
	return "BillingEdit";
}
@RequestMapping(value="/update",method=RequestMethod.POST)
public String updateData(@ModelAttribute BillingForm billing,ModelMap map) {
	service.updateBilling(billing);
	String msg="BillingForm '"+billing.getId()+"'updated";
	List<BillingForm> billings=service.getAllBilling();
	map.addAttribute("message", msg);
	map.addAttribute("billings", billings);
	return "BillingData";
}
}

