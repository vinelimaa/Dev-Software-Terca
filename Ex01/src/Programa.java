
public class Programa {

	public static void main(String[] args) {

		String matricula = "12345";
		String nome = "Pedro";
		double nota1 = 5.6;
		double nota2 = 5.8;
		
		double notaFinal = (nota1 + nota2) / 2 ;
		
		System.out.println("Matr�cula: " + matricula);
		System.out.println("Nome: " + nome);
		if(notaFinal >= 6) {
			System.out.println("Aprovado: (x)sim ( )n�o");
		} else {
			System.out.println("Aprovado: ( )sim (x)n�o");
		}
		System.out.println("Nota final: " + notaFinal);
		
	}

}
