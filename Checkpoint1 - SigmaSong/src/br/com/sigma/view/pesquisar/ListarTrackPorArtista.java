package br.com.sigma.view.pesquisar;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sigma.dao.TrackDao;
import br.com.sigma.dao.impl.TrackDaoImpl;
import br.com.sigma.entity.Track;
import br.com.sigma.singleton.EntityManagerFactorySingleton;

public class ListarTrackPorArtista {
    public static void main(String[] args){

        //Obtendo o entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		//Obter uma TrackDao
        TrackDao trackDao = new TrackDaoImpl(em);
       

		//Pesquisar todas as Tracks
        List<Track> lista1 = trackDao.listarPorArtista("Linkin Park");
        List<Track> lista2 = trackDao.listarPorArtista("Queen");
        List<Track> lista3 = trackDao.listarPorArtista("Michael Jackson");
        List<Track> lista4 = trackDao.listarPorArtista("Beyonce");

        //Exibir todas as musicas cadastradas por Artista
        lista1 = trackDao.listarPorArtista("Linkin Park");
        System.out.println("\nArtista: Linkin Park");
        lista1.forEach(track -> System.out.println(
        		//"Artista " + track.getArtista().getNome() +
                "Musica: "+ track.getTitulo()));

        System.out.println("*****************************");
        
        lista2 = trackDao.listarPorArtista("Queen");
        System.out.println("\nArtista: Queen");
        lista2.forEach(track -> System.out.println(
                "Musica: "+ track.getTitulo()));
                
        System.out.println("*****************************");
        
        lista3 = trackDao.listarPorArtista("Michael Jackson");
        System.out.println("\nArtista: Michael Jackson");
        lista3.forEach(track -> System.out.println(
                "Musica: "+ track.getTitulo()));

        System.out.println("*****************************");
        
        lista4 = trackDao.listarPorArtista("Beyonce");
        System.out.println("\nArtista: Beyonce");
        lista4.forEach(track -> System.out.println(
                "Musica: "+ track.getTitulo()));
    }
}