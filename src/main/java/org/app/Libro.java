package org.app;

import java.util.ArrayList;
import java.util.List;

public class Libro {
    private String nombreLibro;
    private String nombreAutor;
    private String nombreEditorial;

    public Libro(String libro, String autor, String editorial){
        this.nombreLibro = libro;
        this.nombreAutor = autor;
        this.nombreEditorial = editorial;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }
}
