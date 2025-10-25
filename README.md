# Recursos del sistema

Hecho por Sara Pérez

> El link del repositorio es: <https://github.com/SaraPF3/recursos_sistema>

El programa ejecuta tres comandos que muestran los recursos del sistema y guarda los datos en un fichero con formato markdown.

En el archivo **App.java** se ejecutan los comandos guardados en sus respectivas constantes:

```java
public class App {

    public static final String COMANDOPS = "ps";
    public static final String COMANDODF = "df";
    public static final String COMANDOFREE = "free";
    public static final String FICH = "informes/Informe.md";
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
```

La clase **Comando** tiene el método que ejecuta los comandos. Se ha utilizado lombok:

```java
@Data
@AllArgsConstructor
public class Comando implements Ejecutable {

    private String comando;

    @Override
    public String ejecutar() throws IOException, Exception {

        String MSG_ERROR = "Ha ocurrido un error al ejecutar el comando.";
        String N = "\n";
        int NUM0 = 0;
        int NUM_ERR = 34;
        StringBuilder output = new StringBuilder();

        try {
            Process process = Runtime.getRuntime().exec(comando);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append(N);
            }

            int exitVal = process.waitFor();
            if (exitVal == NUM0) {
            } else {
                System.out.println(MSG_ERROR);
            }

        } catch (IOException | InterruptedException e) {
            System.exit(NUM_ERR);
        }
        return output.toString();
    }
}
```

Se utiliza una interfaz, **Ejecutable**, que lanza el proceso de ejecución de los comandos:

```java
public interface Ejecutable {
    String ejecutar() throws IOException, Exception;
}
```

Se utiliza la clase **Informe** para crear un archivo markdown con los datos obtenidos al ejecutar los comandos:

```java
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
```
