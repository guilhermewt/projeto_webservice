package com.webserviceproject.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webserviceproject.entities.pk.ItemsDePedidoPK;

@Entity
@Table(name = "tb_itemsDePedido")
public class ItemsDePedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ItemsDePedidoPK id = new ItemsDePedidoPK();
	
	private Integer quantidade;
	private Double price;
	
	public ItemsDePedido () {		
	}

	public ItemsDePedido(Pedido pedidos, Produto produtos, Integer quantidade, Double price) {
		super();
		id.setPedido(pedidos);
		id.setProduto(produtos);
		this.quantidade = quantidade;
		this.price = price;
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
    public void setPedido(Pedido pedido) {
    	id.setPedido(pedido);
    }
    
    public Produto getProduto() {
    	return id.getProduto();
    }
    
    public void setProduto(Produto produto) {
    	id.setProduto(produto);
    }

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double subTotal() {
		return quantidade * price;
	}

}
