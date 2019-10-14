package br.com.nova.roma.tap.projeto.interfaces;

import br.com.nova.roma.tap.projeto.entity.Caixa;
import br.com.nova.roma.tap.projeto.entity.Cliente;

public interface FuncoesLotericaControlador {
     
	int quantidadeCaixa();
	
	Caixa obterCaixa();
	
	void liberarCaixa(Caixa c);
	
	void fecharLoterica();
	
}
