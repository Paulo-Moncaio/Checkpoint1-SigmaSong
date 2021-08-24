package br.com.sigma.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.sigma.dao.TrackDao;
import br.com.sigma.entity.Genero;
import br.com.sigma.entity.Track;

public class TrackDaoImpl extends GenericDAOImpl<Track, Genero> implements TrackDao {
	
	public TrackDaoImpl(EntityManager em) {
		super(em);
	}
	
	@Override
	public List<Track> listarPorGenero(Genero genero) {
		//Definir a query
		TypedQuery<Track> query = em.createQuery("from Track t where t.genero = :g", Track.class);
		//Setar o parametro
		query.setParameter("g", genero);
		//Execitar a query
		return query.getResultList();
	}
	
	@Override
	public List<Track> listarPorArtista(String artista) {
		//Definir a query
		TypedQuery<Track> query = em.createQuery("from Track t where t.artista.nome = :a", Track.class);
		//Setar o parametro
		query.setParameter("a", artista);
		//Execitar a query
		return query.getResultList();
	}

}
