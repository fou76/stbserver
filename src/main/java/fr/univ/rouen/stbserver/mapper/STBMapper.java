package fr.univ.rouen.stbserver.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;


import org.springframework.jdbc.core.RowMapper;
import fr.univ.rouen.stbserver.model.STB;


public class STBMapper implements RowMapper<STB>{

	  public static final String BASE_SQL //
      = "select id, titre, nomEntiteClient, date, descr from stb";
	
	@Override
	public STB mapRow(ResultSet rs, int rowNum) throws SQLException {
		Integer id = rs.getInt("id");
		String nomEntiteClient = rs.getString("nomEntiteClient");
		String titre = rs.getString("titre");
		String date = rs.getString("date");
		String descr = rs.getString("descr");
		
		return new STB(id, titre, descr, date,nomEntiteClient);
	}

}
