package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle.Control;

import javax.swing.JButton;

import org.app.Biblioteca;

import launcher.Controlador;

public class VentanaPrincipal extends VentanaGeneral {
    private Biblioteca biblioteca;
    private JButton botonAgregarLibro;
    private JButton botonBuscarLibro;
    private JButton botonAgregarUsuario;
    private JButton botonBuscarUsuario;
    private JButton botonSalir;

    public VentanaPrincipal(Biblioteca biblioteca) {
        super( "Ventana Principal", 500, 500);
        this.biblioteca = biblioteca;
        this.generarElementos();
    }

    private void generarElementos() {
        super.generarJLabelEncabezado(null, "Biblioteca", 100, 20, 300, 30);
        this.generarBotonAgregarLibro();
        this.generarBotonBuscarLibro();
        this.generarBotonAgregarUsuario();
        this.generarBotonBuscarUsuario();
        this.generarBotonSalir();
    }
    private void generarBotonAgregarLibro() {
        JButton btnAgregarLibro = super.generarBoton("Agregar libro", 100, 70, 300, 50);
        this.botonAgregarLibro = btnAgregarLibro;
        this.add(btnAgregarLibro);
        this.botonAgregarLibro.addActionListener(this);
    }

    private void generarBotonBuscarLibro() {
        JButton btnBuscarLibro = super.generarBoton("Buscar libro", 100, 130, 300, 50);
        this.botonBuscarLibro = btnBuscarLibro;
        this.add(btnBuscarLibro);
        this.botonBuscarLibro.addActionListener(this);
    }
    private void generarBotonAgregarUsuario() {
        JButton btnAgregarUsuario = super.generarBoton("Agregar usuario", 100, 190, 300, 50);
        this.botonAgregarUsuario = btnAgregarUsuario;
        this.add(btnAgregarUsuario);
        this.botonAgregarUsuario.addActionListener(this);
    }
    private void generarBotonBuscarUsuario() {
        JButton btnBuscarUsuario = super.generarBoton("Buscar usuario", 100, 250, 300, 50);
        this.botonBuscarUsuario = btnBuscarUsuario;
        this.add(btnBuscarUsuario);
        this.botonBuscarUsuario.addActionListener(this);
    }

    private void generarBotonSalir() {
        JButton btnSalir = super.generarBoton("Salir", 100, 310, 300, 50);
        this.botonSalir = btnSalir;
        this.add(btnSalir);
        this.botonSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonAgregarLibro){
            // Crea una nueva instancia de VentanaLibro y la muestra
            VentanaAgregarLibro ventanaAgregarLibro = new VentanaAgregarLibro(biblioteca, VentanaPrincipal.this);
            ventanaAgregarLibro.setVisible(true);
            // Opcional: oculta la ventana principal
            setVisible(false);
        }

        if (e.getSource() == this.botonBuscarLibro){
            // Crea una nueva instancia de VentanaBuscarLibro y la muestra
            VentanaBuscarLibro ventanaBuscarLibro = new VentanaBuscarLibro(biblioteca, VentanaPrincipal.this);
            ventanaBuscarLibro.setVisible(true);
            // Opcional: oculta la ventana principal
            setVisible(false);
        }

        if (e.getSource() == this.botonAgregarUsuario){
            // Crea una nueva instancia de VentanaAgregarUsuario y la muestra
            VentanaAgregarUsuario ventanaAgregarUsuario = new VentanaAgregarUsuario(biblioteca, VentanaPrincipal.this);
            ventanaAgregarUsuario.setVisible(true);
            // Opcional: oculta la ventana principal
            setVisible(false);
        }

        if (e.getSource() == this.botonBuscarUsuario){
            // Crea una nueva instancia de VentanaBuscarUsuario y la muestra
            VentanaBuscarUsuario ventanaBuscarUsuario = new VentanaBuscarUsuario(biblioteca, VentanaPrincipal.this);
            ventanaBuscarUsuario.setVisible(true);
            // Opcional: oculta la ventana principal
            setVisible(false);
        }
        
        if (e.getSource() == this.botonSalir){
            Controlador controlador = new Controlador();
            controlador.guardarDatos(biblioteca);
            // Cierra la ventana
            System.exit(0);
        }
    }
}