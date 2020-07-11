package com.ultimoproyecto.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;       
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;

import com.ultimoproyecto.beans.Asesoria;
import com.ultimoproyecto.dao.AsesoriaDao;

@Controller("/asesoria")
public class AsesoriaControlador {
	
	@Autowired
	AsesoriaDao dao;
	
    @RequestMapping("/aseform")    
    public String showform(Model m){    
        m.addAttribute("command", new Asesoria());  
        return "aseform";
    } 

    @RequestMapping(value="/asesoria/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("ase") Asesoria ase){    
        dao.save(ase);
        return "redirect:/viewase";
    }
    
    @RequestMapping("/viewase")    
    public String viewase(Model m){    
        List<Asesoria> list=dao.getAsesorias();
        m.addAttribute("list",list);  
        return "viewase";
    }
	
}
