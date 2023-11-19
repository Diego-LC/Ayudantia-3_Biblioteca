package org.app;

import java.util.ArrayList;

public class Bibliotecario {
	private String nombre;
	private String rut;
	private String direccion;
	private int idBibliotecario;
	private Biblioteca biblioteca;
	private ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();

	public Bibliotecario(String nombre, String rut, String direccion, int idBibliotecario) {
		this.nombre = nombre;
		this.rut = rut;
		this.direccion = direccion;
		this.idBibliotecario = idBibliotecario;
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

	public void agregarPrestamo(Prestamo prestamo) {
		this.prestamos.add(prestamo);
	}

	public ArrayList<Prestamo> getPrestamos(){
		return this.prestamos;
	}

	@Override
	public String toString() {
		return getNombre() + "," + getRut() + "," + getDireccion() + "," + getIdBibliotecario();
	}

}