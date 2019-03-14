package com.julio.agenda.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.julio.agenda.app.models.dao.IContactoDao;
import com.julio.agenda.app.models.entity.Contacto;

@Service
public class ContactoServiceImpl implements IContactoService{

	@Autowired
	private IContactoDao contactoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Contacto> findAll() {
		// TODO Auto-generated method stub
		return (List<Contacto>) contactoDao.findAll();
	}

	@Override
	@Transactional
	public void save(Contacto contacto) {
		contactoDao.save(contacto);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Contacto findOne(Long id) {
		// TODO Auto-generated method stub
		return contactoDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		contactoDao.delete(id);
		
	}

}
