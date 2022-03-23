package programContas.exceptions;

public class NegativoNaoSaldoException extends Exception {

	@Override
	public String getMessage() {
		return "Transação cancelada. Valores negativos não são permitidos no depósito. Utilize a operação sacar.";
	}

}
