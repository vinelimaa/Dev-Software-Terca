package br.edu.up.modelo;

public class Grupo {
	
	public String letra;
	public int[] valores = new int[12];	
	
	private int contador = 0;
	
	public Grupo(String str) {
		this.letra = str;
	}

	public int getValor() {
		int valor = 0;
		for (int i = 0; i < valores.length; i++) {
			valor += valores[i];
		}
		return valor;
	}
	
	public void adicionarValor(String vlr) {
		int vlrInteiro = Integer.parseInt(vlr);
		this.valores[this.contador] = vlrInteiro;
		this.contador++;
	}
}
