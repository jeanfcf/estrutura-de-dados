package upe.ecomp.ed.questao2;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
	
		ArvoreExp nov = new ArvoreExp("( ( ( 1 - 2 ) - ( 2 + 1 ) ) + ( -1 * -50 ) )");
		System.out.println(nov.calcula());
		
		ArvoreExp nov1 = new ArvoreExp("( ( ( 1 - 2 ) * ( 2 * 1 ) ) - ( -1 / 0 ) )");
		System.out.println(nov1.calcula());
		
	}
}