package com.julio.agenda.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.julio.agenda.app.models.entity.Contacto;

public interface IContactoDao extends CrudRepository<Contacto, Long> {

}
