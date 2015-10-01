package br.usjt.arqdesis.to;

import br.usjt.arqdesis.dao.UsuarioDao;
import br.usjt.arqdesis.model.Usuario;

public class UsuarioTo {
	
	public boolean validarUsuario(Usuario usuario){
		UsuarioDao usuarioDao = new UsuarioDao();
		return usuarioDao.validarUsuario(usuario);
	}
}
