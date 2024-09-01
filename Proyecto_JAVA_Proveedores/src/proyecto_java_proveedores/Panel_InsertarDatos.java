package proyecto_java_proveedores;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class Panel_InsertarDatos extends JPanel{
    JPanel Encabezado=new JPanel(); 
    List <String>Ls_Tablas=new ArrayList();
    ConexionBD Conexion_Actual; 
    JComboBox Tablas=new JComboBox(); 
    JButton B_Seleccionar=new JButton(); 
    public Panel_InsertarDatos(ConexionBD Conexion_Actual){
        this.Conexion_Actual=Conexion_Actual; 
        this.setVisible(true); 
        this.setPreferredSize(new Dimension(1000,500));
        this.setMaximumSize(new Dimension(1000,500));
        /// Inicializar Encabezado.
        Encabezado.setLayout(new FlowLayout(FlowLayout.LEFT, 20,0));
        Encabezado.setPreferredSize(new Dimension(1000, 50));
        JLabel Titulo=new JLabel();
        Titulo.setText("Selecciona una Tabla: ");
        Titulo.setFont(new Font("Arial", Font.PLAIN, 18));
        Encabezado.add(Titulo);
        /// ComboBox con las Tablas Disponibles.
        Tablas.setPreferredSize(new Dimension(150,25));
        Ls_Tablas=this.Conexion_Actual.GetTablasDisponibles();
        for(String tabla : Ls_Tablas){
            Tablas.addItem(tabla);
        }
        B_Seleccionar.setText("Seleccionar Tabla");
        B_Seleccionar.addActionListener(this.Manejador_Button());
        Encabezado.add(Tablas);
        Encabezado.add(B_Seleccionar);
        this.add(Encabezado); 
        this.repaint();
    }
    private ActionListener Manejador_Button(){
        ActionListener Seleccionar_Tabla=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Tabla_Seleccionada=Panel_InsertarDatos.this.Tablas.getSelectedItem().toString();
                JOptionPane.showMessageDialog(null,Tabla_Seleccionada);
                if(Tabla_Seleccionada.equals("proveedor")){
                    /// Lógica para mostrar el JPanel de Proveedor.
                }   
                else if(Tabla_Seleccionada.equals("pieza")){
                    /// Lógica para mostrar el JPanel de Pieza.
                }  
                else if(Tabla_Seleccionada.equals("oferta")){
                    /// Lógica para mostrar el JPanel de Oferta.
                }  
            }
        }; 
        return Seleccionar_Tabla; 
    }
}
