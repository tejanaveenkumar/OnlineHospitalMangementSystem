package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Doctor;

public class DoctorExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-disposition", "attachment;filename=DOCTOR.xlsx");
		Sheet sheet=workbook.createSheet();
		@SuppressWarnings("unchecked")
		List<Doctor> doctors=(List<Doctor>) model.get("doctors");
		setHead(sheet);
		setBody(sheet,doctors);
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("Doctor_Id");
		row.createCell(1).setCellValue("Doctor_Name");
		row.createCell(2).setCellValue("Address");
		row.createCell(3).setCellValue("Gender");
		row.createCell(4).setCellValue("Contact_Num");
		row.createCell(5).setCellValue("Specialization");
		row.createCell(6).setCellValue("Service_Charges");	
	}
	private void setBody(Sheet sheet, List<Doctor> doctors) {
		int rowNum=1;
		for (Doctor doctor : doctors) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(doctor.getDoc_Id());
			row.createCell(1).setCellValue(doctor.getDoctor_Name());
			row.createCell(2).setCellValue(doctor.getAddress());
			row.createCell(3).setCellValue(doctor.getGender());
			row.createCell(4).setCellValue(doctor.getContact_Num());
			row.createCell(5).setCellValue(doctor.getSpecialization());
			row.createCell(6).setCellValue(doctor.getService_Charges());
			
		}
	}

}
