package fr.univrouen.stbserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.univ.rouen.stbserver.dao.StbDAO;
import fr.univ.rouen.stbserver.model.OPReport;
import fr.univ.rouen.stbserver.model.STB;
import fr.univ.rouen.stbserver.model.Status;

@RestController
public class PostControlleur {
	
	@Autowired
	private StbDAO stbDAO;
	
//	@RequestMapping(value = "/testpost", method = RequestMethod.POST,  consumes = "application/xml")
//	public String postTest(@RequestBody String stb) {
//		return ("<result><response>Message reçu : </response>" 
//				+ stb + "</result>");
//	}
	
//	@PostMapping(value = "/poststb", produces = MediaType.APPLICATION_XML_VALUE)
//	@ResponseBody
//	public String postSTB() {
//		FileLoader stb = new FileLoader();
//		return stb.loadFile();
//	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_XML_VALUE, consumes = "application/xml")
	public @ResponseBody OPReport insertSTB(@RequestBody STB stb) {
		try {
			int id = stbDAO.insertSTB(stb);
//			if (id == 0) {
//				return new OPReport(id, Status.INSERTED);
//			}
			return new OPReport(id, Status.INSERTED);
		} catch (Exception e) {
			//e.printStackTrace();
			return new OPReport(Status.ERROR);
		} 
	}
	
	
//	@RequestMapping(value = "/xml")
//	public @ResponseBody SmallSTB getXML() {
//		SmallSTB smallSTB = new SmallSTB(0, "Test STB", 1, "2020/03/23", "Test JAXB");
//		return smallSTB;
//	}

}
