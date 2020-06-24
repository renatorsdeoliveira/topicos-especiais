package net.guides.springboot2.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.guides.springboot2.springboot2jpacrudexample.beans.EmpresaDTO;
import net.guides.springboot2.springboot2jpacrudexample.model.Empregado;
import net.guides.springboot2.springboot2jpacrudexample.model.Empresa;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService{

	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Override
	public List<Empresa> getAllEmpresas() {
		return this.empresaRepository.findAll();
	}

	@Override
	public Optional<Empresa> getEmpresaById(Long empresaId) {
		return this.empresaRepository.findById(empresaId);
	}

	@Override
	public Empresa createEmpresa(Empresa empresa) {
		return this.empresaRepository.save(empresa);
	}

	@Override
	public Empresa updateEmpresa(Empresa empresaDetails) {
		return this.empresaRepository.save(empresaDetails);
	}

	@Override
	public void deleteEmpresa(Empresa empresa) {
		this.empresaRepository.delete(empresa);
	}

}
