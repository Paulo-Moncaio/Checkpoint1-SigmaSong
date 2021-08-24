package br.com.sigma.view.cadastrar;

import javax.persistence.EntityManager;

import br.com.sigma.dao.AlbumDao;
import br.com.sigma.dao.ArtistaDao;
import br.com.sigma.dao.TrackDao;
import br.com.sigma.dao.impl.AlbumDaoImpl;
import br.com.sigma.dao.impl.ArtistaDaoImpl;
import br.com.sigma.dao.impl.TrackDaoImpl;
import br.com.sigma.entity.Album;
import br.com.sigma.entity.Artista;
import br.com.sigma.entity.Genero;
import br.com.sigma.entity.Track;
import br.com.sigma.singleton.EntityManagerFactorySingleton;
import br.com.sigma.exception.CommitException;


public class CadastrarTrack {

    public static void main(String[] args) throws CommitException{
        //Obter Entity Manager
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

        //Obter uma TrackDao
        TrackDao trackDao = new TrackDaoImpl(em);      
        ArtistaDao artistaDao = new ArtistaDaoImpl(em);
        AlbumDao albumDao = new AlbumDaoImpl(em);
  
        Artista linkinPark = artistaDao.pesquisar(3);
        Artista michael = artistaDao.pesquisar(2);
        Artista queen = artistaDao.pesquisar(1);
        Artista beyonce = artistaDao.pesquisar(4);
        Album meteora = albumDao.pesquisar(1);
        Album thriller = albumDao.pesquisar(2);
        Album liveKillers = albumDao.pesquisar(3);
        Album lemonade = albumDao.pesquisar(4);
        
        Track track1 = new Track("Numb", 829319852, 185, linkinPark, meteora, Genero.PUNK);
        Track track2 = new Track("Somewhere I Belong", 216202046, 213, linkinPark, meteora, Genero.PUNK);
        Track track3 = new Track("Billie Jean", 15934285, 199, michael, thriller, Genero.POP);
        Track track4 = new Track("Thriller", 123456656, 165, michael, thriller, Genero.POP);
        Track track5 = new Track("We Will Rock You (fast)", 1231541, 188, queen, liveKillers, Genero.ROCK);
        Track track6 = new Track("Bohemian Rhapsody", 553461, 176, queen, liveKillers, Genero.ROCK);
        Track track7 = new Track("Lemonade", 829312, 210, beyonce, lemonade, Genero.POP);
        Track track8 = new Track("Formation", 821952, 200, beyonce, lemonade, Genero.POP);



        //Instanciar Track
        trackDao.cadastrar(track1);
        trackDao.cadastrar(track2);
        trackDao.cadastrar(track3);
        trackDao.cadastrar(track4);
        trackDao.cadastrar(track5);
        trackDao.cadastrar(track6);
        trackDao.cadastrar(track7);
        trackDao.cadastrar(track8);
        
        //Salvar
        trackDao.salvar();
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
    }

}