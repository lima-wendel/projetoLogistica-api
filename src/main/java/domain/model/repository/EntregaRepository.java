package domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{
	
}
