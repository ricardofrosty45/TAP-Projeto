package br.com.nova.roma.tap.projeto.entity;

import java.util.ArrayList;

public class Loterica {
	private ArrayList<Caixa> listaDeCaixas = new ArrayList<Caixa>();;
	private boolean loteriaFechada;

	public Loterica() {

	}

	public Loterica(ArrayList<Caixa> listaDeCaixas,boolean lotericaFechada) {
           this.listaDeCaixas = listaDeCaixas;
           this.loteriaFechada = false;
	}

	public ArrayList<Caixa> getListaDeCaixas() {
		return listaDeCaixas;
	}

	public void setListaDeCaixas(ArrayList<Caixa> listaDeCaixas) {
		this.listaDeCaixas = listaDeCaixas;
	}

	public boolean isLoteriaFechada() {
		return loteriaFechada;
	}

	public void setLoteriaFechada(boolean loteriaFechada) {
		this.loteriaFechada = loteriaFechada;
	}

}
