package ventanas;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.app.Biblioteca;

//Crea la clase VentanaBuscarUsuario que extiende de VentanaGeneral y muestra una ventana para buscar un usuario
//La clase VentanaBuscarUsuario debe tener un campo para buscar un usuario por su nombre y mostrar los resultados
//La clase VentanaBuscarUsuario debe tener un boton para volver a la VentanaPrincipal

public class VentanaBuscarUsuario extends VentanaGeneral {
    private Biblioteca biblioteca;
    private VentanaPrincipal ventanaPrincipal;
    private JTextField textFieldNombreUsuario;
    private JButton botonBuscarUsuario;
    private JComboBox lblListaResultado;
    private JButton botonVolver;

    public VentanaBuscarUsuario(Biblioteca biblioteca, VentanaPrincipal ventanaPrincipal) {
        super( "Ventana Buscar Usuario", 500, 500);
        this.biblioteca = biblioteca;
        this.ventanaPrincipal = ventanaPrincipal;
        this.generarElementos();
    }

    public void generarElementos() {
        super.generarJLabelEncabezado(null, "Buscar Usuario", 100, 20, 300, 30);
        super.generarJLabel(null,"Ingrese el nombre del usuario", 100, 60, 300, 30);
        this.generarInputTextFieldNombreUsuario();
        this.generarBotonBuscarUsuario();
        this.generarLabelResultado();
        this.generarBotonVolver();
    }

    public void generarInputTextFieldNombreUsuario() {
        JTextField textField = super.generarJTextField(100, 90, 300, 30);
        this.textFieldNombreUsuario = textField;
        this.add(textField);
    }

    public void generarBotonBuscarUsuario() {
        JButton buscarUsuario = super.generarBoton("Buscar usuario", 100, 150, 300, 50);
        this.botonBuscarUsuario = buscarUsuario;
        this.add(buscarUsuario);
        this.botonBuscarUsuario.addActionListener(this);
    }

    public void generarLabelResultado() {
        super.generarJLabel(null, "Lista usuarios encontrados", 100, 210, 300, 50);
        this.lblListaResultado = super.generarListaDesplegable(new Object[0], 100, 270, 300, 50);
        this.add(this.lblListaResultado);
    }

    public void generarBotonVolver() {
        JButton volver = super.generarBoton("Volver", 100, 330, 300, 50);
        this.botonVolver = volver;
        this.add(volver);
        this.botonVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonBuscarUsuario){
            String nombreUsuario = this.textFieldNombreUsuario.getText();
            ArrayList<String> usuarios = this.biblioteca.buscarUsuarioPorNombre(nombreUsuario);
            
            for (String usuario : usuarios) {
                this.lblListaResultado.addItem(usuario);
            }
            System.out.println("Usuarios encontrados: " + usuarios.size());
        }
        if (e.getSource() == this.botonVolver){
            // Crea una nueva instancia de VentanaLibro y la muestra
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(biblioteca);
            ventanaPrincipal.setVisible(true);
            // Opcional: oculta la ventana buscar libro
            setVisible(false);
        }
    }
}
