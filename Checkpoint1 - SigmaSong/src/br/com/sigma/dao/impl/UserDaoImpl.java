package br.com.sigma.dao.impl;

import javax.persistence.EntityManager;

import br.com.sigma.dao.UserDao;
import br.com.sigma.entity.User;

public class UserDaoImpl extends GenericDAOImpl<User, Integer> implements UserDao {
	
	public UserDaoImpl(EntityManager em) {
		super(em);
	}

}
