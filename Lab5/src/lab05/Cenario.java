package lab05;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Representa um cenario para uma aposta.
 * Um cenario eh algo que pode acontecer ou nao.
 * 
 * Cada cenario possui uma descricao e um estado
 * que informa se o cenario foi finalizado ou nao
 * e se finalizado se ocorreu ou nao ocorreu.
 * 
 * O cenario tambem possui uma lista de apostas
 * que foram feitas para tal cenario.
 * 
 * @author Joao Marcelo
 *
 */
public class Cenario {
	private String descricao;
	private Estado estado;
	private double soma_ocorre;
	private double soma_nao_ocorre;
	/**
	 * Cria o cenario a partir de uma descricao.
	 * Inicialmente o cenario nao possui nenhuma aposta.
	 * 
	 * @param descricao descricao de um cenario.
	 */
	public Cenario(String descricao) {
		if(descricao==null) throw new NullPointerException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		if(descricao.trim().equals("")) throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		this.descricao = descricao;
		this.estado = Estado.NAO_FINALIZADO;
		this.soma_ocorre = 0;
		this.soma_nao_ocorre = 0;
	}
	
	
	/**
	 * Fecha o cenario a partir da informacao se o mesmo
	 * ocorreu ou nao ocorreu.
	 * @param estado que informa se ocorreu ou nao ocorreu.
	 */
	public void fecharCenario(Estado e) {
		if(this.estado.equals(Estado.NAO_FINALIZADO)){
			this.estado = e;
		}else {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		
	}
	
	/**
	 * Retorna uma string com 
	 * a descricao do cenario.
	 * @return descricao do cenario.
	 */
	public String getDescricao() {
		return this.descricao;
	}
	
	/**
	 * Retorna uma representacao do cenario.
	 * A representacao do cenario eh no formato 
	 * descricao - estado (finalizado ou nao finalizado).
	 * 
	 * @return representacao em string do cenario.
	 */
	public String toString() {
		return descricao + " - " + estado.getEstado();
	}
}
