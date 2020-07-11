package com.ultimoproyecto.controlador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ultimoproyecto.beans.Usuario;
import com.ultimoproyecto.service.ServicioUsuario;

@Controller
public class RegistroControlador {
  @Autowired
  public ServicioUsuario servicioUsuario;

  @RequestMapping(value = "/registro", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("registro");
    mav.addObject("usuario", new Usuario());

    return mav;
  }

  @RequestMapping(value = "/hacerRegistro", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("usuario") Usuario usuario) {

	  servicioUsuario.registro(usuario);

    return new ModelAndView("main", "Nombre", usuario.getNombre());
  }
}
