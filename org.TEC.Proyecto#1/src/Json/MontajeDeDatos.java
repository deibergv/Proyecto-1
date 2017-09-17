package Json;

import java.io.File;

public class MontajeDeDatos {

    public static String MontajeDeDatos(String Dato) {
        File Carpeta = new File(RutaBase.RutaBase());
        File[] ListaDeContenido = Carpeta.listFiles();
        for (File Contenido : ListaDeContenido) {
            if (Contenido.exists() && Contenido.isDirectory()) {
                ArchivosDeCarpeta(Carpeta, Dato);
            } else {
                return LecturaDeJson.LecturaJson(Contenido, Dato);
            }
        }
        return null;
    }

    public static String ArchivosDeCarpeta(File Carpeta, String Dato) {
        File[] ListaDeContenido = Carpeta.listFiles();
        for (File Contenido : ListaDeContenido) {
            if (Contenido.isDirectory()) {
                ArchivosDeCarpeta(Carpeta, Dato);
            } else {
                return LecturaDeJson.LecturaJson(Contenido, Dato);
            }
        }
        return null;
    }
}