package br.com.sigma.view.cadastrar;

import javax.persistence.EntityManager;

import br.com.sigma.dao.PlaylistDao;
import br.com.sigma.dao.UserDao;
import br.com.sigma.dao.impl.PlaylistDaoImpl;
import br.com.sigma.dao.impl.UserDaoImpl;
import br.com.sigma.entity.Playlist;
import br.com.sigma.entity.User;
import br.com.sigma.exception.CommitException;
import br.com.sigma.singleton.EntityManagerFactorySingleton;

public class CadastrarPlaylist {
	
	public static void main(String[] args) throws CommitException {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter uma PlaylistDao
		PlaylistDao playlistDao = new PlaylistDaoImpl(em);
		UserDao userDao = new UserDaoImpl(em);
		
		User paulo = userDao.pesquisar(1);
		User joao = userDao.pesquisar(2);
		User pedro = userDao.pesquisar(3);
		
		//Instanciar Playlist
		Playlist playlist1 = new Playlist("Corridinha", paulo, 4830, 38, 23);
		Playlist playlist2 = new Playlist("Classicos", joao, 7200, 57, 30);
		Playlist playlist3 = new Playlist("Pop", pedro, 5760, 120, 24);
		
		//Cadastrar Playlist
		playlistDao.cadastrar(playlist1);
		playlistDao.cadastrar(playlist2);
		playlistDao.cadastrar(playlist3);


		//Salvar
		playlistDao.salvar();
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

}
