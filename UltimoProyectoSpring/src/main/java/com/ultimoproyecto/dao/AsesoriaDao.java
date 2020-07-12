package com.ultimoproyecto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ultimoproyecto.beans.Asesoria;

public class AsesoriaDao {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}

	public int save(Asesoria ase){    
	    String sql="insert into Asesorias (idasesoria,detalle,gestion,propuestas,fecha,especial,visitaid) values('"+ase.getIdasesoria()+"','" +ase.getDetalle() + "','" +ase.getPropuestas()+ "','" +ase.getFecha()+ "','" +ase.getEspecial() + "','" +ase.getVisitaid() + "')";
	    return template.update(sql);
	}
	
	public int update(Asesoria ase){    
	    String sql="update Asesorias set detalle='"+ase.getDetalle()+"', gestion='"+ase.getGestion()+"', propuestas='"+ase.getPropuestas()+"', fecha='"+ase.getFecha()+"', especial="+ase.getEspecial()+"' where id="+ase.getIdasesoria()+"";
	    return template.update(sql);    
	}   
	
	public int delete(int idasesoria){    
	    String sql="delete from Asesorias where idasesoria="+idasesoria+"";
	    return template.update(sql);
	}    
	
	public Asesoria getAsesoriaById(int idasesoria){    
	    String sql="select * from Asesorias where idasesoria=?";
	    return template.queryForObject(sql, new Object[]{idasesoria},new BeanPropertyRowMapper<Asesoria>(Asesoria.class));    
	}
	
	public List<Asesoria> getAsesoria(){    
	    return template.query("select * from Asesorias",new RowMapper<Asesoria>(){    
	        public Asesoria mapRow(ResultSet rs, int row) throws SQLException {    
	            Asesoria ase=new Asesoria();    
	            ase.setIdasesoria(rs.getInt(1));    
	            ase.setDetalle(rs.getString(2));    
	            ase.setGestion(rs.getString(3));
	            ase.setPropuestas(rs.getString(4));
	            ase.setFecha(rs.getString(5));
	            ase.setEspecial(rs.getString(6));
	            ase.setVisitaid(rs.getInt(7));
	            return ase;
	        }    
	    });    
	}

}
