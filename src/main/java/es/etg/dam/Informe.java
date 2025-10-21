package es.etg.dam;

import java.io.FileWriter;
import java.io.IOException;

public class Informe {

    private final StringBuilder contenido = new StringBuilder();
    public static final String N = "\n";
    public static final String TIT = "# Recursos del sistema";
    public static final String HASH = "## ";
    
    public void agregarTitulo(){
        contenido.append(TIT).append(N).append(N);
    }

    public void agregarSeccion(String titulo, String texto){
        contenido.append(HASH).append(titulo).append(N).append(N);
        contenido.append(texto).append(N);
    }

    public void crear(String nom) throws IOException {
        String textoFinal = contenido.toString().stripTrailing();
        try (FileWriter writer = new FileWriter(nom)) {
            writer.write(textoFinal + N);
        }
    }
    
}
