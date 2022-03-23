package programContas.exceptions;

public class ContaNaoEncontradaException extends Exception {

	@Override
	public String getMessage() {
		return "Erro: A conta solicitada n�o foi encontrada.";
	}
}
