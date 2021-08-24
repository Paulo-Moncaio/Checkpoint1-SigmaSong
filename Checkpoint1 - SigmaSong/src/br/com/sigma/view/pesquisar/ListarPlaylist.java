package br.com.sigma.view.pesquisar;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sigma.dao.PlaylistDao;
import br.com.sigma.dao.impl.PlaylistDaoImpl;
import br.com.sigma.entity.Playlist;
import br.com.sigma.singleton.EntityManagerFactorySingleton;

public class ListarPlaylist {
	public static void main(String[] args) {
		
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter uma PlaylistDao
		PlaylistDao playlistDao = new PlaylistDaoImpl(em);
		
		//Pesquisar todas as Playlists
		List<Playlist> lista = playlistDao.listar();
		
		//Exibir todas as playlists cadastradas
		System.out.println("*****************************");
		for (Playlist playlist : lista) {
			System.out.println("Nome playlist: " + playlist.getTitulo());
            System.out.println("Criador: " + playlist.getCriadoPor());
            System.out.println("Duracao: " + playlist.getDuracao());
            System.out.println("Curtidas: " + playlist.getCurtidas());
            System.out.println("Musicas: " + playlist.getMusicas());
			System.out.println("*****************************");
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

}
