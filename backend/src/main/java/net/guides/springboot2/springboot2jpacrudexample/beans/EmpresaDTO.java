package net.guides.springboot2.springboot2jpacrudexample.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import net.guides.springboot2.springboot2jpacrudexample.model.Empregado;

public class EmpresaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private long id;
	private String nomeEmpresa;
	private String cnpjEmpresa;
	private String telefone;
	private String endereco;
	private Date dataFundacao;
	private Empregado proprietario;
	private List<Empregado> listEmpregados;;
	private String role;
	
	public EmpresaDTO() {
		super();
	}

	public EmpresaDTO(long id, String nomeEmpresa, String cnpjEmpresa, String telefone, String endereco,
			Date dataFundacao, Empregado proprietario, List<Empregado> listEmpregados, String role) {
		super();
		this.id = id;
		this.nomeEmpresa = nomeEmpresa;
		this.cnpjEmpresa = cnpjEmpresa;
		this.telefone = telefone;
		this.endereco = endereco;
		this.dataFundacao = dataFundacao;
		this.proprietario = proprietario;
		this.listEmpregados = listEmpregados;
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

	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}

	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public Empregado getProprietario() {
		return proprietario;
	}

	public void setProprietario(Empregado proprietario) {
		this.proprietario = proprietario;
	}

	public List<Empregado> getListEmpregados() {
		return listEmpregados;
	}

	public void setListEmpregados(List<Empregado> listEmpregados) {
		this.listEmpregados = listEmpregados;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
