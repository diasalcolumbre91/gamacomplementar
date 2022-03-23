package programContas.exceptions;

public class NegativoNaoSaldoException extends Exception {

	@Override
	public String getMessage() {
		return "Transa��o cancelada. Valores negativos n�o s�o permitidos no dep�sito. Utilize a opera��o sacar.";
	}

}
