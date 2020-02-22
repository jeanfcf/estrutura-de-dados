package upe.ecomp.ed.questao1b;

public class Fibonacci {
	
	public static void main(String[] args) {
		System.out.println(multiplicaFib(10));
		System.out.println(multiplicaFib(12));
		System.out.println(multiplicaFib(6));
		System.out.println(multiplicaFib(3));
		System.out.println(multiplicaFib(1));
		System.out.println(multiplicaFib(-11));
	}
	
	//retorna ao numero de fibonacci da posicao n
	public static int fibo(int n) {
		if (n <= 2) {
			return 1;
		} else {
			return fibo(n - 1) + fibo(n - 2);
		}
	}
	
	//multiplica os pares da sequencia de fibonacci
	public static int multiplicaFib(int n) {
		if (n == 3) {
			return 2;
		} else if (n<=2) {
			return 0;
		} else {
			if (fibo(n) % 2 == 0) {
				return fibo(n) * multiplicaFib(n - 1);
			} else {
				return multiplicaFib(n - 1);
			}
		}
	}
}
