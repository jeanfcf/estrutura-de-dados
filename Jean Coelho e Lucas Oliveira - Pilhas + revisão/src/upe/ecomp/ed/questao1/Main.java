package upe.ecomp.ed.questao1;

public class Main {

	public static void main(String[] args) {
		Pilha nova = new Pilha();

		nova.push("Estudando");
		nova.push("_Pilhas");
		nova.push("_agora!");
		
		nova.listar();
		System.out.println("a quantidade de alterações salvas é: "+nova.alterSalva());
		
		nova.desfazer();
		
		nova.listar();
		System.out.println("a quantidade de alterações salvas é: "+nova.alterSalva());

	}

}
