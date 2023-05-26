package fr.univ.rouen.stbserver.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.jdbc.core.RowMapper;
import fr.univ.rouen.stbserver.model.SmallSTB;



public class SmallSTBMapper implements RowMapper<SmallSTB>{

	  public static final String BASE_SQL //
      = "select id, titre, version, date, descr from smallstb";
	
	@Override
	public SmallSTB mapRow(ResultSet rs, int rowNum) throws SQLException {
		Integer version = rs.getInt("version");
		Integer id = rs.getInt("id");
		String titre = rs.getString("titre");
		String date = rs.getString("date");
		String descr = rs.getString("descr");
		
		return new SmallSTB(id, titre, version, date, descr);
	}

}
