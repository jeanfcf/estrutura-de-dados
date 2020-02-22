package upe.ecomp.ed.questao5;

public class Hiperfatorial{
	public static void main(String[] args) {
		System.out.println(hiperfat(6));
		System.out.println(hiperfat(11));
		System.out.println(hiperfat(18));
		System.out.println(hiperfat(4));
		System.out.println(hiperfat(-1));
		System.out.println(hiperfat(0));
	}
	
	public static double hiperfat(int n) {
		if(n>1) {
			return hiperfat(n-1)*Math.pow(n, n);
		}else if(n==1) {
			return 1;
		}else {
			return 0;
		}
	}
}
