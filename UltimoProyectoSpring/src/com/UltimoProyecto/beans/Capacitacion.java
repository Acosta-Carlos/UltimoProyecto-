package com.UltimoProyecto.beans;

public class Capacitacion {
	
	public int id_capacitacion;
	public String fecha;
	public String hora;
	public int num_asistentes;
	public int id_visita;
	
	public Capacitacion(int id_capacitacion, String fecha, String hora, int num_asistentes, int id_visita) {
		
		this.id_capacitacion = id_capacitacion;
		this.fecha = fecha;
		this.hora = hora;
		this.num_asistentes = num_asistentes;
		this.id_visita = id_visita;
	}
	public Capacitacion() {
		
	}

	public int getId_capacitacion() {
		return id_capacitacion;
	}

	public void setId_capacitacion(int id_capacitacion) {
		this.id_capacitacion = id_capacitacion;
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

	public int getNum_asistentes() {
		return num_asistentes;
	}

	public void setNum_asistentes(int num_asistentes) {
		this.num_asistentes = num_asistentes;
	}

	public int getId_visita() {
		return id_visita;
	}

	public void setId_visita(int id_visita) {
		this.id_visita = id_visita;
	}

	@Override
	public String toString() {
		return "Capacitacion [id_capacitacion=" + id_capacitacion + ", fecha=" + fecha + ", hora=" + hora
				+ ", num_asistentes=" + num_asistentes + ", id_visita=" + id_visita + "]";
	}
	
	
	
	

}
