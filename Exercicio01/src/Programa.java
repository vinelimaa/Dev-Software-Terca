import java.util.Scanner;

/**
 
Exercício de fixação 1

	Criar um programa para processar as seguintes informações de um aluno:
matrícula, nome , nota1, nota2 e se ele está aprovado ou reprovado;
	Durante a execução calcular a nota final do aluno utilizando a seguinte
regra: notaFinal = (nota1 + nota2) / 2. Se a nota final for igual ou superior a
6 o aluno está aprovado, caso contrário estará reprovado;

	O programa deverá imprimir o seguinte relatório:

Matrícula: xxxxx
Nome: xxxxx xxxxx
Aprovado: ( x ) Sim ( ) Não
Nota final: xxxxx

*/

public class Programa { //Início Programa

	public static void main(String[] args) { //Início main
		
//		String matricula, nome; 
//		double nota1 = 7.5, nota2 = 6.7, notaFinal = (nota1 + nota2) / 2;
//		matricula = "12345";
//		nome = "Vinícius Damas";
	
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite a matrícula: ");
		String matricula = leitor.nextLine();
		System.out.println("Digite nome: ");
		String nome = leitor.nextLine();
		System.out.println("Digite a nota 1: ");
		double nota1 = leitor.nextDouble();
		//leitor.nextLine();
		System.out.println("Digite a nota 2: ");
		double nota2 = leitor.nextDouble();
		
		double notaFinal = (nota1 + nota2) / 2;
		
		System.out.println("Matrícula: " + matricula); //Concatenação
		System.out.println("Nome: " + nome);
		
		//igual ou superior a 6
		if (notaFinal >=6) {
			System.out.println("Aprovado: (x) Sim ( ) Não");
			
		} else {
			System.out.println("Aprovado: ( ) Sim (x) Não");
		}
		System.out.println("Nota final: " + notaFinal);
		
		leitor.close();
		
	} //Fim main
	
	
} //Fim Programa
