package com.ultimoproyecto.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;

import com.ultimoproyecto.beans.Mejora;

public class MejoraDao {

JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	
	public int save(Mejora m){    

	    String sql="insert into mejoras (idmejora,fecha,motivo,actividades,estado,cliente_id) values('"+m.getIdmejora()+"','"+m.getFecha()+"','"+m.getMotivo()+"','"+m.getActividades()+"','"+m.getEstado()+"','"+m.getCliente_id()+"')";

	    return template.update(sql);
	}
	
	public int update(Mejora m){    

	    String sql="update mejoras set idmejora='"+m.getIdmejora()+"', fecha='"+m.getFecha()+"', motivo='"+m.getMotivo()+"',actividades='"+m.getActividades()+"', estado='"+m.getEstado()+"', cliente_id='"+m.getCliente_id()+"' where idmejora="+m.getIdmejora()+"";
	    return template.update(sql);    
	}   
	
	public int delete(int idmejora){    
	    String sql="delete from mejoras where idmejora="+idmejora+"";
	    return template.update(sql);
	}    

	public Mejora getMejById(int idmejora){    
	    String sql="select * from mejoras where idmejora=?";
	    return template.queryForObject(sql, new Object[]{idmejora},new BeanPropertyRowMapper<Mejora>(Mejora.class));    

	}
	
	public List<Mejora> getMejoras(){    
	    return template.query("select * from mejoras",new RowMapper<Mejora>(){    
	        public Mejora mapRow(ResultSet rs, int row) throws SQLException {    
	            Mejora m=new Mejora();    
	            m.setIdmejora(rs.getInt(1));    
	            m.setFecha(rs.getString(2));    
	            m.setMotivo(rs.getString(3));
	            m.setActividades(rs.getString(4));
	            m.setEstado(rs.getString(5));
	            m.setCliente_id(rs.getInt(6));

	            return m;
	        }    
	    });    
	}

}

