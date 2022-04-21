public class Programa{

	public static void main(String[] args){

		String matricula = "12345";
		String nome = "Vinicius Damas";
		double nota1 = 7.5;
		double nota2 = 8.0;
		double notaFinal = (nota1 + nota2)/2;

		System.out.println("Matrícula: " + matricula);
		System.out.println("Nome: " + nome);
		if(notaFinal > 6){
			System.out.println("Aprovado: (x) Sim ( ) Não");
		}
		else{
			System.out.println("Aprovado: ( ) Sim (x) Não");
		}
		System.out.println("Nota final: " + notaFinal);
	}
}