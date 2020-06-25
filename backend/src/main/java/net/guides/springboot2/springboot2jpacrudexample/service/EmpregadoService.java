package net.guides.springboot2.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import net.guides.springboot2.springboot2jpacrudexample.model.Empregado;

public interface EmpregadoService {
	
	List<Empregado> getAllEmpregados();

	Optional<Empregado> getEmpregadoById(Long empregadoId);

	Empregado createEmpregado(Empregado empregado);	

	Empregado updateEmpregado(Empregado empregadoDetails);

	void deleteEmpregado(Empregado empregado);
	
	List<Empregado>getAllProprietatios();
}
