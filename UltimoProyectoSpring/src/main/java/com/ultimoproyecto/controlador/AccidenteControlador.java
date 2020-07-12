package com.ultimoproyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;

import com.ultimoproyecto.beans.Accidente;
import com.ultimoproyecto.dao.AccidenteDao;

	@Controller
	public class AccidenteControlador {

		@Autowired
		AccidenteDao accdao;
		
	    @RequestMapping("/accform")    
	    public String showform(Model m){    
	        m.addAttribute("command", new Accidente());  
	        return "accform";
	    } 

	    @RequestMapping(value="/accsave",method = RequestMethod.POST)    
	    public String save(@ModelAttribute("acc") Accidente acc){    
	    	accdao.save(acc);
	        return "redirect:/viewacc";
	    }
	    
	    @RequestMapping("/viewacc")    
	    public String viewcap(Model m){    
	        List<Accidente> list=accdao.getAccidente();
	        m.addAttribute("list",list);  
	        return "viewacc";
	    }
	  
	    @RequestMapping(value="/accedit/{idaccidente}")    
	    public String edit(@PathVariable int idaccidente, Model m){    
	    	Accidente acc=accdao.getCliById(idaccidente);
	        m.addAttribute("command",acc);
	        return "acceditform";
	    }

	    @RequestMapping(value="/editaccsave",method = RequestMethod.POST)    
	    public String editsave(@ModelAttribute("acc") Accidente acc){
	    	accdao.update(acc);
	        return "redirect:/viewacc";
	    }

	    @RequestMapping(value="/deleteacc/{idaccidente}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int idaccidente){    
	    	accdao.delete(idaccidente);    
	        return "redirect:/viewacc";
	    }
	    
	}
	

