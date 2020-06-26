package net.guides.springboot2.springboot2jpacrudexample.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2jpacrudexample.model.Empregado;
import net.guides.springboot2.springboot2jpacrudexample.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	@Modifying@Query(value = "select emp.id, emp.nome_empresa, emp.cnpj_empresa, emp.endereco, emp.date_fundacao,\n" + 
			"emp.telefone, e.nome_completo, emp.empregado_id from empresas as emp\n" + 
			"inner join empregados as e on e.id = emp.empregado_id",
			nativeQuery = true )
	List<Empresa> findAllInnerJoin();

}

