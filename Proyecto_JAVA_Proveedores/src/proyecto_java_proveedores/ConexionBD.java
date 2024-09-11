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
    String url="jdbc:mysql://localhost:3306/"+nombre_bd; 
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
    
    public Connection getConnection(){
        return this.Nueva_Conexion;
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
    
    /// Obtener Atributos de una Tabla
    public List<String> GetAtributosTabla(String Tabla){
        List<String> Atributos=new ArrayList();
        try(Statement stm=Nueva_Conexion.createStatement()){
            ResultSet campos=stm.executeQuery("Describe "+Tabla);
            while(campos.next()){
                Atributos.add(campos.getString(1));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Obtener los Campos: "+e.toString());
        }
        return Atributos;
    }
    
    // Obtener el Ultimo ID 
    public int GetLastID(String Tabla){
        int ID=0; 
        String ID_Tabla="ID_"+Tabla;
        try(Statement stm=Nueva_Conexion.createStatement()){
            String sentencia="SELECT MAX("+ID_Tabla+") FROM "+Tabla;
            ResultSet resultado=stm.executeQuery(sentencia);
            while(resultado.next()){
                ID=resultado.getInt(1);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Obtener ID"+e.toString()); 
        }
        return ID; 
    }
    /// Ejecutar Sentencia de la que se espera solo un resultado.
    public String getUniqueResultQuery(String Query){
        String Resultado=""; 
        try(Statement stm=Nueva_Conexion.createStatement()){
            ResultSet resultado=stm.executeQuery(Query);
            while(resultado.next()){
                return Resultado=resultado.getString(1);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Ejecutar la Sentencia"+e.toString()); 
        }
        return Resultado; 
    }
    
    public String getLastID(String Tabla){
        String lastID=""; 
        try (Statement stm=this.Nueva_Conexion.createStatement()){
            String ID="ID_"+Tabla; 
            String query="SELECT MAX("+ID+") FROM "+Tabla;
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
                lastID=rs.getString(1); 
            }
        }catch(Exception e){
         JOptionPane.showMessageDialog(null,"Error al Obtener el Último ID: "+e.toString());
        }
        
        return lastID; 
    }
    
    public List<List<String>> getResultBusqueda(String Tabla, String Atributo,String Signo ,String Criterio){
        List<List<String>> Resultado=new ArrayList();
        try(Statement stm=Nueva_Conexion.createStatement()){
            String Query="SELECT * FROM "+Tabla+" WHERE "+Atributo+" "+Signo+" "+Criterio;
            ResultSet resultado=stm.executeQuery(Query);
            ResultSetMetaData query_md=resultado.getMetaData();
            int Columnas=query_md.getColumnCount()+1;
            while(resultado.next()){
                List<String>Fila=new ArrayList();
                for(int i=1; i<Columnas; i++){
                    Fila.add(resultado.getString(i));
                }
                Resultado.add(Fila);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al obtener la busqueda: "+e.toString());
        }
        return Resultado; 
    }
    public List<List<String>> getResultBusqueda(String Tabla, String Atributo){
        List<List<String>> Resultado=new ArrayList();
        
        return Resultado; 
    }
    public void EliminarDatos(String tabla, int id){
        
        
        try(Statement stm=Nueva_Conexion.createStatement()){
            String sentencia="DELETE FROM "+tabla+"WHERE ID_"+tabla+"="+id; 
            stm.executeQuery(sentencia);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro: ", "Notificación de Estado", JOptionPane.ERROR_MESSAGE);
        }
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
    public void EjecutarSentencia(PreparedStatement Query){
        try{
            Query.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha Agregado el Registro a la Base de Datos","Ingreso Exitoso", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Ejecutar la Sentencia: "+e.toString()); 
        }
    }
}
