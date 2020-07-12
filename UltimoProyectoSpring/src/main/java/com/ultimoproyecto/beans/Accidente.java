package com.ultimoproyecto.beans;

public class Accidente {

	private int idaccidente;
	private String fecha;
	private String hora;
	private String suceso;
	private String lugar;
	private int cliente_id;

	public Accidente(int idaccidente, String fecha, String hora, String suceso, String lugar, int cliente_id) {
		this.idaccidente = idaccidente;
		this.fecha = fecha;
		this.hora = hora;
		this.suceso = suceso;
		this.lugar = lugar;
		this.cliente_id = cliente_id;
	}

	public Accidente() {
		// TODO Auto-generated constructor stub
	}


	public int getIdaccidente() {
		return idaccidente;
	}


	public void setIdaccidente(int idaccidente) {
		this.idaccidente = idaccidente;
	}


	public String getFecha() {
		return fecha;
	}




	public void setFecha(String fecha) {
		this.fecha = fecha;
	}




	public String getHora() {
		return hora;
	}




	public void setHora(String hora) {
		this.hora = hora;
	}




	public String getSuceso() {
		return suceso;
	}




	public void setSuceso(String suceso) {
		this.suceso = suceso;
	}




	public String getLugar() {
		return lugar;
	}




	public void setLugar(String lugar) {
		this.lugar = lugar;
	}




	public int getCliente_id() {
		return cliente_id;
	}




	public void setCliente_id(int clienteid) {
		this.cliente_id = clienteid;
	}




	@Override
	public String toString() {
		return "Accidente [idaccidente=" + idaccidente + ", fecha=" + fecha + ", hora=" + hora + ", suceso=" + suceso
				+ ", lugar=" + lugar + ", cliente_id=" + cliente_id + "]";
	}
	
	
}
