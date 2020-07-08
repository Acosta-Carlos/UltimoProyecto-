package com.UltimoProyecto.dao;
import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;

import com.UltimoProyecto.beans.Capacitacion;

public class CapacitacionDao {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	
	public int save(Capacitacion c){    
	    String sql="insert into Capacitacion (id_capacitacion,fecha,hora,num_asistentes,id_visita) values('"+c.getId_capacitacion()+"',"+c.getFecha()+",'"+c.getHora()+"','"+c.getNum_asistentes()+"','"+c.getId_visita()+"')";
	    return template.update(sql);
	}
	
	/*public int update(Capacitacion c){    
	    String sql="update Capacitacion set id_capacitacion='"+c.getId_capacitacion()+"', fecha="+c.getFecha()+",hora='"+c.getHora()+"', num_asistentes='"+c.getNum_asistentes()+"', id_visita='"+c.getId_visita()+"' where id_capacitacion="+c.getId_capacitacion()+"";
	    return template.update(sql);    
	}   
	
	public int delete(int id){    
	    String sql="delete from Capacitacion where id_capacitacion="+id_capacitacion+"";
	    return template.update(sql);
	}    

	public Capacitacion getCliById(int id){    
	    String sql="select * from Cliente where id=?";
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Capacitacion>(Capacitacion.class));    
	}
	*/
	public List<Capacitacion> getCapacitacion(){    
	    return template.query("select * from Capacitacion",new RowMapper<Capacitacion>(){    
	        public Capacitacion mapRow(ResultSet rs, int row) throws SQLException {    
	        	Capacitacion c = new Capacitacion();    
	            c.setId_capacitacion(rs.getInt(1));    
	            c.setFecha(rs.getString(2));    
	            c.setHora(rs.getString(3));
	            c.setNum_asistentes(rs.getInt(4));
	            c.setId_visita(rs.getInt(5));
	           
	            return c;
	        }    
	    });    
	}    	
	
	
}
