package ventanas;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.app.Biblioteca;

public class VentanaAgregarLibro extends VentanaGeneral {
    private final Biblioteca biblioteca;
    private VentanaPrincipal ventanaPrincipal;
    private JTextField textFieldNombreLibro;
    private JTextField textFieldNombreAutor;
    private JTextField textFieldNombreEditorial;
    private JTextField textFieldISBN;
    private JButton botonAgregarLibro;
    private JButton botonVolver;

    public VentanaAgregarLibro(Biblioteca biblioteca, VentanaPrincipal ventanaPrincipal) {
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
        this.generarBotonAgregarLibro();
        this.generarBotonVolver();
    }

    private void generarInputTextFieldNombreLibro() {
        JTextField textField = super.generarJTextField(100, 90, 300, 30);
        this.textFieldNombreLibro = textField;
        this.add(textField);
    }

    private void generarInputTextFieldNombreAutor() {
        JTextField textField = super.generarJTextField(100, 150, 300, 30);
        this.textFieldNombreAutor = textField;
        this.add(textField);
    }

    private void generarInputTextFieldNombreEditorial() {
        JTextField textField = super.generarJTextField(100, 210, 300, 30);
        this.textFieldNombreEditorial = textField;
        this.add(textField);
    }

    private void generarInputTextFieldISBN() {
        JTextField textField = super.generarJTextField(100, 270, 300, 30);
        this.textFieldISBN = textField;
        this.add(textField);
    }

    private void generarBotonAgregarLibro() {
        JButton jbAgregarLibro = super.generarBoton("Agregar libro", 100, 330, 300, 50);
        this.add(jbAgregarLibro);
        this.botonAgregarLibro = jbAgregarLibro;
        this.botonAgregarLibro.addActionListener(this);
    }

    private void generarBotonVolver() {
        JButton volver = super.generarBoton("Volver", 100, 390, 300, 50);
        this.botonVolver = volver;
        this.add(volver);
        this.botonVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.botonAgregarLibro == e.getSource()){
            // Código para agregar libro
            String nombreLibro = textFieldNombreLibro.getText();
            String nombreAutor = textFieldNombreAutor.getText();
            String nombreEditorial = textFieldNombreEditorial.getText();
            String ISBN = textFieldISBN.getText();
            if (biblioteca.setNewLibro(nombreLibro, nombreAutor, nombreEditorial, ISBN)){
                System.out.println("Libro agregado");
            } else {
                System.out.println("Libro ya existe con ese ISBN");
            }
            ventanaPrincipal.setVisible(true);
            // Opcional: oculta la ventana agregar libro
            setVisible(false);
        }
        if (e.getSource() == this.botonVolver){
            // Hace visible la ventana principal
            ventanaPrincipal.setVisible(true);
            // Hace invisible la ventana actual
            dispose();
        }
    }
}
