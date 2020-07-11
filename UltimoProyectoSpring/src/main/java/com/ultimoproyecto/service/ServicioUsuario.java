package com.ultimoproyecto.service;

import com.ultimoproyecto.beans.Login;
import com.ultimoproyecto.beans.Usuario;

public interface ServicioUsuario {

  int registro(Usuario usuario);

  Usuario validarUsuario(Login login);
}
