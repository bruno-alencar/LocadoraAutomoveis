package br.usjt.arqdesis.model;

public class Grupo {
	private Long codigo;
	private String nome;
	private char sigla;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
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
