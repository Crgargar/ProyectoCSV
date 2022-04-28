package es.cristiangg.armasnucleares;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// ArrayList para almacenar la informacion que queremos mostrar

@XmlRootElement
public class Armas {    
    private ArrayList<Arma> listasArma = new ArrayList();
    
    public ArrayList<Arma> getListaArma() {
        return listasArma;
    }
    
    @XmlElement(name = "Arma")
    public void setListaArma(ArrayList<Arma> listasArma) {
        this.listasArma = listasArma;
    }
}