
package programContas.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import programContas.Conta;
import programContas.ContaCorrente;
import programContas.exceptions.NegativoNaoSaldoException;
import programContas.exceptions.SaldoInsuficienteException;

class ContaCorrenteTest {
	
	@Test
	void testDepositaComValorNegativoDisparaNegativoNaoException() throws Exception {
		Conta c = new ContaCorrente(1234, 100.00, "Conta Corrente");
		
		assertThrows(NegativoNaoSaldoException.class, () -> c.deposita(-200.00));
	}
	
	@Test
	void testDepositaCasoDeSucesso() throws Exception {
		Conta c = new ContaCorrente(1234, 100.00, "Conta Corrente");
		c.deposita(100.00);
		assertEquals(200.00, c.getSaldo());
	}
	
	@Test
	void testSacarValorNegativoDisparaExceptionSaldoInsuficiente() {
		Conta c = new ContaCorrente(1234, 100.00, "Conta Corrente");
		
		assertThrows(SaldoInsuficienteException.class, () -> c.sacar(-200.00));
		
	}

	@Test
	void testSacarCasoDeSucesso() throws SaldoInsuficienteException {
		Conta c = new ContaCorrente(1234, 100.00, "Conta Corrente");
		c.sacar(10.00);
		assertEquals(90.00, c.getSaldo());
	}

	
	@Test
	void testSacarSaldoInsuficienteDisparaException() {
		Conta c = new ContaCorrente(1234, 100.00, "Conta Corrente");
		
		assertThrows(SaldoInsuficienteException.class, () -> c.sacar(200.00));
	}
	
}
