package org.baeldung.persistence.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.baeldung.persistence.dao.FooDao;
import org.baeldung.persistence.dao.IFooDao;
import org.baeldung.persistence.model.Foo;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Configurable(autowire = Autowire.BY_NAME)
public class FooService {

	@Autowired
	private IFooDao dao;

	private String sayHey;
	private static Logger log = Logger.getLogger(FooService.class.getClass()
			.getName());
	public FooService() {
		super();

	}

	// API

	public void create(final Foo entity) {
		dao.create(entity);
		log.log(Level.INFO, sayHey + "::created->" + entity.getId());
	}

	public Foo findOne(final long id) {
		return dao.findOne(id);
	}

	public List<Foo> findAll() {
		return dao.findAll();
	}

	public IFooDao getDao() {
		return dao;
	}

	public void setDao(final FooDao dao) {
		this.dao = dao;
	}

}
