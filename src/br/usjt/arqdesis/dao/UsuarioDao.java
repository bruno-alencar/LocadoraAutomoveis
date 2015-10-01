package br.usjt.arqdesis.dao;

import br.usjt.arqdesis.model.Usuario;

public class UsuarioDao {
	
	private static final String SQLValidarUsuario="select * from login where usuario= '(?)' and senha = '(?)'";
	
	public boolean validarUsuario(Usuario usuario){
		
		return true;
	}
}
