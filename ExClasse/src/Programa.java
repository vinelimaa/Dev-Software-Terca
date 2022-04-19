import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Programa {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
//		String[] alunos = new String[2];
//		alunos[0] = "Pedro;1234;7.8;6.7;8.8";
//		alunos[1] = "Ana;4321;6.8;9.7;5.8";
//		
//		double totalDasNotas = 0;
//		
//		for (int i = 0; i < alunos.length; i++) {
//			String linha = alunos[i];
//			String[] dados = linha.split(";");
//			for (int j = 0; j < dados.length; j++) {
//				String dado = dados[j];
//				if (j > 1) {
//					totalDasNotas = totalDasNotas + Double.parseDouble(dado);
//				}
//				
//				System.out.println(dado);
//			}
//			System.out.println(totalDasNotas / 3);
//			totalDasNotas = 0;
//		}
		
		
//		Aluno aluno1 = new Aluno();
//		aluno1.matricula = "12345";
//		aluno1.nome = "João";
//		aluno1.nota1 = 7.8;
//		aluno1.nota2 = 8.3;
//		aluno1.nota3 = 5.6;
//		
//		Aluno aluno2 = new Aluno();
//		aluno2.matricula = "343434";
//		aluno2.nome = "Pedro";
//		aluno2.nota1 = 6.8;
//		aluno2.nota2 = 9.3;
//		aluno2.nota3 = 3.6;
//		
//		Aluno[] alunos = new Aluno[2];
//		alunos[0] = aluno1;
//		alunos[1] = aluno2;
		
		
		File arquivo = new File("C:\\_src\\ws\\ExClasse\\src\\alunos.csv");
		Scanner leitor = new Scanner(arquivo);
		leitor.nextLine(); //saltar o título
				
		Aluno[] alunos = new Aluno[5];
		int contador = 0;
		
		while(leitor.hasNext()) {
			String linha = leitor.nextLine();
			String[] dados = linha.split(";");
			String matricula = dados[0];
			String nome = dados[1];
			String nota1 = dados[2];
			String nota2 = dados[3];
			String nota3 = dados[4];
			
			Aluno aluno = new Aluno();
			aluno.matricula = matricula;
			aluno.nome = nome;
			aluno.nota1 = Double.parseDouble(nota1);
			aluno.nota2 = Double.parseDouble(nota2);
			aluno.nota3 = Double.parseDouble(nota3);
			
			alunos[contador] = aluno;
			contador++;
		}
						
		for (int i = 0; i < alunos.length; i++) {
			Aluno a = alunos[i];
			System.out.println("Matrícula: " + a.matricula);
			System.out.println("Nome: " + a.nome);
			System.out.println("Nota 1: " + a.nota1);
			System.out.println("Nota 2: " + a.nota2);
			System.out.println("Nota 3: " + a.nota3);
			System.out.println("Nota final: " + a.getNotaFinal());
			System.out.println();
		}

		leitor.close();
		
		
		
	}

}
