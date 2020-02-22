package upe.ecomp.ed.questao3;

public class Main {

	public static boolean palindromo(String s) {
		if (s != null) {
			FilaCircular<Character> fila = new FilaCircular<Character>();
			FilaCircular<Character> fila2 = new FilaCircular<Character>();
			for (int i = 0; i < s.length(); i++) {
				fila.enqueue(s.charAt(i));
			}

			for (int i = s.length() - 1; i >= 0; i--) {
				fila2.enqueue(s.charAt(i));
			}

			while (fila.getInicio() == fila2.getInicio()) {
				if (fila.size() == 0 || fila2.size() == 0) {
					return true;
				}
				fila.dequeue();
				fila2.dequeue();
			}

			return false;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		FilaCircular<String> nova = new FilaCircular<String>();
		nova.enqueue("lucas");
		nova.enqueue("é");
		nova.enqueue("lindo");
		nova.enqueue("demais");
		nova.imprimir();
		nova.dequeue();
		nova.imprimir();
		System.out.println();

		// verificando se a palavra passada é um palíndromo
		System.out.println("'Sofrimento' é um palindromo? " + palindromo("Sofrimento"));
		System.out.println("'arara' é um palindromo? " + palindromo("arara"));
		System.out.println("'kaiak' é um palindromo? " + palindromo("kaiak"));
		System.out.println(palindromo(null));

	}
}
