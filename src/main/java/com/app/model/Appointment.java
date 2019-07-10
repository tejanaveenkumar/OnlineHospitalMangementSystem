package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="appoinment")
public class Appointment {
@Id
@GeneratedValue(generator="appoint_gen")
@GenericGenerator(name = "appoint_gen", strategy = "increment")
private Integer id;
	private String scheduled_On;
	@Column(name="pname")
	private String patient_Name;
	@Column(name="paid")
	private String patient_Id;
	@Column(name="mobile")
	private String mobile_Number;
	@Column(name="doc_name")
	private String doctor_Name;
	@Column(name="categr")
	private String category;
	public Appointment() {
		super();
	}
	public Appointment(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getScheduled_On() {
		return scheduled_On;
	}
	public void setScheduled_On(String scheduled_On) {
		this.scheduled_On = scheduled_On;
	}
	public String getPatient_Name() {
		return patient_Name;
	}
	public void setPatient_Name(String patient_Name) {
		this.patient_Name = patient_Name;
	}
	public String getPatient_Id() {
		return patient_Id;
	}
	public void setPatient_Id(String patient_Id) {
		this.patient_Id = patient_Id;
	}
	public String getMobile_Number() {
		return mobile_Number;
	}
	public void setMobile_Number(String mobile_Number) {
		this.mobile_Number = mobile_Number;
	}
	public String getDoctor_Name() {
		return doctor_Name;
	}
	public void setDoctor_Name(String doctor_Name) {
		this.doctor_Name = doctor_Name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Appointment [id=" + id + ", scheduled_On=" + scheduled_On + ", patient_Name=" + patient_Name
				+ ", patient_Id=" + patient_Id + ", mobile_Number=" + mobile_Number + ", doctor_Name=" + doctor_Name
				+ ", category=" + category + ", getId()=" + getId() + ", getScheduled_On()=" + getScheduled_On()
				+ ", getPatient_Name()=" + getPatient_Name() + ", getPatient_Id()=" + getPatient_Id()
				+ ", getMobile_Number()=" + getMobile_Number() + ", getDoctor_Name()=" + getDoctor_Name()
				+ ", getCategory()=" + getCategory() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
