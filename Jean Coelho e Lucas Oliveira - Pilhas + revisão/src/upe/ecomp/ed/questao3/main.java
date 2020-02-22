package upe.ecomp.ed.questao3;

public class main {

	public static boolean estaContida(PilhaDinamica<Integer> p1, PilhaDinamica<Integer> p2) {

		if (p1.size() <= p2.size()) {
			while (!p1.top().equals(p2.top())) {
				if (p2.isEmpty()) {
					return false;
				}
				p2.pop();
			}

			while (!p1.isEmpty()) {
				if (!p1.pop().equals(p2.pop())) {
					return false;

				}
			}
		} else 
			return false;
		
		return true;

	}

	public static void main(String[] args) {

		PilhaDinamica<Integer> p1 = new PilhaDinamica<Integer>();
		PilhaDinamica<Integer> p2 = new PilhaDinamica<Integer>();
		PilhaDinamica<Integer> p3 = new PilhaDinamica<Integer>();
		PilhaDinamica<Integer> p4 = new PilhaDinamica<Integer>();
		PilhaDinamica<Integer> p5 = new PilhaDinamica<Integer>();
		PilhaDinamica<Integer> p6 = new PilhaDinamica<Integer>();
		PilhaDinamica<Integer> p7 = new PilhaDinamica<Integer>();
		PilhaDinamica<Integer> p8 = new PilhaDinamica<Integer>();
		PilhaDinamica<Integer> p9 = new PilhaDinamica<Integer>();
		PilhaDinamica<Integer> p10 = new PilhaDinamica<Integer>();
		p1.push(1);
		p1.push(2);
		p2.push(1);
		p2.push(2);
		p2.push(3);
		p2.push(4);
		System.out.println(estaContida(p1, p2));
		p3.push(1);
		p3.push(2);
		p3.push(2);
		p4.push(1);
		p4.push(2);
		p4.push(2);
		System.out.println(estaContida(p3,p4));
		 p5.push(1);
		 p5.push(1);
		 p5.push(1);
		 p5.push(1);
		 p5.push(1);
		 p5.push(1);
		 p6.push(1);
		 p6.push(1);
		 System.out.println(estaContida(p5,p6));
		 p7.push(3);
		 p7.push(5);
		 p7.push(9);
		 p8.push(9);
		 p8.push(5);
		 p8.push(3);
		 System.out.println(estaContida(p7,p8));
		 p9.push(3);
		 p9.push(5);
		 p9.push(9);
		 p10.push(7);
		 p10.push(4);
		 p10.push(2);
		 p10.push(6);
		 System.out.println(estaContida(p9,p10));
		 
		
		
		

	}
}
