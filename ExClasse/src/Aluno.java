
public class Aluno {
	
	//Atributos
	public String matricula;
	public String nome;
	public double nota1;
	public double nota2;
	public double nota3;
	
	//M�todos	
	public double getNotaFinal() {
		return (nota1 + nota2 + nota3) / 3;
	}

}
