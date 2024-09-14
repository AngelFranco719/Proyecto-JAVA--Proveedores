package proyecto_java_proveedores;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class Panel_BuscarDatos extends JPanel {
    JFrame Contenedor;
    ConexionBD Conexion_Actual;

    JComboBox<String> cbTablas;
    JComboBox<String> cbAtributos;
    JTextField tfCriterio;
    JButton btnBuscar;
    JTextArea taResultados;

    public Panel_BuscarDatos(ConexionBD Conexion_Actual, JFrame Contenedor) {
        this.Conexion_Actual = Conexion_Actual;
        this.Contenedor = Contenedor;

        this.setLayout(new BorderLayout());

        // Panel superior para seleccionar tabla, atributo y criterio
        JPanel panelBusqueda = new JPanel(new FlowLayout());

        cbTablas = new JComboBox<>();
        List<String> tablas = Conexion_Actual.GetTablasDisponibles();
        for (String tabla : tablas) {
            cbTablas.addItem(tabla);
        }

        cbAtributos = new JComboBox<>();
        // Aquí deberías cargar los atributos de la tabla seleccionada

        tfCriterio = new JTextField(10);

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarBusqueda();
            }
        });

        panelBusqueda.add(new JLabel("Tabla:"));
        panelBusqueda.add(cbTablas);
        panelBusqueda.add(new JLabel("Atributo:"));
        panelBusqueda.add(cbAtributos);
        panelBusqueda.add(new JLabel("Criterio:"));
        panelBusqueda.add(tfCriterio);
        panelBusqueda.add(btnBuscar);

        this.add(panelBusqueda, BorderLayout.NORTH);

        // Área de texto para mostrar resultados
        taResultados = new JTextArea(20, 50);
        JScrollPane scrollResultados = new JScrollPane(taResultados);
        this.add(scrollResultados, BorderLayout.CENTER);
    }

    // Método para realizar la búsqueda
    private void realizarBusqueda() {
        String tablaSeleccionada = (String) cbTablas.getSelectedItem();
        String atributoSeleccionado = (String) cbAtributos.getSelectedItem();
        String criterio = tfCriterio.getText();

        // Consulta para obtener los resultados
        String query = "SELECT * FROM " + tablaSeleccionada + " WHERE " + atributoSeleccionado + " LIKE '%" + criterio + "%'";
        List<List<String>> resultados = Conexion_Actual.GetSelectAllFromResult(tablaSeleccionada); 

        // Mostrar los resultados en el JTextArea
        StringBuilder sbResultados = new StringBuilder();
        for (List<String> fila : resultados) {
            for (String dato : fila) {
                sbResultados.append(dato).append("\t");
            }
            sbResultados.append("\n");
        }

        taResultados.setText(sbResultados.toString());
    }
}
