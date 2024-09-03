package Formularios_Inserts;
import proyecto_java_proveedores.*; 
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*; 

public class Formulario_Insert_Compra extends JPanel{
    ConexionBD Conexion_Actual; 
    JPanel Encabezado=new JPanel(); 
    List<List<String>> Facturas=new ArrayList(); 
    public Formulario_Insert_Compra(ConexionBD Conexion_Actual){
        System.out.println("Si"); 
        this.Conexion_Actual=Conexion_Actual;
        this.setPreferredSize(new Dimension(1000,500)); 
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
       /// Inicializar Encabezado.
       JLabel L_Titulo=new JLabel();
       L_Titulo.setText("Registrar Nueva Compra:");
       L_Titulo.setFont(new Font("Arial", Font.BOLD, 16));
       Encabezado.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
       Encabezado.setPreferredSize(new Dimension(1000,50));
       Encabezado.add(L_Titulo);
       this.add(Encabezado); 
       this.repaint(); 
       /// Inicializar Combos.
       JPanel P_Combos=new JPanel(); 
       P_Combos.setPreferredSize(new Dimension(1000, 50));
       P_Combos.setMaximumSize(new Dimension(1000, 50));
       P_Combos.setLayout(new FlowLayout(FlowLayout.LEFT, 10,10));
       JLabel L_Factura=new JLabel(); 
       JComboBox CB_Factura=new JComboBox();
       ConfigurarLabels(L_Factura, "Selecciona la Factura: "); 
       Facturas=Conexion_Actual.GetSelectAllFromResult("Factura"); 
    }
    private void ConfigurarLabels(JLabel Label, String Texto){
        Label.setText(Texto);
        Label.setFont(new Font("Arial",Font.PLAIN,15));
    }
    private void ConfigurarComboBox(JComboBox Combo, List<List<String>> Lista, int index){
        for(List fila : Lista){
            
        }
    }
}
