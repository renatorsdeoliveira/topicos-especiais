package net.guides.springboot2.springboot2jpacrudexample.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import net.guides.springboot2.springboot2jpacrudexample.Enums.*;

@Entity
@Table(name = "empregados")
public class Empregado {
	/*Nome, Endereço, E-mail, Telefone, CPF,
Data de Nascimento, Função (Tipo Enumerado com as opções: ADMINISTRATIVO,
SUPERVISÃO, GERÊNCIA, PROPRIETÁRIO) e salário.*/
	
	private long id;
	private String Nome;
	private String Endereco;
	private String emailId;
	private String telefone;
	private String CPF;
	private Date dataNascimento;
	private Funcao funcao;
	private Double salario;
	
	@OneToOne(mappedBy = "proprietario")
    private Empresa empresa;
	
	public Empregado() {
		
	}
	
	public Empregado(long id, String nome, String endereco, String emailId, String telefone, String cPF,
			Date dataNascimento, Funcao funcao, Double salario) {
		super();
		this.id = id;
		this.Nome = nome;
		this.Endereco = endereco;
		this.emailId = emailId;
		this.telefone = telefone;
		this.CPF = cPF;
		this.dataNascimento = dataNascimento;
		this.funcao = funcao;
		this.salario = salario;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "nome_Completo", nullable = false)
	public String getNome() {
		return Nome;
	}
	
	public void setNome(String nome) {
		Nome = nome;
	}

	@Column(name = "endereco", nullable = false)
	public String getEndereco() {
		return Endereco;
	}
	
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Column(name = "telefone", nullable = false)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Column(name = "CPF", nullable = false)
	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	@Column(name = "data_nascimento", nullable = false)
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Column(name = "funcao", nullable = false)
	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	
	@Column(name = "salario", nullable = false)
	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Empregado [id=" + id + ", Nome=" + Nome + ", Endereco=" + Endereco + ", emailId=" + emailId
				+ ", telefone=" + telefone + ", CPF=" + CPF + ", dataNascimento=" + dataNascimento + ", funcao="
				+ funcao + ", salario=" + salario + "]";
	}
	
}
