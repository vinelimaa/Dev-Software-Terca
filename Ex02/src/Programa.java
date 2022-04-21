import java.util.Scanner;

public class Programa{

	public static void main(String[] args){

		Scanner leitor = new Scanner(System.in);

		int qtd = 80;
		int cont = 0;

		String[] matriculas  = new String[qtd];
		String[] nomes 	     = new String[qtd];
		double[] notas1      = new double[qtd];
		double[] notas2      = new double[qtd];
		double[] notasFinais = new double[qtd];

		for (int i = 0; i < qtd; i++) {
			System.out.println("Dados do Aluno (" + (i + 1) + ")");
			
			System.out.println("Informe a matr�cula:");
			matriculas[i] = leitor.nextLine();

			System.out.println("Informe o nome:");
			nomes[i] = leitor.nextLine();

			System.out.println("Informe a nota 1:");
			notas1[i] = leitor.nextDouble();

			System.out.println("Informe a nota 2:");
			notas2[i] = leitor.nextDouble();

			notasFinais[i] = (notas1[i] + notas2[i])/2;

			cont++;

			System.out.println("Deseja continuar?");
			System.out.println("Digite 0 para Sim e 1 para N�o:");
			int interromper = leitor.nextInt();
			if (interromper == 1){
				break;
			}
			System.out.println("----------------------");

			leitor.nextLine();
		}
		System.out.println("#########  RELAT�RIO  ###########\n");

		for (int i = 0; i < cont; i++) {
			System.out.println("Matr�cula: " + matriculas[i]);
			System.out.println("Nome: " + nomes[i]);
			if (notasFinais[i] >= 6){
				System.out.println("Aprovado: (x) Sim ( ) N�o");
			}
			else{
				System.out.println("Aprovado: ( ) Sim (x) N�o");
			}
			System.out.println("Nota final: " + notasFinais[i]);
			System.out.println();
		}
		leitor.close();
	}
}
