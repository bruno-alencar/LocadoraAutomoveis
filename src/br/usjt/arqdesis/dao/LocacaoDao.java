package br.usjt.arqdesis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.usjt.arqdesis.model.Acessorio;
import br.usjt.arqdesis.model.Locacao;

public class LocacaoDao {

	private static final String SQLInsertLocacao = "INSERT INTO locacao (data_locacao, local_locacao, data_prevista_devolucacao, local_previsto_devolucacao, data_devolucao, local_devolucacao, tipo_tarifa, valor_estimado, cliente, automovel, grupo) "
												 + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SQLInsertTipoAcessorio = "INSERT INTO tipoAcessorio(codigo_locacao, codigo_acessorio)"
														+"VALUES (?,?)";
	private static final String SQLSelectLocacao = "SELECT * FROM locacao WHERE codigo = (?)";
	Connection con;

	public void locar(Locacao locacao){
		con = ConnectionFactory.conect();
		PreparedStatement stmt;
		ResultSet rs;
		
		try {
			stmt = con.prepareStatement(SQLInsertLocacao, new String[]{"codigo"});
			stmt.setTimestamp(1, locacao.getData_locacao());
			stmt.setString(2, locacao.getLocal_locacao());
			stmt.setTimestamp(3, locacao.getData_prevista_devolucao());
			stmt.setString(4, locacao.getLocal_previsto_devolucao());
			stmt.setTimestamp(5, locacao.getData_devolucao());
			stmt.setString(6, locacao.getLocal_devolucao());
			stmt.setString(7, locacao.getTipo_tarifa());
			stmt.setDouble(8, locacao.getValor_estimado());
			stmt.setLong(9, locacao.getCliente().getCodigo());
			stmt.setLong(10, locacao.getAutomovel().getCodigo());
			stmt.setLong(11, locacao.getGrupo().getCodigo());
			
			stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			
			if(rs.next()){
				locacao.setCodigo(Long.parseLong(rs.getString(1)));
				this.insertTipoAcessorios(locacao);
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.disconnect(con);
		}
	}
	
	public Locacao consult(Locacao locacao){
		con = ConnectionFactory.conect();
		PreparedStatement stmt;
		ResultSet rs;
		try {
			stmt = con.prepareStatement(SQLSelectLocacao);
			stmt.setLong(1, locacao.getCodigo());
			
			rs = stmt.executeQuery();
			
			if(rs.next()){
				locacao.setData_locacao(rs.getTimestamp(1));
				locacao.setLocal_locacao(rs.getString(2));
				locacao.setData_prevista_devolucao(rs.getTimestamp(3));
				locacao.setLocal_previsto_devolucao(rs.getString(4));
				locacao.setData_devolucao(rs.getTimestamp(5));
				locacao.setLocal_devolucao(rs.getString(6));
				locacao.setTipo_tarifa(rs.getString(7));
				locacao.setValor_estimado(rs.getDouble(8));
				locacao.getCliente().setCodigo(rs.getLong(9));
				locacao.getAutomovel().setCodigo(rs.getLong(10));
				locacao.getGrupo().setCodigo(rs.getLong(11));
			}
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.disconnect(con);
		}
		
		return locacao;
	}
	
	private void insertTipoAcessorios(Locacao locacao){
		PreparedStatement stmt;
		
		try {
			stmt = con.prepareStatement(SQLInsertTipoAcessorio);
			
			for(Acessorio acessorio: locacao.getListaAcessorios()){
				stmt.setLong(1, locacao.getCodigo());
				stmt.setLong(2, acessorio.getCodigo());
				
				stmt.execute();
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
