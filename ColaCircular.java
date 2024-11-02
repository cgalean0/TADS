public class ColaCircular<T> implements Cola<T>{

    private T[] array;
    private int inicio;
    private int fin;
    private int capMax;
    private int contador;

    
    @SuppressWarnings("unchecked")
    public ColaCircular(int capMax){
        this.array = (T[]) new Object[capMax];
        this.inicio = 0;
        this.fin = 0;
        this.capMax = capMax;
        this.contador = 0;
    }

    /**
     * Agrega un elemento al final de la cola
     */
    @Override
    public void enconlar(T item) {
        array[(fin % capMax)] = item;
        contador++;
        if (fin < capMax) {
            fin++;
        } else {
            fin = 0;
        }
    }
    /**
     * | Quita un elemento al inicio de la cola
     * @return elem eliminado.
     */
    @Override
    public T desencolar() {
        T elem = array[inicio % capMax];
        contador--;
        if (inicio < capMax) {
            inicio++;
        } else {
            inicio = 0;
        }
        return elem;
    }
    /**
     * @return true ssi la cantidad de elementos es cero
     */
    @Override
    public boolean esVacia() {
        return (contador == 0);
    }
    /**
     * Elimina todo los elementos de la cola.
     */
    @Override
    public void vaciar() {
        while (contador != 0) {
            desencolar();
        }
    }
}//fin clase;