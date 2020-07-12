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

import com.ultimoproyecto.beans.Pago;
import com.ultimoproyecto.dao.PagoDao;

@Controller ("/pago")
public class PagoControlador {

	@Autowired
	PagoDao daopag;
	
	static Logger log = Logger.getLogger(CapacitacionControlador.class.getName());
	
    @RequestMapping("/pagform")    
    public String showform(Model m){    
        m.addAttribute("command", new Pago());
        log.info("Ingreso a formulario de creación de pagos");
        return "pagform";
    } 

    @RequestMapping(value="/pagosave",method = RequestMethod.POST)    
    public String save(@ModelAttribute("pag") Pago pag){    
        daopag.save(pag);
        log.info("Capacitación creada: " + pag.toString());
        return "redirect:/viewpag";
    }
    
    @RequestMapping("/viewpag")    
    public String viewpag(Model m){    
        List<Pago> list=daopag.getPago();
        m.addAttribute("list",list);
        log.info("Listado de pagos");
        return "viewpag";
    }
    
    @RequestMapping(value="/editpag/{idpago}")    
    public String edit(@PathVariable int idpago, Model m){    
        Pago pag=daopag.getEmpById(idpago);
        m.addAttribute("command",pag);
        log.info("Ingreso a edición de pagos");
        return "pageditform";
    }

    @RequestMapping(value="/pageditsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("pag") Pago pag){
        daopag.update(pag);
        log.info("Procesando edición de Pagos");
        return "redirect:/viewpag";
    }

    @RequestMapping(value="/deletepag/{idpago}",method = RequestMethod.GET)    
    public String delete(@PathVariable int idpago){    
        daopag.delete(idpago);
        log.debug("DEBUG - Pago eliminado");
        return "redirect:/viewpag";
    }
    
}

