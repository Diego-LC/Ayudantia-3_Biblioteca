import java.util.ArrayList;

public class Biblioteca {
	private String nombreBiblioteca;
	private String direccionBiblioteca;
	private Bibliotecario bibliotecario;
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Libro> libros = new ArrayList<Libro>();

	public void Biblioteca(String nombreBiblioteca, String direccionBiblioteca) {
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException();
	}

	public Libro buscarLibro(String nombreLibro) {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Libro> obtenerLibroPorAutor(String nombreAutor) {
		throw new UnsupportedOperationException();
	}

	private boolean libroExiste(Libro libro) {
		throw new UnsupportedOperationException();
	}

	public Prestamo generarPrestamo(Bibliotecario blibliotecario, Libro libro, Usuario usuario, Date fechaInicio, Date fechaTermino) {
		throw new UnsupportedOperationException();
	}
}