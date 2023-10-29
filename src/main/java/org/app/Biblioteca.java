package org.app;

import java.util.ArrayList;
import java.util.Date;

public class Biblioteca {
	private String nombreBiblioteca;
	private String direccionBiblioteca;
	private Bibliotecario bibliotecario;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Libro> libros = new ArrayList<Libro>();

	public Biblioteca(String nombreBiblioteca, String direccionBiblioteca) {
		this.nombreBiblioteca = nombreBiblioteca;
		this.direccionBiblioteca = direccionBiblioteca;
	}

	public String getNombreBiblioteca() {
		return this.nombreBiblioteca;
	}

	public void setNombreBiblioteca(String nombreBiblioteca) {
		this.nombreBiblioteca = nombreBiblioteca;
	}

	public String getDireccionBiblioteca() {
		return this.direccionBiblioteca;
	}

	public void setDireccionBiblioteca(String direccionBiblioteca) {
		this.direccionBiblioteca = direccionBiblioteca;
	}

	public void agregarLibro(Libro libro) {
		//Método que reciba como parámetro un libro, verifique que no está en la lista de libros y lo agregue.
		if (libro == null) {
			throw new NullPointerException("El libro no puede ser nulo");
		}
		if (libroExiste(libro)) {
			throw new IllegalArgumentException("El libro ya existe en la biblioteca");
		}
		libros.add(libro);
	}

	public Libro buscarLibro(String nombreLibro) {
		for (Libro l : this.libros) {
			if (l.getNombreLibro().equals(nombreLibro)) {
				return l;
			}
		}
		return null;
	}

	public ArrayList<Libro> obtenerLibroPorAutor(String nombreAutor) {
		ArrayList<Libro> librosAutor = new ArrayList<Libro>();
		for (Libro l : this.libros) {
			if (l.getNombreAutor().equals(nombreAutor)) {
				librosAutor.add(l);
			}
		}
		return librosAutor;
	}

	private boolean libroExiste(Libro libro) {
		for (Libro l : this.libros) {
			if (l.equals(libro)) {
				return true;
			}
		}
		return false;
	}

	public Prestamo generarPrestamo(Bibliotecario blibliotecario, Libro libro, Usuario usuario, Date fechaInicio, Date fechaTermino) {
		if (!libroExiste(libro)) {
			throw new IllegalArgumentException("El libro no existe en la biblioteca");
		}
		if (libro.getEsPrestado()) {
			throw new IllegalStateException("El libro ya está prestado");
		}
		if (bibliotecario == null || usuario == null || fechaInicio == null || fechaTermino == null) {
			throw new NullPointerException("Ningún argumento puede ser nulo");
		}
		if (fechaInicio.after(fechaTermino)) {
			throw new IllegalArgumentException("La fecha de inicio debe ser anterior a la fecha de término");
		}
		Prestamo prestamo = new Prestamo(bibliotecario, libro, usuario, fechaInicio, fechaTermino);
		libro.setEsPrestado(true);
		return prestamo;
	}
}