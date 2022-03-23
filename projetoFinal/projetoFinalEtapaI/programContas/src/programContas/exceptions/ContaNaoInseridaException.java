package programContas.exceptions;

public class ContaNaoInseridaException extends Exception {

	@Override
	public String getMessage() {
		return "Erro: A conta não foi criada.";
	}

}
