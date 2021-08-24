package br.com.sigma.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;

import br.com.sigma.exception.CommitException;
import br.com.sigma.dao.GenericDAO;

public abstract class GenericDAOImpl<T,K> implements GenericDAO<T, K> {

	protected EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		clazz = (Class<T>) ((ParameterizedType)getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public List<T> listar(){
		//definir query
		TypedQuery<T> query = em.createQuery("from " + clazz.getName(), clazz);
		//Configurar o maximo de resultados na pesquisa
		query.setMaxResults(50);
		//Executar query
		return query.getResultList();
		
	}
	
	@Override
	public List<T> listar(int posicao, int maximo){
		return em.createQuery("from " + clazz.getName(), clazz)
				.setFirstResult(posicao) //posicao do primeiro registro que serra retornado
				.setMaxResults(maximo)  //maximo de resultados
				.getResultList();
	}
	
	@Override
	public void cadastrar(T entity) {
		em.persist(entity);
	}

	@Override
	public void alterar(T entity) {
		em.merge(entity);
	}

	@Override
	public void remover(K codigo) throws EntityNotFoundException {
		T entidade = pesquisar(codigo);
		if (entidade == null){
			throw new EntityNotFoundException("Entidade não encontrada");
		}
		em.remove(entidade);
	}

	@Override
	public T pesquisar(K codigo) {
		return em.find(clazz, codigo);
	}
	
	public void salvar() throws CommitException{
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new CommitException("Erro no commit" + e);
		}
	}

}