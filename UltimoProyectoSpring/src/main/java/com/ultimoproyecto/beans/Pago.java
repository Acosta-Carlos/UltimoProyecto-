package com.ultimoproyecto.beans;

public class Pago {

	private int idpago;
	private String mesanio;
	private int montoregular;
	private int montoadicionales;
	private int idcliente;


	public Pago() {
		// TODO Auto-generated constructor stub
	}

	public Pago(int idpago, String mesanio, int montoregular, int montoadicionales, int idcliente) {
		this.idpago = idpago;
		this.mesanio = mesanio;
		this.montoregular = montoregular;
		this.montoadicionales = montoadicionales;
		this.idcliente = idcliente;
	}


	public int getIdpago() {
		return idpago;
	}




	public void setIdpago(int idpago) {
		this.idpago = idpago;
	}


	public String getMesanio() {
		return mesanio;
	}


	public void setMesanio(String mesanio) {
		this.mesanio = mesanio;
	}


	public int getMontoregular() {
		return montoregular;
	}


	public void setMontoregular(int montoregular) {
		this.montoregular = montoregular;
	}


	public int getMontoadicionales() {
		return montoadicionales;
	}


	public void setMontoadicionales(int montoadicionales) {
		this.montoadicionales = montoadicionales;
	}


	public int getIdcliente() {
		return idcliente;
	}



	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}


	@Override
	public String toString() {
		return "Pago [idpago=" + idpago + ", mesanio=" + mesanio + ", montoregular=" + montoregular + ", montoadicionales=" + montoadicionales + ", idcliente=" + idcliente + "]";
	}
	
	
	
}
