package br.com.sigma.dao;

import java.util.List;

import br.com.sigma.entity.Artista;

public interface ArtistaDao extends GenericDAO<Artista, Integer>{
	
	List<Artista> listar();

}
