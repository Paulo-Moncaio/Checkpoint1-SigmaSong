package br.com.sigma.view.pesquisar;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sigma.dao.ArtistaDao;
import br.com.sigma.dao.impl.ArtistaDaoImpl;
import br.com.sigma.entity.Artista;
import br.com.sigma.singleton.EntityManagerFactorySingleton;

public class ListarArtista {
	public static void main(String[] args) {
		
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um ArtistaDao
		ArtistaDao artistaDao = new ArtistaDaoImpl(em);
		
		//Pesquisar todas os artistas
		List<Artista> lista = artistaDao.listar();
		
		//Exibir todas os artista cadastrados
		System.out.println("*****************************");
		for (Artista artista : lista) {
			System.out.println("Nome artista: " + artista.getNome());
			System.out.println("Nr seguidores: " + artista.getSeguidores());
			System.out.println("*****************************");
		}
		

		//Fechar fabrica
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

}
