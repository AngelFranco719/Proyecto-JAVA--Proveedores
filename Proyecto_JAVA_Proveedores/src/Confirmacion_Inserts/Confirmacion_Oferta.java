package Confirmacion_Inserts;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;
import proyecto_java_proveedores.ConexionBD;

public class Confirmacion_Oferta extends JFrame{
    /// Atributos de la Clase
    JPanel Panel_Principal=new JPanel(); 
    int IDProveedor_Seleccionado; 
    int IDPieza_Seleccionado; 
    String Proveedor_Seleccionado; 
    String Pieza_Seleccionada; 
    String Precio_Seleccionado; 
    String FechaInicio_Seleccionada; 
    String FechaFin_Seleccionada;
    JButton B_Aceptar=new JButton();
    JButton B_Cancelar=new JButton();
    ConexionBD ConexionActual; 
    public Confirmacion_Oferta(String Proveedor, String Pieza, String Precio, 
            String FechaInicio, String FechaFin, int ID_Proveedor, int ID_Pieza, ConexionBD Conexion){
        /// Inicialización de Variables; 
        this.ConexionActual=Conexion; 
        this.IDProveedor_Seleccionado=ID_Proveedor;
        this.IDPieza_Seleccionado=ID_Pieza; 
        this.Proveedor_Seleccionado=Proveedor; 
        this.Pieza_Seleccionada=Pieza; 
        this.Precio_Seleccionado=Precio; 
        this.FechaInicio_Seleccionada=FechaInicio; 
        this.FechaFin_Seleccionada=FechaFin; 
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
        JLabel L_Pieza = new JLabel(); 
        this.ConfigurarLabel(L_Pieza, " ofrece un(a)  ");
        JTextField TF_Pieza=new JTextField();
        this.ConfigurarTextField(TF_Pieza,this.Pieza_Seleccionada);
        P_Oracion.add(L_Proveedor);
        P_Oracion.add(TF_Proveedor); 
        P_Oracion.add(L_Pieza); 
        P_Oracion.add(TF_Pieza); 
        Contenido.add(P_Oracion); 
        /// Segunda Oración.
        JPanel P_OracionD=new JPanel(); 
        this.ConfigurarPanelOracion(P_OracionD);
        JLabel L_Precio=new JLabel(); 
        JTextField TF_Precio=new JTextField(); 
        this.ConfigurarLabel(L_Precio,"A un precio de: ");
        this.ConfigurarTextField(TF_Precio, "$"+this.Precio_Seleccionado);
        P_OracionD.add(L_Precio); 
        P_OracionD.add(TF_Precio); 
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
        JLabel L_FechaF=new JLabel(); 
        JTextField TF_FechaF=new JTextField(); 
        this.ConfigurarLabel(L_FechaF,"Hasta el ");
        this.ConfigurarTextField(TF_FechaF, this.FechaFin_Seleccionada);
        P_OracionC.add(L_FechaF); 
        P_OracionC.add(TF_FechaF); 
        Contenido.add(P_OracionC);
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
                    Confirmacion_Oferta.this.dispose();
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
                    Confirmacion_Oferta.this.dispose();
                }
            }
        }; 
        return Click_Aceptar; 
    }
    
    private void GenerarSentencia(){
        try{
            String Query="INSERT INTO Oferta"
                + "(ID_Proveedor, ID_Pieza, Ofe_Precio, Ofe_Fecha_Inicio, Ofe_Fecha_Final) "
                + "VALUES(?,?,?,?,?);";
            PreparedStatement stm=ConexionActual.getConnection().prepareStatement(Query);
            stm.setInt(1, IDProveedor_Seleccionado);
            stm.setInt(2, IDPieza_Seleccionado);
            stm.setString(3, Precio_Seleccionado);
            stm.setString(4, FechaInicio_Seleccionada);
            stm.setString(5, FechaFin_Seleccionada);    
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
