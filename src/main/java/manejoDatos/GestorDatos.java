package manejoDatos;
import org.app.*;
import java.io.*;

public class GestorDatos {
    public void leerArchivoBiblioteca(String direccionArchivo, Biblioteca biblioteca) {
        String textoArchivo = "";
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
        //Lee cada línea del archivo hasta que la línea sea nula
            while((textoArchivo = br.readLine()) != null){
                String[] data = textoArchivo.split(",");
                biblioteca.agregarBibliotecario(data[0],data[1],data[2],Integer.parseInt(data[3]));
                String[] prestamos = data[4].split(";");
                for (String prestamo: prestamos) {
                    System.out.println(prestamo);
                }

            }
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
        //Si el documento no es nuevo y tiene registrados datos, se debe
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
