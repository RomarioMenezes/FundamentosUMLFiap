package exercicio2;

public class Exercicio2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		
		Aeroporto aeroporto = new Aeroporto("Guarulhos");
		
		Aviao a1 = new Aviao("TAN 123", aeroporto);
		Aviao a2 = new Aviao("OLÉ 111", aeroporto);
		Aviao a3 = new Aviao("LINHA 222", aeroporto);
		 
		
		aeroporto.start();
		a1.start();
		a2.start();
		a3.start();


		while(true) {
		  Thread.currentThread().sleep(10000);
		  aeroporto.alterarEstadoPista(true);
		}
	}
}
