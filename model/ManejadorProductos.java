package mx.itam.diplomado.libreria.model;

import mx.itam.diplomado.libreria.utils.ListaIndexadaOrdenada;

/**
 *  Maneja las Listas de productos
 * 
 * @author Guillermo Hernandez
 */
public class ManejadorProductos {
    private ListaIndexadaOrdenada<Producto> productos;
    /*
     * Constructor
     */
    public ManejadorProductos(){
        this.productos=new ListaIndexadaOrdenada<Producto>();
    }
    
    /*
     * Añade un producto a la lista de productos
     * @param cat:int Categoria
     * @param id:int ID de producto
     * @param nombre:String Descripcion del producto
     * @return true:boolean Si se alade correctamente
     * 
     */
    public boolean addProducto(int cat, int id, String nombre){
        return this.productos.add(new Producto(cat,id,nombre));
    }
    
    /*
     * Añade un producto a la lista de productos
     * @param cat:int Categoria
     * @param id:int ID de producto
     * @param nombre:String Descripcion del producto
     * @param c:double Costo
     * @param pre:double Precio
     * @return true:boolean Si se alade correctamente
     * 
     */
    public boolean addProducto(int cat, int id, String nombre, double c, double pre){
        return this.productos.add(new Producto(cat,id,nombre,c,pre));
    }
    
    /*
     * Añade un producto a la lista de productos
     * @param p:Producto Objeto Producto
     * @return true:boolean Si se alade correctamente
     * 
     */
    public boolean addProducto(Producto p){
        return this.productos.add(p);
    }
    
    /*
     * Elimina un producto de la lista de productos
     * @param cat:int Categoria
     * @param id:int ID de producto
     * @return productoEliminado:Producto
     * 
     */
    public Producto removeProducto(int cat, int id){
        return this.productos.remove(new Producto(cat,id));
    }
    
    /*
     * Elimina un producto de la lista de productos
     * @param p:Producto Objeto Producto
     * @return productoEliminado:Producto
     * 
     */
    public Producto removeProducto(Producto p){
        return this.productos.remove(p);
    }
    
    /*
     * Cambia el precio de un producto
     * @param idCat:int ID de categoria del producto
     * @param idProducto:int ID de producto
     * @param precio:double Nuevo precio del producto
     * @return true si cambia correctamente el precio
     * 
     */
    public boolean cambiaPrecio(int idCat, int idProducto, double precio){
        boolean b=false;
        Producto p=new Producto(idCat, idProducto);
        int pos=this.productos.indexOf(p);
        if(pos>=0){
            this.productos.get(pos).setPrecio(precio);
            b=true;
        }
        return b;
    }
    
    /*
     * Cambia el costo de un producto
     * @param idCat:int ID de categoria del producto
     * @param idProducto:int ID de producto
     * @param precio:double Nuevo precio del producto
     * @return true si camia correctamente el costo
     * 
     */
    public boolean cambiaCosto(int idCat, int idProducto, double costo){
        boolean b=false;
        Producto p=new Producto(idCat, idProducto);
        int pos=this.productos.indexOf(p);
        if(pos>=0){
            this.productos.get(pos).setCosto(costo);
            b=true;
        }
        return b;
    }
    
    /*
     * Cambia la categoria de un producto
     * @param idCat:int ID de categoria del producto
     * @param idProducto:int ID de producto
     * @param newCat:int Nuevo precio del producto
     * @return true si camia correctamente la categoria
     * 
     */
    public boolean cambiaCategoria(int idCat, int idProducto, int newCat){
        boolean b=false;
        Producto p=new Producto(idCat, idProducto);
        int pos=this.productos.indexOf(p);
        if(pos>=0){
            this.productos.get(pos).setCatId(newCat);
            b=true;
        }
        return b;
    }
    
    /*
     * Cambia el descripcion de un producto
     * @param idCat:int ID de categoria del producto
     * @param idProducto:int ID de producto
     * @param s:String Nueva descripcion del producto
     * @return true si camia correctamente la descripcion
     * 
     */
    public boolean cambiaDescripcion(int idCat, int idProducto, String s){
        boolean b=false;
        Producto p=new Producto(idCat, idProducto);
        int pos=this.productos.indexOf(p);
        if(pos>=0){
            this.productos.get(pos).setDescripcion(s);
            b=true;
        }
        return b;
    }
    
    /*
     * Cuenta los productos de la lias
     * @return x:int numero de productos en la lista
     * 
     */
    public int countProductos(){
        return this.productos.size();
    }
    
    /*
     * Verifica que un producto dado esté en la lista
     * @param c:Categoria
     * @param p:Producto
     * @return true si el producto dado está en la lista
     * 
     */
    public boolean contains(Categoria c, Producto p){
        boolean b=false;
        int idCat=c.getId();
        int idProducto=p.getId();
        for(int i=0;i<this.countProductos();i++){
            if(this.productos.get(i).getCatId()==idCat && this.productos.get(i).getId()==idProducto){
                b=true;
            }
        }
        return b;
    }
    
    /*
     * Borra todos los productos de la lista
     * 
     */
    public void clear(){
        this.productos.clear();
    }
    
    /*
     * Devuelve los productos que estén en la categoria indicada
     * @param cat:int
     * @return listita:ListaIndexadaOrdenada
     * 
     */
    public ListaIndexadaOrdenada<Producto> getProductsByCat(int cat){
        ListaIndexadaOrdenada<Producto> listita;
        listita= new ListaIndexadaOrdenada<Producto>();
        for(int x=0; x<this.countProductos();x++){
            Producto p=this.productos.get(x);
            System.out.println(p.toString());
            if(p.getCatId()==cat){
                listita.add(p);
            }
        }
        return listita;
    }
    
    @Override
    public String toString(){
        StringBuffer c=new StringBuffer();
        c.append("Manejador de Productos\n");
        c.append("Productos en la lista\n");
        c.append(this.productos.toString());
        return c.toString();
                
    }
}
