package GUI;

import static GUI.ControladorVentanaPrincipal.*;
import static GUI.CreadorDeVentanas.CreadorDeVentanas;
import static Json.MontajeDeDatos.ListaDeStores;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

    Image IconFolder = new Image(getClass().getResourceAsStream("/GUI/Img/folder.gif"));

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
        TreeItem<String> NuevoStore = new TreeItem<String>(store, new ImageView(IconFolder));
        TreeItem<String> JsonBase = new TreeItem<String>(store);
        NodoPrincipal.getChildren().add(NuevoStore);
        Commit.EscrituraCommit("Json.Crear.Store()");
        Commit.EscrituraParametro(store);
        NuevoStore.getChildren().add(JsonBase);
        Commit.EscrituraCommit("Json.Crear.Archivo()");
        Commit.EscrituraParametro(NuevoStore.getValue());
        Commit.EscrituraParametro(store);
        ListaDeStores.Insertar(store);
        stagePrincipal.close();

        seleccionado = JsonBase;
        CreadorDeVentanas("VentanaNuevoAtributo");                              // Añadido de atributos base
    }

    @FXML
    private void Cancelar(ActionEvent event) {
        stagePrincipal.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
