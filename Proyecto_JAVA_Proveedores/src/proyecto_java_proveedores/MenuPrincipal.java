package proyecto_java_proveedores;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
public class MenuPrincipal extends JFrame{
    JPanel JP_PanelPrincipal=new JPanel(); 
    JPanel Opciones=new JPanel(); 
    JPanel Contenido=new JPanel(); 
    /// ToggleButtons para manejar la opción seleccionada por el usuario.
    JToggleButton InsertarDatos=new JToggleButton();
    JToggleButton ActualizarDatos=new JToggleButton(); 
    JToggleButton EliminarDatos=new JToggleButton(); 
    JToggleButton VerDatos=new JToggleButton(); 
    List<JToggleButton> Lista_Opciones=new ArrayList<>(); 
    ConexionBD Conexion_Actual; 
    /// Constructor de la Clase.
    public MenuPrincipal(ConexionBD Conexion_Actual){
        this.Conexion_Actual=Conexion_Actual; 
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(10,10,1080,720);
        this.setLayout(new FlowLayout());
        this.setVisible(true); 
        ///Inicialización del Panel Principal.
        JP_PanelPrincipal.setPreferredSize(new Dimension(1080,720));
        JP_PanelPrincipal.setLayout(new BoxLayout(JP_PanelPrincipal, BoxLayout.Y_AXIS));
        /// Inicializar Encabezado.
        JLabel Titulo=new JLabel();
        JPanel Encabezado=new JPanel();
        Encabezado.setMaximumSize(new Dimension(550, 50)); 
        Encabezado.setBorder(new EmptyBorder(10,10,10,10)); 
        Titulo.setText("Gestor de Información para Proveedores.");
        Titulo.setFont(new Font("Arial", Font.BOLD, 20));
        Titulo.setForeground(new Color(13,47,131));
        Encabezado.add(Titulo); 
        /// Inicializar el Panel de Opciones.
        Opciones.setSize(250,50);
        Opciones.setMinimumSize(new Dimension(1080,70));
        Opciones.setMaximumSize(new Dimension(1080,70));
        Opciones.setBorder(new EmptyBorder(10,10,10,10)); 
        Opciones.setLayout(new FlowLayout(FlowLayout.CENTER, 20,10));
        this.InicializarOpcionesCombo();
        /// Inicializar Panel de Contenido.
        Contenido.setMaximumSize(new Dimension(1080, 500));
        Contenido.setMinimumSize(new Dimension(1080, 500));
        Contenido.setBorder(new EmptyBorder(20,20,20,20));
        Contenido.setLayout(new FlowLayout());
        
        
        JP_PanelPrincipal.add(Encabezado); 
        JP_PanelPrincipal.add(Opciones); 
        JP_PanelPrincipal.add(Contenido); 
        this.add(JP_PanelPrincipal); 
        this.pack();
    }
    private void InicializarOpcionesCombo(){
        InsertarDatos.setText("Insertar Datos");
        ActualizarDatos.setText("Actualizar Datos");
        EliminarDatos.setText("Eliminar Datos");
        VerDatos.setText("Ver Datos");
        Lista_Opciones.add(InsertarDatos);
        Lista_Opciones.add(ActualizarDatos);
        Lista_Opciones.add(EliminarDatos);
        Lista_Opciones.add(VerDatos);
        for(JToggleButton Opcion : Lista_Opciones){
            Opciones.add(Opcion); 
            Opcion.addActionListener(this.ManejoToggleButton());
        }
    }
    
    /// Función que añade un Manjeador de Eventos al seleccionar un ToggleButton.
    private ActionListener ManejoToggleButton(){
        ActionListener Click_Opcion=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(JToggleButton Opcion : Lista_Opciones){
                    if(Opcion!=e.getSource()){
                        Opcion.setSelected(false);
                        Contenido.removeAll();
                        Contenido.repaint();
                    }
                }
                if(e.getSource()==Lista_Opciones.get(0)){
                    Panel_InsertarDatos Insertar=new Panel_InsertarDatos(MenuPrincipal.this.Conexion_Actual, MenuPrincipal.this); 
                    Contenido.add(Insertar);
                    Contenido.repaint();
                }
                MenuPrincipal.this.pack();
            }
            
        };   
        return Click_Opcion;
    }
    
}
