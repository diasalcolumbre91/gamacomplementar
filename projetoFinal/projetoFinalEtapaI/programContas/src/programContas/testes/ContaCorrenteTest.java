
package programContas.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import programContas.Conta;
import programContas.ContaCorrente;
import programContas.exceptions.SaldoInsuficienteException;

class ContaCorrenteTest {

	@Test
	void TestSacarValorNegativoDisparaExceptionSaldoInsuficiente() {
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
