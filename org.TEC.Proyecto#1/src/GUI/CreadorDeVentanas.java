package GUI;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Contrucctor de clase encargada de crear las ventanas segun respectivo llamado
 *
 * @author deiber
 */
public class CreadorDeVentanas {

    public static Stage stagePrincipal;

    /**
     * Filtro de creacion
     *
     * @param NombreDeVentana
     */
    public static void CreadorDeVentanas(String NombreDeVentana) {
        String Ventana = NombreDeVentana;
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(Ventana + ".fxml"));
            AnchorPane ventanaDos = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            ventana.setResizable(false);
            ventana.initModality(Modality.WINDOW_MODAL);
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaDos);
            ventana.setScene(scene);
            if (null != NombreDeVentana) {
                switch (NombreDeVentana) {
                    case "VentanaBusqueda": {
                        ventana.setTitle("Busqueda");
                        ControladorVentanaBusqueda controller = loader.getController();
                        controller.setStagePrincipal(ventana);
                        break;
                    }
                    case "VentanaActualizacion": {
                        ventana.setTitle("Actualizacion");
                        ControladorVentanaActualizacion controller = loader.getController();
                        controller.setStagePrincipal(ventana);
                        break;
                    }
                    case "VentanaNuevoStore": {
                        ventana.setTitle("Nuevo");
                        ControladorVentanaNuevoStore controller = loader.getController();
                        controller.setStagePrincipal(ventana);
                        break;
                    }
                    case "VentanaNuevoJson": {
                        ventana.setTitle("Nuevo");
                        ControladorVentanaNuevoJson controller = loader.getController();
                        controller.setStagePrincipal(ventana);
                        break;
                    }
                    case "VentanaNuevoAtributo": {
                        ventana.setTitle("Nuevo");
                        ControladorVentanaNuevoAtributo controller = loader.getController();
                        controller.setStagePrincipal(ventana);
                        break;
                    }
                    default:
                        break;
                }
            }
            ventana.show();
        } catch (IOException ex) {
            System.out.println(ex.toString());
            System.out.println("Error en Ventana");
        }
    }
}
