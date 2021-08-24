package br.com.sigma.dao;

import java.util.List;

import br.com.sigma.entity.User;

public interface UserDao extends GenericDAO<User, Integer>{
	
	List<User> listar();

}
