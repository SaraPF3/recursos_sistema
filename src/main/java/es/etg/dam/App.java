package es.etg.dam;

public class App {

    public static final String[] COMANDOPS = {"ps"};
    public static final String[] COMANDODF = {"df"};
    public static final String[] COMANDOFREE = {"free"};
    public static final String FICH = "src/main/java/es/etg/dam/informes/Informe.md";
    public static final String N = "\n";
    public static final String TXT_PS = "Se muestran los procesos en ejecución.";
    public static final String TXT_DF = "Se muestra información sobre el espacio utilizado y el espacio disponible de todos los sistemas de archivos montados.";
    public static final String TXT_FREE = "Se muestra información sobre el uso de la memoria del sistema.";
    public static final String DECORACION = "----------------------------";
    public static final String TEXTO_SALIDA_PS = "Líneas que obtiene ps" + N + N + TXT_PS + N + N + DECORACION;
    public static final String TEXTO_SALIDA_DF = "Líneas que obtiene ds" + N + N + TXT_DF + N + N + DECORACION;
    public static final String TEXTO_SALIDA_FREE = "Líneas que obtiene free" + N + N + TXT_FREE + N + N + DECORACION;
    

    public static void main(String[] args) throws Exception {

        Informe inf = new Informe();
        inf.agregarTitulo();

        Ejecutable ejec = new Comando(COMANDOPS);
        String salida1 = ejec.ejecutar(null);
        inf.agregarSeccion(TEXTO_SALIDA_PS, salida1 + N + DECORACION + N);

        Ejecutable ejec2 = new Comando(COMANDODF);
        String salida2 = ejec2.ejecutar(null);
        inf.agregarSeccion(TEXTO_SALIDA_DF, salida2 + N + DECORACION + N);


        Ejecutable ejec3 = new Comando(COMANDOFREE);
        String salida3 = ejec3.ejecutar(null);
        inf.agregarSeccion(TEXTO_SALIDA_FREE, salida3 + N + DECORACION + N);

        inf.crear(FICH);
    }
}
