package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Doctor;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class DoctorPdfView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=Doctors.pdf");
		Paragraph p=new Paragraph();
		document.add(p);
		List<Doctor> doctors=(List<Doctor>) model.get("doctors");
		PdfPTable table=new PdfPTable(7);
		table.addCell("Doctor_Id");
		table.addCell("Doctor_Name");
		table.addCell("Address");
		table.addCell("Gender");
		table.addCell("Contact_Num");
		table.addCell("Specialization");
		table.addCell("Service_Charges");
for (Doctor doctor : doctors) {
	table.addCell(doctor.getDoc_Id().toString());
	table.addCell(doctor.getDoctor_Name());
	table.addCell(doctor.getAddress());
	table.addCell(doctor.getGender());
table.addCell(doctor.getContact_Num());
table.addCell(doctor.getSpecialization());
table.addCell(doctor.getSpecialization());
}
document.add(table);
document.add(new Paragraph(new Date().toString()));

	}

}
