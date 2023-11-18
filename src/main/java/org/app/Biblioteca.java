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
		try {
			// Método que recibe un libro como parámetro, verifica si no está en la lista de libros y lo agrega.
			if (libro == null) {
				throw new NullPointerException("El libro no puede ser nulo");
			}

			if (libroExiste(libro)) {
				throw new IllegalArgumentException("El libro ya existe en la biblioteca");
			}

			libros.add(libro);
		} catch (NullPointerException | IllegalArgumentException ex) {
			// Manejo de excepciones específicas lanzadas anteriormente
			System.err.println("Error al agregar el libro: " + ex.getMessage());
		} catch (Exception ex) {
			// Manejo de otras excepciones no previstas
			System.err.println("Error inesperado al agregar el libro: " + ex.getMessage());
		}
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
			if (l.getIsbn().equals(libro.getIsbn())) {
				return true;
			}
		}
		return false;
	}

	public Prestamo generarPrestamo(Bibliotecario bibliotecario, Libro libro, Usuario usuario, Date fechaInicio, Date fechaTermino) {
		validarCondiciones(libro, bibliotecario, usuario, fechaInicio, fechaTermino);

		Prestamo prestamo = crearPrestamo(bibliotecario, libro, usuario, fechaInicio, fechaTermino);
		libro.setEsPrestado(true);

		return prestamo;
	}

	private void validarCondiciones(Libro libro, Bibliotecario bibliotecario, Usuario usuario, Date fechaInicio, Date fechaTermino) {
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
	}

	private Prestamo crearPrestamo(Bibliotecario bibliotecario, Libro libro, Usuario usuario, Date fechaInicio, Date fechaTermino) {
		try {
			return new Prestamo(bibliotecario, libro, usuario, fechaInicio, fechaTermino);
		} catch (Exception ex) {
			System.err.println("Error al crear el préstamo: " + ex.getMessage());
			// Puedes manejar el error de otra manera, como lanzar una excepción o devolver un valor predeterminado
			return null;
		}
	}
	@Override
	public String toString(){
		return getNombreBiblioteca() + getDireccionBiblioteca();
	}

}