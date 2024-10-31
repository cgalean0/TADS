/**
 * Esta clase implementa el TAD Lista utilizando memoria dinámica (Nodos enlazados)
 * Ademas esta lista esta implementada con ficticio.
 */
public class ListaEnlazada<T> implements Lista<T> {
    

    //Estructura de los nodos
    private class Nodo {
        protected T elem;
        protected Nodo siguiente;

        Nodo(T elem) {
            this.elem = elem;
            this.siguiente = null;
        }
    }

    private Nodo cabeza;//Indica la cabeza de la lista.
    private int tamaño;//Lleva el tamaño de la lista.

    //Constructor de la clase.
    public ListaEnlazada(){
        this.cabeza = new Nodo(null);//Implementa un ficticio.
        this.tamaño = 0;
    }

    /**
     * | Método que inserta un elemento al final de la lista.
     * @param item es el elemento que guardaremos en al final de la lista.
     * @pre @param item no debe ser null.
     * @post agrega el item al final de la lista.
     */
    public void insertarFin(T item){
        //Precondition.
        if(item.equals(null)) throw new IllegalArgumentException("El item no debe ser nulo");

        
        Nodo nuevoNodo = new Nodo(item); // Creamos el nodo que contiene el item.
        Nodo puntero = cabeza; //Usamos un puntero para ubicar el último elemento.
        while (puntero.siguiente != (null)) {//Recorremos el arreglo hasta llegar al ultimo
            puntero = puntero.siguiente;
        }
        puntero.siguiente = nuevoNodo;//Insertamos el elemento.
        tamaño++;
    }

    /**
     * | Método que permite insertar un elemento al principio de la lista.
     * @param elem es el elemento que se desea insertar
     * @pre @param elem no debe ser null
     * @post inserta el elemento al principio de la lista.
     */
    public void insertarInicio(T elem){
        //Precondition
        if (elem.equals(null)) throw new IllegalArgumentException("Elem no debe ser null");
        
    
        Nodo nuevoNodo = new Nodo(elem);
        if (longitud() >= 1) {
            nuevoNodo.siguiente = cabeza.siguiente;
            cabeza.siguiente = nuevoNodo;
            tamaño++;
        } else {
            cabeza.siguiente = nuevoNodo;
            tamaño++;
        }
    }

    /**
     * | Método que permite insertar en una posicion de la lista un elemento.
     * @param elem es el elemento que se desea insertar
     * @param pos es la posicion donde se quiere insertar el elemento.
     * @pre @param elem no debe ser "null" y @param pos no debe ser menor a la longitud de la lista.
     */
    public void insertarPos(T elem, int pos){
        //Precondition
        if (pos < 0) throw new IllegalArgumentException("La posicion no es válida.");
        if (elem.equals(null)) throw new IllegalArgumentException("El elemento es nulo.");

        
        Nodo nuevoNodo = new Nodo(elem);//Almacenamos el elemento en un nodo
        Nodo puntero = cabeza;//usamos un puntero para recorrer la lista
        if (pos > tamaño){//Si la posicion que quiere ser insertada es mayor inserta al final.
            insertarFin(elem);//Utilizo el método ya declarado para eso.
            tamaño++;
        } else {
            int i = 1;
            while(i < pos){//Iteramos hasta llegar a la posicion donde se desea insertar
                puntero = puntero.siguiente;
                i++;
            }
            nuevoNodo.siguiente = puntero.siguiente;//Se referencia el siguiente del nuevo nodo
            puntero.siguiente = nuevoNodo; //Se cambia la referencia del nodo anterior
            tamaño++;
        }
    }
    
    /**
     * Elimina la primera ocurrencia del elemento. 
     * @param item Elemento a eliminar
     * @return true si el elemento se eliminó, falso si el elemento no pertenece a la lista.
     * @pre lista.longitud() == N
     * @pos lista.longitud() == N-1
     */
    
    public boolean eliminar(T item){
        //Precondition
        if (longitud() <= 0) throw new IllegalStateException("No puedes eliminar nada de una lista vacía");
        
        Nodo puntero = cabeza.siguiente;//Puntero para recorrer la lista
        int i = 1;
        while (puntero.siguiente != null && i < tamaño){//Recorre hasta encontrar el elemento
            if (puntero.elem.equals(item)) {
                puntero.siguiente = puntero.siguiente.siguiente;
                tamaño--;
                return true;
            }
            puntero = puntero.siguiente;
        }
        return false;
    }

    /**
     * Elimina el elemento en la posicion especificada
     * @param pos es la posicion del elemento
     * @return true ssi el elemento es eliminado.
     */
    @Override
    public boolean eliminarPos(int pos) {
        if (pos < 0 || pos > longitud()) throw new IllegalArgumentException("La posicion debe ser válida");
        int contador = 0;
        Nodo puntero = cabeza.siguiente;
        Nodo actual = puntero;
        while (contador < pos) {
            actual = puntero;
            puntero = puntero.siguiente;
            contador++;
        }
        if (contador == pos) {
            actual.siguiente = puntero.siguiente;
            tamaño--;
            return true;
        }
        return false;
    }
    /**
     * Busca la posición en la que se encuentra un elemento.
     * @param item Elemento a buscar
     * @return Posición o -1 en caso que no se encuentre
     * @pos (posicion == -1) or (0 <= posicion < lista.longitud())  
     */

    public int buscar(T item){
        //Precondition
        if (tamaño < 0 || item == null) throw new IllegalStateException("La lista está vacía");

    
        int posicion = 1;
        Nodo puntero = cabeza.siguiente;
        while (puntero.siguiente != null && posicion < tamaño) {
            if (puntero.elem.equals(item)) {
                return posicion; //Retorna la posicion en caso de encontrar el elemento.
            }
            puntero = puntero.siguiente;
            posicion++;
        }        
        return -1;//Si no lo encuentra retorna -1
    }
    /**
     * | Método que retorna el tamaño de la lista.
     * @return tamaño actual de la lista.
     */
    public int longitud(){
        return tamaño;
    }
    /**
     * Imprime por pantalla los elementos de la lista.
     */
    
    
    public void imprimir(){
        if (longitud() <= 0) throw new IllegalStateException("La lista está vacía");
        
        Nodo puntero = cabeza.siguiente;
        StringBuilder resultado = new StringBuilder("Elementos de la lista: ");
        int contador = 0;
        while (contador < tamaño) {
            resultado.append(puntero.elem).append(" --> ");
            puntero = puntero.siguiente;
            contador++;
        }
        System.out.println(resultado.toString());
    }
    /**
     * Retorna el elemento en un cierto indice o posicion.
     * @param index es la posicion del elemento.
     * @pre index debe ser un indice valido, 0<= index < longitud.
     * @return elem en la posicion indicada o null si no encuentra el elemento.
     */
    @Override
    public T obtenerElem(int index) {
        if (index < 0 || index > longitud()) throw new IllegalArgumentException("El indice no es válido, o la lista está vacía.");

        Nodo puntero = cabeza.siguiente;
        int contador = 0;
        T elem = null;
        while (contador != index) {
            elem = puntero.elem;
            puntero = puntero.siguiente;
            contador++;
        }
        return elem;
    }
    
}//Fin de la clase.