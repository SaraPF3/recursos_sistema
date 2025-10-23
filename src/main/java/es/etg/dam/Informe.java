package es.etg.dam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Informe {

    public static final String N = "\n";
    public static final String TIT = "# Recursos del sistema";
    public static final String COMILLAS = "```";
    public static final String TXT_COM = "## Comando ";
    public static final String TXT = "text";

    public static void crear(String ruta, List<String> info, String[] comandos) {
        File fich = new File(ruta);
        try (FileWriter fw = new FileWriter(fich)) {
            fw.write(TIT + N);
            for (int i = 0; i < info.size(); i++) {
                fw.write(String.format(N + TXT_COM + comandos[i] + N + N));
                String total = COMILLAS + TXT + N + info.get(i) + COMILLAS + N;
                fw.write(total);
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
