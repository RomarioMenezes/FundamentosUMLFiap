package exercicio2;

public class Aeroporto extends Thread {

	
	private String nome;
	private boolean pista = false;
	
	
	
	@Override
	public void run() {
	}


	public Aeroporto(String nome) {
		this.nome = nome;
	}


	public void aguardarPistaDisponivel() {
		if(!pista) {
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}	
			}
		}else {
			synchronized (this) {
				notify();
			}
		}
		
	}
	
	
	public void alterarEstadoPista(boolean pista) {
		this.pista = pista; 
		if(pista) {
			System.out.println("Pista Livre.");
			synchronized (this) {
				notify();	
			}
		}else {
			System.out.println("Pista Bloqueada para Voo.");
		}
	}

}
