package net.guides.springboot2.springboot2jpacrudexample.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ManyToAny;


@Entity
@Table(name = "empresas")
public class Empresa {

	private long id;
	private String nomeEmpresa;
	private int cnpjEmpresa;
	private int qtdFuncionarios;
	private Date dataFundacao;
	private Empregado proprietario;
	private List<Empregado> listEmpregados;
	
	public Empresa() {
		
	}
	
	
	public Empresa(long id, String nomeEmpresa, int cnpjEmpresa, int qtdFuncionarios, Empregado proprietario,
			List<Empregado> listEmpregados) {
		super();
		this.id = id;
		this.nomeEmpresa = nomeEmpresa;
		this.cnpjEmpresa = cnpjEmpresa;
		this.qtdFuncionarios = qtdFuncionarios;
		this.proprietario = proprietario;
		this.listEmpregados = listEmpregados;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	@Column(name = "nome_empresa", nullable = false)
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	
	@Column(name = "cnpj_empresa", nullable = false)
	public int getCnpjEmpresa() {
		return cnpjEmpresa;
	}

	public void setQtdFuncionarios(int qtdFuncionarios) {
		this.qtdFuncionarios = qtdFuncionarios;
	}
	
	@Column(name = "qtd_funcionarios", nullable = false)
	public int getQtdFuncionarios() {
		return qtdFuncionarios;
	}

	public void setCnpjEmpresa(int cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}

	
	@OneToOne
	@JoinColumn(name = "empregado_id")
	public Empregado getProprietario() {
		return proprietario;
	}
	
	public void setProprietario(Empregado proprietario) {
		this.proprietario = proprietario;
	}
	
	@OneToMany
	@JoinColumn(name = "empresa_id")
	public List<Empregado> getListEmpregados() {
		return listEmpregados;
	}

	public void setListEmpregados(List<Empregado> listEmpregados) {
		this.listEmpregados = listEmpregados;
	}

	@Column(name = "date_fundacao")
	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nomeEmpresa=" + nomeEmpresa + ", cnpjEmpresa=" + cnpjEmpresa
				+ ", qtdFuncionarios=" + qtdFuncionarios + ", dataFundacao=" + dataFundacao + ", proprietario="
				+ proprietario + ", listEmpregados=" + listEmpregados + "]";
	}

}
