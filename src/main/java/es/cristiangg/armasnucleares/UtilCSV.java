package es.cristiangg.armasnucleares;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;


public class UtilCSV {

// Variables
    String pais = "";
    int armas = 0;
    Armas DatosLista = new Armas();
    
// Leer los datos del fichero
    
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
                armas = Integer.valueOf(valores[3]); // Sacamos el valor de la posicion 3 que son las armas
                pais = valores[0]; // Sacamos el valor de la posicion 0 que son los paises
                int año = Integer.valueOf(valores[2]); // Sacamos el valor de la posicion 2 que son los años
                if( año == nuevoAño){ // Si año es igual al año que hemos metido entra en el if
                    if (armas != 0){ // Si armas es distinto a 0 muestra lo siguiente
                        // muestra la informacion de los Paises y las Armas
                        System.out.println(String.valueOf(pais) + " : " + String.valueOf(armas));
                        Arma p1 = new Arma(pais, armas);
                        DatosLista.getListaArma().add(p1); //Almacenamos el resultado
                    }
                }
                texto = br.readLine();
            }
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
    
// Almacenamos el resultado en un fichero nuevo
    
    public static void GuardarDatos(){
        String nombreFichero = "Paises con armas.csv"; // Nombre del nuevo fichero
        String texto = BotonPantalla.GuardarDatos; // Boton que llamamos para guardar
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