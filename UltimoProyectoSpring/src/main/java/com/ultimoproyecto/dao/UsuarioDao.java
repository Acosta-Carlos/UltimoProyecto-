package com.ultimoproyecto.dao;

import com.ultimoproyecto.beans.Login;
import com.ultimoproyecto.beans.Usuario;

public interface UsuarioDao {

  int registro(Usuario usuario);

  Usuario validarUsuario(Login login);
}
