package org.app;

import java.util.ArrayList;
import java.util.Date;

import launcher.Controlador;

public class Biblioteca {
	private String nombreBiblioteca;
	private String direccionBiblioteca;
	private Bibliotecario bibliotecario;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Libro> libros = new ArrayList<Libro>();

	public Biblioteca(String nombre, String direccion) {
		this.nombreBiblioteca = nombre;
		this.direccionBiblioteca = direccion;
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

	public void setBibliotecario(Bibliotecario bibliotecario){
		this.bibliotecario = bibliotecario;
	}
	public Bibliotecario getBibliotecario(){
		return this.bibliotecario;
	}

	public boolean setNewLibro(String nombreLibro, String nombreAutor, String nombreEditorial, String isbn){
		Libro libro = new Libro(nombreLibro, nombreAutor, nombreEditorial, isbn, false);
		if (libroExiste(libro)){
			return false;
		}
		this.libros.add(libro);
		return true;
	}

	public void setLibro(Libro libro) {
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
			System.err.println("Error al agregar el libro: " + ex.getMessage());
		} catch (Exception ex) {
			// Manejo de otras excepciones no previstas
			System.err.println("Error inesperado al agregar el libro: " + ex.getMessage());
		}
	}

	public ArrayList<Libro> getLibros(){
		return this.libros;
	}

	public ArrayList<Libro> buscarLibroPorNombre(String nombreLibro) {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		for (Libro l : this.libros) {
			if (l.getNombreLibro().toLowerCase().contains(nombreLibro.toLowerCase())) {
				libros.add(l);
			}
		}
		return libros;
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

	public Prestamo generarPrestamo(Libro libro, Usuario usuario, Date fechaInicio, Date fechaTermino) {
		validarCondicionesPrestamo(libro, usuario, fechaInicio, fechaTermino);

		Prestamo prestamo = crearPrestamo(libro, usuario, fechaInicio, fechaTermino);
		libro.setEsPrestado(true);
		this.bibliotecario.agregarPrestamo(prestamo);
		usuario.setPrestamo(prestamo);
		this.usuarios.add(usuario);
		return prestamo;
	}

	private void validarCondicionesPrestamo(Libro libro, Usuario usuario, Date fechaInicio, Date fechaTermino) {
		try{
			if (!libroExiste(libro)) {
				throw new IllegalArgumentException("El libro no existe en la biblioteca");
			}

			if (libro.getEsPrestado()) {
				throw new IllegalStateException("El libro ya está prestado");
			}

			if (this.bibliotecario == null || usuario == null || fechaInicio == null || fechaTermino == null) {
				throw new NullPointerException("Ningún argumento puede ser nulo");
			}

			if (fechaInicio.after(fechaTermino)) {
				throw new IllegalArgumentException("La fecha de inicio debe ser anterior a la fecha de término");
			}
		}
		catch (IllegalArgumentException | IllegalStateException | NullPointerException ex){
			System.err.println("ex.getMessage() = " + ex.getMessage());
		}
		catch (Exception ex){
			System.err.println("Error: " + ex.getMessage());
		}
	}

	private Prestamo crearPrestamo(Libro libro, Usuario usuario, Date fechaInicio, Date fechaTermino) {
		try {
			libro.setEsPrestado(true);
			return new Prestamo(this.bibliotecario, libro, usuario, fechaInicio, fechaTermino);
		} catch (Exception ex) {
			System.err.println("Error al crear el préstamo: " + ex.getMessage());
			// Puedes manejar el error de otra manera, como lanzar una excepción o devolver un valor predeterminado
			return null;
		}
	}
	
	public boolean setNewUsuario(String nombreUsuario, String rutUsuario, String numeroTelefono) {
		Usuario usuario = new Usuario(nombreUsuario, rutUsuario, numeroTelefono);
		if (usuarioExiste(usuario)){
			return false;
		}
		this.usuarios.add(usuario);
		return true;
	}

	public void setUsuario(Usuario usuario) {
		try {
			// Método que recibe un usuario como parámetro, verifica si no está en la lista de usuarios y lo agrega.
			if (usuario == null) {
				throw new NullPointerException("El usuario no puede ser nulo");
			}

			if (usuarioExiste(usuario)) {
				throw new IllegalArgumentException("El usuario ya existe en la biblioteca");
			}

			usuarios.add(usuario);
		} catch (NullPointerException | IllegalArgumentException ex) {
			System.err.println("Error al agregar el usuario: " + ex.getMessage());
		} catch (Exception ex) {
			// Manejo de otras excepciones no previstas
			System.err.println("Error inesperado al agregar el usuario: " + ex.getMessage());
		}
	}

	public ArrayList<Usuario> getUsuarios(){
		return this.usuarios;
	}

	public ArrayList<String> buscarUsuarioPorNombre(String nombreUsuario) {
		ArrayList usuarios = new ArrayList<String>();
		for (Usuario u : this.usuarios) {
			if (u.getNombre().toLowerCase().contains(nombreUsuario.toLowerCase())) {
				usuarios.add(u.getNombre());
			}
		}
		return usuarios;
	}

	private boolean usuarioExiste(Usuario usuario) {
		for (Usuario u : this.usuarios) {
			if (u.getRut().equals(usuario.getRut())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString(){
		return this.bibliotecario.toString()+", "+this.libros.toString();
	}
}