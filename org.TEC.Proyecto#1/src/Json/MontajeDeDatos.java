package Json;

import java.io.File;

/**
 * Clase encargada del llamado y montaje de datos segun su respectivo llamado
 *
 * @author deiber
 */
public class MontajeDeDatos {

    public static String MontajeDeDatos(String Dato) {
        File Carpeta = new File(RutaBase.RutaBase());
        File[] ListaDeContenido = Carpeta.listFiles();
        String ListaDeDatos = "";
        ListaDeDatos += ArchivosDeCarpeta(ListaDeContenido, Dato);
        System.out.println(ListaDeDatos);
        return ArchivosDeCarpeta(ListaDeContenido, Dato);

    }

    public static String ArchivosDeCarpeta(File[] Carpeta, String Dato) {
        String ListaDeDatos = "";
        for (File Contenido : Carpeta) {
            if (Contenido.isDirectory()) {
                File[] ListaDeContenido = Contenido.listFiles();
                ArchivosDeCarpeta(ListaDeContenido, Dato);
            } else {
                ListaDeDatos += LecturaDeJson.LecturaJson(Contenido, Dato);
            }
        }
        System.out.println(ListaDeDatos);
        return ListaDeDatos;
    }
}
