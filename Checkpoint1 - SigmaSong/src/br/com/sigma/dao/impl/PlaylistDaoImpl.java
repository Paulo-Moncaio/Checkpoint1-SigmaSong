package br.com.sigma.dao.impl;

import javax.persistence.EntityManager;

import br.com.sigma.dao.PlaylistDao;
import br.com.sigma.entity.Playlist;

public class PlaylistDaoImpl extends GenericDAOImpl<Playlist, Integer> implements PlaylistDao {
	
	public PlaylistDaoImpl(EntityManager em) {
		super(em);
	}

}
