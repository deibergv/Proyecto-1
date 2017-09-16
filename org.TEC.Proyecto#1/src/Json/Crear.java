package Json;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Crear {

    public static void CrearStore(String NombreDeLaCarpeta) {
    }

    public static void CrearCarpeta(String NombreDeCarpeta) {
        File Carpeta = new File("/home/deiber/Documents/" + NombreDeCarpeta);
        if (Carpeta.exists() && Carpeta.isFile()) {
            System.out.println("Ya existe una carpeta con ese nombre");
        } else {
            try {
                if (!Carpeta.exists()) {
                    Carpeta.mkdir();
                }
                //creacion de archivo base junto a carpeta
                //CrearJson.NuevoJson(filename);
            } catch (Exception e) {
            }
        }
    }

    public static void NuevoJson(String NombreDelJson) {
        try {
            Metadata Nuevo = new Metadata("a", "b", "c", "d", "f", "g");
            Gson gson = new Gson();
            String jsonString = gson.toJson(Nuevo);
            String ruta = "/home/deiber/Documents/" + NombreDelJson + ".txt";
            File archivo = new File(ruta);
            BufferedWriter bw;
            if (archivo.exists()) {
                System.out.println("Ya existe un archivo con ese nombre");
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(jsonString);
            } else {
                System.out.println("Archivo creado");
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(jsonString);
            }
            bw.close();
        } catch (IOException e) {
        }
    }

}
