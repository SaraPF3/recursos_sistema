# Recursos del sistema

Hecho por Sara Pérez

> El link del repositorio es: <https://github.com/SaraPF3/recursos_sistema>

El programa ejecuta tres comandos que muestran los recursos del sistema.

En el archivo **App.java** se ejecutan los comandos guardados en sus respectivas constantes:

```java
public class App {

    public static final String[] COMANDOPS = {"ps"};
    public static final String[] COMANDODF = {"df"};
    public static final String[] COMANDOFREE = {"free"};
    public static final String NOM = "src/main/java/es/etg/dam/informes/Informe.md";
    public static final String N = "\n";
    public static final String DECORACION = "----------------------------";
    public static final String TEXTO_SALIDA_PS = "Líneas que obtiene ps" + N + N + DECORACION;
    public static final String TEXTO_SALIDA_DF = "Líneas que obtiene ds" + N + N + DECORACION;
    public static final String TEXTO_SALIDA_FREE = "Líneas que obtiene free" + N + N + DECORACION;

    public static void main(String[] args) throws Exception {

        Informe inf = new Informe();
        inf.agregarTitulo();

        Ejecutable ejec = new Comando(COMANDOPS);
        String salida1 = ejec.ejecutar(null);
        System.out.println(TEXTO_SALIDA_PS + N + salida1 + DECORACION + N);
        inf.agregarSeccion(TEXTO_SALIDA_PS, salida1);

        Ejecutable ejec2 = new Comando(COMANDODF);
        String salida2 = ejec2.ejecutar(null);
        System.out.println(salida2);
        inf.agregarSeccion(TEXTO_SALIDA_DF, salida2);


        Ejecutable ejec3 = new Comando(COMANDOFREE);
        String salida3 = ejec3.ejecutar(null);
        System.out.println(salida3);
        inf.agregarSeccion(TEXTO_SALIDA_FREE, salida3);

        inf.crear(NOM);
    }
}
```

La clase **Comando** tiene el método que ejecuta los comandos. Se ha utilizado lombok:

```java
@Data
@AllArgsConstructor
public class Comando implements Ejecutable {

    private String[] comando;
    private String[] parametro;

    public Comando(String[] comando) {
        this.comando = comando;
    }

    @Override
    public String ejecutar(String[] entrada) throws IOException, Exception {

        String MSG_ERROR = "Ha ocurrido un error al ejecutar el comando.";
        String N = "\n";
        StringBuilder output = new StringBuilder();

        try {
            Process process = Runtime.getRuntime().exec(comando);

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append(N);
            }

            //Dejamos el programa bloqueado hasta que termine el otro.
            int exitVal = process.waitFor();
            if (exitVal == 0) {
            } else {
                System.out.println(MSG_ERROR);
            }

        } catch (IOException | InterruptedException e) {
            System.exit(34);
        }
        return output.toString();
    }
}
```

Se utiliza una interfaz, **Ejecutable**, que lanza el proceso de ejecución de los comandos:

```java
public interface Ejecutable {
    String ejecutar(String[] entrada) throws IOException, Exception;
}
```

Se utiliza la clase **Informe** para crear un archivo markdown con los datos obtenidos al ejecutar los comandos:

```java
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
```
