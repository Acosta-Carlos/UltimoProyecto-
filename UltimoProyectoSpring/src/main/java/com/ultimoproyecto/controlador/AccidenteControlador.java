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


	import com.ultimoproyecto.beans.Accidente;
	import com.ultimoproyecto.dao.AccidenteDao;

		
		@Controller ("/accidente")
		public  class AccidenteControlador {

			@Autowired
			AccidenteDao accidao;
			
			static Logger log = Logger.getLogger(AccidenteControlador.class.getName());
			
		    @RequestMapping("/accidenteform")    
		    public String showform(Model m){    
		        m.addAttribute("command", new Accidente());  
		        log.info("Ingreso a formulario de creación de accidentes");
		        return "accidenteform";
		    } 

		    @RequestMapping(value="/saveacci",method = RequestMethod.POST)    
		    public String save(@ModelAttribute("acci") Accidente acci){    
		        accidao.save(acci);
		        log.info("Accidente creada: " + acci.toString());
		        return "redirect:/viewaccidente";
		    }
		    
		    @RequestMapping("/viewaccidente")    
		    public String viewaccidente(Model m){    
		        List<Accidente> list=accidao.getAccidentes();
		        m.addAttribute("list",list);  
		        log.info("Listado de accidente");
		        return "viewaccidente";
		    }
		    
		    @RequestMapping(value="/editacci/{idaccidente}")    
		    public String edit(@PathVariable int idaccidente, Model m){    
		        Accidente acci=accidao.getAcciById(idaccidente);
		        m.addAttribute("command",acci);
		        log.info("Ingreso a edición de accidentes");
		        return "accidenteeditform";
		    }

		    @RequestMapping(value="/editsaveacci",method = RequestMethod.POST)    
		    public String editsave(@ModelAttribute("acci") Accidente acci){
		        accidao.update(acci);
		        log.info("Procesando edición de Accidentes");
		        return "redirect:/viewaccidente";
		    }

		    @RequestMapping(value="/deleteacci/{idaccidente}",method = RequestMethod.GET)    
		    public String delete(@PathVariable int idaccidente){    
		        accidao.delete(idaccidente);    
		        log.debug("DEBUG - Accidente eliminado");
		        return "redirect:/viewaccidente";
		    }
		    
		}



