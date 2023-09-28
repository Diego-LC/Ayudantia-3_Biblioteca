package org.app;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Biblioteca {
    private final List<Libro> libros = new ArrayList<>();
    private String nombreBiblioteca;
    private String direccionBiblioteca;

    public Biblioteca(Libro libro, String nombre, String direccion) {
        this.libros.add(libro);
        this.nombreBiblioteca = nombre;
        this.direccionBiblioteca = direccion;
    }
    public List<Libro> getListaLibros(){
        return this.libros;
    }
    public String getNombreBiblioteca(){
        return this.nombreBiblioteca;
    }
    public String getDireccionBiblioteca(){
        return this.direccionBiblioteca;
    }
    public void setLibro(Libro libro){
        this.libros.add(libro);
    }
    public void setNombreBiblioteca(String nombreBiblioteca){
        this.nombreBiblioteca = nombreBiblioteca;
    }
    public void setDireccionBiblioteca(String direccionBiblioteca){
        this.direccionBiblioteca = direccionBiblioteca;
    }
}