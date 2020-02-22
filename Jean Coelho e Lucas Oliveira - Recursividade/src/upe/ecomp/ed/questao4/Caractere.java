package upe.ecomp.ed.questao4;

public class Caractere {
	public static boolean verificaLetra(String a, String b) {

		try {
			if (b.contains(a.substring(0, 1))) {

				return verificaLetra(a.substring(1), b);
			} else {
				return false;
			}
		} catch (StringIndexOutOfBoundsException e) {
			return true;
		}
	}

	public static void main(String[] args) {
		// tendo como referencia a teoria dos conjuntos, o conjunto vazio esta contido
		// em qualquer conjunto, logo:
		System.out.println(verificaLetra("", "abacaxi"));
		
		// System.out.println(verificaLetra(null, "sopa"));
		
		System.out.println(verificaLetra("f uzoi", "fui fazer farofa feliz"));
		System.out.println(verificaLetra("sofro", ""));
		System.out.println(verificaLetra(" ", "piaba"));
	}
}
