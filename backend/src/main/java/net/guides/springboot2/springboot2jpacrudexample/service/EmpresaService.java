package net.guides.springboot2.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import net.guides.springboot2.springboot2jpacrudexample.model.Empresa;

public interface EmpresaService {
	
	List<Empresa> getAllEmpresas();

	Optional<Empresa> getEmpresaById(Long empresaId);

	Empresa createEmpresa(Empresa empresa);	

	Empresa updateEmpresa(Empresa empresaDetails);

	void deleteEmpresa(Empresa empresa);
}
