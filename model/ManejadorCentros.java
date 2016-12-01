package mx.itam.diplomado.libreria.model;
import mx.itam.diplomado.libreria.utils.ListaIndexadaOrdenada;

/**
 *  Maneja las listas de centros
 *  @author Guillermo Hernández
 *  @version 1.0
 */
public class ManejadorCentros {
    private ListaIndexadaOrdenada<Centro> centros;
    /*
     * Constructor
     */
    public ManejadorCentros(){
        super();
        this.centros=new ListaIndexadaOrdenada<Centro>();
    }

    
    /*
     * Verifica que un centro dado esté en la lista
     * @param c:Centro
     * @return centro:Centro
     * 
     */
    public Centro containsCentro(Centro c){
        int pos=this.centros.indexOf(c);
        if(pos>=0){
            return this.centros.get(pos);
        }else{
            return null;
        }
    }
    
    /*
     * Añade un centro a la lista de centros
     * @param id:int Número de centro
     * @return true:boolean Si se añade correctamente
     * 
     */
    public boolean addCentro(int id){
        return this.centros.add(new Centro(id));
    }
    
    /*
     * Añade un centro a la lista de centros
     * @param id:int Número de centro
     * @param nombre:String Nombre del centro
     * @return true:boolean Si se añade correctamente
     * 
     */
    public boolean addCentro(int id, String nombre){
        return this.centros.add(new Centro(id,nombre));
    }
    
    /*
     * Añade un centro a la lista de centros
     * @param id:int Número de centro
     * @param nombre:String Nombre del centro
     * @param direccion:String Direccion
     * @return true:boolean Si se añade correctamente
     * 
     */
    public boolean addCentro(int id, String nombre, String direccion){
        return this.centros.add(new Centro(id,nombre, direccion));
    }
    
    /*
     * Añade un centro a la lista de centros
     * @param c:Centro Objeto Centro
     * @return true:boolean Si se añade correctamente
     * 
     */
    public boolean addCentro(Centro c){
        return this.centros.add(c);
    }
        
    /*
     * Elimina un centro de la lista de centros
     * @param c:int
     * @return centro:Centro si se elimina correctamente
     * 
     */
    public Centro removeCentro(int c){
        return this.centros.remove(new Centro(c));
    }
    
    /*
     * Elimina un centro de la lista de centros
     * @param c:Centro Objeto Centro
     * @return centro:Centro si se elimina correctamente
     * 
     */
    public Centro removeCentro(Centro c){
        return this.centros.remove(c);
    }
    
    /*
     * Cambia el nombre del centro especificado
     * @param c:int Número de centro
     * @param n:String Nuevo nombre
     * @return true si se cambia correctamente
     * 
     */
    public boolean renameCentro(int c, String n){
        boolean b=false;
        Centro cc=new Centro(c);
        int pos=this.centros.indexOf(cc);
        if(pos>=0){
            this.centros.get(pos).setNombre(n);
            b=true;
        }
        return b;
    }
    
    /*
     * Cambia la dirección del centro especificado
     * @param c:int Número de centro
     * @param n:String Nueva direccion
     * @return true si se cambia correctamente
     * 
     */
    public boolean changeAddressCentro(int c, String n){
        boolean b=false;
        Centro cc=new Centro(c);
        int pos=this.centros.indexOf(cc);
        if(pos>=0){
            this.centros.get(pos).setDireccion(n);
            b=true;
        }
        return b;
    }
    
    /*
     * Cuenta cuantos Centros hay en la lista
     * @return int
     * 
     */
    public int countCentros(){
        return this.centros.size();
    }
    
    /*
     * Elimina los centros de la lista
     * @return int
     * 
     */
    public void clear(){
        this.centros.clear();
    }
    
    /*
     * Devuelve todos los centros de la lista
     * @return lista:ListaIndexadaOrdenada<Centro>
     * 
     */
    public ListaIndexadaOrdenada<Centro> getCentros(){
        return this.centros;
    }
    
    /*
     * Devuelve el objeto Centro de la lista que tenga el idCentro indicado
     * @param c:int
     * @return centro:Centro
     * 
     */
    public Centro getCentro(int c){
        return this.containsCentro(new Centro(c));
    }
    
    @Override
    public String toString(){
        StringBuffer c=new StringBuffer();
        c.append("Manejador de Centros\n");
        c.append("Centros en la lista\n");
        c.append(this.centros.toString());
        return c.toString();
                
    }

}
