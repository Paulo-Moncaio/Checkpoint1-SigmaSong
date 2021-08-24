package br.com.sigma.view.cadastrar;

import javax.persistence.EntityManager;

import br.com.sigma.dao.UserDao;
import br.com.sigma.dao.impl.UserDaoImpl;
import br.com.sigma.entity.User;
import br.com.sigma.exception.CommitException;
import br.com.sigma.singleton.EntityManagerFactorySingleton;

public class CadastrarUser {
	
	public static void main(String[] args) throws CommitException {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar Usuario
		User user1 = new User("Paulo", 100);
		User user2 = new User("Joao", 10);
		User user3 = new User("Pedro", 24);
		
		//Obter uma UserDao
		UserDao userDao = new UserDaoImpl(em);

		//Cadastrar usuario
		userDao.cadastrar(user1);
		userDao.cadastrar(user2);
		userDao.cadastrar(user3);
        
		//Salvar
		userDao.salvar();
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

}