package GUI;

import static GUI.ControladorVentanaPrincipal.*;
import static Json.MontajeDeDatos.ListaDeStores;
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
    private TextField Store;

    @FXML
    private Button Aceptar;
    @FXML
    private Button Cancelar;

    /**
     * Creacion del nuevo nodo con su respectivo nombre
     *
     * @param event
     */
    @FXML
    private void Aceptar(ActionEvent event) {
        String store = (Store.getText());
        TreeItem<String> NuevoStore = new TreeItem<String>(store);
        NodoPrincipal.getChildren().add(NuevoStore);
        Commit.EscrituraCommit("Json.Crear.Store()");
        Commit.EscrituraParametro(store);
        ListaDeStores.Insertar(store);
        stagePrincipal.close();
    }

    @FXML
    private void Cancelar(ActionEvent event) {
        stagePrincipal.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
