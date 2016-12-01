
package mx.itam.diplomado.libreria.model;

/**
 * Class Categoria
 * Modelado de la categoría de productos en la librería
 *
 * @author Guillermo Hernández
 * @version 1.0
 * 
 */
public class Categoria implements Comparable<Categoria> {
    private int id;
    private String nombre;

    /*
     * Constructor
     * @param id Id de la categoría.
     */
    public Categoria(int id){
        super();
        this.id=id;
        this.nombre=new String();
    }
    
    /*
     * Constructor
     * @param id Id de la categoría.
     * @param catName Nombre completo de la categoría
     */
    public Categoria(int id, String catName){
        super();
        this.id=id;
        this.nombre=catName;
    }
    
    /*
     * getId
     * @return Id de categoría
     */
    public int getId(){
        return this.id;
    }
    
    /*
     * getNombre
     * @return Nombre de la categría
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /*
     *  Establece el nombre de la categoria
     *  @param nombre String Nombre de la categoria
     */
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    @Override
    public String toString(){
        return "Categoria (Objeto) {id=>"+this.id+", nombre=>"+this.nombre+"}\n";
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
            Categoria other = (Categoria) obj;
            if (this.id != other.id)
                    return false;
            return true;
    }

    @Override
    public int compareTo(Categoria arg0) {
            return this.id-arg0.id;
    }
}
