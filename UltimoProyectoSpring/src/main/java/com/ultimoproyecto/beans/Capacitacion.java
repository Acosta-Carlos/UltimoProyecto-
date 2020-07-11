package com.ultimoproyecto.beans;

public class Capacitacion {
	
	public int idcapacitacion;
	public String fecha;
	public String hora;
	public int numasistentes;
	public int idvisita;
	public Capacitacion(int idcapacitacion, String fecha, String hora, int numasistentes, int idvisita) {
		super();
		this.idcapacitacion = idcapacitacion;
		this.fecha = fecha;
		this.hora = hora;
		this.numasistentes = numasistentes;
		this.idvisita = idvisita;
	}
	
	public Capacitacion() {
		
		
	}
	
	public int getIdcapacitacion() {
		return idcapacitacion;
	}
	public void setIdcapacitacion(int idcapacitacion) {
		this.idcapacitacion = idcapacitacion;
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
	public int getNumasistentes() {
		return numasistentes;
	}
	public void setNumasistentes(int numasistentes) {
		this.numasistentes = numasistentes;
	}
	public int getIdvisita() {
		return idvisita;
	}
	public void setIdvisita(int idvisita) {
		this.idvisita = idvisita;
	}
	@Override
	public String toString() {
		return "Capacitacion [idcapacitacion=" + idcapacitacion + ", fecha=" + fecha + ", hora=" + hora
				+ ", numasistentes=" + numasistentes + ", idvisita=" + idvisita + "]";
	}



}