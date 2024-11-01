/*
 * Interface del TAD cola
 */
public interface Cola<T> {

    /*
     * | Agrega un elemento al final de la cola.
     */
    void enconlar(T item);
    
    /*
     * | Elimina un elemento al inicio de la cola.
     */
    T desencolar();

    /*
     * | Retorna si la cola esta vacía
     */
    boolean esVacia();

    /*
     * | Vacía la cola
     */
    void vaciar();
}