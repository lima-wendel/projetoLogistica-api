package controller.copy;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import domain.model.Entrega;
import domain.model.repository.EntregaRepository;
import domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
	
	private EntregaRepository entregaRepository;
	private SolicitacaoEntregaService solicitacaoEntregaService;
	
	@PostMapping //ao criar uma nova entrega envia um POST em /entregas passando no corpo da requisicao um JSON com todos os dados da entrega
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
		return solicitacaoEntregaService.solicitar(entrega);
	}
	
	//método que retorna a lista de entregas
	@GetMapping
	public List<Entrega> listar() {
		return entregaRepository.findAll();
	}
	
	//método para buscar entrega pelo id da entrega
	@GetMapping("/entregaId")
	public ResponseEntity<Entrega> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId)
				.map(ResponseEntity::ok) //caso exista algo no optional, retorna ok com a própria entrega
				.orElse(ResponseEntity.notFound().build());
	}
	
	
}
