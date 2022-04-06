package com.webserviceproject.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webserviceproject.entities.enums.StatusDePedido;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
    
	private Integer statusDePedido;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@JsonIgnore
	@OneToOne(mappedBy = "pedido",cascade = CascadeType.ALL)
	private Payment payment;

	public Pedido() {
	}

	public Pedido(Long id, Instant moment, StatusDePedido statusDePedido, Usuario usuario) {
		super();
		this.id = id;
		this.moment = moment;
		setStatusDePedido(statusDePedido);
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public StatusDePedido getStatusDePedido() {
		return StatusDePedido.valueOf(statusDePedido);
	}

	public void setStatusDePedido(StatusDePedido statusDePedido) {
		if (statusDePedido != null) {
			this.statusDePedido = statusDePedido.getCode();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

}
