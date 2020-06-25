package net.guides.springboot2.springboot2jpacrudexample.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2jpacrudexample.model.Empresa;

@Repository
public class EmpresaCustomRepository {
	
	private final EntityManager en;
	
	public EmpresaCustomRepository(EntityManager en) {
		this.en = en;
	}
	
	public List<Empresa> getAll(){
		
		String query = "select E from empresas as E";
		
		TypedQuery<Empresa> q = en.createQuery(query, Empresa.class);
		
		return q.getResultList();
		
	}
}
