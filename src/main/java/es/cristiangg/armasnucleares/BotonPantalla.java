package es.cristiangg.armasnucleares;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class BotonPantalla {
    
    static TextArea textArea = new TextArea();
    static String GuardarDatos;

    
    public void Pantalla(VBox root){
        
//        UtilCSV utilcsv = new UtilCSV();
        TextField textfield = new TextField();
            textfield.setMinWidth(100);
            textfield.setMaxWidth(100);
        Button buttonver = new Button("Introduce Año");
            textArea.setMaxWidth(200);
            textArea.setMinWidth(200);
        root.getChildren().addAll(textfield, buttonver, textArea);
        buttonver.setOnAction((t) -> {
            int nuevoAño;
            nuevoAño = Integer.valueOf(textfield.getText());
            UtilCSV mostrar = new UtilCSV();
            mostrar.LeerDatos(nuevoAño);
////            textArea.setText(String.valueOf(mostrar.pais) + " : " + String.valueOf(mostrar.armas));
//            mostrar.Datos();
            for (int x=0; x<mostrar.DatosLista.getListaArma().size(); x++) {
                System.out.println(mostrar.DatosLista.getListaArma().get(x).getPais() + " : " + mostrar.DatosLista.getListaArma().get(x).getArmasNucleares());
                textArea.appendText(mostrar.DatosLista.getListaArma().get(x).getPais() + " : " + mostrar.DatosLista.getListaArma().get(x).getArmasNucleares() + "\n");
//                textArea.setText(mostrar.DatosLista.getListaArma().get(x).getPais() + ": " + mostrar.DatosLista.getListaArma().get(x).getArmasNucleares());
            }
//                                
        });
        Button buttonguardar = new Button("Guardar Datos");
        buttonguardar.setOnAction((t) -> {
//            UtilCSV guardar = new UtilCSV();
            GuardarDatos = textArea.getText();
            UtilCSV.GuardarDatos();

        });
        root.getChildren().add(buttonguardar);

    }          
}