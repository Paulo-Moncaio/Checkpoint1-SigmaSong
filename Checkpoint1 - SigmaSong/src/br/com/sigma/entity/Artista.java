package br.com.sigma.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_SS_ARTISTA")
@SequenceGenerator(name="seqArtista",sequenceName = "SEQ_TB_SS_ARTISTA", allocationSize = 1)
public class Artista {
	
	@Id
	@Column(name = "cd_artista")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqArtista")	
	protected int id; 

	@Column(name = "nm_artista")
	protected String nome;
	
	@Column(name = "qt_seguidores")
	protected int seguidores;

	
	public Artista(String nome, int seguidores) {
		super();
		this.nome = nome;
		this.seguidores = seguidores;
	}


	public Artista(int id, String nome, int seguidores) {
		super();
		this.id = id;
		this.nome = nome;
		this.seguidores = seguidores;
	}


	public Artista() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(int seguidores) {
		this.seguidores = seguidores;
	}

	
}
