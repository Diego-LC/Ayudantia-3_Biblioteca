package org.app;

public class Libro {
	private String nombreLibro;
	private String nombreAutor;
	private String nombreEditorial;
	private String isbn;
	private boolean esPrestado;
	private Prestamo prestamo;

	public Libro(String nombreLibro, String nombreAutor, String nombreEditorial, String isbn, boolean b) {
		this.nombreLibro = nombreLibro;
		this.nombreAutor = nombreAutor;
		this.nombreEditorial = nombreEditorial;
		this.isbn = isbn;
		this.esPrestado = b;
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

	public boolean getEsPrestado() {
        return this.esPrestado;
    }

	public void setEsPrestado(boolean esPrestado) {
		this.esPrestado = esPrestado;
	}

@Override
	public String toString(){
		return "["+nombreLibro+", "+nombreAutor+", "+nombreEditorial+", "+isbn+", "+String.valueOf(esPrestado)+"]";
}
}