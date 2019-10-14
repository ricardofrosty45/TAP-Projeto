package br.com.nova.roma.tap.projeto.controlador;

import java.util.LinkedList;
import java.util.Queue;

import br.com.nova.roma.tap.projeto.interfaces.impl.FuncoesLotericaImpl;

public class ControladorDaLoterica extends FuncoesLotericaImpl {

	private final Queue<String> listaNomeCaixa = new LinkedList<String>();
	private static boolean aberto = true;
	
	public ControladorDaLoterica() {
		this.listaNomeCaixa.add("Luan");
	}
	
	public void fecharLoterica() {
		System.out.println("Fechando Loterica");
		System.out.println("Loterica fechada:" + Thread.currentThread().getName());

		aberto = false;
		synchronized (this.listaNomeCaixa) {
			this.listaNomeCaixa.notifyAll();

		}
		
		System.exit(0);
	}
}
