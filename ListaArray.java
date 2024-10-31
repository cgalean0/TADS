
import java.util.Arrays;
/**
 * Esta clase implementa el TAD Lista utilizando un arreglo como estructura base.
 */
public class ListaArray<T> implements Lista<T>
{
    protected T[] elems;//Elementos de la lista
    private int maxSize;//Tamaño maximo de la lista.
    private int contador;//Lleva la cantidad de elementos y marca la posicion vacia de la lista.

    @SuppressWarnings("unchecked")
    public ListaArray(int maxSize){
        this.elems = (T[]) new Object[maxSize];
        this.maxSize = maxSize;
        this.contador = 0;
    }
    /**
     * Inserta un elemento al final de la lista.
     * @param item Elemento a insertar
     * @pre item no debe ser null y debe haber espacio en el arreglo.
     * @post agrega un elemento al final de la lista.
     */
    public void insertarFin(T item){
        //Precondition
        if((contador +1) == maxSize) throw new IllegalStateException("No hay espacio en el arreglo");
        if(item == null) throw new IllegalArgumentException("Item no debe ser null");
        
        //Lógica del método.
        if (elems[contador] == null) {
            elems[contador] = item;
            contador++;
        }
    }

    /**
     * | Método que permite insertar un elemento al inicio de la lista
     * @pre elem no debe ser null y la lista no debe estar llena.
     * @post añade el elemento al principio de la lista
     */
    public void insertarInicio(T elem){
        //Precondition
        if ((contador + 1) == maxSize) throw new IllegalStateException("Lista llena");
        if (elem == null) throw new IllegalArgumentException("El elemento es nulo");

        //Lógica del método
        int i = contador;
        //Movemos los elementos una posicion para insertar el elemento nuevo al inicio
        while (i > 1) {
            int k = i - 1;
            while (k >= 0) {
                elems[i] = elems[k];
                k--;
                i--;
            }
        }
        elems[0] = elem;//Actualizamos el valor del primer elemento
        contador++;//Aumentamos el contador
    }
    /**
     * | Inserta el elemento en la posicion indicada
     * @param elem elemento a guardar.
     * @pre elem no debe ser null, pos debe ser una posicion válida >= 0.
     * @post añade item en la posicion que se indica.  
     */
    public void insertarPos(T elem, int pos){
        //Preconditions
        if ((contador + 1) == maxSize) throw new IllegalStateException("Lista llena.");
        if (pos < 0) throw new IllegalArgumentException("Posicion no válida");
        if (elem == null) throw new IllegalArgumentException("El elemento no debe ser nulo");

        //Lógica del método
        if (pos > contador) {//Si la posicion a insertar supera la cantidad de elementos lo inserta al final
            insertarFin(elem);
        } else {//Sino movemos los elementos que hayan en esa posicion y insertamos el elemento.
            int i = contador;
            while (i > pos) {
                int k = i - 1;
                while (k >= pos) {
                    elems[i] = elems[k];
                    k--;
                    i--;
                }
            }
            elems[pos] = elem;
            contador++;
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
        if (elems.length < 1) throw new IllegalStateException("La lista está vacía.");
        if (item == null) throw new IllegalArgumentException("El item no debe ser null.");
        
        //Logica del método.
        int posElem = buscar(item);
        if (posElem == -1) {
            return false;
        } else {
            int i = posElem;
            int j = i + 1;
            while (i < contador) {
                while (j <= contador) {
                     elems[i] = elems[j];
                    i++;
                    j++;
                }
            }
            contador--;
            return true;
        }
    }
    /**
     * Elimina el elemento en la posicion especificada
     * @param pos es la posicion del elemento
     * @return true ssi el elemento es eliminado.
     */
    @Override
    public boolean eliminarPos(int pos) {
        if (pos > longitud() || pos < 0) throw new IllegalArgumentException("La posicion no es válida.");

        int i = pos;
        int k = i + 1;
        T elemento = elems[pos + 1];
        while (i < elems.length - 1) {
            while (k <= elems.length - 1) {
                elems[i] = elems[k];
                i++;
                k++;
            }
        }
        if(elemento == elems[pos]) {
            contador--;
            return true;
        }
        return false;
    }
    /**
     * | Permite buscar un item dentro de la lista.
     * @pre item no debe ser null y la longitud debe ser mayor a cero.
     * @return posicion del elemento ssi lo encuentra sino -1.
     */
    public int buscar(T item){
        //Precondition
        if (elems.length < 1) throw new IllegalStateException("La lista está vacía");
        if (item == null) throw new IllegalArgumentException("El item no debe ser null");

        boolean isHere = false;//Nos permite evitar que el ciclo siga una vez ya hemos encontrado la primer coincidencia.
        for (int i = 0; i < elems.length && !isHere; i++) {
            if (elems[i] == item) {
                isHere = true;
                return i;
            }
        }
        return -1;
    }
    /**
     * | Método que permite obtener los elementos en un cierto índice.
     * @param index es la posicion del elemento
     * @return el elemento es esa posicion.
     */
    public T obtenerElem(int index) {
        if (index < 0 || index > longitud()) throw new IllegalArgumentException("La posicion debe ser válida");
        return elems[index];
    }
    /**
     * | Devuelve la longitud de la lista.
     */
    public int longitud(){
        return contador;
    }
    /**
     * | Método que imprime la lista completa.
     */
    public void imprimir(){
        System.out.println(Arrays.toString(elems));
    }
    
}//Fin clase