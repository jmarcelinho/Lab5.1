package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab05.Cenario;
import lab05.Estado;

public class CenarioTest {
	
	private Cenario cenario;
	@Before
	public void setUp() {
		cenario = new Cenario("Todos os alunos vao ser aprovados");
	}

	@Test(expected = NullPointerException.class)
	public void cenarioComDescricaoNulaTest() {
		cenario = new Cenario(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cenarioComDescricaoVaziaTest() {
		cenario = new Cenario("        ");
	}
	
	@Test(expected = NullPointerException.class)
	public void cadastraApostaComNomeNullTest() {
		cenario.cadastrarAposta(null, 200, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void cadastraApostaComNomeVazioTest() {
		cenario.cadastrarAposta("       ", 2000, "N VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void fecharCenarioFinalizadoTest() {
		cenario.fecharCenario(Estado.FINALIZADO_OCORREU);
		cenario.fecharCenario(Estado.FINALIZADO_NAO_OCORREU);
	}
	
	@Test
	public void getApostasPerdedorasTest() {
		cenario.cadastrarAposta("Jose", 200, "VAI ACONTECER");
		cenario.cadastrarAposta("Joao", 500, "N VAI ACONTECER");
		int expected = 500;
		cenario.fecharCenario(Estado.FINALIZADO_OCORREU);
		assertEquals(expected, (int)cenario.getSomaPerdedoras());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getApostasPerdedorasCenarioNaoFinalizadoTest() {
		cenario.getSomaPerdedoras();
	}
	
	@Test
	public void listarApostasTest() {
		cenario.cadastrarAposta("Jose", 200, "VAI ACONTECER");
		cenario.cadastrarAposta("Joao", 500, "N VAI ACONTECER");
		String expected = "Jose - R$200.0 - Vai acontecer\n" +
						"Joao - R$500.0 - Nao vai acontecer\n";
		assertEquals(expected, cenario.listarApostas());
	}
	
	@Test
	public void numeroApostasTest() {
		cenario.cadastrarAposta("Jose", 200, "VAI ACONTECER");
		cenario.cadastrarAposta("Joao", 500, "N VAI ACONTECER");
		assertEquals(2, cenario.numeroApostas());
	}
	
	@Test
	public void valorApostasCenarioTest() {
		cenario.cadastrarAposta("Jose", 200, "VAI ACONTECER");
		cenario.cadastrarAposta("Joao", 500, "N VAI ACONTECER");
		assertEquals(700, cenario.valorApostas());
	}
	
	@Test
	public void getDescricaoTest() {
		String expected = "Todos os alunos vao ser aprovados";
		assertEquals(expected, cenario.getDescricao());
	}
	
	@Test
	public void toStringCenarioNaoFinalizadoTest() {
		String expected = "Todos os alunos vao ser aprovados - Nao finalizado";
		assertEquals(expected, cenario.toString());
	}
	
	@Test
	public void toStringCenarioFinalizadoOcorreuTest() {
		cenario.fecharCenario(Estado.FINALIZADO_OCORREU);
		String expected = "Todos os alunos vao ser aprovados - Finalizado (ocorreu)";
		assertEquals(expected, cenario.toString());
	}
	
	public void toStringCenarioFinalizadoNaoOcorreuTest() {
		cenario.fecharCenario(Estado.FINALIZADO_NAO_OCORREU);
		String expected = "Todos os alunos vao ser aprovados - Finalizado ( n ocorreu)";
		assertEquals(expected, cenario.toString());
	}
	
}
