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
public class ControladorVentanaNuevoObjeto implements Initializable {

    private Stage stagePrincipal;

    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }

    public static ObservableList MenuAtributos = FXCollections.observableArrayList();

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

        System.out.println(Atributos.getSelectionModel().getSelectedItem());
        
        
        
        
        // hacer que se haga una nueva columna con atributo....................
//        String json = (Atributo.getText());
//        Commit.EscrituraCommit("Json.Crear.Archivo()");     //// creacion de atributo
//        Commit.EscrituraParametro(json);                        ///// arreglar entrada de info
//        ListaDeAtributos.Insertar(json);
////                         hacer que hojas permitan agregar objetos segun atributos dados.....
        Tabla tabla1 = new Tabla("123", "asd", "asd");              //// esto es de nuevo OBJETOS
        list.add(tabla1);
        BotonCommit.setDisable(false);                                          ////Activacion de Commit
        stagePrincipal.close();
    }

    @FXML
    private void Cancelar(ActionEvent event) {
        stagePrincipal.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Atributos.setTooltip(new Tooltip("Seleccione un atributo"));
        MenuAtributos = FXCollections.observableArrayList();
        for (String temp : ListaDeAtributos) {
            MenuAtributos.add(temp);
        }
        Atributos.setItems(MenuAtributos);
        Objeto.setTooltip(new Tooltip("Ingrese informacion para el atributo"));
    }
}
