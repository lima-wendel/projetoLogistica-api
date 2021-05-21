package controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import domain.model.Cliente;
import domain.model.repository.ClienteRepository;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
public class ClienteController {
	
//	@PersistenceContext //vai injetar um EntityManager na variável de instância manager
//	private EntityManager manager;
	
//	@Autowired //define a injeção de uma instância gerenciada pelo Spring
//	private ClienteRepository clienteRepository;
	
	private ClienteRepository clienteRepository;
	
	//construtor using fields... alternativa ao @Autowired
	public ClienteController(ClienteRepository clienteRepository) {
	super();
	this.clienteRepository = clienteRepository;
}


	//método listar que vai tratar a requisição e devolver "Teste"
	@GetMapping ("/clientes")//vai mapear o endpoint /clientes e resolver o método, mas só funciona com a marcação RestController
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
		
	//método que retorna apenas um cliente e não uma lista
	@GetMapping("/clientes/{clienteId}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
		return clienteRepository.findById(clienteId)
			//  .map(cliente -> ResponseEntity.ok(cliente));
				.map(ResponseEntity::ok) //retorna 200
				.orElse(ResponseEntity.notFound().build()); //retorna 404
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) //retorna 201 para uma cliente salvo
	//o @REsponseBody vai transformar o JSON da requisição em objeto Java
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
		
	}
	
	
	@PutMapping("/{clienteId}")
	public ResponseEntity<Cliente> atualizar (@PathVariable Long clienteId, @Valid @RequestBody Cliente cliente) {
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		//atualizar cliente
		cliente.setId(clienteId);
		cliente = clienteRepository.save(cliente);
		
		return ResponseEntity.ok(cliente); 
		
	}
	
	//DELETE method
	@DeleteMapping("/{clienteId}")
	public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
		if (!clienteRepository.existsById(clienteId)) {
			return ResponseEntity.notFound().build();
		}
		
		clienteRepository.deleteById(clienteId);
		
		return ResponseEntity.noContent().build();//noContent retorna 204
	}
		
/*		
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		
		//retorna código 200
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		
		//retorna código 404
		return ResponseEntity.notFound().build();
	}
	
*/
		
		//return manager.createQuery("from Cliente", Cliente.class) //"from Cliente", "Cliente.class" é uma jpql, linguagem de consulta do Jakarta Persistence
		//		.getResultList();

/*
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("José");
		cliente1.setTelefone("11 99999-0000");
		cliente1.setEmail("jose@gmail.com");
		
		var cliente2 = new Cliente();
		cliente2.setId(1L);
		cliente2.setNome("João");
		cliente2.setTelefone("11 88888-0000");
		cliente2.setEmail("joao@gmail.com");
		
		return Arrays.asList(cliente1, cliente2);
*/
	

}
