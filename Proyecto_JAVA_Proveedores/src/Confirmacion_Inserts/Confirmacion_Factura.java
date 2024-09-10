package Confirmacion_Inserts;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import proyecto_java_proveedores.ConexionBD;

public class Confirmacion_Factura extends JFrame{
    /// Atributos de la Clase
    JPanel Panel_Principal=new JPanel(); 
    int IDProveedor_Seleccionado; 
    String Proveedor_Seleccionado; 
    float Total_Seleccionado; 
    String FechaInicio_Seleccionada; 
    int NumeroFactura_Seleccionado;
    float iva;
    JButton B_Aceptar=new JButton();
    JButton B_Cancelar=new JButton();
    ConexionBD ConexionActual; 
    public Confirmacion_Factura(String Proveedor, float Total, int NumeroFactura, 
            String FechaInicio, int ID_Proveedor, ConexionBD Conexion){
        /// Inicialización de Variables; 
        this.ConexionActual=Conexion; 
        this.IDProveedor_Seleccionado=ID_Proveedor;
        this.Proveedor_Seleccionado=Proveedor;  
        this.Total_Seleccionado=Total; 
        this.NumeroFactura_Seleccionado=NumeroFactura; 
        this.FechaInicio_Seleccionada=FechaInicio; 
        /// Establecer Vista del JFrame.
        this.setBounds(10,10,700,400);
        this.setVisible(true);
        /// Establecer diseño del Panel Principal.
        Panel_Principal.setLayout(new BoxLayout(Panel_Principal, BoxLayout.Y_AXIS)); 
        Panel_Principal.setBorder(new EmptyBorder(20,20,20,20));
        /// Encabezado.
        JPanel Encabezado=new JPanel(); 
        JLabel L_Titulo=new JLabel(); 
        Encabezado.setPreferredSize(new Dimension(900, 50));
        L_Titulo.setText("Previsualización:");
        L_Titulo.setFont(new Font("Arial", Font.BOLD, 20));
        Encabezado.add(L_Titulo); 
        /// Contenido
        JPanel Contenido=new JPanel(); 
        JPanel P_Oracion=new JPanel(); 
        /// Primer Oración.
        Contenido.setPreferredSize(new Dimension(900,500));
        Contenido.setLayout(new BoxLayout(Contenido, BoxLayout.Y_AXIS));
        this.ConfigurarPanelOracion(P_Oracion);
        JLabel L_Proveedor=new JLabel(); 
        JTextField TF_Proveedor=new JTextField(); 
        this.ConfigurarLabel(L_Proveedor, "El Proveedor ");
        this.ConfigurarTextField(TF_Proveedor, this.Proveedor_Seleccionado);
        P_Oracion.add(L_Proveedor);
        P_Oracion.add(TF_Proveedor); 
        Contenido.add(P_Oracion); 
        /// Segunda Oración.
        JPanel P_OracionD=new JPanel(); 
        this.ConfigurarPanelOracion(P_OracionD);
        JLabel L_Total=new JLabel(); 
        JTextField TF_Total=new JTextField(); 
        this.ConfigurarLabel(L_Total,"Total de la Factura: ");
        this.ConfigurarTextField(TF_Total, "$"+this.Total_Seleccionado);
        P_OracionD.add(L_Total); 
        P_OracionD.add(TF_Total); 
        Contenido.add(P_OracionD); 
         /// Tercera Oración.
        JPanel P_OracionC=new JPanel(); 
        this.ConfigurarPanelOracion(P_OracionC);
        JLabel L_FechaI=new JLabel(); 
        JTextField TF_FechaI=new JTextField(); 
        this.ConfigurarLabel(L_FechaI,"A partir del ");
        this.ConfigurarTextField(TF_FechaI,this.FechaInicio_Seleccionada);
        P_OracionC.add(L_FechaI); 
        P_OracionC.add(TF_FechaI); 
        Contenido.add(P_OracionC);
        /// Segunda Oración.
        JPanel P_OracionE=new JPanel(); 
        this.ConfigurarPanelOracion(P_OracionE);
        JLabel L_NumeroFactura=new JLabel(); 
        JTextField TF_NumeroFactura=new JTextField(); 
        this.ConfigurarLabel(L_NumeroFactura,"Numero de la Factura: ");
        this.ConfigurarTextField(TF_NumeroFactura, "$"+this.NumeroFactura_Seleccionado);
        P_OracionD.add(L_NumeroFactura); 
        P_OracionD.add(TF_NumeroFactura); 
        Contenido.add(P_OracionE); 
        /// Botones de Confirmación
        JPanel Botones=new JPanel(); 
        this.ConfigurarPanelOracion(Botones);
        B_Aceptar.setText("Aceptar");
        B_Cancelar.setText("Cancelar");
        B_Cancelar.addActionListener(this.ClickCancelar());
        B_Aceptar.addActionListener(this.ClickAceptar());
        Botones.add(B_Cancelar); 
        Botones.add(B_Aceptar);
        Contenido.add(Botones); 
        Panel_Principal.add(Encabezado);
        Panel_Principal.add(Contenido);
        this.add(Panel_Principal);
    }
    
    private ActionListener ClickCancelar(){
        ActionListener Click_Cancelar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int Opcion=JOptionPane.showConfirmDialog(null,"¿Quiere Cancelar los Cambios?","Cancelar Insert", JOptionPane.YES_NO_OPTION);
                if(Opcion==JOptionPane.YES_OPTION){
                    Confirmacion_Factura.this.dispose();
                }
            }
        }; 
        return Click_Cancelar; 
    }
     private ActionListener ClickAceptar(){
        ActionListener Click_Aceptar=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int Opcion=JOptionPane.showConfirmDialog(null,"¿Quiere Aplicar los Cambios?","Aplicar Insert", JOptionPane.YES_NO_OPTION);
                if(Opcion==JOptionPane.YES_OPTION){
                    GenerarSentencia(); 
                    Confirmacion_Factura.this.dispose();
                }
            }
        }; 
        return Click_Aceptar; 
    }
    
    private void GenerarSentencia(){
        iva= (float) ((Total_Seleccionado)*0.016);
        try{
            String Query="INSERT INTO factura"
                + "(ID_Proveedor, Fac_Total, Fac_Fecha, Fac_Numero_Factura,Fac_IVA) "
                + "VALUES(?,?,?,?,?);";
            PreparedStatement stm=ConexionActual.getConnection().prepareStatement(Query);
            stm.setInt(1, IDProveedor_Seleccionado);
            stm.setFloat(2, Total_Seleccionado);
            stm.setString(3, FechaInicio_Seleccionada);
            stm.setInt(4, NumeroFactura_Seleccionado); 
            stm.setInt(5, (int) iva);  
            this.ConexionActual.EjecutarSentencia(stm);
            stm.close(); 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Generar la Consulta: "+e.toString());
        }
    } 
     
    private void ConfigurarTextField(JTextField Texto,String Contenido){
         Texto.setText(Contenido);
         Texto.setEditable(false);
         Texto.setFont(new Font("Arial", Font.ITALIC, 15)); 
         Texto.setBackground(Color.white);
    }
    private void ConfigurarLabel(JLabel Texto, String Contenido){
        Texto.setText(Contenido);
        Texto.setFont(new Font("Arial",Font.PLAIN,15)); 
    }
    private void ConfigurarPanelOracion(JPanel Panel){
        Panel.setPreferredSize(new Dimension(900, 50)); 
        Panel.setMaximumSize(new Dimension(900, 50)); 
        Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10,10)); 
    }
}
