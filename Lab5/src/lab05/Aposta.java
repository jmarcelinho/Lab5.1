package lab05;

/**
 * Representacao de uma aposta que pode ou nao ocorrer.
 * Uma aposta armazena o nome do apostador,
 * o valor apostado e a previsao (ocorre ou nao ocorre).
 * 
 * @author Joao Marcelo
 */
public class Aposta {
	
	private String nomeApostador;
	private double valorAposta;
	private Previsao previsao;
	private int cenario;
	
	/**
	 * Constroi uma aposta utilizando o nome do apostador,
	 * o valor que foi apostado e a previsao (vai ou nao ocorrer).
	 * @param nomeApostador nome do apostador.
	 * @param valorAposta valor apostado.
	 * @param previsao previsao da aposta.
	 */
	public Aposta(int cenario, String nomeApostador, double valorAposta, String previsao) {
		isValid(nomeApostador,valorAposta, previsao);
		if(previsao.equals("N VAI ACONTECER")) {
			this.previsao = Previsao.NAO_VAI_ACONTECER;
		}else if(previsao.equals("VAI ACONTECER")){
			this.previsao = Previsao.VAI_ACONTECER;
		}else {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;
	}
	
	
	private void isValid(String nomeApostador, double valorAposta, String previsao) {
		if(nomeApostador==null) 
			throw new NullPointerException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		if(nomeApostador.trim().equals("")) 
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		if(valorAposta<=0) 
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		if(previsao.trim().equals(""))
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
	}
	
	/**
	 * Retorna um double representando o  valor da aposta.
	 * @return valor da aposta.
	 */
	public double getValor() {
		return this.valorAposta;
	}
	
	public int getCenario() {
		return this.cenario;
	}
	
	/**
	 * Retorna a representacao em string 
	 * de uma aposta.
	 * A representacao segue o formato 
	 * nome do apostador - R$ valor da aposta - previsao(vai ocorrer ou nao vai ocorrer)
	 * 
	 * @return representacao em string da aposta.
	 */
	public String toString() {
		return this.nomeApostador + " - R$" + this.valorAposta + " - " + this.previsao.getPrevisao();
	}
}
