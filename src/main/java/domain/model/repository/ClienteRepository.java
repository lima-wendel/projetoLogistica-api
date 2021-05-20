package domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.model.Cliente;

@Repository //define que a interface é um componente do spring mas com semantica de repository, que gerencia entidades
//componente do Spring: tipo gerenciado pelo container do Spring, facilitando a injeção de instâncias em objetos de outras classes
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
