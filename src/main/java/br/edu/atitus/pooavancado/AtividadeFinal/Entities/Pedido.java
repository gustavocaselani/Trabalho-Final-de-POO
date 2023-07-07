package br.edu.atitus.pooavancado.AtividadeFinal.Entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido extends GenericEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private Date data;
	
	@ManyToOne
	@JoinColumn(nullable = false, name ="id_produto")
	private Produto produto;
	
	@Column(nullable = false)
	private double quantidade;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}
}
