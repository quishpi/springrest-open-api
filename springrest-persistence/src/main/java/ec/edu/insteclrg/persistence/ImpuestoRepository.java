package ec.edu.insteclrg.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.insteclrg.domain.Impuesto;

@Repository

public interface ImpuestoRepository extends JpaRepository<Impuesto, Long> {
	Optional<Impuesto> findByCodigo(String codigo);

	

}
