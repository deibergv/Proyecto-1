package GUI;

import Json.RutaBase;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Commit {

    public static void EscrituraCommit(String Peticion) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(RutaBase.RutaBase() + "Commit.txt", true);
            pw = new PrintWriter(fichero);
            pw.println(Peticion);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Se asegura que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void LecturaCommit() {
        File f = new File(RutaBase.RutaBase() + "Commit.txt");
        Scanner s;
        try {
            s = new Scanner(f);
            while (s.hasNextLine()) {
                String linea = s.nextLine();
                System.out.println(linea);                              ///////////////////////////////////////////////////////////
//                if ("BORRAR".equals(linea)) {
//                    DemoEvent.mostrar();
//                }
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void BorrarCommit() {
        File f = new File(RutaBase.RutaBase() + "Commit.txt");
        f.delete();
    }
}
