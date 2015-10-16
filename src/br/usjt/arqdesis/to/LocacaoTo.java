package br.usjt.arqdesis.to;

import br.usjt.arqdesis.dao.LocacaoDao;
import br.usjt.arqdesis.model.Locacao;

public class LocacaoTo{
	
	public void locar(Locacao locacao){
		LocacaoDao locacaoDao = new LocacaoDao();
		locacaoDao.locar(locacao);
	}
	
	public void consult(Locacao locacao){
		LocacaoDao locacaoDao = new LocacaoDao();
		locacaoDao.consult(locacao);
	}
}
