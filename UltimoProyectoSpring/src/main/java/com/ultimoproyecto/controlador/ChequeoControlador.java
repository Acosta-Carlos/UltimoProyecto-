package com.ultimoproyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ultimoproyecto.beans.Chequeo;
import com.ultimoproyecto.dao.ChequeoDao;

public class ChequeoControlador {

	@Controller ("/checklist")
	public class ChecklistControlador {

		@Autowired
		ChequeoDao dao;
		
	    @RequestMapping("/checform")    
	    public String showform(Model m){    
	        m.addAttribute("command", new Chequeo());  
	        return "chechform";
	    } 

	    @RequestMapping(value="/checklist/save",method = RequestMethod.POST)    
	    public String save(@ModelAttribute("chec") Chequeo chec){    
	        dao.save(chec);
	        return "redirect:/viewchec";
	    }
	    
	    @RequestMapping("/viewchec")    
	    public String viewcli(Model m){    
	        List<Chequeo> list=dao.getChequeo();
	        m.addAttribute("list",list);  
	        return "viewchec";
	    }
	    
	    @RequestMapping(value="/editchec/{id}")    
	    public String edit(@PathVariable int id, Model m){    
	        Chequeo chec=dao.getChequeoById(id);
	        m.addAttribute("command",chec);
	        return "checeditform";
	    }

	    @RequestMapping(value="/checklist/editsave",method = RequestMethod.POST)    
	    public String editsave(@ModelAttribute("chec") Chequeo chec){
	        dao.update(chec);
	        return "redirect:/viewchec";
	    }

	    @RequestMapping(value="/deletechec/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int id){    
	        dao.delete(id);    
	        return "redirect:/viewchec";
	    }
	}
}	
