package com.ultimoproyecto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ultimoproyecto.beans.Chequeo;

public class ChequeoDao {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}

	public int save(Chequeo chec){    
	    String sql="insert into Chequeo (idasesoria,detalle,estado,visitaid) values('"+chec.getIdchequeo()+"','" +chec.getDetalle() + "','" +chec.getEstado() + "','" +chec.getVisitaid() + "')";
	    return template.update(sql);
	}
	
	public int update(Chequeo chec){    
	    String sql="update Chequeo set detalle='"+chec.getDetalle()+"', estado="+chec.getEstado()+"' where id="+chec.getIdchequeo()+"";
	    return template.update(sql);    
	}   
	
	public int delete(int idchequeo){    
	    String sql="delete from Chequeo where idchequeo="+idchequeo+"";
	    return template.update(sql);
	}    
	
	public Chequeo getChequeoById(int idchequeo){    
	    String sql="select * from Chequeo where idchequeo=?";
	    return template.queryForObject(sql, new Object[]{idchequeo},new BeanPropertyRowMapper<Chequeo>(Chequeo.class));    
	}
	
	public List<Chequeo> getChequeo(){    
	    return template.query("select * from Chequeo",new RowMapper<Chequeo>(){    
	        public Chequeo mapRow(ResultSet rs, int row) throws SQLException {    
	            Chequeo chec= new Chequeo();    
	            chec.setIdchequeo(rs.getInt(1));    
	            chec.setDetalle(rs.getString(2));    
	            chec.setEstado(rs.getString(3));
	            chec.setVisitaid(rs.getInt(4));
	            return chec;
	        }    
	    });    
	}




}
