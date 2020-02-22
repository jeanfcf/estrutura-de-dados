package upe.ecomp.ed.questao11;

public class FilaDecolagem extends Fila {

	public void listarDecolagem() {
		if (super.getInicio() != null) {
			No aux = super.getInicio();
			for (int i = 0; i < super.getQtd(); i++) {
				if (i == 0) {
					System.out.print("inicio");
				}
				if (aux != null) {
					System.out.print("-> " + aux.getInfo().getNome());
				}
				aux = aux.getProximo();
			}
			System.out.println();
		}
	}

	public Aviao autorizaDeco() {
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

}
