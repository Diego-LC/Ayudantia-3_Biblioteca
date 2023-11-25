package launcher;

import org.app.*;
import ventanas.VentanaPrincipal;

public class Main {
    public static void main(String[] args) {
        Controlador controlador = new Controlador();

        new VentanaPrincipal(controlador.iniciarSistema());
    }
}
