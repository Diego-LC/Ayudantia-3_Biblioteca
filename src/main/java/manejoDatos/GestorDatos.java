package manejoDatos;
import org.app.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class GestorDatos {
    public void leerArchivoPrestamosbiblioteca(Biblioteca biblioteca, String direccionArchivo) {
        String textoArchivo = "";
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
        //Lee cada línea del archivo hasta que la línea sea nula
            int contador = 1;
            while((textoArchivo = br.readLine()) != null){
                if (contador == 1){
                    String[] data = textoArchivo.split(",");
                    biblioteca.setBibliotecario(new Bibliotecario(data[0],data[1],data[2],Integer.parseInt(data[3])));
                }else{
                    String[] data = textoArchivo.split(",");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    Usuario usuario = new Usuario(data[2],data[3],data[4]);
                    Libro libro = new Libro(data[5],data[6],data[7],data[8],false);
                    biblioteca.setLibro(libro);
                    biblioteca.generarPrestamo(libro, usuario, sdf.parse(data[0]),sdf.parse(data[1]));
                }
                contador++;
            }
            br.close();
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw); // Limpia el archivo
            bw.close();
        } catch (Exception e) {
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
    }

    public void leerArchivoLibrosBiblioteca(Biblioteca biblioteca, String direccionArchivo) {
        String textoArchivo = "";
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
        //Lee cada línea del archivo hasta que la línea sea nula
            while((textoArchivo = br.readLine()) != null){
                String[] data = textoArchivo.split(",");
                Libro libro = new Libro(data[0],data[1],data[2],data[3],Boolean.parseBoolean(data[4]));
                biblioteca.setLibro(libro);
            }
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw); // Limpia el archivo
            bw.close();
            br.close();
        } catch (Exception e) {
            System.out.println("Documento no disponible, favor contactar con administrador");
        }
    }

    public boolean registrarDato(Object objeto, String direccionArchivo) {
        boolean lineaVacia=false;
        try {
            File file = new File(direccionArchivo);
            if (!file.exists()) {
                file.createNewFile();
                lineaVacia=true;
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
        //Si el documento no es nuevo y tiene registrados datos, se debe crear un salto de línea
            if(!lineaVacia){
                bw.newLine();
            }
            bw.write(objeto.toString());
            bw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al ingresar dato, favor contactar con administrador: " + e.getMessage());
            return false;
        }
    }

}
