package upe.ecomp.ed.questao2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaEstatica<String> lista = new ListaEstatica<String>();
		ListaEstatica<String> lista2 = new ListaEstatica<String>();
		
		System.out.println("**********ADICIONANDO ELEMENTOS A LISTA************"+"\n");
		System.out.println("a quantidade de elementos na lista eh: " + lista.size()+"\n");
		
		//adiciona elementos na lista e printa
		lista.add("Lucas");
		lista.add("Matheus");
		lista.add("Oliviera");
		lista.add("zords");
		lista.add("jefftionayon");
		lista.add("jiraya");
		lista.add("jiraya");
		lista.add(null);
		lista.print();
		System.out.println("a quantidade de elementos na lista eh: " + lista.size()+"\n");
		System.out.println("******REMOVENDO 'Lucas' E 'jiraya' DA LISTA***********"+"\n");
		
		//remove dois elementos da lista (apenas a primeira ocorrencia de ambos)
		lista.remove("Lucas");
		lista.remove("jiraya");
		lista.remove(null);
		lista.print();
		//printa o tamanho da lista
		System.out.println("a quantidade de elementos na lista eh: " + lista.size()+"\n");
		System.out.println("**********ADICIONA MAIS ELEMENTOS NA LISTA PARA O ARRAY SER DOBRADO*************"+"\n");
		
		//adiciona mais elementos na lista para dobrar o array
		lista.add("Lucas");
		lista.add("Jeje");
		lista.add("grelinho");
		lista.add("zords");
		lista.add("papa");
		lista.add("queingratasolidao");
		lista.add("jesussocorro");
		lista.add("gera");
		lista.add("gera");
		lista.add("gera");
		lista.print();
		//printa o novo tamanho
		System.out.println("a quantidade de elementos na lista eh: " + lista.size()+"\n");
		System.out.println("*******REMOVE TODAS AS OCORRENCIAS DE 'gera' E 'zords'***********"+"\n");
		
		//remove todas as ocorrencias dos elementos passados
		lista.removeAll("gera");
		lista.removeAll("zords");
		lista.print();
		System.out.println("a quantidade de elementos na lista eh: " + lista.size()+"\n");
		System.out.println("*****TROCA 'Matheus' E 'Jeje' DE POSICAO********"+"\n");
		
		//troca a posicao dos elementos
		lista.troca("Matheus", "Jeje");
	    lista.troca("jiraya", "queingratasolidao");
		lista.print();
		System.out.println("a quantidade de elementos na lista eh: " + lista.size()+"\n");
		System.out.println("**********ADICIONANDO ELEMENTOS A UMA NOVA LISTA*************"+"\n");
		
		//adiciona elementos na lista 2
		lista2.add("Pedra");
		lista2.add("Podre");
		lista2.add("pindamonhagaba");
		lista2.add("pipocaparda");
		lista2.add("paleativo");
		lista2.add("jaca");
		lista2.print();
		System.out.println("a quantidade de elementos na lista eh: " + lista2.size()+"\n");
		System.out.println("******CONCATENANDO AMBAS AS LISTAS***********"+"\n");
		
		//concatena a lista um com a lista 2
		lista.concatenar(lista2);
		lista.print();
		System.out.println("a quantidade de elementos na lista eh: " + lista.size());	
		System.out.println("*****************************************");

	}

}
