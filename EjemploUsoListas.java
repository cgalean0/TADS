public class EjemploUsoListas {
    
    /**
     * Dada una lista vacia, carga valores de ejemplo.
     * Resultado esperado: [2, 3, 8, 4, 43, 32]
     * @param lista
     */
    private static void cargarLista(Lista<Integer> lista){
        lista.insertarInicio(3);
        lista.insertarFin(4);
        lista.insertarInicio(2);
        lista.insertarPos(8, 2);
        lista.insertarFin(43);
        lista.insertarFin(32);
    }

    public static void main(String[] args) {
        ListaArray<Integer> listaConArray = new ListaArray<>(40);
        ListaEnlazada<Integer> listaEnlazada = new ListaEnlazada<>();

        //Importante: notar que el método cargarLista() espera un tipo Lista como parámetro.
        // Ambas clases al implementar la interface Lista son compatibles como parámetro.
        // No importa que implementación de la interface se usa, todas son compatibles.
        cargarLista(listaConArray);
        cargarLista(listaEnlazada);

        System.out.println("Longitud de ambas listas: ");
        System.out.println(listaConArray.longitud());
        System.out.println(listaEnlazada.longitud());

        System.out.println("Mostrando la lista implementada sobre arreglos:");
        listaConArray.imprimir();

        System.out.println("Mostrando la lista implementada con Nodos:");
        listaEnlazada.imprimir();

        //Completar... realizando ejemplos de usos de los demás métodos.
    }
}
