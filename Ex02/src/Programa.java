import java.util.Scanner;


public class Programa {

	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);
		
		int qtde = 80;
		
		String[] matriculas = new String[qtde];
		String[] nomes = new String[qtde];
		double[] notas1 = new double[qtde];
		double[] notas2 = new double[qtde];
		double[] notasFinais = new double[qtde];
		
		for (int i = 0; i < qtde; i++) {
			
			System.out.println("DADOS DO ALUNO (" + (i + 1)+ ") ");
			
			System.out.println("Informe a matr�cula:");
			matriculas[i] = leitor.nextLine();
			
			System.out.println("Informe o nome:");
			nomes[i] = leitor.nextLine();
			
			System.out.println("Informe a nota 1:");
			notas1[i] = leitor.nextDouble();
				
			System.out.println("Informe a nota 2:");
			notas2[i] = leitor.nextDouble();
			
			notasFinais[i] = (notas1[i] + notas2[i]) /2;
			
			System.out.println("Deseja continuar?");
			System.out.println("Digite 0 para sim ou 1 para n�o:");
			int interromper = leitor.nextInt();
			if (interromper == 1) {
				break;
			}			
			
			System.out.println("------------------------");
			
			//Avan�o para pr�xima;
			leitor.nextLine();
		}
		
		
		System.out.println("*********** RELAT�RIO *************");
		
		for (int i = 0; i < qtde; i++) {
			System.out.println("Matr�cula: " + matriculas[i]);
			System.out.println("Nome: " + nomes[i]);
			if(notasFinais[i] >= 6) {
				System.out.println("Aprovado: (x)sim ( )n�o");
			} else {
				System.out.println("Aprovado: ( )sim (x)n�o");
			}
			System.out.println("Nota final: " + notasFinais[i]);
			System.out.println();
		}
		
		
		leitor.close();

	}

}
