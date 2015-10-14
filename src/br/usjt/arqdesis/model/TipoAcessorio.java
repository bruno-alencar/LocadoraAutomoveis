package br.usjt.arqdesis.model;

public class TipoAcessorio {
	private Acessorio acessorio;
	private Locacao locacao;
	public Acessorio getAcessorio() {
		return acessorio;
	}
	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}
	public Locacao getLocacao() {
		return locacao;
	}
	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}
	@Override
	public String toString() {
		return "TipoAcessorio [acessorio=" + acessorio + ", locacao=" + locacao + "]";
	}
	
	
}
