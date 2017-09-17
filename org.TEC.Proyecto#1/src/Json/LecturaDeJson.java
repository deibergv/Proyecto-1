package Json;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LecturaDeJson {

    public static String LecturaJson(String NombreDeArchivo, String Dato) {
       
        try {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(RutaBase.RutaBase() + NombreDeArchivo + ".txt"));
            Json.Metadata Lectura = gson.fromJson(br, Json.Metadata.class);

            if (null != Dato) switch (Dato) {
                case "StoreName":
                    return Lectura.getStoreName();
                case "Atributo":
                    return Lectura.getAtributo();
                case "Valor":
                    return Lectura.getValor();
                case "Nombre":
                    return Lectura.getNombre();
                case "Requerido":
                    return Lectura.getRequerido();
                case "Defecto":
                    return Lectura.getDefecto();
                default:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
