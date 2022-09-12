package com.example.crm.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDateTime dataCadastro = LocalDateTime.now();

	@Column(name = "nome", nullable = false, length = 30)
	private String nome;

	//impede que salve varios usuarios o unique
	@Column(name = "login", nullable = false, length = 15,unique = true)
	private String login;

	@Column(name = "senha", nullable = false, length = 10)
	private String senha;

	@Column(name = "telefone", nullable = false, length = 11)
	private String telefone;

	@Column(name = "email", nullable = false, length = 100)
	private String email;

	@Column(name = "perfil", nullable = false, length = 1)
	private Character perfil;

	@Column(name = "status", nullable = false, length = 1)
	private Character status;

	public Usuario() {

	}

	public Usuario(LocalDateTime dataCadastro, String nome, String login, String senha, String telefone, String email,
			Character perfil, Character status) {

		this.dataCadastro = dataCadastro;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.telefone = telefone;
		this.email = email;
		this.perfil = perfil;
		this.status = status;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Character getPerfil() {
		return perfil;
	}

	public void setPerfil(Character perfil) {
		this.perfil = perfil;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}
}
