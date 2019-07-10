package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping("/documents")
public class DocumentController {
	@Autowired
	private IDocumentService service;
	@RequestMapping("/show")
	public String docData() {
		return "Documents";	
	}
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String uploadDoc(@RequestParam CommonsMultipartFile file,ModelMap map) {

		if(file!=null) {
			Document doc=new Document();
			doc.setFileName(file.getOriginalFilename());
			doc.setFileData(file.getBytes());
			int fileId=service.saveDocument(doc);
			map.addAttribute("message", "upload '"+fileId+"'successfully");
			List<Object[]> docs=service.getDocumentIdAndNames();
			map.addAttribute("docs", docs);	
		}
		return "Documents";
	}
	@RequestMapping("/download")
	public void downloaddoc(@RequestParam("docId") int docId,HttpServletResponse resp) {
		Document doc=service.getDocumentById(docId);
		resp.addHeader("Content-Disposition", "attachment;filename="+doc.getFileName());
		try {
			FileCopyUtils.copy(doc.getFileData(),resp.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	
}