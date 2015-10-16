package br.usjt.arqdesis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.model.Locacao;
import br.usjt.arqdesis.to.LocacaoTo;

@WebServlet("/devolucacao.do")
public class DevolucacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo_locacao = request.getParameter("codigo_locacao");
		
		Locacao locacao = new Locacao();
		locacao.setCodigo(Long.parseLong(codigo_locacao));
		
		LocacaoTo locacaoTo = new LocacaoTo();
		locacao = locacaoTo.consult(locacao);
	}

}
