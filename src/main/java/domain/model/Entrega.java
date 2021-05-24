package domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class) //converte de um validation group para outro
	@Valid
	@NotNull
	@ManyToOne //muitas entregas possuem um cliente
	private Cliente cliente; //propriedade cliente com ligação à classe Cliente
	
	@Valid
	@NotNull
	@Embedded //abstrai os dados para outra classe mas direciona para a mesma tabela da entidade entrega
	private Destinatario destinatario;
	
	@NotNull
	private BigDecimal taxa;
	
	@Enumerated(EnumType.STRING) //"importa" como texto as propriedades do Enum
	@JsonProperty(access = Access.READ_ONLY)
	private StatusEntrega status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime dataPedido;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime dataFinalizacao;	
	
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public Cliente getCliente() { return cliente; }
	public void setCliente(Cliente cliente) { this.cliente = cliente; }
	public Destinatario getDestinatario() { return destinatario; }
	public void setDestinatario(Destinatario destinatario) { this.destinatario = destinatario; }
	public BigDecimal getTaxa() { return taxa; }
	public void setTaxa(BigDecimal taxa) { this.taxa = taxa; }
	public StatusEntrega getStatus() { return status; }
	public void setStatus(StatusEntrega status) { this.status = status; }
	public LocalDateTime getDataPedido() { return dataPedido; }
	public void setDataPedido(LocalDateTime dataPedido) { this.dataPedido = dataPedido; }
	public LocalDateTime getDataFinalizacao() { return dataFinalizacao; }
	public void setDataFinalizacao(LocalDateTime dataFinalizacao) { this.dataFinalizacao = dataFinalizacao; }

	

}
