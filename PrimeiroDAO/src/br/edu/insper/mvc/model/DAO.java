package br.edu.insper.mvc.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DAO {
	private Connection connection = null;
	
	public DAO() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");    
		connection =DriverManager.getConnection(
				"jdbc:mysql://localhost/meus_dados","root","jjgg9120");
		}
	public List<Tarefa> getLista() throws SQLException{
		List<Tarefa> tarefas = new ArrayList<Tarefa>();
		
		PreparedStatement stmt = connection.
				prepareStatement("SELECT * FROM Tarefas");
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Tarefa tarefa =new Tarefa();
			tarefa.setId(rs.getInt("id"));
			tarefa.setTarefa(rs.getString("tarefa")); 
			tarefa.setUrgente(rs.getString("urgente"));
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("date"));
			tarefa.setData(data);
			tarefa.setPessoa(rs.getString("encarregado"));
			tarefas.add(tarefa);
			}
		rs.close();
		stmt.close();
		
		return tarefas;
		}
	public void adiciona(Tarefa tarefa) throws SQLException{
		String sql ="INSERT INTO Tarefas"+"(tarefa, urgente, date, encarregado) values(?,?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1,tarefa.getTarefa());
		stmt.setString(2,tarefa.getUrgente());
		stmt.setDate(3, new java.sql.Date(tarefa.getData().getTimeInMillis()));
		stmt.setString(4,tarefa.getPessoa());
		stmt.execute();
		stmt.close();
		}
	
	public void atualiza(Tarefa tarefa)throws SQLException{
		PreparedStatement stmt = connection.prepareStatement("UPDATE Tarefas SET tarefa=?, urgente=? WHERE id=?");
		stmt.setString(1, tarefa.getTarefa());
		stmt.setString(2, tarefa.getUrgente());
		stmt.setInt(3, tarefa.getId());
		stmt.execute();
		stmt.close();
		}
	
	public void remove(Integer id)throws SQLException{
		PreparedStatement stmt = connection.prepareStatement("DELETE FROM Tarefas WHERE id=?");
		stmt.setInt (1, id);
		stmt.execute();
		stmt.close();
		}
	public void close() throws SQLException{
		connection.close();
		}
	}

