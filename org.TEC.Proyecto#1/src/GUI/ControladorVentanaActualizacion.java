package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * Constructor de la clase Actualizacion de Datos
 *
 * @author deiber
 */
public class ControladorVentanaActualizacion implements Initializable {

    private Stage stagePrincipal;

    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }

    /**
     * Asignacion de respectiva accion al boton para el cierre de la ventana
     *
     * @param event
     */
    @FXML
    private void salirVentana(ActionEvent event) {
        stagePrincipal.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
