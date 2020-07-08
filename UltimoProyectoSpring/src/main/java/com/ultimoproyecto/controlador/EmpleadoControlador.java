package com.ultimoproyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ultimoproyecto.beans.Empleado;
import com.ultimoproyecto.dao.EmpleadoDao;

@Controller ("/empleado")
public class EmpleadoControlador {

	@Autowired
	EmpleadoDao daoemp;
	
    @RequestMapping("/empform")    
    public String showform(Model m){    
        m.addAttribute("command", new Empleado());  
        return "empform";
    } 
	
    @RequestMapping(value="/empleado/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("emp") Empleado emp){    
        daoemp.save(emp);
        return "redirect:/viewemp";
    }
    
    @RequestMapping("/viewemp")    
    public String viewemp(Model m){
        List<Empleado> list=daoemp.getEmpleados();
        m.addAttribute("list",list);  
        return "viewemp";
    }	
    
    @RequestMapping(value="/editemp/{idempleado}")    
    public String edit(@PathVariable int idempleado, Model m){    
        Empleado emp=daoemp.getEmpById(idempleado);
        m.addAttribute("command",emp);
        return "empditform";
    }

    @RequestMapping(value="/empleado/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("emp") Empleado emp){
        daoemp.update(emp);
        return "redirect:/viewemp";
    }

    @RequestMapping(value="/deleteemp/{idempleado}",method = RequestMethod.GET)    
    public String delete(@PathVariable int idempleado){    
        daoemp.delete(idempleado);    
        return "redirect:/viewemp";
    }
    
}
