package controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
