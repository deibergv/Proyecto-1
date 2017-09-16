package Json;

import java.io.File;

public class RutaBase { /// Clase encargada de obtener una ruta base en la creacion de archivos del programa    

    public static String RutaBase() {
        String username = System.getProperty("user.name");
        String ruta = "/home/" + username + "/Documents/LinkedDB/";
        return ruta;
    }

    public static void CrearCarpetaBase() {

        File Carpeta = new File(RutaBase.RutaBase());

        if (Carpeta.exists() && Carpeta.isFile()) {
            return;
        } else {
            try {
                if (!Carpeta.exists()) {
                    Carpeta.mkdir();
                }
            } catch (RuntimeException e) {
                System.out.print("RuntimeException: ");
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.print("Exception: ");
                System.out.println(e.getMessage());
            }
        }
    }
}