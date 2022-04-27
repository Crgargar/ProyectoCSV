package es.cristiangg.armasnucleares;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) {
        BotonPantalla boton = new BotonPantalla();
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
        boton.Pantalla(root);
   
    }

    public static void main(String[] args) {
        launch();
    }

}