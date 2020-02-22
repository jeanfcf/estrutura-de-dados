package upe.ecomp.ed.questao11;

public class Main {

	public static void main(String[] args) {
		Aviao teste = new Aviao("Gol");
		Aviao teste1 = new Aviao("Avianca");
		Aviao teste2 = new Aviao("Azul");
		Aviao teste3 = new Aviao("Varig");
		Aviao teste4 = new Aviao("Tam");
		FilaDecolagem fila1 = new FilaDecolagem();
		FilaEspera fila2 = new FilaEspera();
		
		fila1.add(teste);
		fila1.add(teste2);
		fila1.add(teste4);
		fila1.listarDecolagem();
		
		fila2.add(teste1);
		fila2.add(teste3);
		fila2.listarEspera();
		
		fila2.moveAviao(fila1);
		fila2.listarEspera();
		fila1.listarDecolagem();
		
		fila1.autorizaDeco();
		fila1.autorizaDeco();
		fila1.listarDecolagem();
		

	}

}
