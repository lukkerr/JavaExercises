package sorteio;

public class Teste2 {
	public static void main(String[] args) {
		Sorteio sorteio;
		String resultado;

		try {
			sorteio = new Sorteio(0, 1, 2);
			System.out.println("Falha1");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());	
		}	


		try {
			sorteio = new Sorteio(5, 2, 1);
			System.out.println("Falha2");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}	


		try {
			sorteio = new Sorteio(10, 1, 100);
			sorteio.gerarNumeros();
			sorteio.proximoNumero();
			System.out.println("Falha3");

		}
		catch(Exception e) {
			System.out.println(e.getMessage());	
		}	


		try {
			sorteio = new Sorteio(10, 1, 100);
			sorteio.gerarNumeros();
			resultado = sorteio.resultado(null);
			System.out.println("Falha4");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());	
		}	

		System.out.println("Fim do programa");

	}

}