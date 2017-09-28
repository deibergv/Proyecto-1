package Json;

import java.io.File;
import javax.swing.JOptionPane;

/**
 * Constructor de clase encargada de la eliminacion de archivos
 *
 * @author deiber
 */
public class Eliminar {

    /**
     * Eliminacion de una carpeta por su respectivo nombre
     *
     * @param NombreDeCarpeta
     */
    public static void Carpeta(String NombreDeCarpeta) {

        File Archivo = new File(RutaBase.RutaBase() + NombreDeCarpeta);
        if (Archivo.exists() && Archivo.isDirectory()) {
            VaciarCarpeta(Archivo);
            Archivo.delete();
            JOptionPane.showMessageDialog(null, "Carpeta eliminada de forma exitosa", null, JOptionPane.INFORMATION_MESSAGE);////////////////////////
        } else {
            JOptionPane.showMessageDialog(null, "Carpeta no encontrada", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Eliminacion de un archivo buscandolo por su nombre
     *
     * @param NombreDelArchivo
     * @param RutaCarpeta
     */
    public static void Archivo(String NombreDelArchivo, String RutaCarpeta) {

        File archivo = new File(RutaBase.RutaBase() + RutaCarpeta + "/" + NombreDelArchivo + ".txt");

        if (archivo.exists()) {
            archivo.delete();
            JOptionPane.showMessageDialog(null, "Archivo eliminado de forma exitosa", null, JOptionPane.INFORMATION_MESSAGE);////////////////////////
        } else {
            JOptionPane.showMessageDialog(null, "No encontrado", "Error", JOptionPane.WARNING_MESSAGE);                      ////////////////////////
        }
    }

    /**
     * Se encarga del llamado a borrar de carpetas con contenido
     *
     * @param NombreDeCarpeta
     */
    public static void Todos(String NombreDeCarpeta) {

        File Carpeta = new File(RutaBase.RutaBase() + NombreDeCarpeta);

        if (Carpeta.exists() && Carpeta.isDirectory()) {
            VaciarCarpeta(Carpeta);
        } else {
            JOptionPane.showMessageDialog(null, "Carpeta no encontrada", "Error", JOptionPane.WARNING_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Archivos eliminados de forma exitosa", null, JOptionPane.INFORMATION_MESSAGE);////////////////////////
    }

    /**
     * Se encarga del vaciado de una carpeta para su respectiva eliminacion
     *
     * @param Carpeta
     */
    public static void VaciarCarpeta(File Carpeta) {
        File[] ListaDeContenido = Carpeta.listFiles();
        for (File Contenido : ListaDeContenido) {
            if (Contenido.isDirectory()) {
                VaciarCarpeta(Contenido);
            }
            Contenido.delete();
        }
    }
}
