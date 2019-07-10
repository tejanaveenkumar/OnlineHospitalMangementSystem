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

import com.app.model.Patient;
import com.app.service.IPatientService;

@RestController
@RequestMapping("/rest/patient")
public class PatientRestController {
	@Autowired
	private IPatientService service;
	@GetMapping("/all")
public ResponseEntity<?> getAll(){
	ResponseEntity<?> message=null;
	
	List<Patient> patients=service.getAllPatients();
if(patients==null||patients.isEmpty()) {
	message=new ResponseEntity<>(HttpStatus.NO_CONTENT);//data avilable
}else {
	message=new ResponseEntity<List<Patient>>(patients,HttpStatus.OK);//success(200)
}
return message;
}
@GetMapping("/get/{patient_Id}")
public ResponseEntity<?> getOne(@PathVariable Integer patient_Id){
	ResponseEntity<?> message=null;
	Patient patient=service.getOneByPatient(patient_Id);
if(patient==null) {//no data found
message=new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
}
else {
	message=new ResponseEntity<Patient>(patient,HttpStatus.OK);//200

}
	return message;
}

@DeleteMapping("/delete/{patient_Id}")
public ResponseEntity<String> delete(@PathVariable Integer patient_Id){
	
	ResponseEntity<String> message=null;
try {
	service.deletePatient(patient_Id);
	message=new ResponseEntity<String>("patient deleted successfully",HttpStatus.OK);

} catch (Exception e) {
	message=new ResponseEntity<String>("patient not found ",HttpStatus.BAD_REQUEST);
}
return message;	
}

@PostMapping("/insert")
public ResponseEntity<String> save(@RequestBody Patient patient)
{
	ResponseEntity<String> message=null;
	try {
		Integer patient_Id=service.savePatient(patient);
message=new ResponseEntity<String>("saved with '"+patient_Id+"' id",HttpStatus.OK);
	} catch (Exception e) {
		message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return message;
}
@PutMapping("/update")
public ResponseEntity<String> updateData(@RequestBody Patient patient ){
	ResponseEntity<String> message=null;
	try {
		service.updatePatient(patient);
message=new ResponseEntity<String>("patient '"+patient.getPatient_Id()+"' updated",HttpStatus.OK);
		
	} catch (Exception e) {
		message=new ResponseEntity<String>("patient '"+patient.getPatient_Id()+"' not updated",HttpStatus.BAD_REQUEST);
}
	return message;
	}
}