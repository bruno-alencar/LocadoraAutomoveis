package br.usjt.arqdesis.to;

import java.util.ArrayList;
import java.util.List;

import br.usjt.arqdesis.dao.ClienteDao;
import br.usjt.arqdesis.model.Cliente;

public class ClienteTo {
	
	
	public void insert(Cliente cliente){
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.insert(cliente);
	}
	
	public void delete(Cliente cliente){
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.delete(cliente);
	}
	
	public List<Cliente> consultAll(){
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		ClienteDao clienteDao = new ClienteDao();
		listaClientes = clienteDao.consultAll();
		return listaClientes;
	}
	
	
}
