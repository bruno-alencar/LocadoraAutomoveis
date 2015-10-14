package br.usjt.arqdesis.model;

public class Usuario {
	private String login;
	private String senha;
	private TipoUsuario tipo_usuario;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public TipoUsuario getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(TipoUsuario tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	@Override
	public String toString() {
		return "Usuario [login=" + login + ", senha=" + senha + ", tipo_usuario=" + tipo_usuario + "]";
	}
	
	
}
