package Json;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LecturaDeJson {

    public void LecturaJson() {
        try {
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader("/home/deiber/json.txt"));
            Json.Metadata Lectura = gson.fromJson(br, Json.Metadata.class);

            //Printing the Employee Details
            System.out.println("StoreName      : " + Lectura.getStoreName());
            System.out.println("Atributo       : " + Lectura.getAtributo());
            System.out.println("Valor          : " + Lectura.getValor());
            System.out.println("Nombre         : " + Lectura.getNombre());
            System.out.println("Requerido      : " + Lectura.getRequerido());
            System.out.println("Defecto        : " + Lectura.getDefecto());

            System.out.print("");
//            for(String department : key.getStoreName())
//            {
//                System.out.print(department+" | ");
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
