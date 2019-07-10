package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="doctor_appoint")
public class Doctors_Appointment {
	@Id
	@GeneratedValue(generator="docappoint_gen")
	@GenericGenerator(name = "docappoint_gen", strategy = "increment")
	private Integer id;
	@Column(name="doc_name")
	private String doctor_Name;
	@Column(name="pat_Id")
	private Integer patient_Id;
	private String appointment_On;
	@Column(name="doct_Sign")
	private String doctor_Signature;

	//Multiplicticy with PATIENT
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pidfk")
	private Patient patient;
	//Multiplicticy with APPOINMENT	
	/*@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="aidfk")
	private Appointment appoinment;*/

	public Doctors_Appointment() {
		super();
	}
	public Doctors_Appointment(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDoctor_Name() {
		return doctor_Name;
	}
	public void setDoctor_Name(String doctor_Name) {
		this.doctor_Name = doctor_Name;
	}
	public Integer getPatient_Id() {
		return patient_Id;
	}
	public void setPatient_Id(Integer patient_Id) {
		this.patient_Id = patient_Id;
	}
	public String getAppointment_On() {
		return appointment_On;
	}
	public void setAppointment_On(String appointment_On) {
		this.appointment_On = appointment_On;
	}
	public String getDoctor_Signature() {
		return doctor_Signature;
	}
	public void setDoctor_Signature(String doctor_Signature) {
		this.doctor_Signature = doctor_Signature;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "Doctors_Appointment [id=" + id + ", doctor_Name=" + doctor_Name + ", patient_Id=" + patient_Id
				+ ", appointment_On=" + appointment_On + ", doctor_Signature=" + doctor_Signature + ", patient="
				+ patient + ", getId()=" + getId() + ", getDoctor_Name()=" + getDoctor_Name() + ", getPatient_Id()="
				+ getPatient_Id() + ", getAppointment_On()=" + getAppointment_On() + ", getDoctor_Signature()="
				+ getDoctor_Signature() + ", getPatient()=" + getPatient() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
}