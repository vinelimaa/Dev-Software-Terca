package br.edu.up;

import java.util.ArrayList;
import java.util.List;

import br.edu.up.model.Animal;
import br.edu.up.model.Cachorro;
import br.edu.up.model.Gato;
import br.edu.up.model.Homem;
import br.edu.up.model.Humano;
import br.edu.up.model.Mulher;

public class Programa {

	public static void main(String[] args) {

		
		try {
			
			//List listaDeObjetos = new ArrayList();
			List<Animal> listaDeAnimais = new ArrayList();
			List<Cachorro> listaDeCachorros = new ArrayList();

			Cachorro cachorro1 = new Cachorro();
			cachorro1.raca = "Rottweiler";
			cachorro1.nome = "Eros";
			cachorro1.setIdade(3);
			cachorro1.porte = "Médio";
			
			listaDeCachorros.add(cachorro1);
	
			Cachorro cachorro2 = new Cachorro();
			cachorro2.raca = "Vira-lata";
			cachorro2.nome = "Suzi";
			cachorro2.setIdade(3);
			cachorro2.porte = "Pequeno";
			
			listaDeCachorros.add(cachorro2);
				
			Cachorro cachorro3 = new Cachorro();
			cachorro3.raca = "Vira-lata";
			cachorro3.nome = "Goa";
			cachorro3.setIdade(2);
			cachorro3.porte = "Médio";
	
			listaDeCachorros.add(cachorro3);			
			listaDeAnimais.add(cachorro3);
			
			Gato umGato = new Gato();
			umGato.setIdade(4);
			umGato.nome = "Fred";
			
			listaDeAnimais.add(umGato);
			
			Homem umHomemQualquer = new Homem();
			umHomemQualquer.setIdade(54);
			umHomemQualquer.nome = "Gabriel";

			listaDeAnimais.add(umHomemQualquer);
			
			Humano humano = new Humano();
			humano.setIdade(96);
			humano.nome = "Elizabeth";
			
			listaDeAnimais.add(humano);
			
			Mulher mulher = new Mulher();
			mulher.setIdade(43);
			mulher.nome = "Cleonice";
			
			
			for (Animal animal : listaDeAnimais) {
				System.out.println("Nome: " + animal.nome);
				System.out.println("Idade: " + animal.getIdade());
				System.out.println();
			}
			
		
		} catch (Exception e) {
			System.out.println(e.toString());
		}


	}

}
