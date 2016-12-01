package mx.itam.diplomado.libreria.model;

import mx.itam.diplomado.libreria.utils.ListaIndexadaOrdenada;

/**
 * Manejador de existencias
 * @author Guillermo Hernandez
 */
public class ManejadorExistencias {
    private ListaIndexadaOrdenada<Existencia> existencias;
    /*
     * 
     * Constructor
     */
    public ManejadorExistencias(){
        this.existencias=new ListaIndexadaOrdenada<Existencia>();
    }
    
    
    /*
     * Añade un registro de existencias a la lista
     * @param c:Centro
     * @param p:Producto
     * @return true si se añade correctamente
     */
    public boolean addExistencia(Centro c, Producto p){
        return this.existencias.add(new Existencia(c,p,0));
    }
    
    /*
     * Modifica el registro de existencias
     * @param c:Categoria
     * @param p:Producto
     * @param cant:int
     * @return true si se modifica correctamente
     * 
     */
    public boolean modificaExistencias(Centro c, Producto p, int cant){
        boolean b=false;
        Existencia e=new Existencia(c,p);
        int pos=this.existencias.indexOf(e);
        if(pos>=0){
            this.existencias.get(pos).setExistencias(cant);
            b=true;
        }
        return b;
    }
    
    /*
     * Cuenta las existencias de la lista
     * @return int
     * 
     */
    public int count(){
        return this.existencias.size();
    }
    
    @Override
    public String toString(){
        StringBuffer c=new StringBuffer();
        c.append("Manejador de Existencias\n");
        c.append("Categorias en la lista\n");
        c.append(this.existencias.toString());
        return c.toString();
                
    }

    
}
