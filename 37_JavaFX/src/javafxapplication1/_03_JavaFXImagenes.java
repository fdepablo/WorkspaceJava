/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author vened
 */
public class _03_JavaFXImagenes extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //OJO!!! Para el tema de las imagenes es posible que no las
        //incluya en el ejecutable y puede que haya que hacer un
        //limpiar y construir (en netbeans) para que lo incluya en el
        //ejecutable
        
        //Una imagen es un objeto de describe la ubicación de un archivo de 
        //graficos
        Image image = new Image("javafxapplication1/Images/Duke.png");
        //image = new Image(getClass().getResource(imagePath).toString());
        
        //una imageView es un objeto nodo reals, teniendo
        //las mismas propiedades que un nodo normal (posiciones, altura, anchura)
        //ImageView imageView = new ImageView(image);
        ImageView imageView = new ImageView(image);;
        //podemos alternar imagenes para dar para dar aspecto de movimiento
        //imageView.setImage(image);
        
        //Si queremos escalar una imagen manteniendo el ratio podemos
        //usar lo siguiente
        imageView.setPreserveRatio(true); 
        //el ancho de la foto, mas grande, mayor tam
        imageView.setFitWidth(100);
        
        //Tambien si dos imagenes comparten espacio podemos hacer algo 
        //así para ponerlas encima
        //gloveImageView.toFront();
        
        Image image2 = new Image("javafxapplication1/Images/Glove.png");
        
        //una imageView es un objeto nodo reals, teniendo
        //las mismas propiedades que un nodo normal (posiciones, altura, anchura)
        ImageView imageView2= new ImageView(image2);
        imageView2.setLayoutX(100);
        imageView2.setLayoutY(100);
        //podemos alternar imagenes para dar para dar aspecto de movimiento
        //imageView2.setImage(image2);
        
        Group root = new Group();
        root.getChildren().add(imageView);
        root.getChildren().add(imageView2);
        
        Scene scene = new Scene(root, 500, 550);
        
        //La stage o escena es la ventana de la aplicación
        primaryStage.setTitle("Mi Stage!");
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
