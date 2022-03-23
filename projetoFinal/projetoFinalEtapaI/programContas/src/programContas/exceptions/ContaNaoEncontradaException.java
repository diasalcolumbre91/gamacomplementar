package programContas.exceptions;

public class ContaNaoEncontradaException extends Exception {

	@Override
	public String getMessage() {
		return "Erro: A conta solicitada não foi encontrada.";
	}
}
