package programContas;

import programContas.exceptions.NegativoNaoSaldoException;
import programContas.exceptions.SaldoInsuficienteException;

public class ContaCorrente extends Conta {

	public ContaCorrente(long numero, double saldo, String tipoConta) {
		super(numero, saldo, tipoConta);
	}

	@Override
	public void sacar(double valor) throws SaldoInsuficienteException {
		if (valor <= saldo&& valor > 0) {
			saldo -= valor;
			return;

		} else {
			throw new SaldoInsuficienteException();
		}
	}

	@Override
	public void deposita(double valor) throws NegativoNaoSaldoException {
		if(valor > 0 ) {
			saldo += valor;
		}
		else {
			throw new NegativoNaoSaldoException();
		}
	}
	
	@Override
	public String getTipoConta() {
		return tipoConta;
	}
}
