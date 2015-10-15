package br.usjt.arqdesis.to;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
	
	public void update(Cliente cliente){
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.update(cliente);
	}
	
	public List<Cliente> consultAll(){
		ClienteDao clienteDao = new ClienteDao();
		return clienteDao.consultAll();
	}
	
	public String consultAllJSON(){
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		ClienteDao clienteDao = new ClienteDao();
		listaClientes = clienteDao.consultAll();
		
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		
		for(Cliente cliente: listaClientes){
			try {
				object.put("nome", cliente.getNome());
				object.put("cpf", cliente.getCpf());
				object.put("rg", cliente.getRg());
				object.put("telefone", cliente.getTelefone());
				object.put("email", cliente.getEmail());
				object.put("dt_nasc", cliente.getData_nascimento());
				object.put("sexo", cliente.getSexo());
				object.put("cnh", cliente.getCnh());
				object.put("estado_cnh", cliente.getEstado_emissor_cnh());
				object.put("val_cnh", cliente.getValidade_cnh());
				
				array.put(object);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		return array.toString();
	}
	
}
