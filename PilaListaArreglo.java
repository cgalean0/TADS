/**
 * | Clase que implementa el TAD pila haciendo uso del TAD ListaArreglo.
 */

public class PilaListaArreglo<T> implements Pila<T>{


    private ListaArray<T> lista;
    private T tope;

    public PilaListaArreglo(int tamList) {
        this.lista = new ListaArray<>(tamList);
        this.tope = null;
    }
    
    /**
     * | Método apilar apila un elemento en
     * tope de la pila.
     * @param item es el elemento a apilar.
     * @pre item no debe ser null.
     * @post debe apilar el elemento en el tope de
     * la pila e incrementar el tamaño de la pila.
     */
    
    public void apilar(T item) {
        //Precondicion
        if (item == null) throw new IllegalArgumentException("Item no debe ser null");
        
        lista.insertarInicio(item);
        tope = item;
    }
    /**
     * | Método que permite desapilar un elemento
     * del tope de la pila.
     * @pre pila no debe estar vacía.
     * @post desapila el elemento decrementando
     * el tamaño de la pila.
     */
    
    public void desapilar() {
        //Precondicion
        if (lista.longitud() <= 0) throw new IllegalStateException("La lista ya está vacía");

        lista.eliminarPos(0);
        tope = lista.obtenerElem(0);
    }
    /**
     * | Método que devuelve el elemento en el
     * tope de la pila.
     * @pre pila no debe estar vacía.
     * @post devuelve el tope de la pila
     */
    
    public T tope() {
        //Precondicion
        if (lista.longitud() <= 0) throw new IllegalStateException("La lista está vacía y no tiene tope");

        return tope;
    }
    /**
     * | Método que nos dice si una pila es
     * vacía.
     * @pre True
     * @return True ssi longitud de pila es 0.
     */
    
    public boolean esVacia() {
        return (lista.longitud() == 0);
    }
    /**
     * | Método vaciar elimina todos los elementos
     * de la pila.
     * @pre True.
     * @post la longitud de la lista queda en 0.
     */
    
    public void vaciar() {
        if (esVacia()) throw new IllegalStateException("La lista ya está vacia");

        while (!esVacia()) {
            desapilar();
        }
    }
    public void getLista(){
        lista.imprimir();
    }
}//Fin clase
