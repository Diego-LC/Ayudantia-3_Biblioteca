package launcher;

import org.app.*;
import manejoDatos.GestorDatos;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();
        controlador.iniciarSistema();
    }
}
