package ventanas;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.app.Biblioteca;

public class VentanaAgregarUsuario extends VentanaGeneral {
    private final Biblioteca biblioteca;
    private VentanaPrincipal ventanaPrincipal;
    private JTextField textFieldNombreUsuario;
    private JTextField textFieldRutUsuario;
    private JTextField textFieldNumeroTelefono;
    private JButton botonAgregarUsuario;
    private JButton botonVolver;

    public VentanaAgregarUsuario(Biblioteca biblioteca, VentanaPrincipal ventanaPrincipal) {
        super( "Ventana Usuario", 500, 500);
        this.biblioteca = biblioteca;
        this.ventanaPrincipal = ventanaPrincipal;
        this.generarElementos();
    }

    private void generarElementos() {
        super.generarJLabelEncabezado(null, "Agregar Usuario", 100, 20, 300, 30);
        super.generarJLabel(null,"Ingrese el nombre del usuario", 100, 60, 300, 30);
        this.generarInputTextFieldNombreUsuario();
        super.generarJLabel(null,"Ingrese el rut del usuario", 100, 120, 300, 30);
        this.generarInputTextFieldRutUsuario();
        super.generarJLabel(null,"Ingrese el numero de telefono", 100, 180, 300, 30);
        this.generarInputTextFieldNumeroTelefono();
        this.generarBotonAgregarUsuario();
        this.generarBotonVolver();
    }

    private void generarInputTextFieldNombreUsuario() {
        JTextField textField = super.generarJTextField(100, 90, 300, 30);
        this.textFieldNombreUsuario = textField;
        this.add(textField);
    }

    private void generarInputTextFieldRutUsuario() {
        JTextField textField = super.generarJTextField(100, 150, 300, 30);
        this.textFieldRutUsuario = textField;
        this.add(textField);
    }

    private void generarInputTextFieldNumeroTelefono() {
        JTextField textField = super.generarJTextField(100, 210, 300, 30);
        this.textFieldNumeroTelefono = textField;
        this.add(textField);
    }

    private void generarBotonAgregarUsuario() {
        JButton agregarUsuario = super.generarBoton("Agregar usuario", 100, 270, 300, 50);
        this.botonAgregarUsuario = agregarUsuario;
        this.add(agregarUsuario);
        this.botonAgregarUsuario.addActionListener(this);
    }

    private void generarBotonVolver() {
        JButton volver = super.generarBoton("Volver", 100, 330, 300, 50);
        this.botonVolver = volver;
        this.add(volver);
        volver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonAgregarUsuario) {
            String nombreUsuario = this.textFieldNombreUsuario.getText();
            String rutUsuario = this.textFieldRutUsuario.getText();
            String numeroTelefono = this.textFieldNumeroTelefono.getText();
            this.biblioteca.setNewUsuario(nombreUsuario, rutUsuario, numeroTelefono);
            this.textFieldNombreUsuario.setText("");
            this.textFieldRutUsuario.setText("");
            this.textFieldNumeroTelefono.setText("");
        
        } else if (e.getSource() == this.botonVolver) {
            // Crea una nueva instancia de VentanaPrincipal y la muestra
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(biblioteca);
            ventanaPrincipal.setVisible(true);
            // Opcional: oculta la ventana agregar usuario
            setVisible(false);
        
        }
    }
}
