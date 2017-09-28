package Json;

import Listas.ListaDoble;
import Listas.ListaDobleCircular;
import java.io.File;

/**
 * Clase encargada del llamado y montaje de datos segun su respectivo llamado
 *
 * @author deiber
 */
public class MontajeDeDatos {

    public static ListaDoble<String> ListaDeStores = new ListaDoble<>();
    public static ListaDobleCircular<String> ListaDeJsons = new ListaDobleCircular<>();
    
    
    
    
    public static String MontajeDeDatos(String Dato) {
        File Carpeta = new File(RutaBase.RutaBase());
        File[] ListaDeContenido = Carpeta.listFiles();
        String ListaDeDatos = "";
        ListaDeDatos += ArchivosDeCarpeta(ListaDeContenido, Dato);
        System.out.println(ListaDeDatos);
        
        
//        ListaSimple<String> Test = new ListaSimple<>();
//        for(){}    
//        Test.Insertar("primeroHOla");        
        
        return ArchivosDeCarpeta(ListaDeContenido, Dato);

    }

    public static String ArchivosDeCarpeta(File[] Carpeta, String Dato) {
        String ListaDeDatos = "";
        for (File Contenido : Carpeta) {
            if (Contenido.isDirectory()) {
                File[] ListaDeContenido = Contenido.listFiles();
                ArchivosDeCarpeta(ListaDeContenido, Dato);
            } else {
                ListaDeDatos += LecturaDeJson.LecturaJson(Contenido, Dato);
            }
        }
        System.out.println(ListaDeDatos);
        return ListaDeDatos;
    }
}
