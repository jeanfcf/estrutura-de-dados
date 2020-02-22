package upe.ecomp.ed.questao8;

public class Binario {
	public static String somaBinario(String a) {
		String c;
		c = "";
		char[] b = a.toCharArray();
		boolean flag = false;

		for (int i = b.length - 1; i >= 0; i--) {
			if (!flag) {
				if (b[i] == '0') {
					b[i] = '1';
					for (int j = 0; j < b.length; j++) {
						c += Character.toString(b[j]);
					}
					return c;
				} else {
					b[i] = '0';
					flag = true;
				}
			} else {
				if (b[i] == '1') {
					b[i] = '0';
				} else {
					b[i] = '1';
					for (int j = 0; j < b.length; j++) {
						c += Character.toString(b[j]);
					}
					return c;
				}
			}
		}
		return "";
	}

	public static int retornaNumero(String a) {

		char[] b = a.toCharArray();
		int numero = 0;
		int count = b.length - 1;
		for (int i = 0; i < b.length; i++) {
			if (b[i] == '1') {
				numero += (int) Math.pow(2, count);
			}
			count--;
		}
		return numero;
	}

	public static int retornaDecimal(String a) {
		if (a.length() == 16) {// String a;

			// a = Integer.toString(n);

			if (a.startsWith("0")) {

				a = a.replaceAll("0", "a");
				a = a.replaceAll("1", "0");
				a = a.replaceAll("a", "1");
				a = somaBinario(a);
				return retornaNumero(a);

			} else {

				a = a.replaceAll("0", "a");
				a = a.replaceAll("1", "0");
				a = a.replaceAll("a", "1");
				a = somaBinario(a);
				return -retornaNumero(a);

			}
		} else {
			System.out.print("erro numero: ");
			return -99999999;
		}

	}

	public static void main(String[] args) {
		System.out.println(retornaDecimal("0000000000000001"));
		System.out.println(retornaDecimal("1000000000110011"));
		System.out.println(retornaDecimal("1111111111111111"));
		System.out.println(retornaDecimal("-1"));
		System.out.println(retornaDecimal("22222222222222"));
	}

}
