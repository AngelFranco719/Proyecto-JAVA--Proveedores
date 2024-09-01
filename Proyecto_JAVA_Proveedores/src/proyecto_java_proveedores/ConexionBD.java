package proyecto_java_proveedores;
import java.sql.*; 
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class ConexionBD {
    /// Variables necesarias para la conexión con la Base de Datos.
    /// Cambien el valor de las variables con sus datos del servidor MySQL.
    String nombre_bd="proveedores"; 
    String usuario="root";
    String contraseña=""; 
    String url="jdbc:mysql://localhost:3307/"+nombre_bd; 
    String driver="com.mysql.cj.jdbc.Driver"; 
    boolean conectado=false; 
    Connection Nueva_Conexion; 
    
    ///Constructor de la Clase ConexionBD.
    public ConexionBD(){
        try{
            Class.forName(driver); 
            Nueva_Conexion=DriverManager.getConnection(url, usuario, contraseña);
            conectado=true; 
            JOptionPane.showMessageDialog(null, "La Conexión a la Base de Datos fue exitosa.", "Notificación de Conexión", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Error al Conectar la Base de Datos: "+e.toString(), "Notificación de Conexión", JOptionPane.ERROR_MESSAGE);   
        }
    }
    /// Función para Obtener Todas las Tablas en la Base de Datos.
    public List<String> GetTablasDisponibles(){
        List<String> Ls_Tablas=new ArrayList(); 
        String query="SHOW TABLES"; 
        try(Statement stm=Nueva_Conexion.createStatement()){
            ResultSet resultado=stm.executeQuery(query); 
            while(resultado.next()){
                Ls_Tablas.add(resultado.getString("Tables_in_proveedores"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Obtener las Tablas: ", "Notificación de Estado", JOptionPane.ERROR_MESSAGE);
        }
        return Ls_Tablas; 
    }
    
    /// Función que guarda el resultado de sentencias del tipo "SELECT * FROM Tabla"
    public List <List<String>> GetSelectAllFromResult(String Tabla){
        List <List<String>> Resultado=new ArrayList(); 
        String sentencia="SELECT * FROM "+Tabla; 
        try(Statement stm = Nueva_Conexion.createStatement()){
            ResultSet query=stm.executeQuery(sentencia);
            ResultSetMetaData query_md=query.getMetaData();
            int columnas=query_md.getColumnCount(); 
            while(query.next()){
                List <String> fila=new ArrayList(); 
                for(int i=1; i<columnas+1; i++){
                    fila.add(query.getString(i));
                }
                Resultado.add(fila); 
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error al Obtener los Datos: "+e.toString(),"Error de Petición", JOptionPane.ERROR_MESSAGE);
        }
        return Resultado; 
    }
    
}
