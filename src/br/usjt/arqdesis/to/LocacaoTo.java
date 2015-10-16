package br.usjt.arqdesis.to;

import br.usjt.arqdesis.dao.LocacaoDao;
import br.usjt.arqdesis.model.Locacao;

public class LocacaoTo{
	
	public void locar(Locacao locacao){
		LocacaoDao locacaoDao = new LocacaoDao();
		locacaoDao.locar(locacao);
	}
	
	public Locacao consult(Locacao locacao){
		LocacaoDao locacaoDao = new LocacaoDao();
		return locacaoDao.consult(locacao);
	}
}
