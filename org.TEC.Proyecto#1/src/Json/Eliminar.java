package Json;

import java.io.File;
import javax.swing.JOptionPane;

public class Eliminar {

    public static void EliminarArchivo(String NombreDeArchivo) {

        File archivo = new File(RutaBase.RutaBase() + NombreDeArchivo + ".txt");

        if (!archivo.exists()) {
            JOptionPane.showMessageDialog(null, "No encontrado", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            archivo.delete();
            JOptionPane.showMessageDialog(null, "Archivo eliminado de forma exitosa", null, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void EliminarTodos(String NombreDeCarpeta) {

        File Carpeta = new File(RutaBase.RutaBase() + NombreDeCarpeta);

        if (!Carpeta.exists()) {
            JOptionPane.showMessageDialog(null, "Carpeta no encontrada", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            VaciarCarpeta(Carpeta);
        }
    }

    public static void VaciarCarpeta(File Carpeta) {
        File[] ListaDeContenido = Carpeta.listFiles();
        for (File Contenido : ListaDeContenido) {
            if (Contenido.isDirectory()) {
                VaciarCarpeta(Contenido);
            }
            Contenido.delete();
        }
    }

    public static void EliminarCarpeta(String NombreDeCarpeta) {

        File Carpeta = new File(RutaBase.RutaBase() + NombreDeCarpeta);
        VaciarCarpeta(Carpeta);
        if (!Carpeta.exists()) {
            JOptionPane.showMessageDialog(null, "Carpeta no encontrada", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            Carpeta.delete();
            JOptionPane.showMessageDialog(null, "Carpeta eliminada de forma exitosa", null, JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
