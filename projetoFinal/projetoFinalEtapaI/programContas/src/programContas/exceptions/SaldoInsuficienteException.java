package programContas.exceptions;

public class SaldoInsuficienteException extends Exception {

	@Override
	public String getMessage() {
		return "Transação cancelada. O saldo é insuficiente para realizar o saque.";
	}
}
