package br.edu.insper.mvc.model;

import java.util.Calendar;

public class Tarefa {
	private Integer id;
	private String tarefa;
	private String urgente;
	private Calendar data;
	private String pessoa;
	
	public Integer getId(){
		return this.id;
		}
	public void setId(Integer id){
		this.id = id;
		}
	public String getTarefa(){
		return this.tarefa;
		}
	public void setTarefa(String tarefa){
		this.tarefa = tarefa;
		}
	public String getUrgente() {
		return urgente;
	}
	public void setUrgente(String urgente) {
		this.urgente = urgente;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getPessoa() {
		return pessoa;
	}
	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}
}
