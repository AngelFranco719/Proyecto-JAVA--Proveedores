package Formularios_Inserts;
import Confirmacion_Inserts.Confirmacion_Factura;
import VerDatos.JP_VerDatos;
import proyecto_java_proveedores.ConexionBD;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.border.EmptyBorder;

public class Formulario_Insert_Factura extends JPanel{
    ConexionBD Conexion_Actual; 
    Dimension Tamaño=new Dimension(1000, 600);
    List <List<String>> Proveedores=new ArrayList(); 
    JPanel Encabezado=new JPanel();
    JPanel Contenido=new JPanel();
    JButton B_Insertar=new JButton(); 
    int ID_Proveedor;  
    String Proveedor_Seleccionado; 
    String FechaI_Seleccionada;
    float Total_Seleccionado;
    int NumeroFactura_Seleccionado;
    String IVA_Seleccionado; 
    List<String> Registro;
    JFrame Contenedor;
    JP_VerDatos VerDatos;
    JComboBox CB_IDProveedor=new JComboBox(); /// Inicializar ComboBox de Proveedores.
    JTextField TF_Total=new JTextField();/// Para Ingresar el Precio.
    JTextField TF_NumeroFactura=new JTextField();/// Para Ingresar el Numero de factura.
    JDateChooser DC_FechaInicio=new JDateChooser(); /// Para Ingresar la Fecha de Inicio.
    public Formulario_Insert_Factura(ConexionBD Conexion_Actual){
        this.Conexion_Actual=Conexion_Actual; 
        this.InicializarComponentes("Registrar Nueva Factura:", "Insertar Datos");
    }
    public Formulario_Insert_Factura(ConexionBD Conexion_Actual, List<String> Registro, JFrame Contenedor, JP_VerDatos VerDatos){
        this.Conexion_Actual=Conexion_Actual; 
        this.Registro=Registro;
        this.Contenedor=Contenedor;
        this.VerDatos=VerDatos; 
        this.InicializarComponentes("Actualizar Factura:", "Actualizar Datos");
        CB_IDProveedor.setSelectedIndex(Integer.parseInt(Registro.get(1))-1);
        SimpleDateFormat Formato=new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date Fecha=Formato.parse(Registro.get(2));
            DC_FechaInicio.setDate(Fecha);
        }catch(Exception e){
        }
        TF_Total.setText(Registro.get(3));
        TF_NumeroFactura.setText(Registro.get(4)); 
        
    }
    
    private void InicializarComponentes(String TituloVentana, String TituloBoton){
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
        Titulo.setText(TituloVentana);
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
        Configurar_Labels(L_IDProveedor, "Selecciona un Proveedor: ");
        Proveedores=Conexion_Actual.GetSelectAllFromResult("proveedor"); ///Obtener Todos los Proveedores.
        Inicializar_ComboBox(CB_IDProveedor, Proveedores); 
        ID_Combos.add(L_IDProveedor); 
        ID_Combos.add(CB_IDProveedor); 
        /// Configurar Panel de Selectores de Fechas.
        JPanel P_Fechas=new JPanel(); 
        P_Fechas.setPreferredSize(new Dimension(900, 50)); 
        P_Fechas.setMaximumSize(new Dimension(900, 50)); 
        P_Fechas.setLayout(new FlowLayout(FlowLayout.LEFT,20,15)); 
        JLabel L_FechaInicio=new JLabel();  
        Configurar_Labels(L_FechaInicio, "Selecciona la Fecha: "); 
        Configurar_DateChoosers(DC_FechaInicio); 
        P_Fechas.add(L_FechaInicio);
        P_Fechas.add(DC_FechaInicio);
        /// Configurar Panel para Ingresar Cantidad. Total Factura
        JPanel P_Total=new JPanel(); 
        P_Total.setMaximumSize(new Dimension(900,30));
        P_Total.setLayout(new FlowLayout(FlowLayout.LEFT,20,15));  
        JLabel L_Total=new JLabel(); 
        Configurar_Labels(L_Total, "Ingresa el Total de la Factura: "); 
        TF_Total.setPreferredSize(new Dimension(100, 25));
        P_Total.add(L_Total);
        P_Total.add(TF_Total); 
        /// Configurar Panel para Numero de Factura
        JPanel P_NumeroFactura=new JPanel(); 
        P_NumeroFactura.setMaximumSize(new Dimension(900,0));
        P_Total.setLayout(new FlowLayout(FlowLayout.LEFT,20,15));  
        JLabel L_NumeroFactura=new JLabel(); 
        Configurar_Labels(L_NumeroFactura, "Ingresa el Numero de Factura: "); 
        TF_NumeroFactura.setPreferredSize(new Dimension(100, 25));
        P_NumeroFactura.add(L_NumeroFactura);
        P_NumeroFactura.add(TF_NumeroFactura); 
        
        /// Configurar Panel para Boton Insertar.
        JPanel P_Buscar=new JPanel(); 
        P_Buscar.setPreferredSize(new Dimension(900, 30));
        P_Buscar.setLayout(new FlowLayout(FlowLayout.CENTER,20,15)); 
        B_Insertar.setText(TituloBoton);
        B_Insertar.addActionListener(this.Funcion_Insertar());
        P_Buscar.add(B_Insertar); 
        Contenido.add(ID_Combos); 
        Contenido.add(P_Fechas);
        Contenido.add(P_Total);
        Contenido.add(P_NumeroFactura);
        Contenido.add(P_Buscar);
        Encabezado.add(Titulo);
        this.add(Encabezado);
        this.add(Contenido); 
        this.repaint();
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
    private int ObtenerIDs(List <List<String>> Registros, String Seleccionado){
        int id=0; 
        for(List<String> fila : Registros){
            if(fila.get(1).equals(Seleccionado))
            {
             id=Integer.parseInt(fila.get(0));
             return id;
            }
        }
        return id; 
    }
    
    private ActionListener Funcion_Insertar(){
        ActionListener Click_Insertar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat Formato=new SimpleDateFormat("yyyy-MM-dd");
                if(B_Insertar.getText().equals("Insertar Datos")){
                    Proveedor_Seleccionado=CB_IDProveedor.getSelectedItem().toString();               
                    Total_Seleccionado=Float.parseFloat(TF_Total.getText());
                    NumeroFactura_Seleccionado=Integer.parseInt(TF_NumeroFactura.getText());                 
                    FechaI_Seleccionada=Formato.format(DC_FechaInicio.getDate());
                    ID_Proveedor=ObtenerIDs(Proveedores, Proveedor_Seleccionado); 
                    Confirmacion_Factura Confirmar=new Confirmacion_Factura(Proveedor_Seleccionado,
                            Total_Seleccionado,NumeroFactura_Seleccionado,FechaI_Seleccionada, ID_Proveedor, Conexion_Actual);
                }
                else{
                    List<String> CamposActualizados=new ArrayList(); 
                    List<String> Campos=Conexion_Actual.GetAtributosTabla("factura");
                    List<String> NuevosDatos=new ArrayList();
                    if(CB_IDProveedor.getSelectedIndex()!=Integer.parseInt(Registro.get(1))-1){
                        CamposActualizados.add(Campos.get(1));
                        NuevosDatos.add(String.valueOf(CB_IDProveedor.getSelectedIndex()+1));
                    }
                    String Fecha=Formato.format(DC_FechaInicio.getDate());
                    if(!Fecha.equals(Registro.get(2))){
                        CamposActualizados.add(Campos.get(2));
                        try{
                            NuevosDatos.add(Fecha);
                        }catch(Exception ex){
                        
                        }
                    }
                    if(!TF_Total.getText().equals(Registro.get(3))){
                        CamposActualizados.add(Campos.get(3));
                        NuevosDatos.add(TF_Total.getText());
                    }
                    if(!TF_NumeroFactura.getText().equals(Registro.get(4))){
                        CamposActualizados.add(Campos.get(4));
                        NuevosDatos.add(TF_NumeroFactura.getText());
                    }
                    if(Conexion_Actual.ActualizarRegistro("factura", CamposActualizados, NuevosDatos, Integer.parseInt(Registro.get(0)))){
                        VerDatos.InicializarTabla();
                        Contenedor.dispose();
                    }
                }      
            }
        }; 
        return Click_Insertar; 
        
    }
    
}
