package br.com.sigma.view.cadastrar;

import javax.persistence.EntityManager;

import br.com.sigma.dao.ArtistaDao;
import br.com.sigma.dao.impl.ArtistaDaoImpl;
import br.com.sigma.entity.Artista;
import br.com.sigma.singleton.EntityManagerFactorySingleton;
import br.com.sigma.exception.CommitException;


public class CadastrarArtista {

    public static void main(String[] args) throws CommitException{
        //Obter Entity Manager
        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

        //Obter uma ArtistaDAO
        ArtistaDao artistaDao = new ArtistaDaoImpl(em);

        //Instanciar Artista
        Artista artista1 = new Artista("Queen", 2900000);
        Artista artista2 = new Artista("Michael Jackson", 17000000);
        Artista artista3 = new Artista("Linkin Park", 6900000);
        Artista artista4 = new Artista("Beyonce", 3800000);

        //Cadastrar usuario
        artistaDao.cadastrar(artista1);
        artistaDao.cadastrar(artista2);
        artistaDao.cadastrar(artista3);
        artistaDao.cadastrar(artista4);
        
        //Salvar
        artistaDao.salvar();
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
    }

}