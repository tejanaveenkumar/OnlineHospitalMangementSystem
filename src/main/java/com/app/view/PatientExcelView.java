package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Patient;

public class PatientExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=Patients.xlsx");
		Sheet sheet=workbook.createSheet();
		@SuppressWarnings("unchecked")
		List<Patient> patients=(List<Patient>)model.get("patients");
		setHead(sheet);
		setBody(sheet,patients);	
	}
	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("PatientId");
		row.createCell(1).setCellValue("PatientName");
		row.createCell(2).setCellValue("DateOfBirth");
		row.createCell(3).setCellValue("Sex");
		row.createCell(4).setCellValue("PatientAddress");
		row.createCell(5).setCellValue("City");
		row.createCell(6).setCellValue("State");
		row.createCell(7).setCellValue("Service_TYPE");
		row.createCell(8).setCellValue("Date_Of_Service");
	}
	private void setBody(Sheet sheet, List<Patient> patients) {
		int rowNum=1;
		for (Patient patient : patients) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(patient.getPatient_Id());
			row.createCell(1).setCellValue(patient.getPatient_Name());
			row.createCell(2).setCellValue(patient.getDob());
			row.createCell(3).setCellValue(patient.getSex());
			row.createCell(4).setCellValue(patient.getAddress());
			row.createCell(5).setCellValue(patient.getCity());
			row.createCell(6).setCellValue(patient.getState());
			row.createCell(7).setCellValue(patient.getService_type().toString());
			row.createCell(8).setCellValue(patient.getDate_Of_Service());
		}
	}
}
