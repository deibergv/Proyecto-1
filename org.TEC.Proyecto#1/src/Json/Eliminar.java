package Json;

import java.io.File;
import javax.swing.JOptionPane;

public class Eliminar {

    public static void EliminarCarpeta(String NombreDeLaCarpeta) {
        File Carpeta = new File("/home/deiber/Documents/" + NombreDeLaCarpeta);
        if (!Carpeta.exists() && Carpeta.isFile()) {
            JOptionPane.showMessageDialog(null, "Carpeta no encontrada", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            Carpeta.delete();
            System.out.println("Carpeta eliminada");
        }
    }

    public static void EliminarArchivo(String NombreDeArchivo) {
        File archivo = new File("/home/deiber/Documents/" + NombreDeArchivo + ".txt");

        if (!archivo.exists()) {
            JOptionPane.showMessageDialog(null, "No encontrado", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            archivo.delete();
            System.out.println("Archivo eliminado");
        }
    }

    public void EliminarTodos(String NombreDeCarpeta) {
        File Carpeta = new File("/home/deiber/Documents/" + NombreDeCarpeta);

        if (!Carpeta.exists() && Carpeta.isFile()) {
            JOptionPane.showMessageDialog(null, "No encontrado", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            Carpeta.delete();
            Crear.CrearCarpeta(NombreDeCarpeta);                         ///// Borra carpeta y crea una nueva vacia con mismo nombre
        }
    }
}
