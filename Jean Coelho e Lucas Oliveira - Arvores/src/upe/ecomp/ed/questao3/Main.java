package upe.ecomp.ed.questao3;

public class Main {
	public static void main(String[] args) {

		ArvoreExp nov = new ArvoreExp("( ( ( 1 - a ) - ( 2 + 3 ) ) + ( -1 * c ) )");
		
		System.out.println(nov.calcula());
		
		System.out.println(nov.calcula());
		
		System.out.println(nov.calcula());
		
	}
}