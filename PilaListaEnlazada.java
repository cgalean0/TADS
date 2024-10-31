/**
 * | Clase que implementa el TAD Pila haciendo uso de una TAD lista enlazada.
 */
public class PilaListaEnlazada<T> implements Pila<T>{

    private ListaEnlazada<T> lista;
    private T tope;

    public PilaListaEnlazada() {//Constructor de la clase
        this.lista = new ListaEnlazada<>();
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
    @Override
    public void apilar(T item) {
        //Precondicion
        if (item == null) throw new IllegalArgumentException("Item no debe ser null");
        
        //Lógica del método.
        lista.insertarFin(item);
        tope = item;
    }
    /**
     * | Método que permite desapilar un elemento
     * del tope de la pila.
     * @pre pila no debe estar vacía.
     * @post desapila el elemento decrementando
     * el tamaño de la pila.
     */
    @Override
    public void desapilar() {
        //Precondicion
        if (lista.longitud() < 0) throw new IllegalStateException("Lista vacía, nada por desapilar");

        lista.eliminarPos(lista.longitud() - 1);
        tope = lista.obtenerElem(lista.longitud());
    }
    /**
     * | Método que devuelve el elemento en el
     * tope de la pila.
     * @pre pila no debe estar vacía.
     * @post devuelve el tope de la pila
     */
    @Override
    public T tope() {
        //Precondicion
        if (lista.longitud() < 1) throw new IllegalStateException("La pila está vacía");
        
        return tope;
    }
    /**
     * | Método que nos dice si una pila es
     * vacía.
     * @pre True
     * @return True ssi longitud de pila es 0.
     */
    @Override
    public boolean esVacia() {
        return (lista.longitud() == 0);
    }
    /**
     * | Método vaciar elimina todos los elementos
     * de la pila.
     * @pre True.
     * @post la longitud de la lista queda en 0.
     */
    @Override
    public void vaciar() {
        if (esVacia()) throw new IllegalStateException("La lista ya está vacia");

        while (!esVacia()) {
            desapilar();
        }
    }
    /**
     * | Imprime por pantalla la lista.
     */
    @Override
    public void getLista() {
        lista.imprimir();
    }
    
}//Fin clase
