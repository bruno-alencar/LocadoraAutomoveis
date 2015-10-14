package br.usjt.arqdesis.model;

public class Grupo {
	private String nome;
	private char sigla;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public char getSigla() {
		return sigla;
	}
	public void setSigla(char sigla) {
		this.sigla = sigla;
	}
	@Override
	public String toString() {
		return "Grupo [nome=" + nome + ", sigla=" + sigla + "]";
	}
	
	
}
