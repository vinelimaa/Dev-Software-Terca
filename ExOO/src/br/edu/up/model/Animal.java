package br.edu.up.model;

public class Animal {

	private int idade;
	public String nome;
	
	public int getIdade() {
		return idade;
	}
	
	
	public void setIdade(int idade) throws Exception {
		if (idade < 0 || idade > 150) {
			throw new Exception("Idade inválida! " + idade);
		}
		
		this.idade = idade;
	}
	
}
