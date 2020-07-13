package com.ultimoproyecto.dao;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;

import com.ultimoproyecto.beans.Cliente;

public class ReporteDao {
	/*datos de cliente --> id, nombre, correo
	 *datos de visita --> id_profesional, resumen, fecha*/

	//conexión BD
		JdbcTemplate template;
		
		public void setTemplate(JdbcTemplate template) {    
		    this.template = template;    
		}
				
		public Cliente getCliById(int id){    
		    String sql="select * from Cliente where id=?"; 
		    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Cliente>(Cliente.class));    
		}
		public List<Visita> getVisitas(int id){    
		    return template.query("select * from Visitas where cliente_id=?",new RowMapper<Visita>(){    
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
