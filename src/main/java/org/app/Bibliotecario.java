package org.app;

public class Bibliotecario {
	private String nombre;
	private String rut;
	private String direccion;
	private int idBibliotecario;
	private Biblioteca biblioteca;
	private Prestamo prestamo;

	public void Bibliotecario() {
		throw new UnsupportedOperationException();
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

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getIdBibliotecario() {
		return this.idBibliotecario;
	}

	public void setIdBibliotecario(int idBibliotecario) {
		this.idBibliotecario = idBibliotecario;
	}

	@Override
	public String toString() {
		return getNombre() + ", " + getRut() + ", " + getDireccion() + ", " + getIdBibliotecario();
	}
}