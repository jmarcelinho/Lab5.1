package lab05;

import java.util.ArrayList;
import java.util.Iterator;

public class ControllerAposta {
	private ArrayList <Aposta> apostas;
	
	public ControllerAposta() {
		apostas = new ArrayList<>();
	}
	
	/**
	 * Cadastra apostas em um determinado cenario.
	 * Eh necessario que seja informado um inteiro 
	 * que representa o cenario no qual a aposta deve ser
	 * cadastrada.
	 * @param cenario inteiro que representa um cenario.
	 * @param apostador nome do apostador.
	 * @param valor valor da aposta.
	 * @param previsao previsao para aposta(ocorre ou nao ocorre).
	 */
	public void cadastrarAposta(int cenario, String nomeApostador, int valorAposta, String previsao) {
		apostas.add(new Aposta(cenario, nomeApostador, valorAposta, previsao));
	}
	
	/**
	 * Retorna a soma de todas as apostas perdedoras.
	 * @return soma das apostas perdedoras.
	 */
	public int getSomaPerdedoras(int cenario) {
		
		if(this.estado.equals(Estado.NAO_FINALIZADO))
			return -1;
		if(this.estado.equals(Estado.FINALIZADO_OCORREU)) {
			return (int)soma_nao_ocorre;
		}
		return (int)soma_ocorre;
	}
	
	/**
	 * Retorna as representacoes em string das 
	 * apostas cadastradas em um determinado cenario.
	 * 
	 * @return representacoes em string das apostas no cenario.
	 */
	public String listarApostas(int cenario) {
		Iterator <Aposta> it = apostas.iterator();
		String res = "";
		while(it.hasNext()){
			Aposta aposta = it.next();
			if(aposta.getCenario() == cenario) {
				res += aposta.toString() + "\n";
			}
		}
		return res;
	}
	
	/**
	 * Retorna o numero de apostas de um determinado cenario.
	 * @param cenario inteiro que representa um cenario.
	 * @return numero de apostas em um cenario.
	 */
	public int numeroApostas(int cenario) {
		int cont = 0;
		for(Aposta aposta : apostas) {
			if(aposta.getCenario() == cenario) {
				cont++;
			}
		}
		return cont;
	}
	
	/**
	 * Retorna o valor total de apostas de um
	 * determinado cenario.
	 * @param cenario inteiro que representa um cenario.
	 * @return valor total de apostas em um cenario.
	 */
	public int valorApostas(int cenario) {
		int valor = 0;
		for(Aposta aposta : apostas) {
			if(aposta.getCenario() == cenario) {
				valor += aposta.getValor();
			}
		}
		return valor;
	}
}
