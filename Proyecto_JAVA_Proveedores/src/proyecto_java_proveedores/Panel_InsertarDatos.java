package proyecto_java_proveedores;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import Formularios_Inserts.*;
public class Panel_InsertarDatos extends JPanel{
    JPanel Encabezado=new JPanel(); 
    JPanel Contenido=new JPanel(); 
    List <String>Ls_Tablas=new ArrayList();
    ConexionBD Conexion_Actual; 
    JComboBox Tablas=new JComboBox(); 
    JButton B_Seleccionar=new JButton(); 
    public Panel_InsertarDatos(ConexionBD Conexion_Actual){
        this.Conexion_Actual=Conexion_Actual; 
        this.setVisible(true); 
        this.setPreferredSize(new Dimension(1000,550));
        this.setMaximumSize(new Dimension(1000,550));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
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
        
        /// Inicializar JPanel Contenido.
        Contenido.setPreferredSize(new Dimension(1000, 700));
        
        this.add(Encabezado); 
        this.add(Contenido);
        this.repaint();
    }
    private ActionListener Manejador_Button(){
        ActionListener Seleccionar_Tabla=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Tabla_Seleccionada=Panel_InsertarDatos.this.Tablas.getSelectedItem().toString();
                if(Tabla_Seleccionada.equals("proveedor")){
                    /// Lógica para mostrar el JPanel de Proveedor.
                }   
                else if(Tabla_Seleccionada.equals("pieza")){
                  JDPie Insert_Pieza=new JDPie(Panel_InsertarDatos.this.Contenido,Conexion_Actual); 
                }  
                else if(Tabla_Seleccionada.equals("oferta")){
                    /// Lógica para mostrar el JPanel de Oferta.
                    Formulario_Insert_Oferta Insert_Oferta=new Formulario_Insert_Oferta(Panel_InsertarDatos.this.Conexion_Actual); 
                    Panel_InsertarDatos.this.Contenido.add(Insert_Oferta);
                }  
                else if(Tabla_Seleccionada.equals("compra")){
                    /// Lógica para mostrar el JPanel de Compra.
                    Formulario_Insert_Compra Formulario_Compra=new Formulario_Insert_Compra(Conexion_Actual);
                    Panel_InsertarDatos.this.Contenido.add(Formulario_Compra); 
                }  
            }
        }; 
        this.repaint(); 
        return Seleccionar_Tabla; 
    }
}
