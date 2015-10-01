package br.usjt.arqdesis.dao;

import br.usjt.arqdesis.model.Usuario;

public class UsuarioDao {
	
	private static final String SQLValidarUsuario="";
	private static final String SQLSelectTipoUsuario = "";
	
	public boolean consultar(Usuario usuario){
		
		
		this.consultarTipoUsuario();
		return true;
	}
	
	public void consultarTipoUsuario(){
		
	}
}
