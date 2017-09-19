package GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage stagePrincipal;
    private AnchorPane rootPane;

    public void CreadorDeVentanas(String NombreDeVentana) {

        if ("VentanaPrincipal".equals(NombreDeVentana)) {
            try {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("VentanaPrincipal.fxml"));
                rootPane = (AnchorPane) loader.load();
                Scene scene = new Scene(rootPane);
                stagePrincipal.setResizable(false);
                stagePrincipal.setScene(scene);
                stagePrincipal.setTitle("LinkedDB");
                ControladorVentanaPrincipal controller = loader.getController();
                controller.setProgramaPrincipal(this);
                stagePrincipal.show();
            } catch (IOException ex) {
                System.out.println(ex.toString());
                System.out.println("Error con la Ventana");
            }
        } else {
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
                            ventana.setTitle("Nuevo Store");
                            ControladorVentanaNuevoStore controller = loader.getController();
                            controller.setStagePrincipal(ventana);
                            break;
                        }
                        case "VentanaNuevoJson": {
                            ventana.setTitle("Nuevo Json");
                            ControladorVentanaNuevoJson controller = loader.getController();
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

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        this.stagePrincipal = stagePrincipal;
        CreadorDeVentanas("VentanaPrincipal");
    }

    public static void main(String[] args) {
        Json.RutaBase.CrearCarpetaBase();
        launch(args);
        Commit.BorrarCommit();
    }
}
