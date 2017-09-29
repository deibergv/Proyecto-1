package GUI;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Main
 *
 * @author deiber
 */
public class Main extends Application {

    public static Stage stagePrincipal;
    public static AnchorPane rootPane;

    /**
     * Creacion de ventanas segun su respectiva invocacion
     *
     * @param NombreDeVentana
     */
    public void CreadorDeVentanas(String NombreDeVentana) {

        if ("VentanaPrincipal".equals(NombreDeVentana)) {
            try {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("VentanaPrincipal.fxml"));
                rootPane = (AnchorPane) loader.load();
                Scene scene = new Scene(rootPane);
                stagePrincipal.setResizable(false);
//                stagePrincipal.initModality(Modality.WINDOW_MODAL);
                stagePrincipal.setScene(scene);
                stagePrincipal.setTitle("LinkedDB");
                ControladorVentanaPrincipal controller = loader.getController();
                controller.setProgramaPrincipal(this);
                stagePrincipal.show();
            } catch (IOException ex) {
                System.out.println(ex.toString());
                System.out.println("Error con la Ventana");
            }
        }
    }

    /**
     * Llamado a la ventana principal
     *
     * @param stagePrincipal
     * @throws Exception
     */
    @Override
    public void start(Stage stagePrincipal) throws Exception {
        this.stagePrincipal = stagePrincipal;
        CreadorDeVentanas("VentanaPrincipal");
    }

    /**
     * Llamado a la ventana principal
     *
     * @param args
     */
    public static void main(String[] args) {
        Json.RutaBase.CrearCarpetaBase();
        launch(args);
        Commit.BorrarCommit();
    }
}
