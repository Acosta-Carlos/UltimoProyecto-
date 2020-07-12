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

import com.ultimoproyecto.beans.Accidente;
import com.ultimoproyecto.dao.AccidenteDao;

	@Controller ("/accidente")
	public class AccidenteControlador {

		static Logger log = Logger.getLogger(AccidenteControlador.class.getName());
		
		@Autowired
		AccidenteDao accdao;
		
	    @RequestMapping("/accform")    
	    public String showform(Model m){    
	        m.addAttribute("command", new Accidente());
	        log.info("Ingreso a formulario de creación de accidentes");
	        return "accform";
	    } 

	    @RequestMapping(value="/accsave",method = RequestMethod.POST)    
	    public String save(@ModelAttribute("acc") Accidente acc){    
	    	accdao.save(acc);
	    	log.info("Accidente creada: " + acc.toString());
	        return "redirect:/viewacc";
	    }
	    
	    @RequestMapping("/viewacc")    
	    public String viewcap(Model m){    
	        List<Accidente> list=accdao.getAccidentes();
	        m.addAttribute("list",list);  
	        log.info("Listado de accidente");
	        return "viewacc";
	    }
	  
	    @RequestMapping(value="/editacc/{idaccidente}")    
	    public String edit(@PathVariable int idaccidente, Model m){    
	    	Accidente acc=accdao.getAcciById(idaccidente);
	        m.addAttribute("command",acc);
	        log.info("Ingreso a edición de accidentes");
	        return "acceditform";
	    }

	    @RequestMapping(value="/acceditsave",method = RequestMethod.POST)    
	    public String editsave(@ModelAttribute("acc") Accidente acc){
	    	accdao.update(acc);
	    	log.info("Procesando edición de Accidentes");
	        return "redirect:/viewacc";
	    }

	    @RequestMapping(value="/deleteacc/{idaccidente}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int idaccidente){    
	    	accdao.delete(idaccidente);
	    	log.debug("DEBUG - Accidente eliminado");
	        return "redirect:/viewacc";
	    }
	    
	    @RequestMapping("/r_accform")    
	    public String showform2(Model m){    
	        m.addAttribute("command", new Accidente());
	        log.info("Ingreso a formulario de creación de accidentes");
	        return "r_accform";
	    } 

	    @RequestMapping(value="/r_accsave",method = RequestMethod.POST)    
	    public String save2(@ModelAttribute("acc") Accidente acc){    
	    	accdao.save(acc);
	    	log.info("Accidente creada: " + acc.toString());
	        return "viewrespcli";
	    }
	}
	

