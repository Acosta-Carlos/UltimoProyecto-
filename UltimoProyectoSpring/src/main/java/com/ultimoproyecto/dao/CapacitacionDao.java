package com.ultimoproyecto.dao;
import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;

import com.ultimoproyecto.beans.Capacitacion;

public class CapacitacionDao {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	
	public int save(Capacitacion c){    
	    String sql="insert into Capacitaciones (idcapacitacion,fecha,hora,numasistentes,visitas_idvisita) values('"+c.getIdcapacitacion()+"',"+c.getFecha()+",'"+c.getHora()+"','"+c.getNumasistentes()+"','"+c.getVisitas_idvisita()+"')";
	    return template.update(sql);
	}
	
	public int update(Capacitacion c){    
	    String sql="update Capacitaciones set idcapacitacion='"+c.getIdcapacitacion()+"', fecha='"+c.getFecha()+"', hora='"+c.getHora()+"', numasistentes='"+c.getNumasistentes()+"', visitas_idvisita='"+c.getVisitas_idvisita()+"' where idcapacitacion="+c.getIdcapacitacion()+"";
	    return template.update(sql);    
	}   
	
	public int delete(int idcapacitacion){    
	    String sql="delete from Capacitaciones where idcapacitacion="+idcapacitacion+"";
	    return template.update(sql);
	}    

	public Capacitacion getCapById(int idcapacitacion){    
	    String sql="select * from Capacitaciones where idcapacitacion=?";
	    return template.queryForObject(sql, new Object[]{idcapacitacion},new BeanPropertyRowMapper<Capacitacion>(Capacitacion.class));    
	}

	public List<Capacitacion> getCapacitacion(){    
	    return template.query("select * from Capacitaciones",new RowMapper<Capacitacion>(){    
	        public Capacitacion mapRow(ResultSet rs, int row) throws SQLException {    
	        	Capacitacion c = new Capacitacion();    
	            c.setIdcapacitacion(rs.getInt(1));    
	            c.setFecha(rs.getString(2));    
	            c.setHora(rs.getString(3));
	            c.setNumasistentes(rs.getInt(4));
	            c.setVisitas_idvisita(rs.getInt(5));
	           
	            return c;
	        }    
	    });    
	}    	
	
	
}
