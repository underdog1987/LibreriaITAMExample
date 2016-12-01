package mx.itam.diplomado.libreria.utils;


public class ListaIndexadaOrdenada <T extends Comparable <T>> {
	private T [] datos; 
	private int n;
	private final int MAX= 50;

	public ListaIndexadaOrdenada(){
		datos = (T[]) new Comparable[MAX];
		n= 0;
	}
	
	public ListaIndexadaOrdenada(int max){
		datos= (T []) new Comparable[max];
		n= 0;
	}	
	
	public ListaIndexadaOrdenada(T [] arr){
		int tam;
		
		if (arr.length > MAX)
			tam = arr.length*2;
		else
			tam=MAX;
		datos = (T[]) new Comparable[tam];
		n = arr.length;
		for (int i=0; i<n; i++)
			datos[i]= arr[i];
		ManejadorArreglosGenerico.seleccionDirecta(datos, n);
	}

	public boolean add(T x){
		boolean result = false;
		int pos;
		
		if (n<datos.length) {
			pos = ManejadorArreglosGenerico.busqBinaria(datos, n, x);
			if (pos < 0) {
				pos = -pos-1;
				ManejadorArreglosGenerico.corrimientosDer(datos, n, pos);
				datos[pos]= x;
				n++;
				result = true; 
			}
		} 
		return result;
	}
	
	
	 /*public boolean add(T x){
		boolean result = false;
		int pos;
		
		if (n==datos.length) 
			expandCapacity();
		pos = ManejadorArreglosGenerico.busqBinaria(datos, n, x);
		if (pos < 0) {
			pos = -pos-1;
			ManejadorArreglosGenerico.corrimientosDer(datos, n, pos);
			datos[pos]= x;
			n++;
			result = true; 
		} 
		return result;
	}
	*/
	
	public T remove(int pos) {
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
		return ManejadorArreglosGenerico.busqBinaria(datos, n, x);
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
	
	public boolean isEmpty() {
		return n==0;
	}
	
	public void clear() {
		datos = (T[]) new Comparable[MAX];
		n = 0;
	}
	

	/*public void expandCapacity() {
		T[] datosMasGrande = (T[]) new Comparable[datos.length*2];
		
		for (int i=0; i<n; i++)
			datosMasGrande[i] = datos[i];
		datos = datosMasGrande;
	}
	*/
	
	public String toString(){
		StringBuilder salida = new StringBuilder();
		
		salida.append("\nNumero de elementos : "+n);
		for (int i=0; i<n; i++)
			salida.append("\n" + datos[i].toString());
		return salida.toString();
	}
	
}


