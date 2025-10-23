package es.etg.dam;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static final String COMANDOPS = "ps";
    public static final String COMANDODF = "df";
    public static final String COMANDOFREE = "free";
    public static final String FICH = "src/main/resources/Informe.md";
    public static final String N = "\n";
    public static final String TXT_COM = "Comando ";

    public static void main(String[] args) throws Exception {

        String[] comandos = {COMANDOPS, COMANDODF, COMANDOFREE};
        List<String> info = new ArrayList<>(); 

        for (String comando : comandos) {
            Ejecutable ejec = new Comando(comando);
            String salida = ejec.ejecutar();
            info.add(salida);
            System.out.println(TXT_COM + comando + N + N + salida);
        }

        Informe.crear(FICH, info, comandos);
    }
}
