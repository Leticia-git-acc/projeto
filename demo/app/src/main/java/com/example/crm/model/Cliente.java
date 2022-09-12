package com.example.crm.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_cliente")
public class Cliente<String> {

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private LocalDateTime dataCadastro = LocalDateTime.now();

	@Column(name = "nome", nullable = false, length = 30)
	private String nome;
	
	@Column(name = "cpfecnpj", nullable = false, length = 14)
	private String cpfecnpj;

	@Column(name = "logradouro", nullable = false, length = 50)
	private String logradouro;

	@Column(name = "cidade", nullable = false, length = 40)
	private String cidade;

	@Column(name = "uf", nullable = false, length = 02)
	private String uf;

	@Column(name = "cep", nullable = false, length = 8)
	private String cep;

	@Column(name = "telefone", nullable = false, length = 11)
	private String telefone;
	


	@Column(name = "email", nullable = false, length = 100)
	private String email;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<LivroCaixa> livroCaixa = new ArrayList<>();

	public Cliente() {
	}

	
	public Cliente(LocalDateTime dataCadastro, String nome, String cpfecnpj, String logradouro, String cidade, String uf, String cep,
			String telefone, String email) {

		this.dataCadastro = dataCadastro;
		this.nome = nome;
		this.cpfecnpj= cpfecnpj;
		this.logradouro = logradouro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.telefone = telefone;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfecnpj() {
		return cpfecnpj;
	}

	public void setCpfecnpj(String cpfecnpj) {
		this.cpfecnpj = cpfecnpj;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
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

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
