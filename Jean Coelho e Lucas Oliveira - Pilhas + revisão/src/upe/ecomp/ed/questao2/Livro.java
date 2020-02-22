package upe.ecomp.ed.questao2;

public class Livro {
	private String nome;
	private int anoDeLancamento;
	
	public Livro(String nome, int anoDeLancamento) {
		this.nome = nome;
		this.anoDeLancamento = anoDeLancamento;
	}

	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public String getNome() {
		return nome;
	}


}
