package net.guides.springboot2.springboot2jpacrudexample.beans;

import java.io.Serializable;

public class EmpresaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String nomeEmpresa;
	private int cnpjEmpresa;
	private int qtdFuncionarios;
	private String role;
	
	public EmpresaDTO() {
		
	}
	

	
	public EmpresaDTO(long id, String nomeEmpresa, int cnpjEmpresa, int qtdFuncionarios, String role) {
		super();
		this.id = id;
		this.nomeEmpresa = nomeEmpresa;
		this.cnpjEmpresa = cnpjEmpresa;
		this.qtdFuncionarios = qtdFuncionarios;
		this.role = role;
	}



	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public int getCnpjEmpresa() {
		return cnpjEmpresa;
	}

	public void setCnpjEmpresa(int cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}

	public int getQtdFuncionarios() {
		return qtdFuncionarios;
	}

	public void setQtdFuncionarios(int qtdFuncionarios) {
		this.qtdFuncionarios = qtdFuncionarios;
	}



	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
}
