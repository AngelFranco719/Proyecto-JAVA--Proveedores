package Actualizar_Datos;
import Formularios_Inserts.*;
import VerDatos.JP_VerDatos;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import proyecto_java_proveedores.ConexionBD;

public class ActualizarDatos extends JFrame{
    ConexionBD Conexion_Actual; 
    String Tabla; 
    List<String> Registro=new ArrayList(); 
    JP_VerDatos VerDatos; 
    public ActualizarDatos(ConexionBD Conexion_Actual, String Tabla, List<String> Registro, JP_VerDatos VerDatos){
        this.Tabla=Tabla; 
        this.setTitle("Actualizar Datos");
        this.VerDatos=VerDatos; 
        this.Conexion_Actual=Conexion_Actual;
        this.Registro=Registro; 
        JPanel Contenedor=new JPanel(); 
        this.setVisible(true);
        this.add(Contenedor);
        Contenedor.add(this.getPanel());
        this.pack(); 
    }
    
    public JPanel getPanel(){
        JPanel Panel_Actual=new JPanel();
        switch(Tabla){
            case "compra":
                Formulario_Insert_Compra Formulario_Compra=new Formulario_Insert_Compra(Conexion_Actual, Registro,this, this.VerDatos);
                this.revalidate();
                this.repaint();
                return Formulario_Compra; 
            case "factura":
                Formulario_Insert_Factura Formulario_Factura=new Formulario_Insert_Factura(Conexion_Actual,Registro, this, VerDatos); 
                this.revalidate();
                this.repaint();
                return Formulario_Factura; 
            case "oferta":
                Formulario_Insert_Oferta Formulario_Oferta=new Formulario_Insert_Oferta(Conexion_Actual,Registro,this, VerDatos);
                this.revalidate();
                this.repaint();
                return Formulario_Oferta; 
        }
        return Panel_Actual; 
    }
    
}