package upe.ecomp.ed.questao1a;

public class Primo {

	public static void main(String[] args) {
		System.out.println(somaPrimo(2, 11));
		System.out.println(somaPrimo(18, 18));
		System.out.println(somaPrimo(17, 17));
		System.out.println(somaPrimo(3, 3));
		System.out.println(somaPrimo(2, 2));
		System.out.println(somaPrimo(4, 18));
		System.out.println(somaPrimo(0, 11));
		System.out.println(somaPrimo(127, 1));
	}

	public static int somaPrimo(int n, int n2) {
		int soma = 0;
		int maior = 0;
		int menor = 0;
		if (n > n2) {
			maior = n;
			menor = n2;
		} else if (n2 > n) {
			maior = n2;
			menor = n;
		} else {
			if (verificaPrimo(n, n)) {
				return n;
			} else {
				return 0;
			}
		}

		if (verificaPrimo(maior, maior)) {
			soma += maior + somaPrimo(maior - 1, menor);
		} else {
			soma = somaPrimo(maior - 1, menor);
		}

		return soma;
	}

	public static boolean verificaPrimo(int num, int i) {
		if (num <= 1) {
			return false;
		}
		if (i == 2) {
			return true;
		}
		if (num % (i - 1) == 0) {
			return false;
		} else {
			return verificaPrimo(num, i - 1);
		}
	}
}
