package br.com.nova.roma.tap.projeto.controlador;


import br.com.nova.roma.tap.projeto.entity.Cliente;
import br.com.nova.roma.tap.projeto.thread.caixa.ThreadCaixa;

public class ControladorCaixa {

	ThreadCaixa threadCaixa;

	public ControladorCaixa(Cliente c1, Cliente c2,Cliente c3,Cliente c4,ControladorDaLoterica controlLoterica) throws InterruptedException {
		String[] siglaDeAceitacaoApostaCaixa1 = { "ms", "lf", "qn", "lm", "ds", "tm" };
		
		String[] siglaDeAceitacaoApostaCaixa2 = { "ms" };
		
		String[] siglaDeAceitacaoApostaCaixa3 = { "qn", "lm", "ds" };
		
		String[] siglaDeAceitacaoApostaCaixa4 = { "ms", "tm" };
		
		c1.escolha = siglaDeAceitacaoApostaCaixa1;
		c2.escolha = siglaDeAceitacaoApostaCaixa2;
		c3.escolha = siglaDeAceitacaoApostaCaixa3;
		c4.escolha = siglaDeAceitacaoApostaCaixa4;
		
		
		
		if (c1.escolha.equals(siglaDeAceitacaoApostaCaixa1)) {
			threadCaixa = new ThreadCaixa(c1, controlLoterica);
		
		}
		
		if (c2.escolha.equals(siglaDeAceitacaoApostaCaixa2)) {
			threadCaixa = new ThreadCaixa(c2, controlLoterica);
		}
		
		if (c3.escolha.equals(siglaDeAceitacaoApostaCaixa3)) {
			threadCaixa = new ThreadCaixa(c3, controlLoterica);
		}
		
		if (c4.escolha.equals(siglaDeAceitacaoApostaCaixa4)) {
			threadCaixa = new ThreadCaixa(c4, controlLoterica);
		}
		
	};

}
