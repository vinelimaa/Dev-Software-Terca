package br.edu.up;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
import br.edu.up.modelo.Grupo;

public class Programa {
	
	public static void main(String[] args) {
		
		//1. Carregar o arquivo;
		Scanner leitor = getLeitor();
		if(leitor == null) {
			System.out.println("Não foi possível executar o programa!");
		} else {
			//2. Carregar os dados;
			Grupo[] grupos = carregarDados(leitor);
			
			//3. Gravar relatório;
			gravarRelatorio(grupos);
		}
		System.out.println("Deu tudo certo \\o/ \\o/ \\o/ !");
	}
	
	public static void gravarRelatorio(Grupo[] grupos) {
		try {
			
	
			Formatter gravador = new Formatter(
					"C:\\Users\\Vinicius\\Documents\\Dev_Software_Terca\\Exercicio06\\src\\relatorio-de-grupos.txt");
			
			int vlrTotal = 0;
			for (int i = 0; i < grupos.length; i++) {
				Grupo grp = grupos[i];
				gravador.format("Valor do grupo " + grp.letra
						+ ":" + grp.getValor() + "\n");
			}
			gravador.format("Valor total: " + vlrTotal);
			
			gravador.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Grupo[] carregarDados(Scanner leitor) {
		
		Grupo grupoA = new Grupo("A");
		Grupo grupoB = new Grupo("B");
		Grupo grupoC = new Grupo("C");
		Grupo grupoD = new Grupo("D");
		Grupo grupoE = new Grupo("E");
		Grupo grupoF = new Grupo("F");
		
		while(leitor.hasNext()) {
			String linha = leitor.nextLine();
			String[] dadosLinha = linha.split("\t");
			switch(dadosLinha[0]) {
			case "A":
				grupoA.adicionarValor(dadosLinha[1]);
				break;
			case "B":
				grupoB.adicionarValor(dadosLinha[1]);
				break;
			case "C":
				grupoC.adicionarValor(dadosLinha[1]);
				break;
			case "D":
				grupoD.adicionarValor(dadosLinha[1]);
				break;
			case "E":
				grupoE.adicionarValor(dadosLinha[1]);
				break;
			case "F":
				grupoF.adicionarValor(dadosLinha[1]);
				break;	
			}
		}
		Grupo[] grupos = new Grupo[6];
		grupos[0] = grupoA;
		grupos[1] = grupoB;
		grupos[2] = grupoC;
		grupos[3] = grupoD;
		grupos[4] = grupoE;
		grupos[5] = grupoF;
		
		return grupos;
	}
	
	public static Scanner getLeitor() {
		File arquivo = new File("C:\\Users\\Vinicius\\Documents\\Dev_Software_Terca\\Exercicio05\\src\\grupos-tabulados.txt");
		
		Scanner leitor = null;
		try {
			leitor = new Scanner(arquivo);
			
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.out.println("O arquivo não foi encontrado!");
		}
		return leitor;
	}
}
