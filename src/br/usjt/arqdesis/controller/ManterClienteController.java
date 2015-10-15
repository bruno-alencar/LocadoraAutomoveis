package br.usjt.arqdesis.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.usjt.arqdesis.model.Cliente;
import br.usjt.arqdesis.to.ClienteTo;

@WebServlet("/cliente.do")
public class ManterClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 SimpleDateFormat parserSDF = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS", Locale.ENGLISH);
		
		 String cpf = request.getParameter("cpf");
		 String rg = request.getParameter("rg");
		 String telefone = request.getParameter("telefone");
		 String email = request.getParameter("email");
		 String data_nascimento = request.getParameter("dt_nasc");
		 String sexo = request.getParameter("sexo");
		 String cnh = request.getParameter("cnh");
		 String estado_emissor_cnh = request.getParameter("estado_cnh");
		 String validade_cnh = request.getParameter("dt_cnh");
		
		 Cliente cliente = new Cliente();
		try {
			
			cliente.setCpf(Integer.parseInt(cpf));
			cliente.setRg(Integer.parseInt(rg));
			cliente.setTelefone(Integer.parseInt(telefone));
			cliente.setEmail(email);
			cliente.setData_nascimento(new Date(parserSDF.parse(data_nascimento).getTime()));
			cliente.setSexo(sexo);
			cliente.setCnh(Integer.parseInt(cnh));
			cliente.setEstado_emissor_cnh(estado_emissor_cnh);
			cliente.setValidade_cnh(new Date(parserSDF.parse(validade_cnh).getTime()));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}

		ClienteTo clienteTo = new ClienteTo();
		clienteTo.insert(cliente);
		
		RequestDispatcher view = request.getRequestDispatcher("home.jsp");
		view.forward(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cpf = request.getParameter("cpf");
		
		Cliente cliente = new Cliente();
		cliente.setCpf(Integer.parseInt(cpf));
		
		ClienteTo clienteTo = new ClienteTo();
		clienteTo.delete(cliente);
	}

}
