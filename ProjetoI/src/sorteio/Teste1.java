package sorteio;

import java.util.Scanner;

public class Teste1 {
	public static void main(String[] args) {
		try {
			Sorteio sorteio;
			String resultado;

			System.out.println("-----sorteio 1-----------");
			sorteio = new Sorteio(6, 1, 60);
			sorteio.gerarNumeros();
			resultado = sorteio.resultado("-");
			System.out.println("Resultado do sorteio="+resultado);

			System.out.println("-----sorteio 2-----------");
			sorteio = new Sorteio(1, 10, 10);
			sorteio.gerarNumeros();
			resultado = sorteio.resultado("/");
			System.out.println("Resultado do sorteio="+resultado);
			
			Scanner teclado = new Scanner(System.in);
			System.out.println("Qual o numero minimo?");
			int minimo = teclado.nextInt();
			System.out.println("Qual o numero maximo?");
			int maximo = teclado.nextInt();

			System.out.println("-----sorteio 3-----------");
			sorteio = new Sorteio(5, minimo, maximo);
			while( !sorteio.terminou()) {
				sorteio.proximoNumero();
				resultado = sorteio.resultado(".");
				System.out.println("Resultado do sorteio="+resultado);
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Fim do programa");
	}

}