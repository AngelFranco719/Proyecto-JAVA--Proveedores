package proyecto_java_proveedores;
public class Proyecto_JAVA_Proveedores {
    public static void main(String[] args) {
        ConexionBD Establecer_Conexion=new ConexionBD(); 
        if(Establecer_Conexion.conectado){
            MenuPrincipal Menu=new MenuPrincipal(Establecer_Conexion); 
        }
        else{
            System.exit(0);
        }
    }
}
