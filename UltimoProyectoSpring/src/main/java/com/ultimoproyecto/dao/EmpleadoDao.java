package com.ultimoproyecto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ultimoproyecto.beans.Empleado;

public class EmpleadoDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}

	public int save(Empleado e){    
	    String sql="insert into Empleado (nombre,especialidad) values('"+e.getNombre()+"','"+e.getEspecialidad()+"')";
	    return template.update(sql);
	}
	
	public int update(Empleado e){    
	    String sql="update Empleado set nombre='"+e.getNombre()+"', especialidad="+e.getEspecialidad()+"' where id="+e.getIdempleado()+"";
	    return template.update(sql);    
	}   
	
	public int delete(int idempleado){    
	    String sql="delete from Empleado where idempleado="+idempleado+"";
	    return template.update(sql);
	}    

	public Empleado getEmpById(int idempleado){    
	    String sql="select * from Empleado where idempleado=?";
	    return template.queryForObject(sql, new Object[]{idempleado},new BeanPropertyRowMapper<Empleado>(Empleado.class));    
	}
	
	public List<Empleado> getEmpleados(){    
	    return template.query("select * from Empleado",new RowMapper<Empleado>(){    
	        public Empleado mapRow(ResultSet rs, int row) throws SQLException {    
	            Empleado e=new Empleado();    
	            e.setIdempleado(rs.getInt(1));    
	            e.setNombre(rs.getString(2));    
	            e.setEspecialidad(rs.getString(3));
	            return e;
	        }    
	    });    
	}    	
	
	
	
}
