package upe.ecomp.ed.questao3;

public class Sequencia {
	public static void main(String[] args) {
		System.out.println(seq(100));
		System.out.println(seq(-5));
		System.out.println(seq(0));
		System.out.println(seq(1));
		System.out.println(seq(10));
	}

	public static int seq(int n) {
		if (n > 0 && n < 1000) {
			System.out.print(n + ", ");
		}
		if (n > 0 && n * 2 < 1000) {
			System.out.print(seq(n * 2) + ", ");
		}	
		return n;
	}
}
