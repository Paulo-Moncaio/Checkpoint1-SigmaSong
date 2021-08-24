package br.com.sigma.dao.impl;

import javax.persistence.EntityManager;

import br.com.sigma.dao.ArtistaDao;
import br.com.sigma.entity.Artista;

public class ArtistaDaoImpl extends GenericDAOImpl<Artista, Integer> implements ArtistaDao{
	
	public ArtistaDaoImpl(EntityManager em) {
		super(em);
	}

}
