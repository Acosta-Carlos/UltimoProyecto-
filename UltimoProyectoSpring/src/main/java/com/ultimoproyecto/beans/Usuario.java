package com.ultimoproyecto.beans;

public class Usuario {

	private int idusuario;
	private String username;
	private String password;
	private String role;
	private String nombre;
	private String correoelectronico;
	private int activado;
  
  
  	public Usuario(String username, String password, String role, String nombre, String correoelectronico, int activado) {
	this.username = username;
	this.password = password;
	this.role = role;
	this.nombre = nombre;
	this.correoelectronico = correoelectronico;
	this.activado = activado;
}


	public Usuario() {
		// TODO Auto-generated constructor stub
	}


	public int getIdusuario() {
		return idusuario;
	}


	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCorreoelectronico() {
		return correoelectronico;
	}


	public void setCorreoelectronico(String correoelectronico) {
		this.correoelectronico = correoelectronico;
	}


	public int getActivado() {
		return activado;
	}


	public void setActivado(int activado) {
		this.activado = activado;
	}


	@Override
	public String toString() {
		return "User [idusuario=" + idusuario + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", nombre=" + nombre + ", correoelectronico=" + correoelectronico + ", activado=" + activado + "]";
	}

  
}