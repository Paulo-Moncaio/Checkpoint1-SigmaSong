package br.com.sigma.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="TB_SS_ALBUM")
@SequenceGenerator(name="seqAlbum",sequenceName = "SEQ_TB_SS_ALBUM", allocationSize = 1)
public class Album {
	
	@Id
	@Column(name = "cd_album")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAlbum")	
	protected int id;

	@Column(name = "nm_titulo", length =50, nullable = false)
	protected String titulo;

	@Column(name = "dt_duracao")
	protected int duracao;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_artista")
	protected Artista artista;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_criacao", updatable = false)
	protected Calendar dataCriacao;

	
	
	public Album(int id, String titulo, int duracao, Artista artista, Calendar dataCriacao) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.duracao = duracao;
		this.artista =artista;
		this.dataCriacao = dataCriacao;
	}
	
	

	public Album(String titulo, int duracao, Artista artista) {
		super();
		this.titulo = titulo;
		this.duracao = duracao;
		this.artista = artista;
	}



	public Album() {
		super();
		// TODO Auto-generated constructor stub
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

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	
}
