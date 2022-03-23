package programContas;

import java.util.Scanner;

import programContas.exceptions.ContaNaoEncontradaException;
import programContas.exceptions.ContaNaoInseridaException;
import programContas.exceptions.NegativoNaoSaldoException;
import programContas.exceptions.SaldoInsuficienteException;

public class AppContas {

	private Scanner entrada = new Scanner(System.in);
	private GerenciaContas contas = new GerenciaContas();

	public void gerenciarContas(Conta contaGerenciada) throws Exception {
		while (true) {
			System.out.println("Escolha uma operação: 1. Consultar informações sobre uma conta. 2. Realizar depósito na conta. 3. Realizar saque da conta. 4. Voltar.");
			int opcaoEscolhida = entrada.nextInt();
			if (opcaoEscolhida == 1) {
				System.out.println(contaGerenciada.getTipoConta() + " número " + contaGerenciada.getNumero() + ". Saldo atual é: " + contaGerenciada.getSaldo());
				if(contaGerenciada instanceof ContaEspecial) {
					ContaEspecial contaEspecial = (ContaEspecial)contaGerenciada;
					System.out.println("O limite foi estabelecido em " + contaEspecial.getLimite());
				}
			}
			else if (opcaoEscolhida == 2) {
				System.out.println("Qual o valor a depositar?");
				double deposito = entrada.nextDouble();
				try {
					contaGerenciada.deposita(deposito);
				}
				catch (NegativoNaoSaldoException e) {
					System.out.println(e);
				}
				
			}
			else if (opcaoEscolhida == 3 ) {
				System.out.println("Qual o valor a sacar?");
				double valor = entrada.nextDouble();
				try {
					contaGerenciada.sacar(valor);
				}
				catch (SaldoInsuficienteException e) {
					System.out.println(e);
				}
			}
			else if (opcaoEscolhida == 4 ) {
				return;
			}
			else {
				System.out.println("Opção inválida.");
			}
		}
	}

	public void removerConta() throws ContaNaoEncontradaException {
		System.out.println("Qual conta deseja remover?");
		long numero = entrada.nextLong();
		try {
			contas.removerConta(numero);
			System.out.println("A conta " + numero + " foi removida com sucesso.");
		} catch (ContaNaoEncontradaException e) {
			System.out.println(e);
		}
	}

	public void criarNovaConta() throws ContaNaoInseridaException {
		double limite = 0.0;
		System.out.println("Insira o número da conta.");
		long numero = entrada.nextLong();
		System.out.println(
				"A conta será do tipo Conta Corrente ou Conta Especial? 1 para Conta Corrente, 2 para Conta Especial.");
		int tipoConta = entrada.nextInt();
		System.out.println("Insira o saldo que esta conta terá de base.");
		double saldo = entrada.nextDouble();
		if (tipoConta == 2) {
			System.out.println("Qual o limite esta conta terá?");
			limite = entrada.nextDouble();
		}
		try {
			if (tipoConta == 1) {
				contas.InserirConta(numero, saldo, tipoConta, 0.0);
			} else {
				contas.InserirConta(numero, saldo, tipoConta, limite);
			}

		} catch (ContaNaoInseridaException e) {
			System.out.println(e);
		}
	}

	public void menuPrincipal() throws Exception {

		while (true) {
			System.out.println("Menu principal. Escolha: 1. Criar nova conta. 2. Remover conta. 3. Gerenciar uma conta.");
			int opcaoEscolhida = entrada.nextInt();
			if (opcaoEscolhida == 1) {
				criarNovaConta();
			} else if (opcaoEscolhida == 2) {
				removerConta();
			} else if (opcaoEscolhida == 3) {
				System.out.println("Insira o número da conta que deseja gerenciar.");
				Long numeroConta = entrada.nextLong();
				try {
					Conta contaGerenciada = contas.mostrarDadosDaConta(numeroConta);
					gerenciarContas(contaGerenciada);
				}
				catch (ContaNaoEncontradaException e) {
					System.out.println(e);
				}

			} else {
				System.out.println("Opção inválida.");
			}
		}
	}
	public static void main(String []args) throws Exception {
		AppContas appContas = new AppContas();
		appContas.menuPrincipal();
	}
	

}
