package net.guides.springboot2.springboot2jpacrudexample.beans;

import java.io.Serializable;
import java.util.Date;

import net.guides.springboot2.springboot2jpacrudexample.Enums.Funcao;

public class EmpregadoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String Nome;
	private String Endereco;
	private String emailId;
	private String telefone;
	private String CPF;
	private Date dataNascimento;
	private Funcao funcao;
	private Double salario;
	private String role;
	
	public EmpregadoDTO() {
		
	}

	public EmpregadoDTO(long id, String nome, String endereco, String emailId, String telefone, String cPF,
			Date dataNascimento, Funcao funcao, Double salario) {
		super();
		this.id = id;
		Nome = nome;
		Endereco = endereco;
		this.emailId = emailId;
		this.telefone = telefone;
		CPF = cPF;
		this.dataNascimento = dataNascimento;
		this.funcao = funcao;
		this.salario = salario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
