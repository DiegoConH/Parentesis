import java.util.Scanner;
import java.util.Stack;

public class Parentesis {

    private static Stack<String> automataPila=new Stack<>();

    public static void main(String[] args){
        System.out.println("Ingrese parentesis,corchetes o llaves: ");
        Scanner input=new Scanner(System.in);
        String cadena=input.next();

        System.out.println(matcher(cadena,0));
    }

    private static boolean matcher(String cadena, int contador){
        if(String.valueOf(cadena.charAt(contador)).matches("[\\(|\\[|\\{]")){
            automataPila.push(String.valueOf(cadena.charAt(contador)));
        }else{
            if(String.valueOf(cadena.charAt(contador)).matches("[\\)|\\]|\\}]")){
                if(contador==cadena.length()-1){
                    if(automataPila.size()>1){
                        System.out.println("cadena no balanceada, cierres faltantes.");
                        return false;
                    }else{
                        automataPila.pop();
                    }
                }else{
                    if(automataPila.empty()){
                        System.out.println("cadena no balanceada, cierres de mas");
                        return false;
                    }else{
                        automataPila.pop();
                    }
                }
            }
        }

        contador+=1;

        if(contador==cadena.length()){
            return true;
        }else{
            return matcher(cadena,contador);
        }
    }
}
