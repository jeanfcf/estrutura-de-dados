package upe.ecomp.ed.questao6;

public class Main {

	public static void main(String[] args) {
		Deque<String> novo = new Deque<String>();
		novo.addDir(null);
		novo.addEsq("1");
		novo.addDir("2");
		novo.addDir("3");
		novo.addDir("4");
		novo.print();
		System.out.println("A posicao do inicio eh: "+novo.inicio());
		System.out.println("A posicao do fim eh: "+novo.fim());
		System.out.println("**********************************");
		System.out.println("o valor removido foi: "+novo.popEsq());
		System.out.println("o valor removido foi: "+novo.popDir());
		novo.print();
		System.out.println("A nova posicao do inicio eh: "+novo.inicio());
		System.out.println("A nova posicao do fim eh: "+novo.fim());
		System.out.println("**********************************");
		novo.addDir(null);
		novo.addDir("5");
		novo.print();
		System.out.println("o valor removido foi: "+novo.popEsq());
		System.out.println("o valor removido foi: "+novo.popDir());
		System.out.println("o valor removido foi: "+novo.popDir());
		System.out.println("**********************************");
		novo.print();
	}

}
