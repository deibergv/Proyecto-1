package GUI;

import static GUI.ControladorVentanaPrincipal.*;
import static Json.MontajeDeDatos.ListaDeAtributos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

/**
 * Constructor de la clase Nuevo Objeto que se encarga de la creacion de los
 * objetos
 *
 * @author deiber
 */
public class ControladorVentanaActualizacion implements Initializable {

    private Stage stagePrincipal;

    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }

    public static ObservableList MenuAtributos = FXCollections.observableArrayList();
    public static boolean b = false;

    @FXML
    private ChoiceBox Atributos;
    @FXML
    private TextField Objeto;
    @FXML
    private Button Aceptar;
    @FXML
    private Button Cancelar;

    /**
     * Creacion del nuevo objeto
     *
     * @param event
     */
    @FXML
    private void Aceptar(ActionEvent event) {
         String json = (Objeto.getText());
        if (Atributos.getSelectionModel().getSelectedItem() == "Carne"){
//            Atributos.getSelectionModel().getSelectedItem().setText(json);
    }
        BotonCommit.setDisable(false);                                          ////Activacion de Commit
        stagePrincipal.close();
        b= true;
    }

    @FXML
    private void Cancelar(ActionEvent event) {
        stagePrincipal.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Atributos.setTooltip(new Tooltip("Seleccione un atributo"));
        Objeto.setTooltip(new Tooltip("Ingrese informacion para el atributo"));
        if (b == false) {
            MenuAtributos = FXCollections.observableArrayList();
            MenuAtributos.add("Carne");
            MenuAtributos.add("Nombre");
            MenuAtributos.add("Carrera");
            Atributos.setItems(MenuAtributos);
        } else {
            MenuAtributos = FXCollections.observableArrayList();
            for (String temp : ListaDeAtributos) {
                MenuAtributos.add(temp);
            }
            Atributos.setItems(MenuAtributos);
        }

    }
}
