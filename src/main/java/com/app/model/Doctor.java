package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="doctortab")
public class Doctor {
	@Id
	@GeneratedValue(generator="doct_gen")
	@GenericGenerator(name = "doct_gen", strategy = "increment")
	@Column(name="did")
	private Integer doc_Id;
	@Column(name="dname")
	private String doctor_Name;
	@Column(name="addr")
	private String address;
	@Column(name="gende")
private String gender;
	@Column(name="contnum")
	private String contact_Num;
	@Column(name="specliz")
private String specialization;
	@Column(name="serchargs")
private double service_Charges;
	public Doctor() {
		super();
	}
	public Doctor(Integer doc_Id) {
		super();
		this.doc_Id = doc_Id;
	}
	public Doctor(Integer doc_Id, String doctor_Name, String address, String gender, String contact_Num,
			String specialization, double service_Charges) {
		super();
		this.doc_Id = doc_Id;
		this.doctor_Name = doctor_Name;
		this.address = address;
		this.gender = gender;
		this.contact_Num = contact_Num;
		this.specialization = specialization;
		this.service_Charges = service_Charges;
	}
	public Integer getDoc_Id() {
		return doc_Id;
	}
	public void setDoc_Id(Integer doc_Id) {
		this.doc_Id = doc_Id;
	}
	public String getDoctor_Name() {
		return doctor_Name;
	}
	public void setDoctor_Name(String doctor_Name) {
		this.doctor_Name = doctor_Name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact_Num() {
		return contact_Num;
	}
	public void setContact_Num(String contact_Num) {
		this.contact_Num = contact_Num;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public double getService_Charges() {
		return service_Charges;
	}
	public void setService_Charges(double service_Charges) {
		this.service_Charges = service_Charges;
	}
	@Override
	public String toString() {
		return "Doctor [doc_Id=" + doc_Id + ", doctor_Name=" + doctor_Name + ", address=" + address + ", gender="
				+ gender + ", contact_Num=" + contact_Num + ", specialization=" + specialization + ", service_Charges="
				+ service_Charges + ", getDoc_Id()=" + getDoc_Id() + ", getDoctor_Name()=" + getDoctor_Name()
				+ ", getAddress()=" + getAddress() + ", getGender()=" + getGender() + ", getContact_Num()="
				+ getContact_Num() + ", getSpecialization()=" + getSpecialization() + ", getService_Charges()="
				+ getService_Charges() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
