package br.com.sigma.view.pesquisar;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sigma.dao.AlbumDao;
import br.com.sigma.dao.impl.AlbumDaoImpl;
import br.com.sigma.entity.Album;
import br.com.sigma.singleton.EntityManagerFactorySingleton;

public class ListarAlbum {
	public static void main(String[] args) {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
        //Obter um albumDAO
		AlbumDao albumDao = new AlbumDaoImpl(em);
		
        //Listar todas os album cadastrados
		List<Album> lista = albumDao.listar();
		
		System.out.println("*****************************");
		for (Album album : lista) {
			System.out.println("Titulo do Album: " + album.getTitulo());
			System.out.println("Duracao: " + album.getDuracao());
			System.out.println("Artista: " + album.getArtista());
            System.out.println("Data Criacao: " + album.getDataCriacao());
			System.out.println("*****************************");
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

}
