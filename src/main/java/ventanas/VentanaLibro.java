package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.app.Biblioteca;

public class VentanaLibro extends VentanaGeneral {
    private final Biblioteca biblioteca;
    private VentanaPrincipal ventanaPrincipal;

    public VentanaLibro(Biblioteca biblioteca, VentanaPrincipal ventanaPrincipal) {
        super( "Ventana Libro", 500, 500);
        this.biblioteca = biblioteca;
        this.ventanaPrincipal = ventanaPrincipal;
        this.generarElementos();
    }

    private void generarElementos() {
        super.generarJLabelEncabezado(null, "Agregar Libro", 100, 20, 300, 30);
        super.generarJLabel(null,"Ingrese el nombre del libro", 100, 60, 300, 30);
        this.generarInputTextFieldNombreLibro();
        super.generarJLabel(null,"Ingrese el nombre del autor", 100, 120, 300, 30);
        this.generarInputTextFieldNombreAutor();
        super.generarJLabel(null,"Ingrese el nombre de la editorial", 100, 180, 300, 30);
        this.generarInputTextFieldNombreEditorial();
        super.generarJLabel(null,"Ingrese el ISBN", 100, 240, 300, 30);
        this.generarInputTextFieldISBN();
        this.generarBotonAgrgarLibro();
        this.generarBotonVolver();
    }

    private void generarInputTextFieldNombreLibro() {
        JTextField textField = super.generarJTextField(100, 90, 300, 30);
        this.add(textField);
    }

    private void generarInputTextFieldNombreAutor() {
        JTextField textField = super.generarJTextField(100, 150, 300, 30);
        this.add(textField);
    }

    private void generarInputTextFieldNombreEditorial() {
        JTextField textField = super.generarJTextField(100, 210, 300, 30);
        this.add(textField);
    }

    private void generarInputTextFieldISBN() {
        JTextField textField = super.generarJTextField(100, 270, 300, 30);
        this.add(textField);
    }

    private void generarBotonAgrgarLibro() {
        JButton agregarLibro = super.generarBoton("Agregar libro", 100, 330, 300, 50);
        this.add(agregarLibro);
    }

    private void generarBotonVolver() {
        JButton volver = super.generarBoton("Volver", 100, 390, 300, 50);
        this.add(volver);
        volver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Hace visible la ventana principal
                ventanaPrincipal.setVisible(true);
                // Hace invisible la ventana actual
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
