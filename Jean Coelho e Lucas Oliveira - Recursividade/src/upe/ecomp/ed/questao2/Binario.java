package upe.ecomp.ed.questao2;

public class Binario {
	public static void main(String[] args) {
		System.out.println(transformaBin(2));
		System.out.println(transformaBin(12));
		System.out.println(transformaBin(0));
		System.out.println(transformaBin(-1));
		System.out.println(transformaBin(25));
		System.out.println(transformaBin(10000));
	}
	
	public static int transformaBin(int n) {
		if(n>1) {
			System.out.print(transformaBin(n/2));
		}
		return n%2;
	}
}

