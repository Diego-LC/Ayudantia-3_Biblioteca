package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.app.Biblioteca;

public class VentanaPrincipal extends VentanaGeneral {
    private Biblioteca biblioteca;
    
    public VentanaPrincipal(Biblioteca biblioteca) {
        super( "Ventana Principal", 500, 500);
        this.biblioteca = biblioteca;
        this.generarElementos();
    }

    private void generarElementos() {
        super.generarJLabelEncabezado(null, "Biblioteca", 200, 50, 100, 30);
        this.generarBotonAgregarLibro();
        this.generarBotonBuscarLibro();
        this.generarBotonAgregarUsuario();
        this.generarBotonBuscarUsuario();
    }
    private void generarBotonAgregarLibro() {
        JButton btnAgregarLibro = super.generarBoton("Agregar libro", 100, 100, 300, 50);
        this.add(btnAgregarLibro);
        btnAgregarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crea una nueva instancia de VentanaLibro y la muestra
            VentanaLibro ventanaLibro = new VentanaLibro(biblioteca, VentanaPrincipal.this);
            ventanaLibro.setVisible(true);
            // Opcional: oculta la ventana principal
            setVisible(false);
            }
        });
    }
    private void generarBotonBuscarLibro() {
        JButton btnBuscarLibro = super.generarBoton("Buscar libro", 100, 200, 300, 50);
        this.add(btnBuscarLibro);
        btnBuscarLibro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para buscar libro
            }
        });
    }
    private void generarBotonAgregarUsuario() {
        JButton btnAgregarUsuario = super.generarBoton("Agregar usuario", 100, 300, 300, 50);
        this.add(btnAgregarUsuario);
        btnAgregarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para agregar usuario
            }
        });
    }
    private void generarBotonBuscarUsuario() {
        JButton btnBuscarUsuario = super.generarBoton("Buscar usuario", 100, 400, 300, 50);
        this.add(btnBuscarUsuario);
        btnBuscarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para buscar usuario
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Este método se activará cuando ocurra un evento de acción en un componente que no tenga su propio ActionListener.
    }
}