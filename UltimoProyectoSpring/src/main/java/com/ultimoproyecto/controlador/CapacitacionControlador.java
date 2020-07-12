package com.ultimoproyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.log4j.Logger;

import com.ultimoproyecto.beans.Capacitacion;
import com.ultimoproyecto.dao.CapacitacionDao;   

@Controller ("/capacitacion")
public class CapacitacionControlador {

	static Logger log = Logger.getLogger(CapacitacionControlador.class.getName());
	
	@Autowired
	CapacitacionDao capadao;
	
    @RequestMapping("/capform")    
    public String showform(Model m){    
        m.addAttribute("command", new Capacitacion());
        log.info("Ingreso a formulario de creación de capacitaciones");
        return "capform";
    } 

    @RequestMapping(value="/capsave",method = RequestMethod.POST)    
    public String save(@ModelAttribute("cap") Capacitacion cap){    
    	capadao.save(cap);
    	log.info("Capacitación creada: " + cap.toString());
        return "redirect:/viewcap";
    }
    
    @RequestMapping("/viewcap")    
    public String viewcap(Model m){    
        List<Capacitacion> list=capadao.getCapacitacion();
        m.addAttribute("list",list);
        log.info("Listado de capacitaciones");
        return "viewcap";
    }
  
    @RequestMapping(value="/editcap/{idcapacitacion}")    
    public String edit(@PathVariable int idcapacitacion, Model m){    
    	Capacitacion cap=capadao.getCapById(idcapacitacion);
        m.addAttribute("command",cap);
        log.info("Ingreso a edición de capacitaciones");
        return "capeditform";
    }

    @RequestMapping(value="/editcapsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("cap") Capacitacion cap){
    	capadao.update(cap);
    	log.info("Procesando edición de Capacitaciones");
        return "redirect:/viewcap";
    }

    @RequestMapping(value="/deletecap/{idcapacitacion}",method = RequestMethod.GET)    
    public String delete(@PathVariable int idcapacitacion){    
    	capadao.delete(idcapacitacion);
    	log.debug("DEBUG - Capacitación eliminada");
        return "redirect:/viewcap";
    }
  
}