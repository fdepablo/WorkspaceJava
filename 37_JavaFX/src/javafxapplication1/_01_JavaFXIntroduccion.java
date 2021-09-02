/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author vened
 */
public class _01_JavaFXIntroduccion extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //Un boton es un nodo JavaFX
        Button btn1 = new Button();
        btn1.setText("Mi boton 1");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hola boton 1!");
            }
        });
        
        Button btn2 = new Button();
        btn2.setText("Mi boton 2");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hola boton 2!");
            }
        });
        
        //Este es el nodo Raiz, y apila los objetos unos encima de otros
        //Hay diferentes paneles
        //StackPane root = new StackPane();
        //Este pone los elementos como si fuera una regilla
        //TilePane root = new TilePane();
        //Este pone los elementos en fila, de arriba a abajo
        //VBox root = new VBox();
        
        //Este permite colocar los elementos en cualquier lugar
        //por defecto los pone todos en x=0 e y=0
        //así que habría que cambiar la posicion a mano
        //Group root = new Group();
        //btn1.setLayoutX(100);
        //btn2.setLayoutX(300);
        //Este es como el VBox,, pero en horizontal
        HBox hbox = new HBox();
        hbox.getChildren().add(btn1);
        hbox.getChildren().add(btn2);
        
        //Podemos combinarlos
        Group root = new Group();
        root.getChildren().add(hbox);
        
        //La escena es el contenedor para todos los nodos de javaFX
        //largo y alto
        Scene scene = new Scene(root, 500, 550,Color.GRAY);
        
        //La stage o etapa es la ventana de la aplicación
        //el objeto de superior nivel
        primaryStage.setTitle("Mi Etapa!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
