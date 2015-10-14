package br.usjt.arqdesis.model;

public class Acessorio {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Acessorio [nome=" + nome + "]";
	}
	
}
