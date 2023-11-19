package launcher;
import org.app.*;
import manejoDatos.GestorDatos;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("UfroBib", "Dirección");
        biblioteca.agregarBibliotecario("nombreBibliotecario", "20123456-7", "direccion Bibliotecario", 1234567);
        Bibliotecario bibliotecario = biblioteca.getBibliotecario();

        Libro libro1 = new Libro("nombreLibro1","nombreAutor1","nombreEditorial1", "isbn123", false);
        Libro libro2 = new Libro("nombreLibro2","nombreAutor2","nombreEditorial2", "isbn234", false);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        Usuario usuario = new Usuario("nombreUsuario1", "rutUsuario1", "numTelefonoUsuario1");
        try {
            biblioteca.generarPrestamo(libro1, usuario, sdf.parse("18-11-2023"), sdf.parse("28-11-2023"));
        } catch (ParseException e) {
            System.err.println("error: "+ e.getMessage());
        }

        guardarPrestamos(bibliotecario);
        guardarLibros(biblioteca);

        Biblioteca biblioteca2 = new Biblioteca("Nombre2", "Direccion2");

        GestorDatos gd = new GestorDatos();
        gd.leerArchivoPrestamosbiblioteca(biblioteca2, "prestamosBiblioteca.txt");
        gd.leerArchivoLibrosBiblioteca(biblioteca2, "librosBiblioteca.txt");
    }

    private static void guardarPrestamos(Bibliotecario bibliotecario){
        GestorDatos gd = new GestorDatos();
        gd.registrarDato(bibliotecario, "prestamosBiblioteca.txt");
        for (Prestamo prestamo: bibliotecario.getPrestamos()) {
            gd.registrarDato(prestamo, "prestamosBiblioteca.txt");
        }
    }
    private static void guardarLibros(Biblioteca biblioteca){
        GestorDatos gd = new GestorDatos();
        for (Libro libro: biblioteca.getLibros()) {
            gd.registrarDato(libro, "librosBiblioteca.txt");
        }
    }

}
