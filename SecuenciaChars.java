import java.util.Stack;
import java.util.Scanner;

public class SecuenciaChars {
    
    /**
     * Implementacion que define si los parentesis están balanceados o no.
     * @param lista es la lista que queremos chequear.
     */
    public String verificarSecuencia(String cadena) {
        if (cadena.equals(null)) {
            throw new IllegalArgumentException("Cadena nula");
        }

        Stack<String> stackList = new Stack<>();//Stack que guarda los parentesis.
        char[] charArray = cadena.toCharArray();//Convierto la lista a un arreglo de caracteres.
        
        for (int i = 0; i < charArray.length; i++) {
           if (charArray[i] == ')' && stackList.isEmpty()) {
                return "" + "No está balanceado";
           }
           if (charArray[i] == '(') {
                stackList.push("(");
           }
           if (charArray[i] == ')' && !stackList.isEmpty()) {
                stackList.pop();
           }
        }
        if (stackList.isEmpty()){//Si el stack está vacio entonces indica que está balanceado
            return "" + "Está balanceado";
        } else {
            return "" + "No está balanceado";
        }
    }

    public static void main(String[] args) {
        SecuenciaChars sec = new SecuenciaChars();
        System.out.println(sec.verificarSecuencia("()"));
        System.out.println(sec.verificarSecuencia(")("));
        System.out.println(sec.verificarSecuencia(")()"));
    }

}
