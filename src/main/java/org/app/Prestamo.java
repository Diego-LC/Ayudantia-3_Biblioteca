package org.app;

import java.util.ArrayList;
import java.util.Date;

public class Prestamo {
	private Date fechaInicio;
	private Date fechaTermino;
	private Usuario usuario;
	private Bibliotecario bibliotecario;
	private ArrayList<Libro> libro = new ArrayList<Libro>();

	public Prestamo(Bibliotecario bibliotecario, Libro libro, Usuario usuario, Date fechaInicio, Date fechaTermino) {
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaTermino() {
		return this.fechaTermino;
	}

	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public Prestamo() {
		throw new UnsupportedOperationException();
	}
}