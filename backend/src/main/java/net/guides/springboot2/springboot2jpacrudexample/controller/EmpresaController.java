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

import net.guides.springboot2.springboot2jpacrudexample.beans.EmpresaDTO;
import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Empresa;
import net.guides.springboot2.springboot2jpacrudexample.service.EmpresaService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;

	@Autowired
    private ModelMapper modelMapper;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/empresas")
	public List<EmpresaDTO> getAllEmpresas() {
		List<Empresa> empresas = empresaService.getAllEmpresas();
		return empresas.stream()
        .map(this::convertToDto)
        .collect(Collectors.toList());
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/empresas/{id}")
	public ResponseEntity<EmpresaDTO> getEmpresaById(@PathVariable(value = "id") Long empresaId) {
		Empresa empresa = empresaService.getEmpresaById(empresaId).get();
		return ResponseEntity.ok().body(convertToDto(empresa));
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/empresas")
	public Empresa createEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO) {
		return empresaService.createEmpresa(convertToEntity(empresaDTO));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/empresas/{id}")
	public ResponseEntity<Empresa> updateEmpresa(@PathVariable(value = "id") Long empresaId,
			@Valid @RequestBody Empresa empresaDetails) throws ResourceNotFoundException {
		Empresa empresa = empresaService.getEmpresaById(empresaId)
				.orElseThrow(() -> new ResourceNotFoundException("Empresa not found for this id :: " + empresaId));

		empresa.setEmailId(empresaDetails.getEmailId());
		empresa.setLastName(empresaDetails.getLastName());
		empresa.setFirstName(empresaDetails.getFirstName());
		final Empresa updatedEmpresa = empresaService.updateEmpresa(empresaDetails);
		return ResponseEntity.ok(updatedEmpresa);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/empresas/{id}")
	public Map<String, Boolean> deleteEmpresa(@PathVariable(value = "id") Long empresaId)
			throws ResourceNotFoundException {
		Empresa empresa = empresaService.getEmpresaById(empresaId)
				.orElseThrow(() -> new ResourceNotFoundException("Empresa not found for this id :: " + empresaId));

		empresaService.deleteEmpresa(empresa);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	public EmpresaDTO convertToDto(Empresa empresa) {
		EmpresaDTO empresaDTO = modelMapper.map(empresa, EmpresaDTO.class);
		empresaDTO.setRole("ROLE_USER");
		return empresaDTO;
	}
	
	public Empresa convertToEntity(EmpresaDTO empresaDTO) {
		Empresa empresa = modelMapper.map(empresaDTO, Empresa.class);
		return empresa;
	}
}
