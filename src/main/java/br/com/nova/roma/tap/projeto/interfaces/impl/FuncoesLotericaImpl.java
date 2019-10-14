package br.com.nova.roma.tap.projeto.interfaces.impl;

import java.util.LinkedList;
import java.util.Queue;

import br.com.nova.roma.tap.projeto.entity.Caixa;
import br.com.nova.roma.tap.projeto.interfaces.FuncoesLotericaControlador;

public class FuncoesLotericaImpl implements FuncoesLotericaControlador {

	// MS - MEGASENA
	// LF - LOTOFACIL
	// QN - QUINA
	// LM - LOTOMANIA
	// DS - DUPLASENA
	// TM - TIMEMANIA
	public String[] siglaDeAceitacaoApostaCaixa1 = { "ms", "lf", "qn", "lm", "ds", "tm" };
	private boolean aberto = true;
	private Queue<Caixa> filaDeCaixa = new LinkedList<Caixa>();
	private Caixa c1 = new Caixa(1, siglaDeAceitacaoApostaCaixa1, false, "Luan");

	public int quantidadeCaixa() {
         synchronized (this.filaDeCaixa) {
			return this.filaDeCaixa.size();
		}
	}

	public Caixa obterCaixa() {
		this.filaDeCaixa.add(c1);
	      Caixa c = null;
	      try {
	    	  synchronized (filaDeCaixa) {
				while(this.filaDeCaixa.isEmpty()) {
					if(!aberto) {
						System.out.println("Nenhum Caixa Disponivel!");
						return null;
					}
					System.out.println(Thread.currentThread().getName()+" Esta Em Estado Wait!");
					this.filaDeCaixa.wait(3000);
				}
				c = this.filaDeCaixa.poll();
			}
	      }catch(InterruptedException e) {
	    	  e.getMessage();
	      }
	      
	      return c;
	}

	public void liberarCaixa(Caixa c) {
		synchronized (filaDeCaixa) {
			filaDeCaixa.add(c);
			System.out.println("Caixa :"+c.getNomeDoCaixa()+" Esta Liberada!");
			filaDeCaixa.notify();
		}
		

	}

	public void fecharLoterica() {
		aberto = false;
		synchronized (filaDeCaixa) {
			System.out.println("Fechando Os Caixas E Fechando Loterica");
			filaDeCaixa.clear();
		}
		System.exit(0);

	}

	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}

}
