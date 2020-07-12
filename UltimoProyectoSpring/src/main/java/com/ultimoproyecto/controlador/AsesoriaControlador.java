package com.ultimoproyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ultimoproyecto.beans.Asesoria;
import com.ultimoproyecto.dao.AsesoriaDao;

@Controller ("/asesoria")
public class AsesoriaControlador {

	@Autowired
	AsesoriaDao daoase;
		
	@SuppressWarnings("hiding")
	@RequestMapping("/aseform")    
	public <Model> String showform(Model m){    
	m.addAttribute("command", new Asesoria());  
	return "aseform";
	} 

	@RequestMapping(value="/asesoria/save",method = RequestMethod.POST)    
	public String save(@ManagedAttribute("Asesoria") Asesoria ase){    
		daoase.save(ase);
		return "redirect:/viewase";
	 }
	    
	 @RequestMapping("/viewase")    
	 public String viewase(Model m){    
	     List<Asesoria> list=daoase.getAsesoria();
	     m.addAttribute("list",list);  
	     return "viewase";
	  }
	    
	 @RequestMapping(value="/editase/{ase}")    
	 public String edit(@PathVariable int id, Model m){    
	     Asesoria ase=daoase.getAsesoriaById(id);
	     m.addAttribute("command",ase);
	     return "aseeditform";
	  }

	    @RequestMapping(value="/asesoria/editsave",method = RequestMethod.POST)    
	    public String editsave(@ModelAttribute("ase") Asesoria ase){
	        daoase.update(ase);
	        return "redirect:/viewase";
	  }

	    @RequestMapping(value="/deletease/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int id){    
	        daoase.delete(id);    
	        return "redirect:/viewase";
	   }
	    
}


