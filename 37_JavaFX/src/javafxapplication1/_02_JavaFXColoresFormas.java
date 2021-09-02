/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author vened
 */
public class _02_JavaFXColoresFormas extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //Todos los nodos se van a intentar dibujar siempre todo lo que
        //puedan
        //De las figuras podemos hacer por ejemplo un rectangulo
        //20,20 punto de partida (esquina superior izquierda)
        //300 ancho
        //200 altura
        Rectangle rectangulo = new Rectangle(20,150,300,200);
        //Tenemos algunos metodos
        //setX,setY,setWidth y setHeigth para alterar las propiedades
        //rectangulo.setX(300);
        //rectangulo.setY(200);
        
        //Color de relleno de rectangulo
        rectangulo.setFill(Color.BLUE);
        //color del borde del rectangulo
        rectangulo.setStroke(Color.RED);
        //ancho del borde del rectangulo
        rectangulo.setStrokeWidth(3.5);
        
        //Suelen ser posiciones relativas
        //rectangulo.setLayoutX(300);
        //rectangulo.setLayoutY(200);
        
        //podemos consultar Ensembre para saber todos los efectos
        //que podemos hacer en JavaFX. Es un jar ejecutable, podemos
        //copiarlo en cualquier ruta y hacer doble click
        //Podemos hacer tambien degradados
        /*
            startX - the X coordinate of the gradient axis start point
            startY - the Y coordinate of the gradient axis start point
            endX - the X coordinate of the gradient axis end point
            endY - the Y coordinate of the gradient axis end point
            proportional - whether the coordinates are proportional to the shape which this gradient fills
            cycleMethod - cycle method applied to the gradient
            stops - the gradient's color specification
        */
        LinearGradient gradient1 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, 
                new Stop[] { 
                    new Stop(0, Color.DODGERBLUE), 
                    new Stop(1, Color.GREEN) 
                });
        rectangulo.setFill(gradient1);
        
        //Podemos hacer un poligono, uniendo una serie de puntos
        Polygon poligono = new Polygon(new double[]{ 45 , 10 , 10 , 80 , 80 , 80 , });
        poligono.setFill(gradient1);
        poligono.setLayoutX(150);
        
        Group root = new Group();
        root.getChildren().add(rectangulo);
        root.getChildren().add(poligono);

        
        //La escena es el contenedor para todos los nodos de javaFX
        //largo y alto
        //podemos meter un color predefinido
        //Scene scene = new Scene(root, 500, 550,Color.GRAY);
        
        //Tambien podemos crear uno personalizado
        //Color colorPersonalizado = Color.rgb(255, 255, 0);
        
        //incluso con una opacidad
        //Si la opacidad es 0, se vuelve totalmente transparente(blanco)
        Color colorPersonalizado = Color.rgb(255, 255, 0,0.5);
        
        Scene scene = new Scene(root, 500, 550,colorPersonalizado);
        
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
