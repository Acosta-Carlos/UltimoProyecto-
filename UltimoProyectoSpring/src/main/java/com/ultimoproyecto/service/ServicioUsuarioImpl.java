package com.ultimoproyecto.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ultimoproyecto.dao.UsuarioDao;
import com.ultimoproyecto.beans.Login;
import com.ultimoproyecto.beans.Usuario;

public class ServicioUsuarioImpl implements ServicioUsuario {

  @Autowired
  public UsuarioDao usuarioDao;

  public int registro(Usuario usuario) {
    return usuarioDao.registro(usuario);
  }

  public Usuario validarUsuario(Login login) {
    return usuarioDao.validarUsuario(login);
  }

}
