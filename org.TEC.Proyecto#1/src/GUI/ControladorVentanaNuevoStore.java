package GUI;

import static GUI.OpcionesClickDerecho.Opciones.NodoPrincipal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.stage.Stage;

/**
 * Constructor de la clase Nuevo Store que se encarga de la creacion y acciones
 * del mismo
 *
 * @author deiber
 */
public class ControladorVentanaNuevoStore implements Initializable {

    private Stage stagePrincipal;

    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }

    @FXML
    private TextField Texto;

    @FXML
    private Button Aceptar;

    /**
     * Creacion del nuevo nodo con su respectivo nombre
     *
     * @param event
     */
    @FXML
    private void Aceptar(ActionEvent event) {
        String texto = (Texto.getText());
        stagePrincipal.close();
        TreeItem<String> NuevoStore = new TreeItem<String>(texto);
        NodoPrincipal.getChildren().add(NuevoStore);
    }

    @FXML
    private void salirVentana(ActionEvent event) {
        stagePrincipal.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
