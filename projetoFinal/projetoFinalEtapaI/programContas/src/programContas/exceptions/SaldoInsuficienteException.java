package programContas.exceptions;

public class SaldoInsuficienteException extends Exception {

	@Override
	public String getMessage() {
		return "Transa��o cancelada. O saldo � insuficiente para realizar o saque.";
	}
}
