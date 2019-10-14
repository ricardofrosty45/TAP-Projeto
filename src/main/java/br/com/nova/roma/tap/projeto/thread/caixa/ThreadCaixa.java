package br.com.nova.roma.tap.projeto.thread.caixa;

import java.util.ArrayList;
import java.util.Random;

import com.sun.swing.internal.plaf.synth.resources.synth;

import br.com.nova.roma.tap.projeto.entity.Cliente;
import br.com.nova.roma.tap.projeto.interfaces.impl.FuncoesLotericaImpl;

public class ThreadCaixa implements Runnable {
	private FuncoesLotericaImpl control;
	public Thread t1;
	private Cliente c;

	public ThreadCaixa(Cliente c, FuncoesLotericaImpl control) {
		this.c = c;
		this.control = control;
		t1 = new Thread(this, "Caixa 1");
		c.setPrioridadeCliente(new Random().nextInt(4));
		if (c.getPrioridadeCliente() == 1) {
			System.out.println("Cliente:" + c.getNomeCliente() + " Prioridade 1");
			this.t1.setPriority(Thread.MIN_PRIORITY);
		}
		if (c.getPrioridadeCliente() == 2) {
			System.out.println("Cliente:" + c.getNomeCliente() + " Prioridade 2");
			t1.setPriority(2);
		}
		if (c.getPrioridadeCliente() == 3) {
			System.out.println("Cliente:" + c.getNomeCliente() + " Prioridade 3");
			t1.setPriority(2);
		}
		if (c.getPrioridadeCliente() == 4) {
			System.out.println("Cliente:" + c.getNomeCliente() + " Prioridade 4");
			t1.setPriority(2);
		}
		if (c.getPrioridadeCliente() == 5) {
			System.out.println("Cliente:" + c.getNomeCliente() + " Prioridade 5");
			this.t1.setPriority(Thread.MAX_PRIORITY);
		}
		
		t1.start();
	}

	public synchronized void run() {
		if (control.isAberto()) {
			System.out.println("Loterica Aberta!! - Seja Bem Vindo!");
			for (int i = 0; i <= 100; i++) {
				br.com.nova.roma.tap.projeto.mvc.TelaPrincipal.progressBar.setValue(i);
				br.com.nova.roma.tap.projeto.mvc.TelaPrincipal.nomeCliente.setText(c.getNomeCliente());
				br.com.nova.roma.tap.projeto.mvc.TelaPrincipal.caixaUm.setText(Thread.currentThread().getName());
				
				try {
					if(control.obterCaixa() != null) {
						System.out.println(Thread.currentThread().getName()+" Está Atendendo "+c.getNomeCliente()+" Escolhas Do Cliente:"+c.escolha);
						Thread.sleep(3000);
						
					}
				}catch(InterruptedException e) {
					e.getMessage();
				}
				br.com.nova.roma.tap.projeto.mvc.TelaPrincipal.progressBar.setValue(0);
			}
		}

	}

}
