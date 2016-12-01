package mx.itam.diplomado.libreria.utils;


public class ListaIndexadaDesordenada <T>{
	private T [] datos; 
	private int n;
	private final int MAX= 50;

	public ListaIndexadaDesordenada(){
		datos = (T[]) (new Object[MAX]);
		n= 0;
	}
	
	public ListaIndexadaDesordenada(int max){
		datos= (T []) (new Object[max]);
		n= 0;
	}	
	
	public ListaIndexadaDesordenada(T [] arr){
		int tam;
		
		if (arr.length > MAX)
			tam = arr.length*2;
		else
			tam=MAX;
		datos = (T[]) (new Object[tam]);
		n = arr.length;
		for (int i=0; i<n; i++)
			datos[i]= arr[i];
	}

	public boolean addFirst(T x){
		
		//en el caso de que el length de la lista sea igual al maximo se duplucaria
		//se utlizaria el metodo recorre a la derecha
		//esto se hace tomando como lugar de inicio el indice 0 ya que es el primero
		//al final se pondria el elemento nuevo al principio de la lista
		
		boolean result = false;
		
		if (n<datos.length) {
				ManejadorArreglosGenerico.corrimientosDer(datos, n, 0);
				datos[0]= x;
				n++;
				result = true; 
			}
		return result;
	}
	/* addFirst es
	 * lo mismo que invocar a add(0,x)
	 */
		
	public boolean addLast(T x){
		
		//se checa la longitud de la lista para ver si se provoca o no un overflow
		//si se sobrapasa la cantidad maxima de elementos la lista duplica su longitud
		//el length original se guarda en una variable para usarla de referencia
		//se duplica la variable que contiene longitud de la lista, si es necesario
		//se usa el valor del length para tener la posicion del ultimo dato actual de la lista 
		//al valor se le suma 1 y se usa como indice para poner el ultimo dato nuevo
		//se agrega el dato en la casilla
		
		boolean result = false;
		
		if (n<datos.length) {
				datos[n]= x;
				n++;
				result = true; 
			}
		return result;
	}
	/* AddLast es
	 * lo mismo que invocar a add(n,x)
	 */
	
	
	public boolean add(int pos, T x){
		//se da el lenght de la lista para saber el numero de casillas que se tiene
		//se pide el numero de la casilla en la que se quiere poner el dato
		//si el numero sobrepasa al lenght o el lenght es igual al maximo, se duplica su longitud
		//se hace un corrimiento a la derecha desde la casilla elegida
		//luego se coloca el dato en la casilla deseada
		boolean result = false;
		
		if (n<datos.length && pos>=0) {
				ManejadorArreglosGenerico.corrimientosDer(datos, n, pos);
				datos[pos]= x;
				n++;
				result = true; 
			}
		return result;
	}
	
	/* add version con expandCapacity:
	public boolean add(int pos, T x){
		boolean res=false;
	
		if (n==datos.length) 
			expandCapacity();
		if (pos>=0){
			ManejadorArreglosGenerico.corrimientosDer(datos, n, pos);
			datos[pos]= x;
			n++;
			res=true;
		}
		return res;
	}
	 */


	
	
	
	
	public T remove(int pos) {
		//se pide la posicion al usuario
		//el codigo se para si la posicion no existe dentro de la lista
		//se utiliza el metodo recorrimiento a la izquierda de los datos 
		//para quitar el dato de la lista se usa el indice obtenido, se busca y se sobre escribe con el corrimiento
	
		T resultado = null;
		
		if (n>0 && pos>=0 && pos<n) {
			resultado = datos[pos]; 
			ManejadorArreglosGenerico.corrimientosIzq(datos, n, pos);
			n--;
			datos[n] = null;
		}
		return resultado;



	}
	
	public T remove(T x) {
		//se checa el lenght de la lista para saber la cantidad de elementos que tiene
		// se crea una lista nueva con el mismo nombre y longitud pero esta queda vacia
		T resultado = null;
		int pos;
		
		pos = indexOf(x);
		if (pos>=0) {
			resultado = datos[pos]; 
			ManejadorArreglosGenerico.corrimientosIzq(datos, n, pos);
			n--;
			datos[n] = null;
		}
		return resultado;	
	}
	
	public int indexOf(T x) {
		return ManejadorArreglosGenerico.busqSecuencialDesordenada(datos, n, x);
	}
	
	public T get(int index){
		T result = null;
		
		if (index>=0 && index<n) 
			result = datos[index];
		return result;
	}	
	
	public boolean contains(T x) {
		return indexOf(x)>=0 ? true : false;
	}
	
	public int size( ) {
		return n;
	}
	
	boolean isEmpty() {
		return n==0;
	}
	
	public void clear() {
		datos = (T[]) new Object[MAX];
		n = 0;
	}
	
	
	/*public void expandCapacity() {
		T[] datosMasGrande = (T[]) new Object[datos.length*2];
		
		for (int i=0; i<n; i++)
			datosMasGrande[i] = datos[i];
		datos = datosMasGrande;
	}
	*/
	
	public String toString(){
		StringBuilder salida = new StringBuilder();
		
		salida.append("Numero de elementos:"+n);
		for (int i=0; i<n; i++)
			salida.append("\n" + datos[i]);
		return salida.toString();
	}
	
}