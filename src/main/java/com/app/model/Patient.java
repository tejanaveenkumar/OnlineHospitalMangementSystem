package com.app.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="patientTab")
public class Patient {
	@Id
	//@GeneratedValue
	@GeneratedValue(generator="p_gen")
	@GenericGenerator(name="p_gen",strategy="increment")
	@Column(name="pid")
	private Integer patient_Id;
	private String patient_Name;
	private  String dob;
	private String sex;
	private String address;
	private String city;
	private String state;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="serv",joinColumns=@JoinColumn(name="pid"))
	@OrderColumn(name="pos")
	@Column(name="servtype")
	private List<String> service_type;
	private String date_Of_Service;
	public Patient() {
		super();
	}
	public Patient(Integer patient_Id) {
		super();
		this.patient_Id = patient_Id;
	}
	public Patient(Integer patient_Id, String patient_Name, String dob, String sex, String address, String city,
			String state, List<String> service_type, String date_Of_Service) {
		super();
		this.patient_Id = patient_Id;
		this.patient_Name = patient_Name;
		this.dob = dob;
		this.sex = sex;
		this.address = address;
		this.city = city;
		this.state = state;
		this.service_type = service_type;
		this.date_Of_Service = date_Of_Service;
	}
	public Integer getPatient_Id() {
		return patient_Id;
	}
	public void setPatient_Id(Integer patient_Id) {
		this.patient_Id = patient_Id;
	}
	public String getPatient_Name() {
		return patient_Name;
	}
	public void setPatient_Name(String patient_Name) {
		this.patient_Name = patient_Name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<String> getService_type() {
		return service_type;
	}
	public void setService_type(List<String> service_type) {
		this.service_type = service_type;
	}
	public String getDate_Of_Service() {
		return date_Of_Service;
	}
	public void setDate_Of_Service(String date_Of_Service) {
		this.date_Of_Service = date_Of_Service;
	}
	@Override
	public String toString() {
		return "Patient [patient_Id=" + patient_Id + ", patient_Name=" + patient_Name + ", dob=" + dob + ", sex=" + sex
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", service_type=" + service_type
				+ ", date_Of_Service=" + date_Of_Service + ", getPatient_Id()=" + getPatient_Id()
				+ ", getPatient_Name()=" + getPatient_Name() + ", getDob()=" + getDob() + ", getSex()=" + getSex()
				+ ", getAddress()=" + getAddress() + ", getCity()=" + getCity() + ", getState()=" + getState()
				+ ", getService_type()=" + getService_type() + ", getDate_Of_Service()=" + getDate_Of_Service()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
