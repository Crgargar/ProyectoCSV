module es.cristiangg.armasnucleares {
    requires javafx.controls;
    requires java.xml.bind;
    requires jakarta.activation;
    requires java.activation;
    exports es.cristiangg.armasnucleares;
    opens es.cristiangg.armasnucleares to java.xml.bind;

}
