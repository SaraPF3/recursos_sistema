package es.etg.dam;

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
