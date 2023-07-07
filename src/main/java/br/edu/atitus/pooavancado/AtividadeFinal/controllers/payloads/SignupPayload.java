package br.edu.atitus.pooavancado.AtividadeFinal.controllers.payloads;

import br.edu.atitus.pooavancado.AtividadeFinal.Entities.Pedido;

public class SignupPayload {
	
	private String nome;
	private String email;
	private Pedido departamento;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Pedido getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Pedido departamento) {
		this.departamento = departamento;
	}
}
