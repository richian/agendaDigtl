package com.julio.agenda.app.models.service;

import java.util.List;

import com.julio.agenda.app.models.entity.Contacto;

public interface IContactoService {

	public List<Contacto> findAll();

	public void save(Contacto contacto);
	
	public Contacto findOne(Long id);
	
	public void delete(Long id);

}
