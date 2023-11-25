package org.app;

public class Usuario extends Persona {
	private String nombre;
	private String rut;
	private String numeroTelefono;
	private Prestamo prestamo;

	public Usuario() {
		throw new UnsupportedOperationException();
	}

	public Usuario(String nombre, String rut, String numTelefono) {
		this.nombre = nombre;
		this.rut = rut;
		this.numeroTelefono = numTelefono;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRut() {
		return this.rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNumeroTelefono() {
		return this.numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public Prestamo getPrestamo() {
		return this.prestamo;
	}
	
	public void setPrestamo(Prestamo prestamo) {
	this.prestamo = prestamo;
	}

	@Override
	public String toString(){
		return nombre+","+rut+","+numeroTelefono;
	}
}