import java.util.Scanner;

public class Programa {
	
	
	public static void main(String[] args){
		
		Scanner leitor = new Scanner(System.in);
		
		String [] matriculas = new String[5];
		String [] nomes = new String[5];
		
		double [] nota1 = new double[5];
		double [] nota2 = new double[5];
		
		double [] notaFinal = new double[5];
		
		int i;
		
		for(i=0; i<=4; i++) {
			System.out.println("Digite a matricula " + (i + 1) + ":");
			matriculas[i] = leitor.nextLine();
			System.out.println("Digite nome "+ (i + 1) + ":");
			nomes[i] = leitor.nextLine();
			System.out.println("Digite a nota 1: ");
			nota1[i] = leitor.nextDouble();
			System.out.println("Digite a nota 2: ");
			nota2[i] = leitor.nextDouble();
			System.out.println("_____________________\n");
			leitor.nextLine();
			notaFinal[i] = (nota1[i] + nota2[i])/2;
		}
		
		for(i=0; i<=4; i++) {
		System.out.println("Matricula: " + matriculas[i]);
		System.out.println("Nome: " + nomes[i]);
		//igual ou superior a 6
			if (notaFinal[i] >=6) {
				System.out.println("Aprovado: (x) Sim ( ) Nao");
				
			} else {
				System.out.println("Aprovado: ( ) Sim (x) Nao");
			}
		System.out.println("Nota final " + notaFinal[i]);
		System.out.println("__________________________\n");
		}
		
		leitor.close();
	}	
}

	