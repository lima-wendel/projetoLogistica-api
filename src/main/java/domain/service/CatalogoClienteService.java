package domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.model.Cliente;
import domain.model.repository.ClienteRepository;

//classe de serviços que vai gerenciar o catálogo de cliente
@Service //componente Spring que representa os serviços que serão executados, ou seja, regras de negocio
public class CatalogoClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	//método para salvar e excluir um cliente
	@Transactional //declara que o método deve ser executado dentro de uma transação, vai salvar ou tudo ou nada
	public Cliente salvar (Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
	
}
