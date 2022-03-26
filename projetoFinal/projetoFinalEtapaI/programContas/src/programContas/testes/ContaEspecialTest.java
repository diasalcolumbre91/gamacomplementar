package programContas.testes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import programContas.Conta;
import programContas.ContaEspecial;
import programContas.exceptions.NegativoNaoSaldoException;
import programContas.exceptions.SaldoInsuficienteException;

class ContaEspecialTest {

	@Test
	void testDepositaComValorNegativoDisparaNegativoNaoException() throws Exception {
		Conta c = new ContaEspecial(1234, 100.00, "Conta Especial", 100.00);

		assertThrows(NegativoNaoSaldoException.class, () -> c.deposita(-200.00));
	}

	@Test
	void testDepositaCasoDeSucesso() throws Exception {
		Conta c = new ContaEspecial(1234, 100.00, "Conta Especial", 100.00);
		c.deposita(100.00);
		assertEquals(200.00, c.getSaldo());
	}

	@Test
	void testSacarValorNegativoDisparaExceptionSaldoInsuficiente() {
		Conta c = new ContaEspecial(1234, 100.00, "Conta Especial", 100.00);

		assertThrows(SaldoInsuficienteException.class, () -> c.sacar(-200.00));

	}

	@Test
	void testSacarCasoDeSucesso() throws SaldoInsuficienteException {
		Conta c = new ContaEspecial(1234, 100.00, "Conta Especial", 100.00);
		c.sacar(190.00);
		assertEquals(-10.00, c.getSaldo());
	}

	@Test
	void testSacarSaldoInsuficienteDisparaException() {
		Conta c = new ContaEspecial(1234, 100.00, "Conta Especial", 100.00);

		assertThrows(SaldoInsuficienteException.class, () -> c.sacar(300.00));
	}

}
