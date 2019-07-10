package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="billing_Form")
public class BillingForm {
	@Id
	@GeneratedValue(generator="billing_gen")
	@GenericGenerator(name="billing_gen",strategy="increment")
	private Integer id;
	@Column(name="patname")
	private String patient_Name;
	@Column(name="pat_id")
	private Integer patient_Id;
	@Column(name="dat_addm")
	private String date_Of_Admission;
	@Column(name="dat_charg")
	private String date_Of_Discharge;
	private String roomType;
	@Column(name="amt")
	private double amount;
	public BillingForm() {
		super();
	}
	public BillingForm(Integer id) {
		super();
		this.id = id;
	}
	public BillingForm(Integer id, String patient_Name, Integer patient_Id, String date_Of_Admission,
			String date_Of_Discharge, String roomType, double amount) {
		super();
		this.id = id;
		this.patient_Name = patient_Name;
		this.patient_Id = patient_Id;
		this.date_Of_Admission = date_Of_Admission;
		this.date_Of_Discharge = date_Of_Discharge;
		this.roomType = roomType;
		this.amount = amount;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPatient_Name() {
		return patient_Name;
	}
	public void setPatient_Name(String patient_Name) {
		this.patient_Name = patient_Name;
	}
	public Integer getPatient_Id() {
		return patient_Id;
	}
	public void setPatient_Id(Integer patient_Id) {
		this.patient_Id = patient_Id;
	}
	public String getDate_Of_Admission() {
		return date_Of_Admission;
	}
	public void setDate_Of_Admission(String date_Of_Admission) {
		this.date_Of_Admission = date_Of_Admission;
	}
	public String getDate_Of_Discharge() {
		return date_Of_Discharge;
	}
	public void setDate_Of_Discharge(String date_Of_Discharge) {
		this.date_Of_Discharge = date_Of_Discharge;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "BillingForm [id=" + id + ", patient_Name=" + patient_Name + ", patient_Id=" + patient_Id
				+ ", date_Of_Admission=" + date_Of_Admission + ", date_Of_Discharge=" + date_Of_Discharge
				+ ", roomType=" + roomType + ", amount=" + amount + ", getId()=" + getId() + ", getPatient_Name()="
				+ getPatient_Name() + ", getPatient_Id()=" + getPatient_Id() + ", getDate_Of_Admission()="
				+ getDate_Of_Admission() + ", getDate_Of_Discharge()=" + getDate_Of_Discharge() + ", getRoomType()="
				+ getRoomType() + ", getAmount()=" + getAmount() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
