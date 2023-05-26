package fr.univrouen.stbserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.univ.rouen.stbserver.dao.StbDAO;
import fr.univ.rouen.stbserver.model.OPReport;
import fr.univ.rouen.stbserver.model.Status;

public class DeleteControleur {
	@Autowired
	private StbDAO stbDAO;
	
	@DeleteMapping(value = "/stb23/delete", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody Object deleteSTB(
			@RequestParam(value ="id") int id) {
		
		int deletedId = stbDAO.delSTB(id);
		if (deletedId == 0) {
			return new OPReport(Status.ERROR);
		}
		return new OPReport(id, Status.DELETED);
	}

}
