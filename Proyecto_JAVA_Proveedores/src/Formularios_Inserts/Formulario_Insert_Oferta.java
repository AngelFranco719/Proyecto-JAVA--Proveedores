package Formularios_Inserts;
import proyecto_java_proveedores.ConexionBD;
import Confirmacion_Inserts.Confirmacion_Oferta;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

public class Formulario_Insert_Oferta extends JPanel{
    ConexionBD Conexion_Actual; 
    Dimension Tamaño=new Dimension(1000, 500);
    List <List<String>> Proveedores=new ArrayList(); 
    List <List<String>> Pieza=new ArrayList(); 
    JPanel Encabezado=new JPanel();
    JPanel Contenido=new JPanel();
    JButton B_Insertar=new JButton(); 
    public Formulario_Insert_Oferta(ConexionBD Conexion_Actual){
        this.Conexion_Actual=Conexion_Actual; 
        /// Inicializar Panel.
        this.setPreferredSize(Tamaño);
        this.setVisible(true);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS)); 
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setBorder(new EmptyBorder(30,10,10,10)); 
        
        /// Encabezado.
        JLabel Titulo=new JLabel(); 
        Encabezado.setAlignmentX(Component.CENTER_ALIGNMENT);
        Encabezado.setLayout(new FlowLayout(FlowLayout.LEFT, 0,0));
        Encabezado.setPreferredSize(new Dimension(900, 30));
        Encabezado.setMaximumSize(new Dimension(900, 30));
        Titulo.setText("Registrar Nueva Oferta:");
        Titulo.setFont(new Font("Arial", Font.BOLD,18));
        /// Contenido.
        Contenido.setLayout(new BoxLayout(Contenido, BoxLayout.Y_AXIS));
        Contenido.setAlignmentX(Component.CENTER_ALIGNMENT);
        /// Configurar Panel de ComboBox.
        JPanel ID_Combos=new JPanel(); 
        ID_Combos.setMaximumSize(new Dimension(900, 50));
        ID_Combos.setLayout(new FlowLayout(FlowLayout.LEFT, 20,15));
        ID_Combos.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel L_IDProveedor=new JLabel(); 
        JLabel L_IDPieza=new JLabel(); 
        Configurar_Labels(L_IDProveedor, "Selecciona un Proveedor: ");
        Configurar_Labels(L_IDPieza, "Selecciona una Pieza: "); 
        JComboBox CB_IDProveedor=new JComboBox(); /// Inicializar ComboBox de Proveedores.
        JComboBox CB_IDPieza=new JComboBox(); /// Inicializar ComboBox de Pieza.
        Proveedores=Conexion_Actual.GetSelectAllFromResult("proveedor"); ///Obtener Todos los Proveedores.
        Pieza=Conexion_Actual.GetSelectAllFromResult("pieza"); /// Obtener Todas las Piezas.
        Inicializar_ComboBox(CB_IDProveedor, Proveedores); 
        Inicializar_ComboBox(CB_IDPieza, Pieza); 
        ID_Combos.add(L_IDProveedor); 
        ID_Combos.add(CB_IDProveedor); 
        ID_Combos.add(L_IDPieza); 
        ID_Combos.add(CB_IDPieza);
        /// Configurar Panel de Selectores de Fechas.
        JPanel P_Fechas=new JPanel(); 
        P_Fechas.setPreferredSize(new Dimension(900, 50)); 
        P_Fechas.setMaximumSize(new Dimension(900, 50)); 
        P_Fechas.setLayout(new FlowLayout(FlowLayout.LEFT,20,15)); 
        JLabel L_FechaInicio=new JLabel(); 
        JDateChooser DC_FechaInicio=new JDateChooser(); 
        Configurar_Labels(L_FechaInicio, "Selecciona la Fecha de Inicio: "); 
        Configurar_DateChoosers(DC_FechaInicio); 
        JLabel L_FechaFin=new JLabel(); 
        JDateChooser DC_FechaFin=new JDateChooser(); 
        Configurar_Labels(L_FechaFin, "Selecciona la Fecha de Fin: "); 
        Configurar_DateChoosers(DC_FechaFin); 
        P_Fechas.add(L_FechaInicio);
        P_Fechas.add(DC_FechaInicio);
        P_Fechas.add(L_FechaFin);
        P_Fechas.add(DC_FechaFin);
        /// Configurar Panel para Ingresar Cantidad.
        JPanel P_Precio=new JPanel(); 
        P_Precio.setMaximumSize(new Dimension(900,30));
        P_Precio.setLayout(new FlowLayout(FlowLayout.LEFT,20,15));  
        JLabel L_Precio=new JLabel(); 
        JTextField TF_Precio=new JTextField();
        Configurar_Labels(L_Precio, "Ingresa el Precio del Producto: "); 
        TF_Precio.setPreferredSize(new Dimension(100, 25));
        P_Precio.add(L_Precio);
        P_Precio.add(TF_Precio); 
        /// Configurar Panel para Boton Insertar.
        JPanel P_Buscar=new JPanel(); 
        P_Buscar.setPreferredSize(new Dimension(900, 30));
        P_Buscar.setLayout(new FlowLayout(FlowLayout.CENTER,20,15)); 
        B_Insertar.setText("Insertar Datos");
        B_Insertar.addActionListener(this.Funcion_Insertar());
        P_Buscar.add(B_Insertar); 
        Contenido.add(ID_Combos); 
        Contenido.add(P_Fechas);
        Contenido.add(P_Precio);
        Contenido.add(P_Buscar);
        Encabezado.add(Titulo);
        this.add(Encabezado);
        this.add(Contenido); 
    }
    
    private void Configurar_Labels(JLabel Label, String Texto){
        Label.setText(Texto);
        Label.setFont(new Font("Arial", Font.PLAIN, 15));
    }
    
    private void Configurar_DateChoosers(JDateChooser Calendario){
        Calendario.setPreferredSize(new Dimension(150,20));
        Calendario.setDateFormatString("yyyy-MM-dd");
    }
    
    private void Inicializar_ComboBox(JComboBox Opciones, List <List<String>> Registros){
        for(List<String> fila : Registros){
            Opciones.addItem(fila.get(1)); /// Agregar Items al ComboBox.
        }
    }
    
    private ActionListener Funcion_Insertar(){
        ActionListener Click_Insertar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Confirmacion_Oferta Confirmar=new Confirmacion_Oferta();
            }
        }; 
        return Click_Insertar; 
        
    }
    
}
