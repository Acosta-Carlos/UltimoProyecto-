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
	    String sql="insert into Pagos (idpago,mesanio,montoregular,montoadicionales,cliente_id) values('"+p.getIdpago()+"','" +p.getMesanio() + "','" +p.getMontoregular()+ "','" +p.getMontoadicionales() + "','" +p.getCliente_id() + "')";
	    return template.update(sql);
	}

	public int update(Pago p){    
	    String sql="update Pagos set idpago='"+p.getIdpago()+"', mesanio='"+p.getMesanio()+"', montoregular='"+p.getMontoregular()+"', montoadicionales='"+p.getMontoadicionales()+"', cliente_id='"+p.getCliente_id()+"' where idpago="+p.getIdpago()+"";
	    return template.update(sql);    
	}   
	
	public int delete(int idpago){    
	    String sql="delete from Pagos where idpago="+idpago+"";
	    return template.update(sql);
	}    
	
	public Pago getEmpById(int idpago){    
	    String sql="select * from Pagos where idpago=?";
	    return template.queryForObject(sql, new Object[]{idpago},new BeanPropertyRowMapper<Pago>(Pago.class));    
	}
	
	public List<Pago> getPago(){    
	    return template.query("select * from Pagos",new RowMapper<Pago>(){    
	        public Pago mapRow(ResultSet rs, int row) throws SQLException {    
	            Pago p=new Pago();    
	            p.setIdpago(rs.getInt(1));    
	            p.setMesanio(rs.getString(2));    
	            p.setMontoregular(rs.getInt(3));
	            p.setMontoadicionales(rs.getInt(4));
	            p.setCliente_id(rs.getInt(5));
	            return p;
	        }    
	    });    
	}   
}
