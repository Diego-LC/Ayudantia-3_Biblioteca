package org.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Prestamo {
	private Date fechaInicio;
	private Date fechaTermino;
	private Usuario usuario;
	private Bibliotecario bibliotecario;
	private Libro libro;

	public Prestamo(Bibliotecario bibliotecario, Libro libro, Usuario usuario, Date fechaInicio, Date fechaTermino) {
		this.bibliotecario = bibliotecario;
		this.libro = libro;
		this.usuario = usuario;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
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

	private String formatearFecha(Date fecha){
		return new SimpleDateFormat("dd-MM-yyyy").format(fecha);
	}

	@Override
	public String toString(){
        return formatearFecha(fechaInicio)+","+formatearFecha(fechaTermino)+","+usuario.toString()+","+libro.toString();
	}
}