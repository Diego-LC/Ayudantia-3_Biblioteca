package launcher;

import org.app.Biblioteca;
import org.app.Bibliotecario;
import org.app.Libro;
import org.app.Prestamo;
import ventanas.*;

import manejoDatos.GestorDatos;

public class Controlador {
    Biblioteca biblioteca;
    public Biblioteca iniciarSistema() {
        this.biblioteca = leerArchivosBiblioteca();

        return biblioteca;
    }

    public void guardarDatos(Biblioteca biblioteca){
        guardarPrestamos(biblioteca.getBibliotecario());
        guardarLibros(biblioteca);
    }

    private Biblioteca leerArchivosBiblioteca() {
        Biblioteca biblioteca = new Biblioteca("NombreBiblioteca", "DireccionBiblioteca");
        GestorDatos gd = new GestorDatos();
        gd.leerArchivoPrestamosbiblioteca(biblioteca, "prestamosBiblioteca.txt");
        gd.leerArchivoLibrosBiblioteca(biblioteca, "librosBiblioteca.txt");
        return biblioteca;
    }

    private void guardarPrestamos(Bibliotecario bibliotecario) {
        GestorDatos gd = new GestorDatos();
        gd.registrarDato(bibliotecario, "prestamosBiblioteca.txt");
        int guardado = 0;
        for (Prestamo prestamo : bibliotecario.getPrestamos()) {
            if (gd.registrarDato(prestamo, "prestamosBiblioteca.txt")){
                guardado += 1;
            }else{  
                System.out.println("Error al guardar prestamo");
            }
        }
        System.out.printf("Se guardaron %d prestamos\n", guardado);
    }

    private void guardarLibros(Biblioteca biblioteca) {
        GestorDatos gd = new GestorDatos();
        int guardado = 0;
        for (Libro libro : biblioteca.getLibros()) {
            if (gd.registrarDato(libro, "librosBiblioteca.txt")){
                guardado += 1;
            }else{
                System.out.println("Error al guardar libro");
            }
        }
        System.out.printf("Se guardaron %d libros\n", guardado);
    }
}
