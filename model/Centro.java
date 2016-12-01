
package mx.itam.diplomado.libreria.model;

/**
 *
 * Class Centro
 * Modelado de los centros de venta
 * 
 * @author Guillermo Hernández
 * @version 1.0
 */
public class Centro implements Comparable<Centro>{
    private int idCentro;
    private String nombreCentro;
    private String direccion;
    
    public Centro(int i){
        super();
        this.idCentro=i;
        this.nombreCentro=new String();
        this.direccion=new String();
    }
    
    public Centro(int i, String nombre){
        super();
        this.idCentro=i;
        this.nombreCentro=nombre;
        this.direccion=new String();
    }
    
    public Centro(int i, String nombre, String direccion){
        super();
        this.idCentro=i;
        this.nombreCentro=nombre;
        this.direccion=direccion;
        
    }    
    
    /*
     *  Devuelve el nombre del centro
     *  @return nombre String Nombre del centro
     */
    public String getNombre(){
        return this.nombreCentro;
    }
    
    /*
     *  Establece el nombre del centro
     *  @param nuevoNombre String Nombre del centro
     */
    public void setNombre(String n){
        this.nombreCentro=n;
    }
    
    /*
     *  Establece la dirección del centro
     *  @param direccion String Nombre del centro
     */
    public void setDireccion(String n){
        this.direccion=n;
    }
    
    /*
     *  Devuelve el ID del centro
     *  @return id int Id del centro
     */
    public int getIdCentro(){
        return this.idCentro;
    }
    
    /*
     *  Devuelve la direccion del centro
     *  @return direccion String Direccion del centro
     */
    public String getDireccion(){
        return this.direccion;
    }

    @Override
    public String toString(){
        return "Centro (Objeto) {idCentro=>"+this.idCentro+", nombreCentro=>"+this.nombreCentro+", direccion=>"+this.direccion+"}\n";
    }
    
    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + this.idCentro;
            return result;
    }
    @Override
    public boolean equals(Object obj) {
            if (this == obj)
                    return true;
            if (obj == null)
                    return false;
            if (getClass() != obj.getClass())
                    return false;
            Centro other = (Centro) obj;
            if (this.idCentro != other.idCentro)
                    return false;
            return true;
    }

    public int compareTo(Centro arg0) {
            return this.idCentro-arg0.idCentro;
    }
}
