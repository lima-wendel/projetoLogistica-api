package domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.model.Cliente;
import domain.model.Entrega;
import domain.model.StatusEntrega;
import domain.model.repository.EntregaRepository;
import lombok.AllArgsConstructor;

//classe de serviço que cria uma nova entrega
@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {
	private EntregaRepository entregaRepository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		Cliente cliente = clienteRepository.findById(entrega.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
		
		//implementação das regras de entrega. Ex: horário de entrega, entrega com motoboys etc.
		
		//atribuir propriedades antes de salvar:
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		
		return entregaRepository.save(entrega);
	}
}
