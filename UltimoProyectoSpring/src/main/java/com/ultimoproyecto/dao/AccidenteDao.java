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
		
		public int save(Accidente c){    
		    String sql="insert into Accidente (Id accidente,Fecha,Hora,Suceso,Lugar,Cliente id) values('"+c.getIdaccidente()+"','"+c.getFecha()+"','"+c.getHora()+"','"+c.getSuceso()+"','"+c.getLugar()+"','"+c.getClienteid()+"')";
		    return template.update(sql);
		}
		
		public int update(Accidente c){    
		    String sql="update Cliente set idaccidente='"+c.getIdaccidente()+"', Fecha='"+c.getFecha()+"', Hora='"+c.getHora()+"',Suceso='"+c.getSuceso()+"', Lugar='"+c.getLugar()+"', Cliente id='"+c.getClienteid()+"' where idaccidente="+c.getIdaccidente()+"";
		    return template.update(sql);    
		}   
		
		public int delete(int idaccidente){    
		    String sql="delete from Cliente where idaccidente="+idaccidente+"";
		    return template.update(sql);
		}    

		public Accidente getCliById(int idaccidente){    
		    String sql="select * from Accidente where idaccidente=?";
		    return template.queryForObject(sql, new Object[]{idaccidente},new BeanPropertyRowMapper<Accidente>(Accidente.class));    
		}
		
		public List<Accidente> getAccidente(){    
		    return template.query("select * from Accidente",new RowMapper<Accidente>(){    
		        public Accidente mapRow(ResultSet rs, int row) throws SQLException {    
		        	Accidente c=new Accidente();    
		            c.setIdaccidente(rs.getInt(1));    
		            c.setFecha(rs.getString(2));    
		            c.setHora(rs.getString(3));
		            c.setSuceso(rs.getString(4));
		            c.setLugar(rs.getString(5));
		            c.setClienteid(rs.getInt(6));
		            return c;
		        }    
		    });    
		}    	
		
		
	}

