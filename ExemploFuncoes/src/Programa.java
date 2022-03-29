
public class Programa {

	public static void main(String[] args) {
		
		int valor1 = 100;
		int valor2 = 50;
		//int resultado = valor1 + valor2;
		int resultado = somar(valor1, valor2);
		
		//System.out.println(valor);
		
		String texto = String.valueOf(resultado);
		imprimir(texto);
	}

	public static void imprimir(String txt) {
		System.out.println(txt);
	}
	
	public static int somar(int a, int b) {
		int vlr = a + b;
		return vlr;
	}
	//criar funções subtrair, multiplicar e dividir
}
