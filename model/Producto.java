package mx.itam.diplomado.libreria.model;

/**
 *
 * 
 * Modelado de los productos en la librería
 * 
 * @author Guillermo Hernández
 * @version 1.0
 */
public class Producto implements Comparable<Producto>{
    private int id,catId;
    private String descripcion;
    private double costo,precio;
    
    /*
     * Constructor
     * @param catId Numero de categoría
     * @param id Id del producto
     */
    public Producto(int catId, int id){
        this.catId=catId;
        this.id=id;
        this.descripcion=new String();
        this.costo=0;
        this.precio=0;
    }
    
    /*
     * Constructor
     * @param catId Numero de categoría
     * @param id Id del producto
     * @param desc Descripcion del producto
     */
    public Producto(int catId, int id, String desc){
        this.catId=catId;
        this.id=id;
        this.descripcion=desc;
        this.costo=0;
        this.precio=0;
    }
    
    /*
     * Constructor
     * @param catId Numero de categoría
     * @param id Id del producto
     * @param desc Descripcion del producto
     * @param costo Costo del producto
     * @param precio Precio del producto
     */
    public Producto(int catId, int id, String desc, double costo, double precio){
        this.catId=catId;
        this.id=id;
        this.descripcion=desc;
        this.costo=costo;
        this.precio=precio;
    }
    
    /*
     * Devuelve el ID del producto
     * @return id int ID del producto
     */
    public int getId(){
        return this.id;
    }
    /*
     * Devuelve el ID de la categoría del producto
     * @return int CatId
     */
    public int getCatId(){
        return this.catId;
    }
    
    /*
     * Establece la categoría a la que pertenece el producto
     *  @param catid int Categoria del producto
     */
    public void setCatId(int catid){
        this.catId=catid;
    }
    
    /*
     * Devuelve la descripcion del producto
     * @return descripcion String Descripcion del producto
     */
    public String getDescripcion(){
        return this.descripcion;
    }

    /*
     *Establece la descripcion del producto
     * @param descripcion String Descripcion del producto
     */
    public void setDescripcion(String desc){
        this.descripcion=desc;
    }
    
    /*
     * Devuelve el costo del producto
     * @return costo double costo del producto
     */
    public double getCosto(){
        return this.costo;
    }
    
    /*
     *  Establece el costo del producto
     *  @param x double Costo del producto
     */
    public void setCosto(double x){
        this.costo=x;
    }
    
    /*
     *  Devuelve el precio del producto
     *  @return precio double Precio del producto
     */
    public double getPrecio(){
        return this.precio;
    }
            
    /*
     *  Establece el precio del producto
     *  @param x double Precio del producto
     */
    public void setPrecio(double x){
        this.precio=x;
    }
    
    @Override
    public String toString(){
        return "Producto (Objeto) {id=>"+this.id+", categoria=>"+this.catId+", descripcion=>"+this.descripcion+", costo=>"+this.costo+", precio=>"+this.precio+"}\n";
    }
    
    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + this.id;
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
            Producto other = (Producto) obj;
            if (this.id != other.id)
                    return false;
            return true;
    }

    @Override
    public int compareTo(Producto arg0) {
            return this.getId()-arg0.getId();
    }
    
    
    
}