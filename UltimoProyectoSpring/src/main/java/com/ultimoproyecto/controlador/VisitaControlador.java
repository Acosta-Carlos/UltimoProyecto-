package com.ultimoproyecto.controlador;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ultimoproyecto.beans.Visita;
import com.ultimoproyecto.dao.VisitaDao;

@Controller("/visita") 
public class VisitaControlador {
	
	@Autowired
	VisitaDao visidao;
	
	static Logger log = Logger.getLogger(VisitaControlador.class.getName());
	
    @RequestMapping("/visitaform")    
    public String showform(Model m){    
        m.addAttribute("command", new Visita());  
        log.info("Ingreso a formulario de creación de visita");
        return "visitaform";
    } 

    @RequestMapping(value="/savevisita",method = RequestMethod.POST)    
    public String save(@ModelAttribute("v") Visita v){    
        visidao.save(v);
        log.info("Accidente creada: " + v.toString());
        return "redirect:/viewvisita";
    }
    
    @RequestMapping("/viewvisita")    
    public String viewvisita(Model m){    
        List<Visita> list=visidao.getVisitas();
        m.addAttribute("list",list);  
        log.info("Listado de Visitas");
        return "viewvisita";
    }
    
    @RequestMapping(value="/editvisita/{idvisita}")    
    public String edit(@PathVariable int idvisita, Model m){    
        Visita v=visidao.getVisById(idvisita);
        m.addAttribute("command",v);
        log.info("Ingreso a edición de Visitas");
        return "visitaeditform";
    }

    @RequestMapping(value="/editsavevisita",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("v") Visita v){
        visidao.update(v);
        log.info("Procesando edición de Visitas");
        return "redirect:/viewvisita";
    }

    @RequestMapping(value="/deletevisita/{idvisita}",method = RequestMethod.GET)    
    public String delete(@PathVariable int idvisita){    
        visidao.delete(idvisita);    
        log.debug("DEBUG - Visita eliminada");
        return "redirect:/viewvisita";
    }

}
