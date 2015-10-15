package br.usjt.arqdesis.to;

import java.util.List;

import br.usjt.arqdesis.dao.AutomovelDao;
import br.usjt.arqdesis.model.Automovel;

public class AutomovelTo {
	public void insert(Automovel automovel){
		AutomovelDao automovelDao = new AutomovelDao();
		automovelDao.insert(automovel);
	}
	
	public void update(Automovel automovel){
		AutomovelDao automovelDao = new AutomovelDao();
		automovelDao.update(automovel);
	}
	
	public void delete(Automovel automovel){
		AutomovelDao automovelDao = new AutomovelDao();
		automovelDao.delete(automovel);
	}
	
	public List<Automovel> consultAll(){
		AutomovelDao automovelDao = new AutomovelDao();
		return automovelDao.consultAll();
	}
}
