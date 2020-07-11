package com.ultimoproyecto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ultimoproyecto.beans.Login;
import com.ultimoproyecto.beans.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  public int registro(Usuario u) {
    String sql="insert into Usuarios (username,password,role,nombre,correoelectronico,activado) values('" +u.getUsername()+"','" +u.getPassword()+"','" +u.getRole()+"','" +u.getNombre()+"','" +u.getCorreoelectronico()+"','" +u.getActivado()+ "')";
    return jdbcTemplate.update(sql);
  }

  public Usuario validarUsuario(Login login) {
    String sql = "select * from usuarios where username='" + login.getUsername() + "' and password='" + login.getPassword() + "'";
    List<Usuario> usuarios = jdbcTemplate.query(sql, new UserMapper());

    return usuarios.size() > 0 ? usuarios.get(0) : null;
  }

}

class UserMapper implements RowMapper<Usuario> {

  public Usuario mapRow(ResultSet rs, int arg1) throws SQLException {
    
	Usuario usu = new Usuario();

	usu.setUsername(rs.getString("username"));
	usu.setPassword(rs.getString("password"));
	usu.setRole(rs.getString("role"));
	usu.setNombre(rs.getString("nombre"));
	usu.setCorreoelectronico(rs.getString("correoelectronico"));  
	usu.setActivado(rs.getInt("activado"));

    return usu;
  }
}