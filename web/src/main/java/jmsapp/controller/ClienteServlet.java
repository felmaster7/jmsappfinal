package jmsapp.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jmsapp.ejb.CarrinhoEjb;
import jmsapp.modelo.Cliente;
import jmsapp.modelo.Produto;

@WebServlet(name = "cliente", urlPatterns = "/cliente")
public class ClienteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	Cliente cliente;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		Long cpf = Long.parseLong(req.getParameter("cpf"));
		String endereco = req.getParameter("endereco");
		//Cliente cliente = new Cliente(nome, email, cpf, endereco);
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setEndereco(endereco);
		cliente.setCpf(cpf);
		
		//vai pegar do ret o id do cliente
		cliente.setId(1);
		
		req.setAttribute("cliente", cliente);
		req.getRequestDispatcher("venda.jsp").forward(req, resp);

	}

}
