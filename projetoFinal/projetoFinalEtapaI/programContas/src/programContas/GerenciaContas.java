package programContas;

import java.util.HashMap;
import programContas.exceptions.ContaNaoInseridaException;

import programContas.exceptions.ContaNaoEncontradaException;

public class GerenciaContas {
        private HashMap<Long, Conta> listaDeContas = new HashMap<>();

        public void InserirConta(long numero, double saldo, int tipoConta, double limite) throws ContaNaoInseridaException {
                if (!listaDeContas.containsKey(numero) && tipoConta == 1) {
                        listaDeContas.put(numero, new ContaCorrente(numero, saldo, "Conta Corrente"));
                        return;
                } else if (!listaDeContas.containsKey(numero) && tipoConta == 2) {
                        listaDeContas.put(numero, new ContaEspecial(numero, saldo, "Conta Especial", limite));
                        return;
                } else {
                        throw new ContaNaoInseridaException();
                }
        }

        public void removerConta(long numero) throws ContaNaoEncontradaException {
                if (listaDeContas.containsKey(numero)) {
                        listaDeContas.remove(numero);
                        return;
                } else {
                        throw new ContaNaoEncontradaException();
                }
        }

        public Conta mostrarDadosDaConta(long numero) throws ContaNaoEncontradaException {
                if (listaDeContas.containsKey(numero)) {
                        return listaDeContas.get(numero);
                }
                else {
                        throw new ContaNaoEncontradaException();
                }
        }

}
