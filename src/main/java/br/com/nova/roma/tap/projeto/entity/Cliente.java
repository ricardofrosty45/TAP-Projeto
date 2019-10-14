package br.com.nova.roma.tap.projeto.entity;


public class Cliente {
	private String nomeCliente;
	private int idadeDoCliente;
	private int prioridadeCliente;
	public String[] escolha;
	


	public Cliente(String nomeCliente, int idadeDoCliente, int prioridadeCliente) {
            this.nomeCliente = nomeCliente;
            this.idadeDoCliente=idadeDoCliente;
            this.prioridadeCliente = prioridadeCliente;

 
	}
	
	public Cliente() {
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getIdadeDoCliente() {
		return idadeDoCliente;
	}

	public void setIdadeDoCliente(int idadeDoCliente) {
		this.idadeDoCliente = idadeDoCliente;
	}

	public int getPrioridadeCliente() {
		return prioridadeCliente;
	}

	public void setPrioridadeCliente(int prioridadeCliente) {
		this.prioridadeCliente = prioridadeCliente;
	}

}
