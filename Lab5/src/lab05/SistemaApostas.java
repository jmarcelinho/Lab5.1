package lab05;

public class SistemaApostas {
	ControllerAposta controleApostas;
	ControllerCenario controleCenario;
	
	public SistemaApostas(int valorCaixa, double porcentagem) {
		controleApostas = new ControllerAposta();
		controleCenario = new ControllerCenario(valorCaixa, porcentagem);
	}
	
	public int getCaixa() {
		return this.controleCenario.getCaixa();
	}
	
	public int cadastrarCenario(String descricao) {
		return this.controleCenario.cadastrarCenario(descricao);
	}
	
	public String exibirCenario(int numeracao) {
		return this.controleCenario.exibirCenario(numeracao);
	}
	
	public String exibirCenarios() {
		return this.controleCenario.exibirCenarios();
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
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		int aux = controleCenario.isValid(cenario);
		if(aux==0) 
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		else if(aux==1){
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		this.controleApostas.cadastrarAposta(cenario, apostador, valor, previsao);
		if(previsao.equals("VAI ACONTECER")) {
			controleCenario.valoresApostassoma_ocorre += valorAposta;
		}else {
			soma_nao_ocorre += valorAposta;
		}
	}
	
	
	/**
	 * Retorna o valor total de apostas de um
	 * determinado cenario.
	 * @param cenario inteiro que representa um cenario.
	 * @return valor total de apostas em um cenario.
	 */
	public int valorTotalDeApostas(int cenario) {
		int aux = controleCenario.isValid(cenario);
		if(aux == 0) 
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		else if(aux == 1){
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		return controleApostas.valorApostas(cenario);
	}
	
	/**
	 * Retorna o numero de apostas de um determinado cenario.
	 * @param cenario inteiro que representa um cenario.
	 * @return numero de apostas em um cenario.
	 */
	public int totalDeApostas(int cenario) {
		int aux = controleCenario.isValid(cenario);
		if(aux == 0) 
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		else if(aux == 1){
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
		return controleApostas.numeroApostas(cenario);
	}
	
	/**
	 * Retorna representacao em string de todas 
	 * as apostas cadastradas em um cenario.
	 * Para exibir as apostas eh necessario passar
	 * um inteiro que representa um cenario.
	 * @param cenario inteiro que representa um cenario.
	 * @return representacao em string das apostas cadastradas
	 * em um cenario.
	 */
	public String exibeApostas(int cenario) {
		int aux = controleCenario.isValid(cenario);
		if(aux == 0) 
			throw new IllegalArgumentException("Erro na consulta de apostas: Cenario invalido");
		else if(aux == 1){
			throw new IllegalArgumentException("Erro na consulta de apostas: Cenario nao cadastrado");
		}
		return controleApostas.listarApostas(cenario);
	}
}
