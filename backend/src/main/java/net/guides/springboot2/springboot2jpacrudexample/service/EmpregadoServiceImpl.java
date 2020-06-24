package net.guides.springboot2.springboot2jpacrudexample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.guides.springboot2.springboot2jpacrudexample.beans.EmpresaDTO;
import net.guides.springboot2.springboot2jpacrudexample.model.Empregado;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmpregadoRepository;

@Service
public class EmpregadoServiceImpl implements EmpregadoService{

	@Autowired
	private EmpregadoRepository empregadoRepository;
	
	@Override
	public List<Empregado> getAllEmpregados() {
		return this.empregadoRepository.findAll();
	}

	@Override
	public Optional<Empregado> getEmpregadoById(Long empregadoId) {
		return this.empregadoRepository.findById(empregadoId);
	}

	@Override
	public Empregado createEmpregado(Empregado empregado) {
		return this.empregadoRepository.save(empregado);
	}

	@Override
	public Empregado updateEmpregado(Empregado empregadoDetails) {
		return this.empregadoRepository.save(empregadoDetails);
	}

	@Override
	public void deleteEmpregado(Empregado empregado) {
		this.empregadoRepository.delete(empregado);
	}
	


}
