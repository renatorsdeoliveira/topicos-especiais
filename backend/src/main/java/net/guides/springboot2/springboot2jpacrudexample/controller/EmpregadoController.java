package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.Enums.Funcao;
import net.guides.springboot2.springboot2jpacrudexample.beans.EmpregadoDTO;
import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Empregado;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmpregadoRepository;
import net.guides.springboot2.springboot2jpacrudexample.service.EmpregadoService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmpregadoController {
	
	@Autowired
	private EmpregadoService empregadoService;

	@Autowired
    private ModelMapper modelMapper;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/empregados")
	public List<EmpregadoDTO> getAllempregados() {
		List<Empregado> empregados = empregadoService.getAllEmpregados();
		return empregados.stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/empregados/proprietarios")
	public List<EmpregadoDTO> findAllProprietatios(){
		List<Empregado> empregados = empregadoService.getAllProprietatios();
		return empregados.stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
	}
	

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/empregados/{id}")
	public ResponseEntity<EmpregadoDTO> getEmpregadoById(@PathVariable(value = "id") Long empregadoId) {
		Empregado empregado = empregadoService.getEmpregadoById(empregadoId).get();
		return ResponseEntity.ok().body(convertToDto(empregado));
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/empregados")
	public Empregado createEmpregado(@Valid @RequestBody EmpregadoDTO empregadoDTO) {
		return empregadoService.createEmpregado(convertToEntity(empregadoDTO));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/empregados/{id}")
	public ResponseEntity<Empregado> updateEmpregado(@PathVariable(value = "id") Long empregadoId,
			@Valid @RequestBody Empregado empregadoDetails) throws ResourceNotFoundException {
		Empregado empregado = empregadoService.getEmpregadoById(empregadoId)
				.orElseThrow(() -> new ResourceNotFoundException("Empregado not found for this id :: " + empregadoId));

		empregado.setNome(empregadoDetails.getNome());
		empregado.setEndereco(empregadoDetails.getEndereco());
		empregado.setEmailId(empregadoDetails.getEmailId());
		empregado.setTelefone(empregadoDetails.getTelefone());
		empregado.setCPF(empregadoDetails.getCPF());
		empregado.setDataNascimento(empregadoDetails.getDataNascimento());
		empregado.setFuncao(empregadoDetails.getFuncao());
		empregado.setSalario(empregadoDetails.getSalario());
		final Empregado updatedEmpregado = empregadoService.updateEmpregado(empregadoDetails);
		return ResponseEntity.ok(updatedEmpregado);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/empregados/{id}")
	public Map<String, Boolean> deleteEmpregado(@PathVariable(value = "id") Long empregadoId)
			throws ResourceNotFoundException {
		Empregado empregado = empregadoService.getEmpregadoById(empregadoId)
				.orElseThrow(() -> new ResourceNotFoundException("Empregado not found for this id :: " + empregadoId));

		empregadoService.deleteEmpregado(empregado);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public EmpregadoDTO convertToDto(Empregado empregado) {
		EmpregadoDTO empregadoDTO = modelMapper.map(empregado, EmpregadoDTO.class);
		empregadoDTO.setRole("Supervisão");
		return empregadoDTO;
	}
	
	public Empregado convertToEntity(EmpregadoDTO empregadoDTO) {
		Empregado empregado = modelMapper.map(empregadoDTO, Empregado.class);
		return empregado;
	}
}
