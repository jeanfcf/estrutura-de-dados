package upe.ecomp.ed.questao2;

public class Main {

	public static void main(String[] args) {
		TADPilha teste = new Pilha();
		Livro livro = new Livro("Sherlock Holmes", 1980);
		Livro livro1 = new Livro("Percy Jackson", 2012);
		Livro livro2 = new Livro("Harry Potter", 1995);
		Livro livro3 = new Livro("Call me By your name", 2017);
		Livro livro4 = new Livro("1+1",2015);
		
		teste.push(livro);
		teste.push(livro1);
		teste.push(livro2);
		teste.push(livro3);
		teste.push(livro4);
		teste.imprime();
		System.out.println(teste.indexOf(livro));
		teste.remover(livro);
		teste.imprime();
		
		
	}

}
