package com.ultimoproyecto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ultimoproyecto.beans.Pago;

public class PagoDao {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}

	public int save(Pago p){    
	    String sql="insert into Empleado (nombre,especialidad) values('"+p.getIdpago()+"', Mes Año="+p.getMontoregular()+ "', Mes Año="+p.getMontoadicionales() + "', Mes Año="+p.getIdcliente() + "')";
	    return template.update(sql);
	}
	
	public Pago getEmpById(int idpago){    
	    String sql="select * from Pago where idpago=?";
	    return template.queryForObject(sql, new Object[]{idpago},new BeanPropertyRowMapper<Pago>(Pago.class));    
	}
	
	public List<Pago> getPago(){    
	    return template.query("select * from Pago",new RowMapper<Pago>(){    
	        public Pago mapRow(ResultSet rs, int row) throws SQLException {    
	            Pago p=new Pago();    
	            p.setIdpago(rs.getInt(1));    
	            p.setMesanio(rs.getString(2));    
	            p.setMontoregular(rs.getInt(3));
	            p.setMontoadicionales(rs.getInt(4));
	            p.setIdcliente(rs.getInt(5));
	            return p;
	        }    
	    });    
	}   
}
