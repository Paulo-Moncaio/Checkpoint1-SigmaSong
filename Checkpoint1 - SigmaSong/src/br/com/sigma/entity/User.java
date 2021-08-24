package br.com.sigma.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "TB_SS_USER")
@SequenceGenerator(name = "seqUser", sequenceName = "SEQ_TB_SS_USERS", allocationSize = 1)
public class User {
	
	@Id
	@Column(name="cd_user")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUser")
	protected int id;

	@Column(name="nm_user", length = 50, nullable= false)
	protected String nome;

	@Column(name="nr_seguidores")
	protected int seguidores;

	public User() {}

	public User(String nome, int seguidores) {
		super();
		this.nome = nome;
		this.seguidores = seguidores;
	}

	public User(int id, String nome, int seguidores) {
		super();
		this.id = id;
		this.nome = nome;
		this.seguidores = seguidores;
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
