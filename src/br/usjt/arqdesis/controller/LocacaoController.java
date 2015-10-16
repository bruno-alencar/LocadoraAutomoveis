package br.usjt.arqdesis.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.model.Locacao;
import br.usjt.arqdesis.to.LocacaoTo;

@WebServlet("/locacao.do")
public class LocacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat parserSDF = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.ENGLISH);

		String data_locacao = request.getParameter("data_locacao"); 
		String local_locacao = request.getParameter("local_locacao");
		String data_prevista_devolucao = request.getParameter("dt_prev_dev");
		String local_previsto_devolucao = request.getParameter("lcl_prev_dev");
		String data_devolucao = request.getParameter("dt_dev");
		String local_devolucao = request.getParameter("lcl_dev");
		String tipo_tarifa = request.getParameter("tipo_tarifa");
		String valor_estimado = request.getParameter("valor_estimado");
		String cliente = request.getParameter("cliente");
		String automovel = request.getParameter("automovel");
		String grupo = request.getParameter("grupo");
		String listaAcessorios = request.getParameter("lista_acessorios");

		Locacao locacao = new Locacao();
		try {
			locacao.setData_locacao(new Timestamp(parserSDF.parse(data_locacao).getTime()));
			locacao.setLocal_locacao(local_locacao);
			locacao.setData_prevista_devolucao(new Timestamp(parserSDF.parse(data_prevista_devolucao).getTime()));
			locacao.setLocal_previsto_devolucao(local_previsto_devolucao);
			locacao.setData_devolucao(new Timestamp(parserSDF.parse(data_devolucao).getTime()));
			locacao.setLocal_devolucao(local_devolucao);
			locacao.setTipo_tarifa(tipo_tarifa);
			locacao.setValor_estimado(Double.parseDouble(valor_estimado));
			locacao.getCliente().setCodigo(Long.parseLong(cliente));
			locacao.getAutomovel().setCodigo(Long.parseLong(automovel));;
			locacao.getGrupo().setCodigo(Long.parseLong(grupo));
//	        locacao.getListaAcessorios().add(e);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		LocacaoTo locacaoTo = new LocacaoTo();
		locacaoTo.locar(locacao);
	}

}
