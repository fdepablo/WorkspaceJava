/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author vened
 */
public class _04_JavaFXSonido extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        AudioClip audio = new AudioClip(getClass().getResource("Audio/Note5.wav").toString());
        audio.play();
        
        //Podemos combinarlos
        Group root = new Group();
        
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
