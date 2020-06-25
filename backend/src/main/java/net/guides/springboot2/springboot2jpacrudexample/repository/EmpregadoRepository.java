package net.guides.springboot2.springboot2jpacrudexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springboot2jpacrudexample.model.Empregado;

@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Long>{
	
	@Query(value = "SELECT * FROM empregados u WHERE u.funcao = 3 ",
			nativeQuery = true )
	List<Empregado> findAllProprietario();
	
}
