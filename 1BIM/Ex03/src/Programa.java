import java.util.Scanner;

public class Programa {
	
	/*
		Exercício de fixação 3

		Criar um programa para processar as seguintes informações de um 
		aluno: matrícula, nome, nota 1, nota 2, nota 3, nota 4 e 
		nota 5

		O sistema deverá ler as notas do aluno em um vetor e a entrada 
		de dados pelo usuário só poderá ser nos valores de 0 a 10

		No final da execução imprimir o seguinte relatório:
		Matrícula: xxxxx
		Nome: xxxxx xxxxx
		Nota (x): xxxxx
		Nota (y): yyyyy
		(...)

	 */	
	
	public static void main(String[] args) {
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Informe a matrícula:");
		String matricula = leitor.nextLine();
		
		System.out.println("Informe o nome:");
		String nome = leitor.nextLine();
		
		double[] notas = new double[5];
		
		int contador = 0;
		do {
			System.out.println("Informar uma nota entre 0 e 10.");
			System.out.println("Digite a " + (contador + 1) + "a nota:");
			double temp = leitor.nextDouble();
			
//			if (temp < 0 || temp > 10) {
//				//Inválido
//				System.out.println("A nota " + temp + " é inválida!");
//			} else {
//				//Válido
//				notas[contador] = temp;
//				contador++;
//			}
			
			if (temp >= 0 && temp <= 10) {
				//Válido
				notas[contador] = temp;
				contador++;
			} else {
				//Inválido
				System.out.println("A nota " + temp + " é inválida!");
			}
		} while(contador < 5);
		
		System.out.println();
		System.out.println("----------- RELATÓRIO------------");
		System.out.println("Matrícula: " + matricula);
		System.out.println("Nome: " + nome);
		
		for(int i = 0; i < notas.length; i++) {
			System.out.println("Nota " + (i + 1) + ":" + notas[i]);
		}
		 
		leitor.close();
		
	}

}
