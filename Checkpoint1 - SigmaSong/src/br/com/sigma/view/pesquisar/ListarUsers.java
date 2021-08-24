package br.com.sigma.view.pesquisar;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sigma.dao.UserDao;
import br.com.sigma.dao.impl.UserDaoImpl;
import br.com.sigma.entity.User;
import br.com.sigma.singleton.EntityManagerFactorySingleton;

public class ListarUsers {
	
	public static void main(String[] args) {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter uma UserDao
		UserDao userDao = new UserDaoImpl(em);
		
		//Pesquisar todas as cidades
		List<User> lista = userDao.listar();
		
		System.out.println("*****************************");
		//Exibir todas os usuarios cadastrados
		for (User user : lista) {
			System.out.println("Nome: " + user.getNome());
			System.out.println("Nr seguidores: " + user.getSeguidores());
			System.out.println("*****************************");
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}
	

}
