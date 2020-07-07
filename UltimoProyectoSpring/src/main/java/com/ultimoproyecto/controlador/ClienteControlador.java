package com.ultimoproyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;

import com.ultimoproyecto.beans.Cliente;
import com.ultimoproyecto.dao.ClienteDao;

@Controller
public class ClienteControlador {

	@Autowired
	ClienteDao dao;
	
    @RequestMapping("/cliform")    
    public String showform(Model m){    
        m.addAttribute("command", new Cliente());  
        return "cliform";
    } 

    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("cli") Cliente cli){    
        dao.save(cli);
        return "redirect:/viewcli";
    }
    
    @RequestMapping("/viewcli")    
    public String viewcli(Model m){    
        List<Cliente> list=dao.getClientes();
        m.addAttribute("list",list);  
        return "viewcli";
    }
    
    @RequestMapping(value="/editcli/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Cliente cli=dao.getCliById(id);
        m.addAttribute("command",cli);
        return "clieditform";
    }

    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("cli") Cliente cli){
        dao.update(cli);
        return "redirect:/viewcli";
    }

    @RequestMapping(value="/deletecli/{id}",method = RequestMethod.GET)    
    public String delete(@PathVariable int id){    
        dao.delete(id);    
        return "redirect:/viewcli";
    }
    
}

