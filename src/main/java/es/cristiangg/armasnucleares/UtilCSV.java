package es.cristiangg.armasnucleares;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;


public class UtilCSV {
    
    String pais = "";
    int armas = 0;
    int x =0;
    Armas DatosLista = new Armas();

    public void LeerDatos(int nuevoAño){
    String nombreFichero = "country-position-nuclear-weapons.csv";
        // Declarar una variable BufferedReader
        BufferedReader br = null;
        try {
            // Crear un objeto BufferedReader al que se le pasa 
            //   un objeto FileReader con el nombre del fichero
            br = new BufferedReader(new FileReader(nombreFichero));
            // Leer la primera línea, guardando en un String
            String texto = br.readLine();
            texto = br.readLine();
            // Repetir mientras no se llegue al final del fichero200
            while(texto != null) {
                String[] valores = texto.split(",");
//                int armas = Integer.valueOf(valores[3]);
                armas = Integer.valueOf(valores[3]);
                pais = valores[0];
                int año = Integer.valueOf(valores[2]);
                if( año == nuevoAño){
                    if (armas > 0){
//                    System.out.println(String.valueOf(pais) + " : " + String.valueOf(armas));
                        Arma p1 = new Arma(pais, armas);
                        DatosLista.getListaArma().add(p1);
//                        System.out.println(DatosLista.getListaArma().get(1).getPais() + ": " + DatosLista.getListaArma().get(1).getArmasNucleares());
                    }
                }
                    
//                    textArea.setText(String.valueOf(pais) + " : " + String.valueOf(armas));

//                    Datos.getListaArma().get(nuevoAño).getPais();
//                    Datos.getListaArma().get(1).getPais();
//                    Arma almacen = new Arma(pais, String.valueOf(armas));
                    texto = br.readLine();
            }
//            System.out.println("Numero de muertes en el año:" + String.valueOf(ArmasNucleares));
        }
        // Captura de excepción por fichero no encontrado
        catch (FileNotFoundException ex) {
            System.out.println("Error: Fichero no encontrado");
            ex.printStackTrace();
        }
        // Captura de cualquier otra excepción
        catch(Exception ex) {
            System.out.println("Error de lectura del fichero");
            ex.printStackTrace();
        }
        // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
                // Cerrar el fichero si se ha podido abrir
                if(br != null) {
                    br.close();
                }
            }
            catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }
    }
    public static void GuardarDatos(){
        String nombreFichero = "Paises con armas.csv";
        String texto = BotonPantalla.GuardarDatos;
        BufferedWriter bw = null;
        
        try {
        //Crear un objeto BufferedWriter. Si ya existe el fichero, 
        //  se borra automáticamente su contenido anterior.
            bw = new BufferedWriter(new FileWriter(nombreFichero));
        //Escribir en el fichero el texto con un salto de línea
            bw.write(texto + "\n");
        }
// Comprobar si se ha producido algún error
        catch(Exception ex) {
            System.out.println("Error de escritura del fichero");
            ex.printStackTrace();
        }
    // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
                // Cerrar el fichero si se ha podido abrir
                if(bw != null)
                    bw.close();
            }
            catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }
    }
}