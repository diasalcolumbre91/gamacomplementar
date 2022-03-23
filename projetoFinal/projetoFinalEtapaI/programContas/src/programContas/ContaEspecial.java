package programContas;

import programContas.exceptions.NegativoNaoSaldoException;
import programContas.exceptions.SaldoInsuficienteException;

public class ContaEspecial extends Conta {
	private double limite;

	public ContaEspecial(long numero, double saldo, String tipoConta, double limite) {
		super(numero, saldo, tipoConta);
		this.limite = limite;
	}

	
	public double getLimite() {
		return limite;
	}
	
	@Override
	public void sacar(double valor) throws SaldoInsuficienteException {
		if (valor <= saldo + limite&& valor > 0) {
			saldo -= valor;
			return;

		} else {
			throw new SaldoInsuficienteException();
		}
	}

	@Override
	public void deposita(double valor) throws NegativoNaoSaldoException {
		if (valor > 0) {
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
