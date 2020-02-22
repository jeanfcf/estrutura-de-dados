package upe.ecomp.ed.questao3;

public class Main {

	public static void main(String[] args) {
		ListaCircular<String> teste = new ListaCircular<String>();
		ListaCircular<String> teste1 = new ListaCircular<String>();
		ListaCircular<Integer> teste2 = new ListaCircular<Integer>();
		ListaCircular<Integer> teste3 = new ListaCircular<Integer>();
		ListaCircular<String> teste4 = new ListaCircular<String>();
		ListaCircular<Integer> null1 = new ListaCircular<Integer>();
		ListaCircular<Integer> null2 = new ListaCircular<Integer>();
		
		teste.add("a");
		teste.add("b");
		teste.add("c");
		teste1.add("a");
		teste1.add("b");
		
		teste.imprimeLista();
		teste1.imprimeLista();
		teste.addInterc(teste, teste1).imprimeLista();
		System.out.println("a lista teste contem a lista teste1?: "+teste.contains(teste, teste1));
		teste.imprimeLista();
		System.out.println("\n"+ "********************************************************");
		
		teste2.add(1);
		teste2.add(3);
		teste2.add(7);
		teste3.add(5);
		teste3.add(6);
		teste2.imprimeLista();
		teste3.imprimeLista();
		teste2.addInterc(teste2, teste3).imprimeLista();;
		System.out.println("a lista teste2 contem a lista teste3?: "+ teste2.contains(teste2, teste3));
		teste2.imprimeLista();
		System.out.println("\n"+"********************************************************");
		
		teste4.add("pamonha");
		teste4.add("pitaco");
		teste4.add("paleolitico");
		teste4.imprimeLista();
		teste4.addInterc(teste4, teste1).imprimeLista();
		System.out.println("\n"+"********************************************************");
		
		null1.add(null);
		null2.add(null);
		null1.imprimeLista();
		null2.imprimeLista();
		null1.addInterc(null1, null2).imprimeLista();;
		System.out.println("a lista null1 contem a lista null2?: "+ teste2.contains(null1, null2));
		
		
		System.out.println("\n"+"********************************************************");
			
		
	}

}
