package br.com.sigma.dao;

import java.util.List;

import br.com.sigma.entity.Genero;
import br.com.sigma.entity.Track;

public interface TrackDao extends GenericDAO<Track, Genero>{
	
	List<Track> listar();

	List<Track> listarPorGenero(Genero genero);
	
	List<Track> listarPorArtista(String artista);

}
