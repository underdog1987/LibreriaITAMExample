package mx.itam.diplomado.libreria.model;

import mx.itam.diplomado.libreria.utils.ListaIndexadaOrdenada;

/**
 * class ManejadorCategorias
 * @author Guillermo Hernández
 */
public class ManejadorCategorias {
    private ListaIndexadaOrdenada<Categoria> categorias;
    /*
     * Constructor
     */
    public ManejadorCategorias(){
        super();
        this.categorias = new ListaIndexadaOrdenada<Categoria>();
    }
    
    /*
     * Añade una categoria a la lista
     * @param id:int
     * @param nombre:String
     * @return true si se añade correctamente
     * 
     */
    public boolean addCategoria(int id, String nombre){
        return this.categorias.add(new Categoria(id,nombre));
    }
    

    /*
     * Añade una categoria a la lista
     * @param c:Categoria
     * @return true si se añade correctamente
     * 
     */
    public boolean addCategoria(Categoria c){
        return this.categorias.add(c);
    }
    
    /*
     * Elimina la categoria dada
     * @param id:int
     * @return eliminada:Categoria
     * 
     */
    public Categoria removeCategoria(int id){
        return this.categorias.remove(new Categoria(id));
    }
    
    /*
     * Elimina la categoria dada
     * @param c:Categoria
     * @return eliminada:Categoria
     * 
     */
    public Categoria removeCategoria(Categoria c){
        return this.categorias.remove(c);
    }
    
    /*
     * Cambia el nombre de la categoria dada
     * @param cid:int
     * @param newName:String
     * @return true si se cambia correctamente
     * 
     */
    public boolean renameCategoria(int cid, String newName){
        boolean b=false;
        Categoria c=new Categoria(cid);
        int pos=this.categorias.indexOf(c);
        if(pos>=0){
            this.categorias.get(pos).setNombre(newName);
            b=true;
        }
        return b;
    }
    
    /*
     * Cuenta cuantos Categorias hay en la lista
     * @return int
     * 
     */
    public int countCategories(){
        return this.categorias.size();
    }
    
    /*
     * Borra todas las categorias de la lista
     * 
     */
    public void clear(){
        this.categorias.clear();
    }
    
    /*
     * 
     * @param c:Categoria
     * @return ca:Categoria
     * 
     */
    public Categoria containsCategoria(Categoria c){
        int pos=this.categorias.indexOf(c);
        if(pos>=0){
            return this.categorias.get(pos);
        }else{
            return null;
        }
    }
    
    /*
     * Devuelve el objeto Categoria que tega el Id indicado
     * @param c:int
     * @return c:Categoria
     * 
     */
    public Categoria getCategoria(int c){
        return this.containsCategoria(new Categoria(c));
    }
    
    @Override
    public String toString(){
        StringBuffer c=new StringBuffer();
        c.append("Manejador de Categorias\n");
        c.append("Categorias en la lista\n");
        c.append(this.categorias.toString());
        return c.toString();
                
    }

}
