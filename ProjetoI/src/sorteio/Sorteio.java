package sorteio;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Arrays;

public class Sorteio {
	private int n;
	private int min;
	private int max;
	private int[] numeros;
	
	public static void main(String[] args) throws Exception {
		try (Scanner input = new Scanner(System.in)) {
			System.out.print("Digite o total números: ");
			int n = input.nextInt();
			
			System.out.print("Digite o valor mínimo: ");
			int min = input.nextInt();
				
			System.out.print("Digite o valor maxíma: ");
			int max = input.nextInt();
			
			System.out.println("");
			new Sorteio(n, min, max);
		}
		catch(Exception e) {
			throw new Exception("Valor Digitado não é um Número");
		}
	}
	
	public Sorteio(int n, int min, int max) throws Exception {
		
//		if(n <= 0 || n >= 100)
//			throw new Exception("Valor de N < 0 ou > 99");
		
		
		setN(n);
		setMin(min);
		setMax(max);
		setNumeros(new int[n]);
		
		gerarNumeros();
	}
	
	public void gerarNumeros() {
		while( !terminou() ) {
			proximoNumero();
			System.out.println( resultado(",") );
		}
	}
	
	public void proximoNumero() {
		Random sorteio = new Random();
		int maxValue = getMax() - getMin() + 1;
		int sorteado = (int) sorteio.nextInt(maxValue) + getMin();
		
		boolean contains = IntStream.of(getNumeros()).anyMatch(x -> x == sorteado);
		
		if(contains)
			proximoNumero();
		else
			getNumeros()[lastIndex()] = sorteado;
	}
	
	public boolean terminou() {
		boolean result = false;
		if(lastIndex() == getN()) {
			result = true;
		}
		return result;
	}
	
	public String resultado(String padrao) {
		String[] strArray = new String[lastIndex()];
		int[] intArray = getNumerosValidos();
		
		Arrays.sort(intArray);
		
		for(int i = 0; i < lastIndex(); i++)
			strArray[i] =  String.valueOf(intArray[i]);
		
		return "[" + String.join(padrao, strArray) + "]";
	}
	
	public int lastIndex(){
		int last = getNumeros().length;
		for(int x = 0; x < last; x++) {
			if(getNumeros()[x] == 0) {
				last = x;
				break;
			}
		}
		return last;
	}
	
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int[] getNumeros() {
		return numeros;
	}

	public void setNumeros(int[] numeros) {
		this.numeros = numeros;
	}
	
	public int[] getNumerosValidos() {
		int[] newArray = new int[lastIndex()];
		
		for(int i = 0; i < lastIndex(); i++) {
			newArray[i] = getNumeros()[i];
		}
		return newArray;
	}
}