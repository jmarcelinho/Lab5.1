package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab05.ControllerCenario;

public class ControllerCenarioTest {
	ControllerCenario controleCenario;
	@Before
	public void setUp(){
		controleCenario = new ControllerCenario(100, 0.01);
	}

	@Test(expected = IllegalArgumentException.class)
	public void sistemaApostasCaixaNegativoTest() {
		controleCenario = new ControllerCenario(-100, 0.1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void sistemaApostasCaixaZeroTest() {
		controleCenario = new ControllerCenario(0, 0.1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void sistemaApostasPorcentagemZeroTest() {
		controleCenario = new ControllerCenario(100, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void sistemaApostasPorcentagemNegativoTest() {
		controleCenario = new ControllerCenario(100, -1);
	}
	
	@Test
	public void cadastrarCenarioTest() {
		int expected = 1;
		assertEquals(expected, controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados"));
	}
	
	@Test
	public void exibirCenarioTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		String expected = "1 - Todos os alunos vao ser aprovados - Nao finalizado";
		assertEquals(expected, controleCenario.exibirCenario(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void exibirCenarioNumeracaoInvalidaTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		String expected = "1 - Todos os alunos vao ser aprovados - Nao finalizado";
		assertEquals(expected, controleCenario.exibirCenario(2));
	}
	
	@Test
	public void exibirCenariosTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleCenario.cadastrarCenario("Todos os alunos vao ser reprovados");
		String expected = "1 - Todos os alunos vao ser aprovados - Nao finalizado\n"
				+ "2 - Todos os alunos vao ser reprovados - Nao finalizado\n" ;
		assertEquals(expected, controleCenario.exibirCenarios());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void fecharCenarioNumeracaoInvalidaTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleCenario.fecharCenario(0, false);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void fecharCenarioFinalizadoTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		//fechando cenario
		controleCenario.fecharCenario(1, false); 
		//tentando fechar o mesmo cenario
		controleCenario.fecharCenario(1, true); 
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarApostaTestNumeracaoInvalidaTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleCenario.cadastrarAposta(2, "Brito", 200, "N VAI ACONTECER");
	}
	
	@Test
	public void totalDeApostasTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleCenario.cadastrarAposta(1, "Brito", 200, "N VAI ACONTECER");
		controleCenario.cadastrarAposta(1, "Mateus", 200, "VAI ACONTECER");
		int expected = 2;
		assertEquals(expected, controleCenario.totalDeApostas(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void totalDeApostasCenarioInvalidoTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleCenario.cadastrarAposta(1, "Brito", 200, "N VAI ACONTECER");
		controleCenario.cadastrarAposta(1, "Mateus", 200, "VAI ACONTECER");
		int expected = 2;
		assertEquals(expected, controleCenario.totalDeApostas(2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void valorTotalDeApostasCenarioInvalidoTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleCenario.cadastrarAposta(1, "Brito", 200, "N VAI ACONTECER");
		controleCenario.cadastrarAposta(1, "Mateus", 200, "VAI ACONTECER");
		int expected = 2;
		assertEquals(expected, controleCenario.valorTotalDeApostas(2));
	}
	
	@Test
	public void valorTotalDeApostasTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleCenario.cadastrarAposta(1, "Brito", 200, "N VAI ACONTECER");
		controleCenario.cadastrarAposta(1, "Mateus", 200, "VAI ACONTECER");
		int expected = 400;
		assertEquals(expected, controleCenario.valorTotalDeApostas(1));
	}
	
	@Test
	public void getcaixaCenarioTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleCenario.cadastrarAposta(1, "Francisco Cisco", 200, "VAI ACONTECER");
		controleCenario.cadastrarAposta(1, "Brito", 200, "N VAI ACONTECER");
		controleCenario.fecharCenario(1, true);
		int expected = 2;
		assertEquals(expected, controleCenario.getCaixaCenario(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getcaixaCenarioNumeracaoInvalidaTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleCenario.cadastrarAposta(1, "Francisco Cisco", 200, "VAI ACONTECER");
		controleCenario.cadastrarAposta(1, "Brito", 200, "N VAI ACONTECER");
		controleCenario.fecharCenario(1, true);
		int expected = 2;
		assertEquals(expected, controleCenario.getCaixaCenario(2));
	}
	
	@Test
	public void getTotalRateioTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleCenario.cadastrarAposta(1, "Francisco Cisco", 200, "VAI ACONTECER");
		controleCenario.cadastrarAposta(1, "Brito", 200, "N VAI ACONTECER");
		controleCenario.fecharCenario(1, true);
		int expected = 198;
		assertEquals(expected, controleCenario.getTotalRateio(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getTotalRateioNumeracaoInvalidaTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleCenario.cadastrarAposta(1, "Francisco Cisco", 200, "VAI ACONTECER");
		controleCenario.cadastrarAposta(1, "Brito", 200, "N VAI ACONTECER");
		controleCenario.fecharCenario(1, true);
		int expected = 198;
		assertEquals(expected, controleCenario.getTotalRateio(2));
	}
	
	@Test
	public void exibeApostasTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleCenario.cadastrarAposta(1, "Francisco Cisco", 200, "VAI ACONTECER");
		controleCenario.cadastrarAposta(1, "Brito", 200, "N VAI ACONTECER");
		String expected = "Francisco Cisco - R$200.0 - Vai acontecer\n"
				+ "Brito - R$200.0 - Nao vai acontecer\n";
		assertEquals(expected, controleCenario.exibeApostas(1));
	}
	@Test(expected = IllegalArgumentException.class)
	public void exibeApostasNumeracaoInvalidaTest() {
		controleCenario.cadastrarCenario("Todos os alunos vao ser aprovados");
		controleCenario.cadastrarAposta(1, "Francisco Cisco", 200, "VAI ACONTECER");
		controleCenario.cadastrarAposta(1, "Brito", 200, "N VAI ACONTECER");
		String expected = "Francisco Cisco - R$200 - Vai acontecer\n"
				+ "Brito - R$200 - Nao vai acontecer\n";
		assertEquals(expected, controleCenario.exibeApostas(2));
	}
	
	
}
