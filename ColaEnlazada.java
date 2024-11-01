/**
 * Clase que implementa la interfaz cola
 */
public class ColaEnlazada<T> implements Cola<T> {

    private ListaEnlazada<T> lista;

    public ColaEnlazada() {
        this.lista = new ListaEnlazada<>();
    }

    /**
     * | Agrega un elemento al final de la cola
     * @param item no debe ser null
     */
    @Override
    public void enconlar(T item) {
        lista.insertarInicio(item);
    }
    /*
     * | Elimina el elemento al inicio de la cola.
     * @pre la cola no debe estar vacía.
     */
    @Override
    public T desencolar() {
        T elementoEliminado = lista.obtenerElem(lista.longitud() - 1);
        lista.eliminarPos(lista.longitud() - 1);
        return elementoEliminado;
    }
    /*
     * | retorna true ssi la longitud de la cola es cero
     */
    @Override
    public boolean esVacia() {
        return lista.longitud() == 0;
    }
    /*
     * | Vacía la cola eliminando todos los elementos
     * @pre la lista debe tener al menos un elemento
     */
    @Override
    public void vaciar() {
        if (lista.longitud() <= 0) throw new IllegalStateException("La lista ya esta vacía");
        while (!esVacia()){
            desencolar();
        }
    }
}//FIn clase