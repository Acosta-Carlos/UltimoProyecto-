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

import com.ultimoproyecto.beans.Mejora;
import com.ultimoproyecto.dao.MejoraDao;

@Controller("/mejora")
public class MejoraControlador {
	

	static Logger log = Logger.getLogger(CapacitacionControlador.class.getName());
	
	@Autowired
	MejoraDao daomej;
	
	@RequestMapping("/mejform")
	public String showform(Model m) {

		m.addAttribute("command", new Mejora());
		log.info("Ingreso a formulario de creación de mejoras");

        return "mejform";
	}
	
	@RequestMapping(value="/mejsave",method = RequestMethod.POST)    
    public String save(@ModelAttribute("mej") Mejora mej){    
        daomej.save(mej);

        log.info("Mejoras creadas: " + mej.toString());

        return "redirect:/viewmej";
    }
    
    @RequestMapping("/viewmej")    
    public String viewmej(Model m){    
        List<Mejora> list=daomej.getMejoras();

        m.addAttribute("list",list);
        log.info("Listado de mejoras");

        return "viewmej";
    }
    
    @RequestMapping(value="/editmej/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Mejora mej=daomej.getMejById(id);
        m.addAttribute("command",mej);

        log.info("Ingreso a edición de mejoras");

        return "mejeditform";
    }

    @RequestMapping(value="/mejeditsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("cli") Mejora mej){
        daomej.update(mej);

        log.info("Procesando edición de Mejoras");

        return "redirect:/viewmej";
    }

    @RequestMapping(value="/deletemej/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    

        daomej.delete(id);
        log.debug("DEBUG - Mejora eliminada");
        return "redirect:/viewmej";
    }
}

