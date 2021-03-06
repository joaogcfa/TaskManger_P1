package br.edu.insper.controller;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;
import br.edu.insper.mvc.model.Tarefa;

/**
 * Servlet implementation class Atualiza
 */
@WebServlet("/Atualiza")
public class Atualiza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Atualiza() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/atualiza.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		try {
			DAO dao;
			dao = new DAO();
		
		Tarefa tarefa =new Tarefa();
		tarefa.setId(Integer.valueOf(request.getParameter("id")));
		tarefa.setTarefa(request.getParameter("tarefa"));
		
		
		if(!(request.getParameter("urgente") == null)) {
			if ((request.getParameter("urgente")).contentEquals("Urgente")) {
				tarefa.setUrgente("urgente");	
			}
		}
		else if (!(request.getParameter("nao") == null)) {
			if ((request.getParameter("nao")).contentEquals("N�o Urgente")) {
				tarefa.setUrgente("nao");	
			}	
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/lista.jsp");
		dao.atualiza(tarefa);
		dispatcher.forward(request, response);
		dao.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
