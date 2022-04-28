package es.cristiangg.armasnucleares;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class BotonPantalla {
    
// Variables
    
    static TextArea textArea = new TextArea();
    static String GuardarDatos;
 
    public void Pantalla(VBox root){
        TextField textfield = new TextField(); // Donde introducimos el año que queremos
            textfield.setMinWidth(480);
            textfield.setMaxWidth(100);
        Button buttonver = new Button("Introduce Año"); // Boton de introducir año
            buttonver.setStyle("-fx-background-color: #5dc1b9;");
            buttonver.setFont(new Font("Arial", 15));
            textArea.setMaxWidth(480);
            textArea.setMinWidth(200);
            
            final Label label = new Label("Armas Nucleares");
            label.setFont(new Font("Arial", 20));
            
        root.getChildren().addAll(label, buttonver, textfield, textArea); // Agrupacion de los 4
        buttonver.setOnAction((t) -> {
        // Esete boton nos muestra la informacion y la redirigimos a mostrarla en pantalla.
            int nuevoAño;
            nuevoAño = Integer.valueOf(textfield.getText());
            UtilCSV mostrar = new UtilCSV();
            mostrar.LeerDatos(nuevoAño);
            for (int x=0; x<mostrar.DatosLista.getListaArma().size(); x++) {
                System.out.println(mostrar.DatosLista.getListaArma().get(x).getPais() + " : " + mostrar.DatosLista.getListaArma().get(x).getArmasNucleares());
                textArea.appendText(mostrar.DatosLista.getListaArma().get(x).getPais() + " : " + mostrar.DatosLista.getListaArma().get(x).getArmasNucleares() + "\n");
            }
        });
        
        //Boton de guardar la informacion que nos da
        Button buttonguardar = new Button("Guardar Datos");
        buttonguardar.setStyle("-fx-background-color: #5dc1b9;");
        buttonguardar.setFont(new Font("Arial", 15));

        buttonguardar.setOnAction((t) -> {
            GuardarDatos = textArea.getText();
            UtilCSV.GuardarDatos();

        });
        root.getChildren().add(buttonguardar);

    }          
}