package br.usjt.arqdesis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.usjt.arqdesis.model.Automovel;

public class AutomovelDao {

	private static final String SQLInsertAutomovel = "INSERT INTO automovel (chassi, placa, cidade, km, estado, modelo, fabricante, tarifa_km_livre, tarifa_km_controlado)"
												   + "VALUES (?,?,?,?,?,?,?,?,?)";
	private static final String SQLSelectAutomovel = "SELECT * FROM automovel";
	private static final String SQLValidarAutomovelLocado = "SELECT l.codigo "
														  + "FROM locacao l "
														  + "JOIN automovel a"
														  + "ON l.automovel = a.codigo"
														  + "WHERE l.automovel = (?)";
	private static final String SQLDeleteAutomovel = "DELETE FROM automovel where chassi = (?)";
	Connection con;


	public void insert(Automovel automovel){
		con = ConnectionFactory.conect();
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(SQLInsertAutomovel);
			
			stmt.setString(1, automovel.getChassi());
			stmt.setString(2, automovel.getPlaca());
			stmt.setString(3, automovel.getCidade());
			stmt.setInt(4, automovel.getKm());
			stmt.setString(5, automovel.getEstado());
			stmt.setString(6, automovel.getModelo());
			stmt.setString(7, automovel.getFabricante());
			stmt.setDouble(8, automovel.getTarifa_km_livre());
			stmt.setDouble(9, automovel.getTarifa_km_controlado());
			
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.disconnect(con);
		}
	}

	public void update(Automovel automovel){

	}

	public void delete(Automovel automovel){
		PreparedStatement stmt;
		
		try {
			if(this.validarAutomovelLocado(automovel) == false){
				stmt = con.prepareStatement(SQLDeleteAutomovel);
				stmt.setString(1, automovel.getChassi());
				
				stmt.execute();
				
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Automovel> consultAll(){
		con = ConnectionFactory.conect();
		PreparedStatement stmt;
		ResultSet rs;
		List<Automovel> listaAutomoveis = new ArrayList<Automovel>();
		
		try {
			stmt = con.prepareStatement(SQLSelectAutomovel);
			
			rs = stmt.executeQuery();
			
			while(rs.next()){
				Automovel automovel = new Automovel();
				automovel.setCodigo(Long.parseLong(rs.getString(1)));
				automovel.setChassi(rs.getString(2));
				automovel.setPlaca(rs.getString(3));
				automovel.setCidade(rs.getString(4));
				automovel.setKm(rs.getInt(5));
				automovel.setEstado(rs.getString(6));
				automovel.setModelo(rs.getString(7));
				automovel.setFabricante(rs.getString(8));
				automovel.setTarifa_km_livre(rs.getDouble(9));
				automovel.setTarifa_km_controlado(rs.getDouble(10));
				
				listaAutomoveis.add(automovel);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.disconnect(con);
		}
		
		return listaAutomoveis;
	}
	
	private boolean validarAutomovelLocado(Automovel automovel){
		PreparedStatement stmt;
		ResultSet rs;
		boolean validador = false;
		try {
			stmt = con.prepareStatement(SQLValidarAutomovelLocado);
			
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
