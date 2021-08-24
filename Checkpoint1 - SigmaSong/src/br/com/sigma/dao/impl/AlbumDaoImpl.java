package br.com.sigma.dao.impl;

import javax.persistence.EntityManager;
import br.com.sigma.dao.AlbumDao;
import br.com.sigma.entity.Album;

public class AlbumDaoImpl extends GenericDAOImpl<Album, Integer> implements AlbumDao {

	public AlbumDaoImpl(EntityManager em) {
		super(em);
	}
	
}
