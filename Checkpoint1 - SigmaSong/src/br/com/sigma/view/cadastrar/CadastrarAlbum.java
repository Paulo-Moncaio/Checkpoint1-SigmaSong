package br.com.sigma.view.cadastrar;

import javax.persistence.EntityManager;

import br.com.sigma.dao.AlbumDao;
import br.com.sigma.dao.ArtistaDao;
import br.com.sigma.dao.impl.AlbumDaoImpl;
import br.com.sigma.dao.impl.ArtistaDaoImpl;
import br.com.sigma.entity.Album;
import br.com.sigma.entity.Artista;
import br.com.sigma.exception.CommitException;
import br.com.sigma.singleton.EntityManagerFactorySingleton;

public class CadastrarAlbum {
	
	public static void main(String[] args) throws CommitException {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter uma AlbumDao
		AlbumDao albumDao = new AlbumDaoImpl(em);
        ArtistaDao artistaDao = new ArtistaDaoImpl(em);
  
        Artista linkinPark = artistaDao.pesquisar(3);
        Artista michael = artistaDao.pesquisar(2);
        Artista queen = artistaDao.pesquisar(1);
        Artista beyonce = artistaDao.pesquisar(4);
		
		//Instanciar Album
		Album album1 = new Album("Meteora", 2203, linkinPark);
        Album album2 = new Album("Thriller", 4320, michael);
        Album album3 = new Album("Live Killers", 5280, queen);
        Album album4 = new Album("Lemonade", 4320, beyonce);


		//Cadastrar Playlist
		albumDao.cadastrar(album1);
        albumDao.cadastrar(album2);
        albumDao.cadastrar(album3);
        albumDao.cadastrar(album4);
		
        //Salvar
        albumDao.salvar();
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();

	}

}
