package upe.ecomp.ed.questao11;

public class FilaEspera extends Fila {

	public void moveAviao(FilaDecolagem fila) {
		if (fila != null) {
			Aviao e = pop();
			if (e != null) {
				fila.add(e);
			}
		}
	}

	public Aviao pop() {
		Aviao str = null;
		if (super.getInicio() != null) {
			str = super.getInicio().getInfo();
			super.setInicio(super.getInicio().getProximo());
			if (super.getInicio() == null) {
				super.setFim(super.getInicio());
			}
			super.setQtd(super.getQtd() - 1);
		}
		return str;
	}

	public void listarEspera() {
		if (super.getInicio() != null) {
			No aux = super.getInicio();
			for (int i = 0; i < super.getQtd(); i++) {
				if (i == 0)
					System.out.print("inicio");
				if (aux != null)
					System.out.print("-> " + aux.getInfo().getNome());
				if (aux.getProximo() != null)
					aux = aux.getProximo();
			}
			System.out.println();
		}
	}

}
