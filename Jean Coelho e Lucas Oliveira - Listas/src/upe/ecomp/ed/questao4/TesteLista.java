package upe.ecomp.ed.questao4;


public class TesteLista {

	public static void main(String[] args) {
		TADLista<String> lista = new ListaDinamica<String>();
		lista.inserir("4");
		lista.inserir("3");
		lista.inserir("fafas");
		lista.inserir("5");
		lista.inserir("8");
		lista.inserir("2");
		lista.inserir("7");
		lista.imprimeLista();
		lista.remover(null);
		lista.imprimeLista();
		lista.inverter();
		lista.imprimeLista();
	}

}