package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Patient;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PatientPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=Patients.pdf");
Paragraph p=new Paragraph("WELCOME TO PDF");
		document.add(p);
		@SuppressWarnings("unchecked")
		List<Patient> patients=(List<Patient>)model.get("patients");
		PdfPTable t=new PdfPTable(9);
		t.addCell("PatientId");
		t.addCell("PatientName");
		t.addCell("DateOfBirth");
		t.addCell("Sex");
		t.addCell("PatientAddress");
		t.addCell("City");
		t.addCell("State");
		t.addCell("Service_TYPE");
		t.addCell("Date_Of_Service");
for (Patient patient : patients) {
	t.addCell(patient.getPatient_Id().toString());
	t.addCell(patient.getPatient_Name());
	t.addCell(patient.getDob());
	t.addCell(patient.getSex());
	t.addCell(patient.getAddress());
	t.addCell(patient.getCity());
	t.addCell(patient.getState());
	t.addCell(patient.getService_type().toString());
	t.addCell(patient.getDate_Of_Service());
document.add(t);
document.add(new Paragraph(new java.util.Date().toString()));
}
	}

}
