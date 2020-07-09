package com.ultimoproyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;

import com.ultimoproyecto.beans.Pago;
import com.ultimoproyecto.dao.PagoDao;

@Controller ("/pago")
public class PagoControlador {

	@Autowired
	PagoDao daopag;
	
    @RequestMapping("/pagform")    
    public String showform(Model m){    
        m.addAttribute("command", new Pago());  
        return "pagform";
    } 

    @RequestMapping(value="/pagosave",method = RequestMethod.POST)    
    public String save(@ModelAttribute("pag") Pago pag){    
        daopag.save(pag);
        return "redirect:/viewpag";
    }
    
    @RequestMapping("/viewpag")    
    public String viewpag(Model m){    
        List<Pago> list=daopag.getPago();
        m.addAttribute("list",list);  
        return "viewpag";
    }
    
    @RequestMapping(value="/editpag/{idpago}")    
    public String edit(@PathVariable int idpago, Model m){    
        Pago pag=daopag.getEmpById(idpago);
        m.addAttribute("command",pag);
        return "pageditform";
    }

    @RequestMapping(value="/pageditsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("pag") Pago pag){
        daopag.update(pag);
        return "redirect:/viewpag";
    }

    @RequestMapping(value="/deletepag/{idpago}",method = RequestMethod.GET)    
    public String delete(@PathVariable int idpago){    
        daopag.delete(idpago);    
        return "redirect:/viewpag";
    }
    
}

