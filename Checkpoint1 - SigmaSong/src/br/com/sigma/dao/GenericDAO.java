package br.com.sigma.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import br.com.sigma.exception.CommitException;

public interface GenericDAO<T, K> {
	
	void cadastrar(T entity);
	void alterar(T entity);
	void remover(K codigo) throws EntityNotFoundException;
	T pesquisar(K codigo);
	void salvar() throws CommitException;
	
	List<T> listar();
	List<T> listar(int posicao, int maximo);

}
