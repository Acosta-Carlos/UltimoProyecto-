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

import com.ultimoproyecto.beans.Empleado;
import com.ultimoproyecto.dao.EmpleadoDao;

@Controller ("/empleado")
public class EmpleadoControlador {

	static Logger log = Logger.getLogger(CapacitacionControlador.class.getName());
	
	@Autowired
	EmpleadoDao daoemp;
	
    @RequestMapping("/empform")    
    public String showform(Model m){    
        m.addAttribute("command", new Empleado());
        log.info("Ingreso a formulario de creación de empleados");
        return "empform";
    } 
	
    @RequestMapping(value="/emplsave",method = RequestMethod.POST)    
    public String save(@ModelAttribute("emp") Empleado emp){    
        daoemp.save(emp);
        log.info("Empleado creado: " + emp.toString());
        return "redirect:/viewemp";
    }
    
    @RequestMapping("/viewemp")    
    public String viewemp(Model m){
        List<Empleado> list=daoemp.getEmpleados();
        m.addAttribute("list",list);
        log.info("Listado de Empleados");
        return "viewemp";
    }	
    
    @RequestMapping(value="/editemp/{idempleado}")    
    public String edit(@PathVariable int idempleado, Model m){    
        Empleado emp=daoemp.getEmpById(idempleado);
        m.addAttribute("command",emp);
        log.info("Ingreso a edición de empleados");
        return "empeditform";
    }

    @RequestMapping(value="/empleditsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("emp") Empleado emp){
        daoemp.update(emp);
        log.info("Procesando edición de Empleados");
        return "redirect:/viewemp";
    }

    @RequestMapping(value="/deleteemp/{idempleado}",method = RequestMethod.GET)    
    public String delete(@PathVariable int idempleado){    
        daoemp.delete(idempleado);
        log.debug("DEBUG - Empleado eliminado");
        return "redirect:/viewemp";
    }
    
}
