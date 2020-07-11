package com.ultimoproyecto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ultimoproyecto.beans.Accidente ;   
public class AccidenteDao {

	
JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	
	public int save(Accidente ac){    
	    String sql="insert into Accidente (idaccidente,fecha,hora,suceso,lugar,clienteid)"
	    		+ " values('"+ac.getIdaccidente()+"',"+ac.getFecha()+",'"+ac.getHora()+"','"+ac.getSuceso()+"','"+ac.getLugar()+"','"+ac.getClienteid()+"')";
	    return template.update(sql);
	    
	    
	

	}
	
	public List<Accidente> getAccidentes(){    
	    return template.query("select * from Accidentes",new RowMapper<Accidente>(){    
	        public Accidente mapRow(ResultSet rs, int row) throws SQLException {    
	            Accidente ac=new Accidente();    
	            ac.setIdaccidente(rs.getInt(1));
				ac.setFecha(rs.getString(2));
				ac.setHora(rs.getString(3));
				ac.setSuceso(rs.getString(4));
				ac.setLugar(rs.getString(5));
				ac.setClienteid(rs.getInt(6));
	            return ac;
	        }    
	    });    
	}    	
}


