package br.com.nova.roma.tap.projeto.entity;

public class Caixa {
	private int caixaNumecao;
	private String[] siglaDeAceitacaoAposta;
	private String nomeDoCaixa;
	private boolean ocupado;

	public Caixa(int caixaNumecao, String[] siglaDeAceitacaoAposta, boolean ocupado, String nomeDoCaixa) {
		this.caixaNumecao = caixaNumecao;
		this.ocupado = false;
		this.nomeDoCaixa = nomeDoCaixa;
		this.siglaDeAceitacaoAposta = siglaDeAceitacaoAposta;
	}

	public Caixa() {

	}

	public int getCaixaNumecao() {
		return caixaNumecao;
	}

	public void setCaixaNumecao(int caixaNumecao) {
		this.caixaNumecao = caixaNumecao;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public String getNomeDoCaixa() {
		return nomeDoCaixa;
	}

	public void setNomeDoCaixa(String nomeDoCaixa) {
		this.nomeDoCaixa = nomeDoCaixa;
	}

	public String[] getSiglaDeAceitacaoAposta() {
		return siglaDeAceitacaoAposta;
	}

	public void setSiglaDeAceitacaoAposta(String[] siglaDeAceitacaoAposta) {
		this.siglaDeAceitacaoAposta = siglaDeAceitacaoAposta;
	}

}
