package exercicio3;

import java.util.Arrays;

public class Exercicio4 {
	
	public static void main(String[] args) {
		
		Arrays.asList(CorEnum.values()).forEach(e ->{
			System.out.println("Cor: "+e.getCor()+" - Codigo:"+e.getCodigo());
		});
		
		System.out.println(CorEnum.BRANCO.getCodigo());
	}
}


