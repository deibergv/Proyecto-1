package Json;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;

/**
 * Constructor de la clase encargada de la creacion de archivos
 *
 * @author deiber
 */
public class Crear {

    /**
     * Creacion de carpeta base para el guardado de datos
     */
    public static void CarpetaBase() {

        File Carpeta = new File(RutaBase.RutaBase());

        if (!Carpeta.exists()) {
            Carpeta.mkdir();
        }
    }

    /**
     * Creacion respectiva de solicitud de creacion
     *
     * @param NombreDeCarpeta
     */
    public static void Store(String NombreDeCarpeta) {

        File Carpeta = new File(RutaBase.RutaBase() + NombreDeCarpeta);

        if (Carpeta.exists() && Carpeta.isDirectory()) {
            JOptionPane.showMessageDialog(null, "Ya existe una carpeta con ese nombre", null, JOptionPane.WARNING_MESSAGE);
        } else {
            Carpeta.mkdir();
            JOptionPane.showMessageDialog(null, "Carpeta creada de forma exitosa", null, JOptionPane.INFORMATION_MESSAGE);  /////////////////////
        }
    }

    /**
     * Creacion respectiva de solicitud de creacion previa
     *
     * @param NombreDelJson
     * @param RutaCarpeta
     */
    public static void Archivo(String NombreDelJson, String RutaCarpeta) {           // FALTA dirigir a carpeta a donde va a ir

        try {
            String ruta = RutaBase.RutaBase() + RutaCarpeta + "/" + NombreDelJson + ".txt";
            File archivo = new File(ruta);

            BufferedWriter bw;
            if (archivo.exists()) {
                JOptionPane.showMessageDialog(null, "Ya existe un documento con ese nombre", null, JOptionPane.INFORMATION_MESSAGE);
            } else {
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.close();
            }
        } catch (RuntimeException e) {
            System.out.print("RuntimeException: ");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.print("Exception: ");
            System.out.println(e.getMessage());
        }
    }

    /**
     * Agregado informacion a cada Json
     *
     * @param NombreDelJson
     * @param Nuevo
     */
    public static void Informacion(String NombreDelJson, Metadata Nuevo) {           // FALTA dirigir a carpeta a donde va a ir

        try {
//            Metadata Nuevo = new Metadata("a", "b", "c", "d", "f", "g");        //ingreso de informacion al nuevo Json
            Gson gson = new Gson();
            String jsonString = gson.toJson(Nuevo);                             // VARIABLE CON INFORMACION

            String ruta = RutaBase.RutaBase() + NombreDelJson + ".txt";
            File archivo = new File(ruta);

            BufferedWriter bw;
            if (archivo.exists()) {
                String message = "Ya existe un archivo con ese nombre, ¿desea sobreescribirlo?";
                String title = "Archivo ya existente";
                int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    bw = new BufferedWriter(new FileWriter(archivo));
                    bw.write(jsonString);                                       // Reescritura de informacion
                    bw.close();
                    JOptionPane.showMessageDialog(null, "Archivo creado de forma exitosa", null, JOptionPane.INFORMATION_MESSAGE);  //////////////////////
                }
            } else {
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write(jsonString);                                           // escritura de informacion
                bw.close();
                JOptionPane.showMessageDialog(null, "Archivo creado de forma exitosa", null, JOptionPane.INFORMATION_MESSAGE);      //////////////////////
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
