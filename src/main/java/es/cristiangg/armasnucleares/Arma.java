package es.cristiangg.armasnucleares;

public class Arma {
        
    private String Pais;
    private String Iniciales;
    private int year;
    private int ArmasNucleares;
    
    public Arma(String Pais) {
        this.Pais = Pais.toUpperCase();
    }
    
    public Arma(String Pais, int ArmasNucleares) {
        this.Pais = Pais;
        this.ArmasNucleares = ArmasNucleares;
    }
    
    public String getPais() {        
        return Pais;
    }
    
    public void setPais(String Pais) {
        this.Pais = Pais.toUpperCase();
    }
    
    public String getIniciales() {
        return Iniciales;
    }
    
    public void setIniciales(String Iniciales) {
        this.Iniciales = Iniciales;
    }
    
    public int getyear() {
        return year;
    }
    
    public void setyear(int year) {
        this.year = year;
    }
       
    public int getArmasNucleares() {
        return ArmasNucleares;
    }
    
    public void setArmasNucleares(int ArmasNucleares) {
        this.ArmasNucleares = ArmasNucleares;
    }
}
