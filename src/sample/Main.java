package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;
import java.util.Stack;

public class Main extends Application {

    private Stack<String> automataPila=new Stack<>();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        //primaryStage.show();
        System.out.println("Ingrese parentesis,corchetes o llaves: ");
        Scanner input=new Scanner(System.in);
        String cadena=input.next();

        matcher(cadena,0);

    }

    public static void main(String[] args) {
        launch(args);
    }

    private int matcher(String cadena,int contador){
        if(String.valueOf(cadena.charAt(contador)).matches("[\\(|\\[|\\{]")){
            automataPila.push(String.valueOf(cadena.charAt(contador)));
        }else{
            if(String.valueOf(cadena.charAt(contador)).matches("[\\)|\\]|\\}]")){
                if(!automataPila.empty()){
                    if(contador==cadena.length()-1){
                        System.out.println("cadena no balanceada, cierres faltantes.");
                    }else{
                        automataPila.pop();
                    }
                }else{
                    System.out.println("Cadena no balanceada cierres de mas.");
                    return 0;
                }
            }else{
                System.out.println("Cadena incorrecta, debe contener solamente parentesis, corchetes o llaves.");
                return 0;
            }
        }

        contador+=1;

        if(contador==cadena.length()){
            return 1;
        }else{
            return matcher(cadena,contador);
        }
    }
}
