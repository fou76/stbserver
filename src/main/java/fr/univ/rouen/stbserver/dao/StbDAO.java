package fr.univ.rouen.stbserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import fr.univ.rouen.stbserver.model.STB;
import fr.univ.rouen.stbserver.model.STBs;
import fr.univ.rouen.stbserver.mapper.STBMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class StbDAO extends JdbcDaoSupport{
	
	@Autowired
	public StbDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	public STBs getSmallSTBs(){
		String sql = STBMapper.BASE_SQL + ";";
		Object[] params = new Object[] {};
		STBMapper mapper = new STBMapper();
		return new STBs(this.getJdbcTemplate().query(sql, params, mapper));
	}
	
	public STB findSTBbyId(int id){
		String query = STBMapper.BASE_SQL + " where id = ? ;";
		Object[] params = new Object[] { id };
		STBMapper mapper = new STBMapper();
		try {
			STB stb = this.getJdbcTemplate().queryForObject(query, params, mapper);
			return stb;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public int insertSTB(STB stb) {
		/* Before insert :
		 * Vérifier si la STB existe déjà dans la BDD
		 */
			String InsertQuery = "INSERT INTO smallstb (id, titre, version, date, descr) VALUES (NULL, ?, ?, ?, ?);";
			//Object[] params = new Object[] { stb.getTtre(), stb.getVersion(), stb.getDate(), stb.getDescr() };
			
			KeyHolder keyHolder = new GeneratedKeyHolder();
			this.getJdbcTemplate().update(
					new PreparedStatementCreator() {
						public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
							PreparedStatement ps =
									connection.prepareStatement(InsertQuery, Statement.RETURN_GENERATED_KEYS);
							ps.setString(1, stb.getTitre());
							ps.setNString(2, stb.getNomEntiteClient());
							ps.setString(3, stb.getDate());
							ps.setString(4, stb.getDescription());
							return ps;
						}
					}, keyHolder
					);
			//this.getJdbcTemplate().update(query, params);
			return keyHolder.getKey().intValue();
//		}
	}
	
	public int delSTB(int id){
		
		String deleteQuery = "DELETE FROM `smallstb` WHERE id= ? ;";
		Object[] params = new Object[] { id };
		try {
			return this.getJdbcTemplate().update(deleteQuery, params);
		} catch (Exception e) {
			return 0;
		}
		
		
	}
	
	
}
