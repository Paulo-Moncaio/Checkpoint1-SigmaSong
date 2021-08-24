package br.com.sigma.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_SS_TRACK")
@SequenceGenerator(name = "seqTrack", sequenceName = "SEQ_TB_SS_TRACK", allocationSize = 1)
public class Track {
	
	@Id
	@Column(name = "cd_track")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTrack")
	protected int id;
	
	@Column(name = "nm_track", length = 80, nullable = false)
	protected String titulo;
	
	@Column(name = "nr_reproducoes", nullable = false)
	protected int reproducoes;
	
	@Column(name = "vl_duracao", nullable = false)
	protected int duracao;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_artista", nullable = false)
	protected Artista artista;

	@ManyToOne(cascade = CascadeType.PERSIST/* , fetch = FetchType.EAGER */)
	@JoinColumn(name = "cd_album",nullable = false)
	protected Album album;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_genero", nullable = false)
	protected Genero genero;

	public Track() {}
	
	public Track(String titulo, int reproducoes, int duracao, Artista artista, Album album,
			Genero genero) {
		super();
		this.titulo = titulo;
		this.reproducoes = reproducoes;
		this.duracao = duracao;
		this.artista = artista;
		this.album = album;
		this.genero = genero;
	}
	
	public Track(int id, String titulo, int reproducoes, int duracao, Artista artista, Album album,
			Genero genero) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.reproducoes = reproducoes;
		this.duracao = duracao;
		this.artista = artista;
		this.album = album;
		this.genero = genero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getReproducoes() {
		return reproducoes;
	}

	public void setReproducoes(int reproducoes) {
		this.reproducoes = reproducoes;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	
	
}
