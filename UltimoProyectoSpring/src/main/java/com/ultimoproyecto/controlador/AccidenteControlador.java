package com.ultimoproyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ultimoproyecto.beans.Accidente;
import com.ultimoproyecto.dao.AccidenteDao;

@Controller("/accidente")
public class AccidenteControlador {
	
	@Autowired
	AccidenteDao dao;
	
    @RequestMapping("/accform")    
    public String showform(Model m){    
        m.addAttribute("command", new Accidente());  
        return "accform";
    } 

    @RequestMapping(value="/accidente/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("acc") Accidente acc){    
        dao.save(acc);
        return "redirect:/viewacc";
    }
    
    @RequestMapping("/viewacc")    
    public String viewacc(Model m){    
        List<Accidente> list=dao.getAccidentes();
        m.addAttribute("list",list);  
        return "viewacc";
    }

}
