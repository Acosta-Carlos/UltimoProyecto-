package com.ultimoproyecto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.ultimoproyecto.beans.Visita;

public class VisitaDao {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	
	public int save(Visita v){    
	    String sql="insert into Visitas (idvisita,direccion,ciudad,fecha,resumen,observaciones,cliente_id,empleado_idempleado) values('"+v.getIdvisita()+"',"+v.getDireccion()+",'"+v.getCiudad()+"','"+v.getFecha()+"','"+v.getResumen()+"','"+v.getObservaciones()+"','"+v.getCliente_id()+"','"+v.getEmpleado_idempleado()+"')";
	    return template.update(sql);
	}
	
	public int update(Visita v){    
	    String sql="update Visitas set  idvisita='"+v.getIdvisita()+"',direccion='"+v.getDireccion()+"', ciudad='"+v.getCiudad()+"', fecha='"+v.getFecha()+"' , resumen='"+v.getResumen()+"',observaciones='"+v.getObservaciones()+"',cliente_id='"+v.getCliente_id()+"',empleado_idempleado='"+v.getEmpleado_idempleado()+"' where idvisita="+v.getIdvisita()+"";
	  return template.update(sql);    
	}   
	
	public int delete(int idvisita){    
	    String sql="delete from Visitas where idvisita="+idvisita+"";
	    return template.update(sql);
	}    

	public Visita getVisById(int idvisita){    
	    String sql="select * from Visitas where idvisita=?";
	    return template.queryForObject(sql, new Object[]{idvisita},new BeanPropertyRowMapper<Visita>(Visita.class));    
	}
	
	public List<Visita> getVisitas(){    
	    return template.query("select * from Visitas",new RowMapper<Visita>(){    
	        public Visita mapRow(ResultSet rs, int row) throws SQLException {    
	            Visita v=new Visita();    
	            v.setIdvisita(rs.getInt(1));    
	            v.setDireccion(rs.getString(2));    
	            v.setCiudad(rs.getString(3));
	            v.setFecha(rs.getString(4));
	            v.setResumen(rs.getString(5));
	            v.setObservaciones(rs.getString(6));
	            v.setCliente_id(rs.getInt(7));
	            v.setEmpleado_idempleado(rs.getInt(8));
	            
	            return v;
	        }    
	    });    
	}    	
	
	

}
