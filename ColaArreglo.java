/**
 * Clase que implementa el Tad cola
 */
public class ColaArreglo<T> implements Cola<T> {

    private ListaArray<T> lista;
    
    public ColaArreglo(int tamMax){
        this.lista = new ListaArray<>(tamMax);
    }
    /**
     * | Añade un elemento al final de la cola
     * @param item es el elemento que agrega
     * @pre la cola no debe estar llena
     */
    @Override
    public void enconlar(T item) {
        lista.insertarInicio(item);
    }

    @Override
    public T desencolar() {
        T elemEliminado = lista.obtenerElem(lista.longitud() - 1);
        lista.eliminarPos(lista.longitud() - 1);
        return elemEliminado;
    }

    @Override
    public boolean esVacia() {
        return (lista.longitud() == 0);
    }

    @Override
    public void vaciar() {
        if (lista.longitud() <= 0) throw new IllegalStateException("La lista ya esta vacía");
        while (!esVacia()) {
            desencolar();
        }
    }

    
}