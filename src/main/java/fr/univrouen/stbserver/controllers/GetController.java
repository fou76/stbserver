package fr.univrouen.stbserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.univ.rouen.stbserver.dao.StbDAO;
import fr.univ.rouen.stbserver.model.FileLoader;
import fr.univ.rouen.stbserver.model.OPReport;
import fr.univ.rouen.stbserver.model.STB;
import fr.univ.rouen.stbserver.model.STBs;
import fr.univ.rouen.stbserver.model.Status;

@RestController
public class GetController {
	
	@Autowired
	private StbDAO stbDAO;
	
	@GetMapping(path = "/help", produces = "text/html")
	public String help() {
		return new FileLoader().loadFile("html/help.html");
	}

	@RequestMapping(value = "/stb23/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody STBs getListSTBinXML() {
		STBs list = stbDAO.getSmallSTBs();
		return list; 
	}
	
	@GetMapping(value = "/stb23/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody Object getSTBinXML(
			@RequestParam(value ="id") int id) {
		STB stb = stbDAO.findSTBbyId(id);
		if (stb == null) {
			return new OPReport(id, Status.ERROR);
		}
		return stb;
	}
	
	@GetMapping(value = "/stb23/html", produces = MediaType.APPLICATION_XHTML_XML_VALUE)
	public @ResponseBody Object getSTBinHTML(
			@RequestParam(value ="id") int id) {
		
		STB stb = stbDAO.findSTBbyId(id);
		if (stb == null) {
			return new OPReport(id, Status.ERROR);
		}
		String html = new FileLoader().loadFile("html/smallstb.html");
		
		return html.replace("x:stbID",""+stb.getId())
				.replace("x:stbTitle",stb.getTitre())
				.replace("x:stbVesrion",stb.getDate())
				.replace("x:stbDesc",stb.getDescription()); 
	}

}
