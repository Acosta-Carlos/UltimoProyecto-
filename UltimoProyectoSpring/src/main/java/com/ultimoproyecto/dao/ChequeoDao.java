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
	
	public int save(Chequeo ch){    
    String sql="insert into Chequeo (idchequeo,detale,estado,visitas_idvisita) values('"+ch.getIdchequeo()+"','"+ch.getDetalle()+"','"+ch.getEstado()+"','"+ch.getVisitas_idvisita()+"')";
	    return template.update(sql);
	}
	
	public int update(Chequeo ch){    
	    String sql="update Chequeo set  idchequeo='"+ch.getIdchequeo()+"',detalle='"+ch.getDetalle()+"', estado='"+ch.getEstado()+"', visitas_idvisita='"+ch.getVisitas_idvisita()+"' where idchequeo="+ch.getIdchequeo()+"";
	  return template.update(sql);    
	}   
	
	public int delete(int idchequeo){    
	    String sql="delete from Chequeo where idchequeo="+idchequeo+"";
	    return template.update(sql);
	}    

	public Chequeo getCheById(int idchequeo){    
	    String sql="select * from Chequeo where idchequeo=?";
	    return template.queryForObject(sql, new Object[]{idchequeo},new BeanPropertyRowMapper<Chequeo>(Chequeo.class));    
	}
	
	public List<Chequeo> getChequeos(){    
	    return template.query("select * from Chequeo",new RowMapper<Chequeo>(){    
	        public Chequeo mapRow(ResultSet rs, int row) throws SQLException {    
	            Chequeo ch=new Chequeo();    
	            ch.setIdchequeo(rs.getInt(1));
				ch.setDetalle(rs.getString(2));
				ch.setEstado(rs.getString(3));
				ch.setVisitas_idvisita(rs.getInt(4));
	            return ch;
	        }    
	    });    
	}    	

}
