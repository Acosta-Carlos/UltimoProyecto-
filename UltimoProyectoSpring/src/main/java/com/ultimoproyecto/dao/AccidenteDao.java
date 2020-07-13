package com.ultimoproyecto.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;

import com.ultimoproyecto.beans.Accidente;
 

public class AccidenteDao {
	
JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	
	public int save(Accidente a){    
    String sql="insert into Accidentes (idaccidente,fecha,hora,suceso,lugar,cliente_id) values('"+a.getIdaccidente()+"','"+a.getFecha()+"','"+a.getHora()+"','"+a.getSuceso()+"','"+a.getLugar()+"','"+a.getCliente_id()+"')";
	    return template.update(sql);
	}
	
	public int update(Accidente a){    
	    String sql="update Accidentes set  idaccidente='"+a.getIdaccidente()+"',fecha='"+a.getFecha()+"', hora='"+a.getHora()+"', suceso='"+a.getSuceso()+"' , lugar='"+a.getLugar()+"',cliente_id='"+a.getCliente_id()+"' where idaccidente="+a.getIdaccidente()+"";
	  return template.update(sql);    
	}   
	
	public int delete(int idaccidente){    
	    String sql="delete from Accidentes where idaccidente="+idaccidente+"";
	    return template.update(sql);
	}    

	public Accidente getAcciById(int idaccidente){    
	    String sql="select * from Accidentes where idaccidente=?";
	    return template.queryForObject(sql, new Object[]{idaccidente},new BeanPropertyRowMapper<Accidente>(Accidente.class));    
	}
	
	public List<Accidente> getAccidentes(){    
	    return template.query("select * from Accidentes",new RowMapper<Accidente>(){    
	        public Accidente mapRow(ResultSet rs, int row) throws SQLException {    
	            Accidente a=new Accidente();    
	            a.setIdaccidente(rs.getInt(1));
				a.setFecha(rs.getString(2));
				a.setHora(rs.getString(3));
				a.setSuceso(rs.getString(4));
				a.setLugar(rs.getString(5));
				a.setCliente_id(rs.getInt(6));
	            return a;
	        }    
	    });    
	}    	

}