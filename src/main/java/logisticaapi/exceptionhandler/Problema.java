package logisticaapi.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;


public class Problema {
	
	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
	private List<Campo> campos;
	
	@AllArgsConstructor
	@Getter
	public static class Campo {
		private String nome;
		private String mensagem;
	}
	
	
	public Integer getStatus() { return status; }
	public void setStatus(Integer status) { this.status = status; }
	public LocalDateTime getDataHora() { return dataHora; }
	public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
	public String getTitulo() { return titulo; }
	public void setTitulo(String titulo) { this.titulo = titulo; }

}
