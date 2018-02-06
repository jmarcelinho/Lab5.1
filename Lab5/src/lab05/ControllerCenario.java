package lab05;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Controle de cenarios em um sistema de aposta.
 * O controle possui uma lista de cenarios no sistema,
 * o valor em caixa e uma porcentagem de quanto deve 
 * ser retirado para o caixa. 
 * @author Joao Marcelo
 *
 */
public class ControllerCenario {
	private ArrayList<Cenario> cenarios;
	private int caixa;
	private double porcentagemRetirada;
	
	/**
	 * O sistema eh iniciado com um valor inicial em caixa
	 * e a porcentagem que deve ser retirada das apostas para o
	 * caixa.
	 * @param valorCaixa valor inicial do caixa.
	 * @param porcentagem porcentagem de retirada para o caixa.
	 */
	public ControllerCenario(int valorCaixa, double porcentagem) {
		if(valorCaixa<0) throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		if(porcentagem<0) throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		this.cenarios = new ArrayList<>();
		this.caixa = valorCaixa;
		this.porcentagemRetirada = porcentagem;
	}
	
	/**
	 * Retorna um inteiro representando 
	 * o valor em caixa do sistema.
	 * @return o valor em caixa do sistema.
	 */
	public int getCaixa() {
		return this.caixa;
	}
	
	/**
	 * Verifica se a numeracao do cenario eh valida.
	 * Um cenario valido eh o que sua numeracao esta 
	 * lista dos cenarios cadastrados.
	 * @param cenario numeracao de um cenario.
	 */
	public int isValid(int cenario) {
		if(cenario < 0) 
			return 0;
		else if(cenario >=cenarios.size()){
			return 1;
		}
		return 2;
	}
	
	/**
	 * Cadastra cenario no sistema a partir
	 * de uma descricao e retorna a numeracao
	 * dada pelo sistema ao cenario.
	 * @param descricao descricao do sistema.
	 * @return numeracao do sistema cadastrado.
	 */
	public int cadastrarCenario(String descricao) {
		cenarios.add(new Cenario(descricao));
		return cenarios.size();
	}
	
	/**
	 * Retorna uma string representando um cenario
	 * pesquisado a partir da sua numeracao.
	 * 
	 * @param numeracao numeracao do cenario a ser exibido.
	 * @return representacao em string do cenario buscado.
	 */
	public String exibirCenario(int numeracao) {
		if(numeracao-1 < 0) 
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		else if(numeracao-1 >=cenarios.size()){
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		String res = numeracao + " - ";
		res +=cenarios.get(numeracao-1).toString();
		return res;
	}
	
	/**
	 * Retorna uma string representando uma lista
	 * com a representacao de todos os cenarios 
	 * cadastrados no sistema.
	 * @return representacao em string de todos os cenarios
	 * cadastrados no sistema.
	 */
	public String exibirCenarios() {
		Iterator <Cenario> it = cenarios.iterator();
		String res = "";
		int index = 1;
		while(it.hasNext()){
			res+= index++ + " - " + it.next().toString() + "\n";
		}
		return res;
	}
	
	/**
	 * Fecha um cenario a partir da sua numeracao e 
	 * a informacao se ele ocorreu ou nao.
	 * A informacao se ocorreu ou nao ocorreu eh dada
	 * a partir de um boolean que eh True se ocorreu
	 * e False caso contrario.
	 * 
	 * @param cenario inteiro que representa a
	 * numeracao do cenario a ser fechado.
	 * 
	 * @param ocorreu informacao se o cenario ocorreu ou nao.
	 */
	public void fecharCenario(int cenario, boolean ocorreu) {
		if(cenario-1 < 0) 
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		else if(cenario-1 >=cenarios.size()){
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		if(ocorreu) {
			cenarios.get(cenario-1).fecharCenario(Estado.FINALIZADO_OCORREU);
		}else {
			cenarios.get(cenario-1).fecharCenario(Estado.FINALIZADO_NAO_OCORREU);
		}
		this.caixa += getCaixaCenario(cenario);
	}
	
	/**
	 * Retorna um inteiro representado o valor de um
	 * cenario finalizado, que sera
	 * adicionado ao caixa do sistema.
	 * @param cenario numeracao do cenario
	 * @return valor de um cenario que sera adicionado ao caixa do sistema.
	 */
	public int getCaixaCenario(int cenario) {
		if(cenario-1 < 0) 
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		else if(cenario-1 >=cenarios.size()){
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		int soma_perdedoras = cenarios.get(cenario-1).getSomaPerdedoras();
		if(soma_perdedoras == -1)
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		int caixaCenario = (int) (soma_perdedoras * this.porcentagemRetirada);
		//caixaCenario*=100;
		return caixaCenario;
	}
	
	/**
	 * Retorna o valor total das apostas do cenario que sera 
	 * rateado entre as apostas vencedoras do cenario.
	 * 
	 * @param cenario numeracao do cenario. 
	 * 
	 * @return inteiro representado o valor a ser rateado 
	 * entre as apostas vencedoras.
	 * 
	 */
	public int getTotalRateio(int cenario) {
		if(cenario-1 < 0) 
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		else if(cenario-1 >=cenarios.size()){
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		int rateio = cenarios.get(cenario-1).getSomaPerdedoras();
		if(rateio==-1) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		rateio -= getCaixaCenario(cenario);
		return rateio;
	}
	
}








