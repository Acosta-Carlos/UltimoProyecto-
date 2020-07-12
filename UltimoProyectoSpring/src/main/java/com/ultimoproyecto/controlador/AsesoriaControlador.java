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


import com.ultimoproyecto.beans.Asesoria;
import com.ultimoproyecto.dao.AsesoriaDao;




	@Controller("/asesoria")
	public class AsesoriaControlador {
	
	
		@Autowired
		AsesoriaDao asesodao;
		
		static Logger log = Logger.getLogger(AsesoriaControlador.class.getName());
		
	    @RequestMapping("/asesoriaform")    
	    public String showform(Model m){    
	        m.addAttribute("command", new Asesoria());  
	        log.info("Ingreso a formulario de creación de asesorias");
	        return "asesoriaform";
	    } 

	    @RequestMapping(value="/savease",method = RequestMethod.POST)    
	    public String save(@ModelAttribute("ase") Asesoria ase){    
	        asesodao.save(ase);
	        log.info("Asesoria creada: " + ase.toString());
	        return "redirect:/viewasesoria";
	    }
	    
	    @RequestMapping("/viewasesoria")    
	    public String viewase(Model m){    
	        List<Asesoria> list=asesodao.getAsesorias();
	        m.addAttribute("list",list);  
	        log.info("Listado de asesorias");
	        return "viewasesoria";
	    }
	    
	    @RequestMapping(value="/editase/{idasesoria}")    
	    public String edit(@PathVariable int idasesoria, Model m){    
	        Asesoria ase=asesodao.getAseById(idasesoria);
	        m.addAttribute("command",ase);
	        log.info("Ingreso a edición de asesorias");
	        return "asesoriaeditform";
	    }

	    @RequestMapping(value="/editsavease",method = RequestMethod.POST)    
	    public String editsave(@ModelAttribute("ase") Asesoria ase){
	        asesodao.update(ase);
	        log.info("Procesando edición de Asesorias");
	        return "redirect:/viewasesoria";
	    }

	    @RequestMapping(value="/deletease/{idasesoria}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int idasesoria){    
	        asesodao.delete(idasesoria);    
	        log.debug("DEBUG - Asesoria eliminada");
	        return "redirect:/viewasesoria";
	    }
	    
	}



