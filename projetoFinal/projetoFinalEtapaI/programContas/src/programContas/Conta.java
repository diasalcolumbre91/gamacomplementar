package programContas;

import programContas.exceptions.NegativoNaoSaldoException;
import programContas.exceptions.SaldoInsuficienteException;

public abstract class Conta {
	protected long numero;
	protected double saldo;
	protected String tipoConta;

	public Conta(long numero, double saldo, String tipoConta) {
		this.numero = numero;
		this.saldo = saldo;
		this.tipoConta = tipoConta;
	}

	public abstract String getTipoConta();

	public long getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public abstract void deposita(double valor)throws NegativoNaoSaldoException;

	public abstract void sacar(double valor) throws SaldoInsuficienteException;

}
