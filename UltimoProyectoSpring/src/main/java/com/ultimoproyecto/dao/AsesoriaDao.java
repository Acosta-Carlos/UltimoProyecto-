package com.ultimoproyecto.dao;

import java.sql.ResultSet;

import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;

import com.ultimoproyecto.beans.Asesoria;




public class AsesoriaDao {
	
JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}
	
	public int save(Asesoria a){    
	    String sql="insert into Asesorias (idasesoria,detalle,gestion,propuestas,fecha,especial,visitas_idvisita)"
	    		+ " values('"+a.getIdasesoria()+"',"+a.getDetalle()+",'"+a.getGestion()+"','"+a.getPropuestas()+"','"+a.getFecha()+"','"+a.getEspecial()+"','"+a.getVisitas_idvisita()+"')";
	    return template.update(sql);


	}
	
	public List<Asesoria> getAsesorias(){    
	    return template.query("select * from Asesorias",new RowMapper<Asesoria>(){    
	        public Asesoria mapRow(ResultSet rs, int row) throws SQLException {    
	            Asesoria a=new Asesoria();    
	            a.setIdasesoria(rs.getInt(1));
				a.setDetalle(rs.getString(2));
				a.setGestion(rs.getString(3));
				a.setPropuestas(rs.getString(4));
				a.setFecha(rs.getString(5));
				a.setEspecial(rs.getString(6));
				a.setVisitas_idvisita(rs.getInt(7));
	            return a;
	        }    
	    });    
	}    	
}



