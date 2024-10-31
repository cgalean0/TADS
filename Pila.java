
/**
 * Interface del TAD pila.
 */
public interface Pila<T> {
    /**
     * | Método apilar apila un elemento en
     * tope de la pila.
     * @param item es el elemento a apilar.
     * @pre item no debe ser null.
     * @post debe apilar el elemento en el tope de
     * la pila e incrementar el tamaño de la pila.
     */
    void apilar(T item);

    /**
     * | Método que permite desapilar un elemento
     * del tope de la pila.
     * @pre pila no debe estar vacía.
     * @post desapila el elemento decrementando
     * el tamaño de la pila.
     */
    void desapilar();


    /**
     * | Método que devuelve el elemento en el
     * tope de la pila.
     * @pre pila no debe estar vacía.
     * @post devuelve el tope de la pila
     */
    T tope();

    /**
     * | Método que nos dice si una pila es
     * vacía.
     * @pre True
     * @return True ssi longitud de pila es 0.
     */
    boolean esVacia();
    
    /**
     * | Método vaciar elimina todos los elementos
     * de la pila.
     * @pre True.
     * @post la longitud de la lista queda en 0.
     */
    void vaciar();
    
    /**
     * Imprime la lista por pantalla
     */
    void getLista();
}