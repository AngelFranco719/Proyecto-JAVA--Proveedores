
package proyecto_java_proveedores;

public class Pieza {
private String id_pieza="";
private String nombre_pie="";
private String categoria_pie="";
private String codigo_pie="";
private String color_pie="";
private String descripcion_pie="";
private String material_pie="";
private String dimensiones_pie="";


public void SetPieza(String cid,String cnom, String ccod, String cdes, String cmat, String cdim, String ccat,  String ccol)
{
        setId_pieza(cid);
        setNombre_pie(cnom);
        setCategoria_pie(ccat);
        setCodigo_pie(ccod);
        setColor_pie(ccol);
        setDescripcion_pie(cdes);
        setMaterial_pie(cmat);
        setDimensiones_pie(cdim);
    System.out.println("Objeto Pieza iniciado");
}

public void DespPie()
{
     System.out.println("Objeto Pieza");
        System.out.println("ID: " + getId_pieza());
        System.out.println("Nombre: " + getNombre_pie());
        System.out.println("Categoria: " + getCategoria_pie());
        System.out.println("Codigo: " + getCodigo_pie());
        System.out.println("Color: " + getColor_pie());
        System.out.println("Descripcion: " + getDescripcion_pie());
        System.out.println("Material: " + getMaterial_pie());
        System.out.println("Dimensiones: " + getDimensiones_pie());
}

    /**
     * @return the id_medico
     */
    public String getId_pieza() {
        return id_pieza;
    }

    /**
     * @param id_pieza the id_medico to set
     */
    public void setId_pieza(String id_pieza) {
        this.id_pieza = id_pieza;
    }

    /**
     * @return the nombre_med
     */
    public String getNombre_pie() {
        return nombre_pie;
    }

    /**
     * @param nombre_pie the nombre_med to set
     */
    public void setNombre_pie(String nombre_pie) {
        this.nombre_pie = nombre_pie;
    }

    /**
     * @return the esp_med
     */
    public String getCategoria_pie() {
        return categoria_pie;
    }

    /**
     * @param categoria_pie the esp_med to set
     */
    public void setCategoria_pie(String categoria_pie) {
        this.categoria_pie = categoria_pie;
    }

    /**
     * @return the tel_med
     */
    public String getCodigo_pie() {
        return codigo_pie;
    }

    /**
     * @param codigo_pie the tel_med to set
     */
    public void setCodigo_pie(String codigo_pie) {
        this.codigo_pie = codigo_pie;
    }
    
    public String getColor_pie() {
        return color_pie;
    }

    /**
     * @param color_pie the tel_med to set
     */
    public void setColor_pie(String color_pie) {
        this.color_pie = color_pie;
    }
    
    public String getDescripcion_pie() {
        return descripcion_pie;
    }

    /**
     * @param descripcion_pie the tel_med to set
     */
    public void setDescripcion_pie(String descripcion_pie) {
        this.descripcion_pie = descripcion_pie;
    }

    public String getMaterial_pie() {
        return material_pie;
    }

    /**
     * @param material_pie the tel_med to set
     */
    public void setMaterial_pie(String material_pie) {
        this.material_pie = material_pie;
    }

    public String getDimensiones_pie() {
        return dimensiones_pie;
    }

    /**
     * @param dimensiones_pie the tel_med to set
     */
    public void setDimensiones_pie(String dimensiones_pie) {
        this.dimensiones_pie = dimensiones_pie;
    }
}

