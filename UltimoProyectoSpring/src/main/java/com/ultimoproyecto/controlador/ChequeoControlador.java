package com.ultimoproyecto.controlador;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ultimoproyecto.beans.Chequeo;
import com.ultimoproyecto.dao.ChequeoDao;

@Controller("/chequeo")
public class ChequeoControlador {
	
	
	@Autowired
	ChequeoDao chedao;
	
	static Logger log = Logger.getLogger(ChequeoControlador.class.getName());
	
    @RequestMapping("/chequeoform")    
    public String showform(Model m){    
        m.addAttribute("command", new Chequeo());  
        log.info("Ingreso a formulario de creación de Chequeo");
        return "chequeoform";
    } 

    @RequestMapping(value="/savechequeo",method = RequestMethod.POST)    
    public String save(@ModelAttribute("ch") Chequeo ch){    
        chedao.save(ch);
        log.info("Chequeo creado: " + ch.toString());
        return "redirect:/viewchequeo";
    }
    
    @RequestMapping("/viewchequeo")    
    public String viewchequeo(Model m){    
        List<Chequeo> list=chedao.getChequeos();
        m.addAttribute("list",list);  
        log.info("Listado de Chequeos");
        return "viewchequeo";
    }
    
    @RequestMapping(value="/editchequeo/{idchequeo}")    
    public String edit(@PathVariable int idchequeo, Model m){    
        Chequeo ch=chedao.getCheById(idchequeo);
        m.addAttribute("command",ch);
        log.info("Ingreso a edición de Chequeos");
        return "chequeoeditform";
    }

    @RequestMapping(value="/editsavechequeo",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("ch") Chequeo ch){
        chedao.update(ch);
        log.info("Procesando edición de Chequeos");
        return "redirect:/viewchequeo";
    }

    @RequestMapping(value="/deletechequeo/{idchequeo}",method = RequestMethod.GET)    
    public String delete(@PathVariable int idchequeo){    
        chedao.delete(idchequeo);    
        log.debug("DEBUG - Chequeo eliminado");
        return "redirect:/viewchequeo";
    }
}
