package upe.ecomp.poli.questao5;

public class TesteFila {

	public static void preenche(Fila<Integer> F1, Fila<Integer> F2, Fila<Integer> retorno) {

		while (!F1.isEmpty() || !F2.isEmpty()) {

			if (F2.getInicio() == null) {
				while (F1.getInicio() != null) {
					retorno.inserir(F1.remover());
				}
			} else if (F1.getInicio() == null) {
				while (F2.getInicio() != null) {
					retorno.inserir(F2.remover());
				}
			} else if (F2.getInicio() == F1.getInicio()) {
				retorno.inserir(F1.remover());
				retorno.inserir(F2.remover());
			} else if (F1.getInicio() > F2.getInicio()) {
				retorno.inserir(F2.remover());
			} else if (F2.getInicio() > F1.getInicio()) {
				retorno.inserir(F1.remover());
			}
		}

	}

	public static void main(String[] args) {
		Fila<Integer> fila = new Fila<Integer>();
		Fila<Integer> fila2 = new Fila<Integer>();
		Fila<Integer> fila3 = new Fila<Integer>();

		fila.inserir(1);
		fila.inserir(3);
		fila.inserir(null);
		fila.inserir(7);
		fila.inserir(9);
		fila2.inserir(-2);
		fila2.inserir(4);
		fila2.inserir(5);
		fila2.inserir(8);
		fila2.inserir(10);
		
		fila.imprimir();
		fila2.imprimir();
		preenche(fila, fila2, fila3);

		fila3.imprimir();

	}

}