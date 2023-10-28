package org.app;

public class Libro {
	private String nombreLibro;
	private String nombreAutor;
	private String nombreEditorial;
	private String isbn;

	public void Libro(String nombreLibro, String nombreAutor, String nombreEditorial) {
		throw new UnsupportedOperationException();
	}

	public String getNombreLibro() {
		return this.nombreLibro;
	}

	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}

	public String getNombreAutor() {
		return this.nombreAutor;
	}

	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}

	public String getNombreEditorial() {
		return this.nombreEditorial;
	}

	public void setNombreEditorial(String nombreEditorial) {
		this.nombreEditorial = nombreEditorial;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
}