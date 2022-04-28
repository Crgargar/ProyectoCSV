package es.cristiangg.armasnucleares;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application {
    
    static Label Titulo = new Label();

    
    // Llamar a pantalla el boton de Introducir numero y de Guardar fichero
    @Override
    public void start(Stage stage) {
        BotonPantalla boton = new BotonPantalla();
        VBox root = new VBox();
        root.setStyle("-fx-background-color: #d5ffff;");
        root.setAlignment(Pos.CENTER);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        boton.Pantalla(root); // Aqui realizamos la llamada
        

        
    }

    public static void main(String[] args) {
        launch();
    }

}