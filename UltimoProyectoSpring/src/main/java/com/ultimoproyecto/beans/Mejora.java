package com.ultimoproyecto.beans;

public class Mejora {
	
	private int idmejora;
	private String fecha;
	private String motivo;
	private String actividades;
	private String estado;
	private int cliente_id;
	
	public Mejora() {
		super();
	}

	public Mejora(int idmejora, String fecha, String motivo, String actividades, String estado, int cliente_id) {
		super();
		this.idmejora = idmejora;
		this.fecha = fecha;
		this.motivo = motivo;
		this.actividades = actividades;
		this.estado = estado;
		this.cliente_id = cliente_id;
	}

	public int getIdmejora() {
		return idmejora;
	}

	public void setIdmejora(int idmejora) {
		this.idmejora = idmejora;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getActividades() {
		return actividades;
	}

	public void setActividades(String actividades) {
		this.actividades = actividades;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	@Override
	public String toString() {
		return "Mejora [idmejora=" + idmejora + ", fecha=" + fecha + ", motivo=" + motivo + ", actividades="
				+ actividades + ", estado=" + estado + ", cliente_id=" + cliente_id + "]";
	}
		
	
}