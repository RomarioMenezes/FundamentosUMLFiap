package exercicio2;

public class Aviao extends Thread {
 
	 private String nomeVoo;
	 private Aeroporto aeroporto;
	 
	public Aviao(String nomeVoo, Aeroporto aeroporto) {
		super();
		this.nomeVoo = nomeVoo;
		this.aeroporto = aeroporto;
	}
	 
	
	
	
	@Override
	public void run() {
		
		while(true) {
			try {
				decolar();
				aterrisar();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}

	public synchronized void decolar() throws InterruptedException {
			System.out.println("Voo :" +nomeVoo +" Aguando pista...");
		    aeroporto.aguardarPistaDisponivel();
			System.out.println("Voo :" +nomeVoo +" Decolando...");
			aeroporto.alterarEstadoPista(false);
			voar();
		
	}
	
	public synchronized void voar() {
		try {
			System.out.println("Voo :" +nomeVoo +" Voando...");
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		aeroporto.alterarEstadoPista(true);
	}

	public synchronized void aterrisar() throws InterruptedException {
		    
		aeroporto.aguardarPistaDisponivel();
		System.out.println("Voo :" +nomeVoo +" Aterrisando...");
		aeroporto.alterarEstadoPista(false);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		aeroporto.alterarEstadoPista(true);
	}
}
