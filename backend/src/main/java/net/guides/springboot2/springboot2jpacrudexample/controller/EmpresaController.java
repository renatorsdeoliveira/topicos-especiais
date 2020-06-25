package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.io.Console;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Empregado;
import net.guides.springboot2.springboot2jpacrudexample.model.Empresa;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmpresaCustomRepository;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmpresaRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class EmpresaController {
	
	@Autowired
	EmpresaRepository empresaRepository;
	EmpresaCustomRepository empCustom;
	

	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("empresas")
	public List<Empresa> getAlEmpresas(){
		return empresaRepository.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/empresas/{id}")
	public ResponseEntity<Empresa> getEmpresasById(@PathVariable(value = "id") Long empresaId)
			throws ResourceNotFoundException{
		Empresa empresa = empresaRepository.findById(empresaId)
				.orElseThrow(() -> new ResourceNotFoundException("Nenhuma empresa localizada :: " + empresaId));
		return ResponseEntity.ok().body(empresa);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/empresas/{id}")
	public Empresa addEmpresas(@Validated @RequestBody Empresa empresa) {
		return empresaRepository.save(empresa);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/empresa/{id}")
	public ResponseEntity<Empresa> updateEmpresa(@PathVariable(value = "id") Long empresaId,
			@Validated @RequestBody Empresa empresaDetalhes) throws ResourceNotFoundException{
		Empresa empresa = empresaRepository.findById(empresaId)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi possível atualizar :: " +empresaId + ":: não localizado"));
		
		empresa.setNomeEmpresa(empresaDetalhes.getNomeEmpresa());
		empresa.setCnpjEmpresa(empresaDetalhes.getCnpjEmpresa());
		empresa.setTelefone(empresaDetalhes.getTelefone());
		empresa.setEndereco(empresaDetalhes.getEndereco());
		empresa.setDataFundacao(empresaDetalhes.getDataFundacao());
		empresa.setProprietario(empresaDetalhes.getProprietario());
		empresa.setListEmpregados(empresaDetalhes.getListEmpregados());
		final Empresa upEmpresa = empresaRepository.save(empresa);
		return ResponseEntity.ok(upEmpresa);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/empresas/{id}")
	public Map<String, Boolean> deleteEmpresa(@PathVariable(value = "id") Long empresaId)
		throws ResourceNotFoundException{
		Empresa empresa = empresaRepository.findById(empresaId)
				.orElseThrow(() -> new ResourceNotFoundException("Não existe empresa para esse id :: "+empresaId));
		empresaRepository.delete(empresa);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deletado", Boolean.TRUE);
		return response;
	}

}