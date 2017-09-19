package Json;

import java.io.File;
import javax.swing.JOptionPane;

public class Eliminar {

    public static void Archivo(String NombreDeArchivo) {

        File Archivo = new File(RutaBase.RutaBase() + NombreDeArchivo);
        File archivo = new File(RutaBase.RutaBase() + NombreDeArchivo + ".txt");
        if (Archivo.exists() && Archivo.isDirectory()) {
            VaciarCarpeta(Archivo);
            Archivo.delete();
            JOptionPane.showMessageDialog(null, "Carpeta eliminada de forma exitosa", null, JOptionPane.INFORMATION_MESSAGE);////////////////////////
        } else if (archivo.exists()) {
            archivo.delete();
            JOptionPane.showMessageDialog(null, "Archivo eliminado de forma exitosa", null, JOptionPane.INFORMATION_MESSAGE);////////////////////////
        } else {
            JOptionPane.showMessageDialog(null, "Carpeta o Archivo no encontrado", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
//    public static void Archivo(String NombreDeArchivo) {
//
//        File archivo = new File(RutaBase.RutaBase() + NombreDeArchivo + ".txt");
//
//        if (archivo.exists()) {
//            File archivo = new File(RutaBase.RutaBase() + NombreDeArchivo + ".txt");
//            archivo.delete();
//            JOptionPane.showMessageDialog(null, "Archivo eliminado de forma exitosa", null, JOptionPane.INFORMATION_MESSAGE);////////////////////////
//        } else {
//            JOptionPane.showMessageDialog(null, "No encontrado", "Error", JOptionPane.WARNING_MESSAGE);                      ////////////////////////
//        }
//    }

    public static void Todos(String NombreDeCarpeta) {

        File Carpeta = new File(RutaBase.RutaBase() + NombreDeCarpeta);

        if (Carpeta.exists() && Carpeta.isDirectory()) {
            VaciarCarpeta(Carpeta);
        } else {
            JOptionPane.showMessageDialog(null, "Carpeta no encontrada", "Error", JOptionPane.WARNING_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Archivos eliminados de forma exitosa", null, JOptionPane.INFORMATION_MESSAGE);////////////////////////
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
}
