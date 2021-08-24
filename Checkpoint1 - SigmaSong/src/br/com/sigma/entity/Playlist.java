package br.com.sigma.entity;

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

@Entity
@Table(name="TB_SS_PLAYLIST")
@SequenceGenerator(name="seqPlaylist",sequenceName = "SEQ_TB_SS_ALBUM", allocationSize = 1)
public class Playlist {
	
	@Id
	@Column(name = "cd_playlist")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqPlaylist")
	protected int id;

	@Column(name = "nm_titulo", length = 80, nullable = false)
	protected String titulo;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_user", nullable = false)
	protected User criadoPor;

	@Column(name = "vl_duracao", nullable = false)
	protected int duracao;

	@Column(name = "qt_curtidas", nullable = false)
	protected int curtidas;
	
	@Column(name = "qt_musicas", nullable = false)
	protected int musicas;
	
	public Playlist(String titulo, User criadoPor, int duracao, int curtidas, int musicas) {
		super();
		this.titulo = titulo;
		this.criadoPor = criadoPor;
		this.duracao = duracao;
		this.curtidas = curtidas;
		this.musicas = musicas;
	}

	public Playlist() {
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

	public User getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(User criadoPor) {
		this.criadoPor = criadoPor;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(int curtidas) {
		this.curtidas = curtidas;
	}

	public int getMusicas() {
		return musicas;
	}

	public void setMusicas(int musicas) {
		this.musicas = musicas;
	}

	
	

}
