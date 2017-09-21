package GUI;

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
 * Constructor de la clase Nuevo Json que se encarga de la creacion del mismo
 *
 * @author deiber
 */
public class ControladorVentanaNuevoJson implements Initializable {

    private Stage stagePrincipal;

    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }

    public TreeItem<String> Seleccionado;
    public static void Seleccionado (TreeItem<String> NodoSelecionado){
        TreeItem<String> Seleccionado = NodoSelecionado;
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
         stagePrincipal.close();
//        String texto = (Texto.getText());
//        stagePrincipal.close();
//        TreeItem<String> NuevoJson = new TreeItem<String>(texto);
//        Seleccionado.getParent().getChildren().add(NuevoJson);
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
