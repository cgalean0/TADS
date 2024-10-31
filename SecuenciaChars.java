import java.util.Stack;
import java.util.Scanner;

public class SecuenciaChars {
    
    /**
     * Implementacion que define si los parentesis están balanceados o no.
     * @param lista es la lista que queremos chequear.
     */
    public void verificarSecuencia(String cadena) {
        if (cadena.equals(null)) {
            throw new IllegalArgumentException("Cadena nula");
        }

        Stack<String> stackList = new Stack<>();//Stack que guarda los parentesis.
        char[] charArray = cadena.toCharArray();//Convierto la lista a un arreglo de caracteres.
        
        for (int i = 0; i < charArray.length; i++) {
           if (charArray[i] == '(') {
                stackList.push("(");
           } else if (charArray[i] == ')' && stackList.size() >= 1) {
                stackList.pop();
           }
        }
        if (stackList.isEmpty()){//Si el stack está vacio entonces indica que está balanceado
            System.out.println("Está balanceado.");
        } else {
            System.out.println("No está balanceado.");
        }
    }

    /**
     * Con el main busco recibir la cadena de caracteres.
     * @param args es la entrada que recibe desde la consola.
     */
    public static void main(String[] args) {
        SecuenciaChars verSec = new SecuenciaChars();
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();//Leemos la entrada por consola
        sc.close();
        verSec.verificarSecuencia(word);     
    }

}
