package br.edu.insper.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;
import br.edu.insper.mvc.model.Tarefa;

/**
 * Servlet implementation class Cria
 */
@WebServlet("/Cria")
public class Cria extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cria() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao;
		try {
			dao = new DAO();
		
		Tarefa tarefa =new Tarefa();
		tarefa.setTarefa(request.getParameter("tarefa"));
		
		System.out.println(request.getParameter("pessoa"));
		tarefa.setPessoa(request.getParameter("pessoa"));
		
//		System.out.println(request.getParameter("urgente"));
		
		if(!(request.getParameter("urgente") == null)) {
			if ((request.getParameter("urgente")).contentEquals("Urgente")) {
				tarefa.setUrgente("urgente");	
			}
		}
		else if (!(request.getParameter("nao") == null)) {
			if ((request.getParameter("nao")).contentEquals("Não Urgente")) {
				tarefa.setUrgente("nao");	
			}	
		}
		
		String data_recebida = request.getParameter("data");
		Date data =new SimpleDateFormat("dd-MM-yyyy").parse(data_recebida);
		Calendar data_prazo =Calendar.getInstance();
		data_prazo.setTime(data);
		tarefa.setData(data_prazo);
		dao.adiciona(tarefa);
		
		dao.close();
		response.sendRedirect("lista.jsp");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
