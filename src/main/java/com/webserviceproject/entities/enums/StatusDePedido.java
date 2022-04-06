package com.webserviceproject.entities.enums;

public enum StatusDePedido {
	
	WAITING_PAYMENT(1),PAID(2),SHIPPED(3),DELIVERED(4),CANCELED(5);
	
	private int code;
	
	private StatusDePedido(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static StatusDePedido valueOf(int code) {
		for(StatusDePedido value : StatusDePedido.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("invalid order status code ");
	}
}
