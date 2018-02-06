package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import lab05.Aposta;

public class ApostaTest {
	
	private Aposta aposta;
	@Before
	public void setUp(){
		aposta = new Aposta("Joao", 200, "VAI ACONTECER");
	}

	@Test(expected = NullPointerException.class)
	public void apostaNomeNullTest() {
		aposta = new Aposta(null, 200, "N VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void apostaNomeVazioTest() {
		aposta = new Aposta("        ", 200, "N VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void apostaValorNegativoTest() {
		aposta = new Aposta("Marcelo", -30, "N VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void apostaValorZeroTest() {
		aposta = new Aposta("Marcelo", 0, "N VAI ACONTECER");
	}
	
	@Test
	public void toStringTest() {
		String expected = "Joao - R$200.0 - Vai acontecer";
		assertEquals(expected, aposta.toString());
	}
	
	@Test
	public void valorApostaTest() {
		int expected = 200;
		assertEquals(expected, (int)aposta.getValor());
	}

}
