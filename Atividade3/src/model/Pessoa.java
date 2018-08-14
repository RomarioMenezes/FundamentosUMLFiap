package model;

public class Pessoa implements Comparable<Pessoa>{
	
	private String nome, empresa;
	private int idade;
	private char sexo;
	
	public Pessoa(String nome, String empresa, int idade, char sexo) {
		super();
		this.nome = nome;
		this.empresa = empresa;
		this.idade = idade;
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}



	@Override
	public int compareTo(Pessoa o) {
		return this.nome.compareTo(o.getNome());
	}

	
	
}
