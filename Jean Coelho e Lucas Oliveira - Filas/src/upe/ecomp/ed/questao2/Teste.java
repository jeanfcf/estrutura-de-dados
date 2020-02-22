package upe.ecomp.ed.questao2;

public class Teste {
	
	public static void main(String[] args) {
		
		Loja jean = new Loja();
		
		ListaDinamica<Fila<Cliente>> ju = new ListaDinamica<Fila<Cliente>>();
		
		ju.inserir(new Fila<Cliente>());
		ju.inserir(new Fila<Cliente>());
		ju.inserir(new Fila<Cliente>());
		
		jean.setCaixas(ju);
		
		jean.abreFila(0);
		jean.abreFila(1);
		jean.chegaNovo(new Cliente("Jean1"));
		jean.chegaNovo(new Cliente("Jean2"));
		jean.chegaNovo(new Cliente("Jean3"));
		jean.chegaNovo(new Cliente("Jean4"));
		jean.chegaNovo(new Cliente("Jean5"));
		jean.chegaNovo(new Cliente("Jean6"));
		jean.chegaNovo(new Cliente("Jean7"));
		jean.chegaNovo(new Cliente("Jean8"));
		jean.chegaNovo(new Cliente("Jean9"));
		jean.chegaNovo(new Cliente("Jean"));
		
		jean.atendeFila(2);
		
		jean.chegaNovo(new Cliente("alskjghas"));
		
		
		
		
		
	}

}
