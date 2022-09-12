package com.example.crm.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "livrocaixa")
public class LivroCaixa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	@ManyToOne //muito registro para um cliente
	@JoinColumn(name = "cliente")
	private Cliente cliente;


	@Column(name = "data_lancamento")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataLancamento;

	@Column(name = "descricao", nullable = false, length = 50)
	private String descricao;

	@Column(name = "tipo", nullable = false, length = 1)
	private Character tipo;

	@Column(scale = 12, precision = 2)
	private double valor;


	public LivroCaixa() {

	}

	//public LivroCaixa(Integer idcliente, Date dataLancamento, String descricao, Character tipo, double valor) {

	//	this.cliente = cliente;
	//	this.dataLancamento = dataLancamento;
	//	this.descricao = descricao;
	//	this.tipo = tipo;
	//	this.valor = valor;


	public Integer getId() {
		return id;
	}


	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Character getTipo() {
		return tipo;
	}

	public Character setTipo(Character tipo) {
		return this.tipo = tipo;

	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
