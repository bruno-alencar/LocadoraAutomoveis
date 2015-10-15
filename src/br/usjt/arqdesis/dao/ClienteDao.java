package br.usjt.arqdesis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.usjt.arqdesis.model.Cliente;

public class ClienteDao {
	
	private static final String SQLInsertCliente = "INSERT INTO cliente (nome, cpf, rg, telefone, email, data_nascimento, sexo, cnh, estado_emissor_cnh, validade_cnh) "
												 + "VALUES (?,?,?,?,?,?,?,?,?,?)";
	private static final String SQLSelectCliente = "Select * from cliente";
	
	private static final String SQLDeleteCliente = "DELETE FROM cliente WHERE cpf = (?)";
	private static final String SQLValidarClienteLocacao = "SELECT l.codigo "
														  +"FROM locacao l"
														  +"JOIN cliente c"
														  + "ON c.codigo = l.cliente "
														  + "WHERE l.cliente = (?)";
	Connection con;
	
	public void insert(Cliente cliente){
		con = ConnectionFactory.conect();
		PreparedStatement stmt;
		
		try {
			stmt = con.prepareStatement(SQLInsertCliente);
			stmt.setString(1, cliente.getNome());
			stmt.setInt(2, cliente.getCpf());
			stmt.setInt(3, cliente.getRg());
			stmt.setInt(4, cliente.getTelefone());
			stmt.setString(5, cliente.getEmail());
			stmt.setDate(6, cliente.getData_nascimento());
			stmt.setString(7, cliente.getSexo());
			stmt.setInt(8, cliente.getCnh());
			stmt.setString(9, cliente.getEstado_emissor_cnh());
			stmt.setDate(10, cliente.getValidade_cnh());
			
			stmt.execute();
			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.disconnect(con);
		}
	}
	
	public void delete(Cliente cliente){
		con = ConnectionFactory.conect();
		PreparedStatement stmt;
		
		try {
			
			if(this.validarClienteLocacao(cliente) == false){
				stmt = con.prepareStatement(SQLDeleteCliente);
				stmt.setInt(1, cliente.getCpf());
				
				stmt.execute();
				stmt.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.disconnect(con);
		}
	}
	
	public void update(Cliente cliente){
		
	}
	
	public List<Cliente> consultAll(){
		con = ConnectionFactory.conect();
		PreparedStatement stmt;
		ResultSet rs;
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		try {
			stmt = con.prepareStatement(SQLSelectCliente);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				Cliente cliente = new Cliente();
				cliente.setNome(rs.getString(1));
				cliente.setCpf(rs.getInt(2));
				cliente.setRg(rs.getInt(3));
				cliente.setTelefone(rs.getInt(4));
				cliente.setEmail(rs.getString(5));
				cliente.setData_nascimento(rs.getDate(6));
				cliente.setSexo(rs.getString(7));
				cliente.setCnh(rs.getInt(8));
				cliente.setEstado_emissor_cnh(rs.getString(9));
				cliente.setValidade_cnh(rs.getDate(10));
				
				listaClientes.add(cliente);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.disconnect(con);
		}
		
		return listaClientes;
	}
	
	public boolean validarClienteLocacao(Cliente cliente){
		PreparedStatement stmt;
		ResultSet rs;
		boolean validador = false;
		try {
			stmt = con.prepareStatement(SQLValidarClienteLocacao);
			stmt.setInt(1, cliente.getCpf());
			rs = stmt.executeQuery();
			
			if(rs != null){
				validador = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return validador;
	}
}
