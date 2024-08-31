package proyecto_java_proveedores;
import java.sql.*; 
import javax.swing.JOptionPane;
public class ConexionBD {
    /// Variables necesarias para la conexión con la Base de Datos.
    /// Cambien el valor de las variables con sus datos del servidor MySQL.
    String nombre_bd="proveedores"; 
    String usuario="root";
    String contraseña=""; 
    String url="jdbc:mysql://localhost:3307/"+nombre_bd; 
    String driver="com.mysql.cj.jdbc.Driver"; 
    Connection Nueva_Conexion; 
    
    ///Constructor de la Clase ConexionBD.
    public ConexionBD(){
        try{
            Class.forName(driver); 
            Nueva_Conexion=DriverManager.getConnection(url, usuario, contraseña);
            JOptionPane.showMessageDialog(null, "La Conexión a la Base de Datos fue exitosa.", "Notificación de Conexión", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Error al Conectar la Base de Datos: "+e.toString(), "Notificación de Conexión", JOptionPane.ERROR_MESSAGE);   
        }
    }
    
}
