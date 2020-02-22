package upe.ecomp.ed.questao8;

public class div {

	public static int div(int m, int n) {
		if (n > 0) {
			if ((m - n) < 0) {
				return 0;
			} else {
				return div((m - n), n) + 1;
			}
		} else {
			return -1;
		}
	}

	public static void main(String[] args) {
		//considerando numeros naturais
		//-1 significa erro
		System.out.println(div(10, 3));
		System.out.println(div(15, 3));
		System.out.println(div(25, 3));
		System.out.println(div(0, 3));
		System.out.println(div(10, 0));
		System.out.println(div(3, 3));
		System.out.println(div(10, 1));
		System.out.println(div(10, -2));
		System.out.println(div(1,1));
		System.out.println(div(100,3));

	}

}