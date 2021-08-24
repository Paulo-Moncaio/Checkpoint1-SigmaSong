package br.com.sigma.view.pesquisar;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sigma.dao.TrackDao;
import br.com.sigma.dao.impl.TrackDaoImpl;
import br.com.sigma.entity.Track;
import br.com.sigma.singleton.EntityManagerFactorySingleton;

public class ListarTrack {
	public static void main(String[] args) {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
//		Obter uma TrackDao
		TrackDao trackDao = new TrackDaoImpl(em);
		
//		Listar todas as musicas
		List<Track> lista = trackDao.listar();
		
		System.out.println("*****************************");
		for (Track track : lista) {
			System.out.println("Titulo: " + track.getTitulo());
			System.out.println("Nome Album: " + track.getAlbum().getTitulo());
			System.out.println("Nome Artista: " + track.getArtista().getNome());
			System.out.println("Genero: " + track.getGenero());
			System.out.println("*****************************");
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

}
