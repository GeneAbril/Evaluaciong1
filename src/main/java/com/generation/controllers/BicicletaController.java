package com.generation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.models.Bicicleta;
import com.generation.services.BicicletaService;

@Controller
@RequestMapping("/bicicleta")
public class BicicletaController {

    @Autowired
	BicicletaService bicicletaService;

    @RequestMapping("")
	public String inicio(@ModelAttribute("bicicleta") Bicicleta bicicleta) {
		
		return "bici.jsp";
}
@PostMapping("/guardar")
	public String guardarBicicleta(@Valid @ModelAttribute("bicicleta") Bicicleta bicicleta,
			BindingResult resultado,
			Model model) {
		
		
		if(resultado.hasErrors()) {
			model.addAttribute("msgError","Datos erroneos");
			return "bici.jsp";
		}else {
			//enviamos el obeto a persistir en base datos
			bicicletaService.guardarBicicleta(bicicleta);
			//obtener una lista de bicicletas
			List<Bicicleta> listaBicicleta = bicicletaService.findAll();
			//pasamos la lista de bicicletas al jsp
			model.addAttribute("bicicletaCapturados", listaBicicleta);
			return "mostrarBicicleta.jsp";
		}

        }
        @RequestMapping("/editar/{id}") //editar para el despliegue 
	public String editar(@PathVariable("id") Long id,
			Model model) {
		System.out.println("el id es: "+id);
		
		Bicicleta bicicleta = bicicletaService.buscarId(id);
		model.addAttribute("bicicleta", bicicleta);//pasar al jsp
		
		return "editarBicicleta.jsp";//redireccionar a otra url o path
	} 

    @PostMapping("/actualizar/{id}")
	public String actualizarBicicleta(@PathVariable("id") Long id,@Valid @ModelAttribute("bicicleta") Bicicleta bicicleta,
			BindingResult resultado,
			Model model) {
		System.out.println("el id al actualizar es: "+id +" getId "+bicicleta.getId());
		

		if(resultado.hasErrors()) {
			model.addAttribute("msgError","Datos erroneos");
			return "editarBicicleta.jsp";
		}else {
			bicicleta.setId(id); //-> agregar el id al objeto
			
			//enviamos el obeto a persistir en base datos
			bicicletaService.guardarBicicleta(bicicleta);
			//obtener una lista de bicicletas
			List<Bicicleta> listaBicicletas = bicicletaService.findAll();
			//pasamos la lista de bicicletas al jsp
			model.addAttribute("bicicletasCapturadas", listaBicicletas);
			return "mostrarBicicleta.jsp";
		}
	}
}