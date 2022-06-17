package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	Optional<Empresa> findByRuc(String ruc);
}
