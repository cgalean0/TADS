/**
 * Clase que nos permite comprobar si dada una expresion matemática o texto
 * se fija que los parentesis esten bien balanceados, es decir que, al tener
 * una expresion de la forma "(3+15) * 2" dira que está bien balanceada, en cambio expresiones
 * como )3+15(*2 dira que no es correcta, es decir que no está bien balanceada.
 * Para esto usamos la PilaListaEnlazada.
 */

 public class SecuenciaCharsEnlazada {

    private PilaListaEnlazada<String> pila;

    //Constructor
    public SecuenciaCharsEnlazada() {
        this.pila = new PilaListaEnlazada<>();
    }
    
    /**
     * Método encargado de verificar si los parentesis estan bien balanceados
     * @param entrada es la entrada a verificar
     * @return "Correcto" ssi los parentesis están bien balanceados.
     */
    public String verifParentesis(String entrada) {
        if (entrada == null) throw new IllegalArgumentException("La frase no debe ser null");
        
        char[] listaChars = entrada.toCharArray();//creamos un arreglo de caracteres para recorrer sus elementos
        for (int i = 0; i < listaChars.length; i++) {
            if (listaChars[i] == ')' && pila.esVacia()) {
               
            }
            if (listaChars[i] == '('){
                pila.apilar("(");
            }
            if (!pila.esVacia() && listaChars[i] == ')') {
                pila.desapilar();
            }
        }
        if (pila.esVacia()) {
            return "" + "Está balanceado";
        } else {
            return "" + "No está balanceado";
        }
    }

    public static void main(String[] args) {
        SecuenciaCharsEnlazada sec = new SecuenciaCharsEnlazada();

        
        System.out.println(sec.verifParentesis("()"));
        System.out.println(sec.verifParentesis(")("));
        System.out.println(sec.verifParentesis("()("));
    }

}