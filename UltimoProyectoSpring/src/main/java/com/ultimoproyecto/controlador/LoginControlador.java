package com.ultimoproyecto.controlador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ultimoproyecto.beans.Login;
import com.ultimoproyecto.beans.Usuario;
import com.ultimoproyecto.service.ServicioUsuario;

@Controller
public class LoginControlador {

  @Autowired
  ServicioUsuario ServicioUsuario;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("login", new Login());

    return mav;
  }

  @RequestMapping(value = "/procesoLogin", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("login") Login login) {
    ModelAndView mav = null;

    Usuario usuario = ServicioUsuario.validarUsuario(login);

    if (usuario != null) {
      mav = new ModelAndView("main");
      mav.addObject("nombre", usuario.getNombre());
    } else {
      mav = new ModelAndView("login");
      mav.addObject("message", "Error de usuario o contraseña");
    }

    return mav;
  }

}
