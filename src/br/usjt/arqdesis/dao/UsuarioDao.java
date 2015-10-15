package br.usjt.arqdesis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.arqdesis.model.Usuario;

public class UsuarioDao {
	
	private static final String SQLValidarUsuario="select * from login where usuario= '(?)' and senha = '(?)'";
	Connection con;
	
	public boolean validarUsuario(Usuario usuario){
		con = ConnectionFactory.conect();
		PreparedStatement stmt;
		ResultSet rs;
		boolean validador = false;
		
		try {
			stmt = con.prepareStatement(SQLValidarUsuario);
			
			rs = stmt.executeQuery();
			
			if(rs != null){
				validador = true;
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return validador;
	}
}
