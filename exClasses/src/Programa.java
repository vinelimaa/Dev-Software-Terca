import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Programa {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File arquivo = new File("C:\\Users\\Vinicius\\Documents\\Dev_Software_Terca\\exClasses\\src\\alunos.csv");
		Scanner leitor = new Scanner(arquivo);
		leitor.nextLine();
				
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
			
			System.out.println(linha);
		}

		
		for (int i = 0; i < alunos.length; i++) {
			Aluno a = alunos[i];
			System.out.println("Matrícula: " + a.matricula);
			System.out.println("Nome: " + a.nome);
			System.out.println("Nota 1: " + a.nota1);
			System.out.println("Nota 2: " + a.nota2);
			System.out.println("Nota 3: " + a.nota3);
			System.out.println();
		}
		
		leitor.close();
	}
}
