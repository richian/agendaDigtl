package com.julio.agenda.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.julio.agenda.app.models.entity.Contacto;
import com.julio.agenda.app.models.service.IContactoService;

@Controller
@SessionAttributes("contacto")
public class ContactoController {

	@Autowired
	private IContactoService contactoService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Lista de Contactos");
		model.addAttribute("contactos", contactoService.findAll());
		return "listar";
	}

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Contacto contacto = new Contacto();
		model.put("contacto", contacto);
		model.put("titulo", "Formulario de Contactos");
		return "form";
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Contacto contacto = null;
		
		if(id > 0) {
			contacto = contactoService.findOne(id);
		} else {
			return "redirect:/listar";
		}
		model.put("contacto", contacto);
		model.put("titulo", "Editar Contacto");
		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Contacto contacto, BindingResult result, Model model, SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Contactos");
			return "form";
		}

		contactoService.save(contacto);
		status.setComplete();
		return "redirect:listar";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id > 0) {
			contactoService.delete(id);
		}
		return "redirect:/listar";
	}
}
