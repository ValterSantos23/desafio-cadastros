package com.web.desafio.DesafioWeb.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_cliente", length = 10)
	private int cod_cliente;
	
	@Column(name = "nome", nullable = false, length = 40)
	private String nome;
	
	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;
	
	@Column(name = "rg", nullable = false, length = 17)
	private String rg;
	
	@Column(name = "data_nasc", nullable = true)
	private Date data_nasc;
	
	@Column(name = "endereco", nullable = false, length = 40)
	private String endereco;
	
	@Column(name = "complemento", nullable = true, length = 20)
	private String complemento;
	
	@Column(name = "bairro", nullable = false, length = 20)
	private String bairro;
	
	@Column(name = "cep", nullable = true, length = 8)
	private String cep;
	
	@Column(name = "cidade", nullable = false, length = 20)
	private String cidade;
	
	@Column(name = "uf", nullable = false, length = 2)
	private String uf;
	
	@Column(name = "telefone", nullable = true, length = 13)
	private String telefone;
	
	@Column(name = "celular", nullable = false, length = 15)
	private String celular;
	
	@Column(name = "obs", nullable = true, length = 150)
	private String obs;

	//Getters e Setters
	
	public int getCod_cliente() {
		return cod_cliente;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTeleforne(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
	//Métodos que removem tudo que não for números do CPF, RG e CEP
	public void cpfNumeros() {
		setCpf(getCpf().replaceAll("[^\\d]", ""));

	}
	public void rgNumeros() {
		setRg(getRg().replaceAll("[^\\d]", ""));
		
	}
	public void cepNumeros() {
		setCep(getCep().replaceAll("[^\\d]", ""));
		
	}
	
}
