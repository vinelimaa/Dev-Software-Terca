import java.util.Scanner;

public class Programa {
	
	
	public static void main(String[] args) {
		
//		double[] pesos = new double[5];
//		pesos[0] = 0.05;
		
		double[] pesos = {0.05 , 0.05 , 0.2 , 0.2, 0.5};
				
		
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Informe a matrícula:");
		String matricula = leitor.nextLine();
		
		System.out.println("Informe o nome:");
		String nome = leitor.nextLine();
		
		double[] notas = new double[5];
		double notaFinal = 0;
		
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
				notaFinal = notaFinal + (notas[contador] * pesos[contador]);
				contador++;
			} else {
				//Inválido
				System.out.println("A nota " + temp + " é inválida!");
			}
		} while(contador < 5);
		
//		double notaFinal = 
//				(notas[0] * pesos[0]) +
//				(notas[1] * pesos[1]) +
//				(notas[2] * pesos[2]) +
//				(notas[3] * pesos[3]) +
//				(notas[4] * pesos[4]);
		
		System.out.println();
		System.out.println("----------- RELATÓRIO------------");
		System.out.println("Matrícula: " + matricula);
		System.out.println("Nome: " + nome);
		
		for(int i = 0; i < notas.length; i++) {
			System.out.println("Nota " + (i + 1) + ":" + notas[i]);
		}
		
		System.out.println("Nota final: " + notaFinal);
		System.out.println();
		if (notaFinal >= 6) {
			System.out.println("Aprovado!");
		} else {
			System.out.println("Reprovado!");
		}
		 
		leitor.close();
		
	}

}
