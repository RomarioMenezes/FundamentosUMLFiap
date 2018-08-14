package exercicio3;

public enum CorEnum {
	
	BRANCO("Branco", 21),
	PRETO("Preto",22),
	VERMELHO("Vermelho",23),
	AMARELO("Amarelo",24),
	AZUL("Azul",25);
	
	private int codigo;
	private String cor;
	
	private CorEnum(String cor, int codigo) {
	    this.codigo = codigo;
	    this.cor = cor;
	}
	
	public String getCor() {
		return this.cor;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
}


