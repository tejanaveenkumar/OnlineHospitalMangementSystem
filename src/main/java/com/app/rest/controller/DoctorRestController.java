package com.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Doctor;
import com.app.service.IDoctorService;

@RestController
@RequestMapping("/rest/doctor")
public class DoctorRestController {
	@Autowired
	private IDoctorService service;
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> message=null;
		List<Doctor> doctors=service.getAllDoctor();
		if(doctors==null||doctors.isEmpty()) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);//data available
		}else {
			message=new ResponseEntity<List<Doctor>>(doctors,HttpStatus.OK);//200

		}
return message;	
}
	@GetMapping("/get/{doc_Id}")
	public ResponseEntity<?> getOne(@PathVariable Integer doc_Id){
		ResponseEntity<?> message=null;
		Doctor doctor=service.getOneByDoctorId(doc_Id);
		if(doctor==null) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
		}else {
			message=new ResponseEntity<Doctor>(doctor,HttpStatus.OK);//204
		}
		return message;

	}
	@DeleteMapping("/delete/{doc_Id}")
	public ResponseEntity<String> deleteData(@PathVariable Integer doc_Id){
		ResponseEntity<String> message=null;
		
		try {
			service.deleteDoctor(doc_Id);
			message=new ResponseEntity<String>("doctor deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			message=new ResponseEntity<String>("doctor not found ", HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	
	@PostMapping("/insert")
	public ResponseEntity<String> save(@RequestBody Doctor doctor)
	{
		ResponseEntity<String> message=null;
		try {
			Integer doc_Id=service.saveDoctor(doctor);
message=new ResponseEntity<String>("saved '"+doc_Id+"'id",HttpStatus.OK);			
		} catch (Exception e) {
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;	
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateData(@RequestBody Doctor doctor){
		ResponseEntity<String> message=null;
		try {
			service.updateDoctor(doctor);
message=new ResponseEntity<String>("doctor '"+doctor.getDoc_Id()+"'updated",HttpStatus.OK);	
		} catch (Exception e) {
			message=new ResponseEntity<String>("doctor '"+doctor.getDoc_Id()+"' not updated",HttpStatus.BAD_REQUEST);

		}
		return message;
	}
}