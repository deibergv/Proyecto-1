package GUI;

import Json.Crear;
import Json.RutaBase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Constructor de la clase commit
 *
 * @author deiber
 */
public class Commit {

    /**
     * Creacion de archivo .txt encargado de guardar informacion para su previo
     * uso
     *
     * @param Peticion
     */
    public static void EscrituraCommit(String Peticion) {
        FileWriter Funcion = null;
        PrintWriter escritura = null;
        try {
            Funcion = new FileWriter(RutaBase.RutaBase() + "Commit.txt", true);
            escritura = new PrintWriter(Funcion);
            escritura.println(Peticion);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Se asegura que se cierra el fichero.
                if (null != Funcion) {
                    Funcion.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * Constructor de la clase commit encargado de crear parametros para su
     * posterior invocacion
     *
     * @param Parametro
     */
    public static void EscrituraParametro(String Parametro) {
        FileWriter Funcion = null;
        PrintWriter escritura = null;
        try {
            Funcion = new FileWriter(RutaBase.RutaBase() + "Parametros.txt", true);
            escritura = new PrintWriter(Funcion);
            escritura.println(Parametro);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Se asegura que se cierra el fichero.
                if (null != Funcion) {
                    Funcion.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * Constructor de la clase commit encargado de la espectiva lectura de datos
     * del .txt
     */
    public static void LecturaCommit() {
        File commit = new File(RutaBase.RutaBase() + "Commit.txt");
        File parametros = new File(RutaBase.RutaBase() + "Parametros.txt");
        Scanner c;
        Scanner p;
        try {
            c = new Scanner(commit);
            p = new Scanner(parametros);
            while (c.hasNextLine()) {
                String lineaCommit = c.nextLine();
                String lineaParametros = p.nextLine();
                if (null != lineaCommit) {
                    switch (lineaCommit) {
//                    case "Json.Crear.Archivo()":
//                        Crear.Archivo(lineaParametros, METADATA);
//                        break;
                        case "Json.Crear.Store()":
                            Crear.Store(lineaParametros);
                            break;
                        case "Json.Eliminar.Archivo()":
                            Json.Eliminar.Archivo(lineaParametros);
                            break;
                        case "Json.Eliminar.Todos()":
                            Json.Eliminar.Todos(lineaParametros);
                            break;
                        default:
                            break;
                    }
                }
            }
            c.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Se encarga de la respectiva eliminacion del archivo .txt para evitar
     * conflictos posteriores
     */
    public static void BorrarCommit() {
        File c = new File(RutaBase.RutaBase() + "Commit.txt");
        c.delete();
        File p = new File(RutaBase.RutaBase() + "Parametros.txt");
        p.delete();
    }
}