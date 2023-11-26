package ventanas;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.app.Biblioteca;
import org.app.Libro;

public class VentanaBuscarLibro extends VentanaGeneral {
    private Biblioteca biblioteca;
    private VentanaPrincipal ventanaPrincipal;
    private JTextField textFieldNombreLibro;
    private JButton botonBuscarLibro;
    private JComboBox lblListaResultado;
    private JButton botonVolver;

    public VentanaBuscarLibro(Biblioteca biblioteca, VentanaPrincipal ventanaPrincipal) {
        super( "Ventana Buscar Libro", 500, 500);
        this.biblioteca = biblioteca;
        this.ventanaPrincipal = ventanaPrincipal;
        this.generarElementos();
    }

    private void generarElementos() {
        super.generarJLabelEncabezado(null, "Buscar Libro", 200, 10, 300, 30);
        super.generarJLabel(null,"Ingrese el nombre del libro", 150, 40, 300, 30);
        this.generarInputTextFieldNombreLibro();
        this.generarBotonBuscarLibro();
        this.generarListaResultado();
        this.generarBotonVolver();
    }

    private void generarInputTextFieldNombreLibro() {
        JTextField textField = super.generarJTextField(150, 70, 200, 30);
        this.textFieldNombreLibro = textField;
        this.add(textField);
    }

    private void generarBotonBuscarLibro() {
        JButton buscarLibro = super.generarBoton("Buscar libro", 150, 100, 200, 50);
        this.botonBuscarLibro = buscarLibro;
        this.add(buscarLibro);
        this.botonBuscarLibro.addActionListener(this);
    }

    private void generarListaResultado() {
        super.generarJLabel(null, "Lista libros encontrados", 150, 160, 300, 50);
        this.lblListaResultado = super.generarListaDesplegable(new Object[0], 150, 200, 190, 50);
        this.add(this.lblListaResultado);
    }

    private void generarBotonVolver() {
        JButton volver = super.generarBoton("Volver", 150, 350, 200, 50);
        this.botonVolver = volver;
        this.add(volver);
        this.botonVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonBuscarLibro) {
            String nombreLibro = this.textFieldNombreLibro.getText();
            this.lblListaResultado.removeAllItems();
            ArrayList<Libro> librosEncontrados = this.biblioteca.buscarLibroPorNombre(nombreLibro);
            for (Libro libro : librosEncontrados) {
                this.lblListaResultado.addItem(libro.getNombreLibro());
            }
            System.out.println("Libros encontrados: " + librosEncontrados.size());

        } else if (e.getSource() == this.botonVolver) {
            this.setVisible(false);
            this.ventanaPrincipal.setVisible(true);
        }
    }
}