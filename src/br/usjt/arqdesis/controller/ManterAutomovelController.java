package br.usjt.arqdesis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.model.Automovel;
import br.usjt.arqdesis.to.AutomovelTo;

@WebServlet("/automovel.do")
public class ManterAutomovelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AutomovelTo automovelTo = new AutomovelTo();
		request.setAttribute("listaAutomoveis", automovelTo.consultAll());
		
		RequestDispatcher view = request.getRequestDispatcher("consultarAutomovel.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcao = request.getParameter("opcao");
		
		if(opcao.equals("alterar")){
			
		}else if(opcao.equals("consultarTodos")){
			this.consultAll(request, response);
		}else if(opcao.equals("consultarEspecifica")){
			
		}
	}
	
	protected void alterar(HttpServletRequest request, HttpServletResponse response){
		String codAutomovel = request.getParameter("automovel");
		
		
		AutomovelTo automovelTo = new AutomovelTo();
		
		Automovel automovel = automovelTo.consult(Long.parseLong(codAutomovel));
		
		
		
	}
	
	protected void consultAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chassi = request.getParameter("chassi");
		String placa = request.getParameter("placa");
		String cidade = request.getParameter("cidade");
		String km = request.getParameter("km");
		String estado = request.getParameter("estado");
		String modelo = request.getParameter("modelo");
		String fabricante = request.getParameter("fabricante");
		String tarifa_km_livre = request.getParameter("tarifa_km_livre");
		String tarifa_km_controlado = request.getParameter("tarifa_km_controlado");
		
		Automovel automovel = new Automovel();
		automovel.setChassi(chassi);
		automovel.setPlaca(placa);
		automovel.setCidade(cidade);
		automovel.setKm(Integer.parseInt(km));
		automovel.setEstado(estado);
		automovel.setModelo(modelo);
		automovel.setFabricante(fabricante);
		automovel.setTarifa_km_livre(Double.parseDouble(tarifa_km_livre));
		automovel.setTarifa_km_controlado(Double.parseDouble(tarifa_km_controlado));
		
		AutomovelTo automovelTo = new AutomovelTo();
		automovelTo.insert(automovel);
		
		RequestDispatcher view = request.getRequestDispatcher("home.jsp");
		view.forward(request, response);
	}

//	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	 //Alterar automovel
//	}
//
//	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String chassi = request.getParameter("chassi");
//		
//		Automovel automovel = new Automovel();
//		automovel.setChassi(chassi);
//		
//		AutomovelTo automovelTo = new AutomovelTo();
//		automovelTo.delete(automovel);
//	}

}
