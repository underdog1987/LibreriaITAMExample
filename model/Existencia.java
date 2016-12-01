package mx.itam.diplomado.libreria.model;

/**
 * Class Existencia
 * Modelado de la tabla de existencias
 *
 * @author Guillermo Hernández
 * @version 1.0
 * 
 */
public class Existencia implements Comparable<Existencia> {
    private Centro centro;
    private Producto producto;
    private int existencias;
    
    public Existencia(Centro centro, Producto producto){
        this.centro=centro;
        this.producto=producto;
        this.existencias=0;
    }
    
    public Existencia(Centro centro, Producto producto, int e){
        this.centro=centro;
        this.producto=producto;
        this.existencias=e;
    }
    
    /*
     *  Devuelve el centro al qiue refiere la existencia
     *  @return centro Centro
     */
    public Centro getCentro(){
        return this.centro;
    }
    
    /*
     *  Devuelve el producto al qiue refiere la existencia
     *  @return producto Producto
     */
    public Producto getProducto(){
        return this.producto;
    }
    
    /*
     *  Devuelve las existencias a las que refire la existencia (objeto)
     *  @return n int
     */
    public int getExistencias(){
        return this.existencias;
    }
    
    /*
     *  Establece las existencias a las que refire la existencia (objeto)
     *  @param a int
     */
    public void setExistencias(int a){
        this.existencias=a;
    }
    
    @Override
    public String toString(){
        return "Existencia (Objeto) {\n"+
                    "centro=>(Objeto){\n" +
                        this.centro.toString()+"},\n" +
                    "producto=>(Objeto){\n"+
                        this.producto.toString()+"},\n"+
                    "existencias=>"+this.existencias+
                "\n}";
    }
    
    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + this.centro.getIdCentro();
            result = prime * result + this.producto.getId();
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
            Existencia other = (Existencia) obj;
            if(!other.centro.equals(this.centro) || !other.producto.equals(this.producto)){
                return false;
            }
            return true;
    }

    @Override
    public int compareTo(Existencia arg0) {
            return this.hashCode()-arg0.hashCode();
    }

    
}
