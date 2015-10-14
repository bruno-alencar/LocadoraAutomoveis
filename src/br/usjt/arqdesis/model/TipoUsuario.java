package br.usjt.arqdesis.model;

public class TipoUsuario {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "TipoUsuario [nome=" + nome + "]";
	}
	
	
}
