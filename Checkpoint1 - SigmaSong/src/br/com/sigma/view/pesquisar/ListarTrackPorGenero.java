package br.com.sigma.view.pesquisar;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sigma.dao.TrackDao;
import br.com.sigma.dao.impl.TrackDaoImpl;
import br.com.sigma.entity.Genero;
import br.com.sigma.entity.Track;
import br.com.sigma.singleton.EntityManagerFactorySingleton;

public class ListarTrackPorGenero {
	public static void main(String[] args) {
//		Obtendo  oentity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		TrackDao trackDao = new TrackDaoImpl(em);
		
		List<Track> listaPunk = trackDao.listarPorGenero(Genero.PUNK);
		List<Track> listaPop = trackDao.listarPorGenero(Genero.POP);
		List<Track> listaRock = trackDao.listarPorGenero(Genero.ROCK);
		
//		Exibir todas musicas com genero PUNK
		listaPunk = trackDao.listarPorGenero(Genero.PUNK);
		System.out.println("\nMusicas do genero Punk");
		listaPunk.forEach(track -> 
			System.out.println("Musica: " + track.getTitulo()));
		
//		Exibir todas musicas com genero POP
		listaPop = trackDao.listarPorGenero(Genero.POP);
		System.out.println("\nMusicas do genero Pop");
		listaPop.forEach(track -> 
			System.out.println("Musica: " + track.getTitulo()));
		
//		Exibir todas musicas com genero POP
		listaRock = trackDao.listarPorGenero(Genero.ROCK);
		System.out.println("\nMusicas do genero Rock");
		listaRock.forEach(track -> 
			System.out.println("Musica: " + track.getTitulo()));
		
//		Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

}
