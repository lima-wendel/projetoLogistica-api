package domain.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.model.Cliente;

@Repository //define que a interface é um componente do spring mas com semantica de repository, que gerencia entidades
//componente do Spring: tipo gerenciado pelo container do Spring, facilitando a injeção de instâncias em objetos de outras classes
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	
	//extends JpaRepository<Cliente, Long> automaticamente adiciona diversas funcionalidades ao repositório
	//para consultar e gerenciar a entidade Cliente
	
	//declarar método que retorna um List
	//o Spring Data JPA fornece uma implementação de busca por nome em tempo de execução
	List<Cliente> findByName(String nome);
	List<Cliente> findByNameContaining(String nome);
	Optional<Cliente> findByEmail(String email);
	
	
}
