package GUI;

import static GUI.ControladorVentanaPrincipal.*;
import static GUI.CreadorDeVentanas.CreadorDeVentanas;
import static Json.MontajeDeDatos.ListaDeJsons;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
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

    @FXML
    private TextField Json;
    @FXML
    private TextField Atributo;

    @FXML
    private RadioButton Entero;
    @FXML
    private RadioButton Flotante;
    @FXML
    private RadioButton Cadena;
    @FXML
    private RadioButton FechaHora;

    @FXML
    private RadioButton Foranea;
    @FXML
    private RadioButton Primaria;

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
        String json = (Json.getText());
        TreeItem<String> NuevoJson = new TreeItem<String>(json);
        seleccionado.getChildren().add(NuevoJson);
        Commit.EscrituraCommit("Json.Crear.Archivo()");
        Commit.EscrituraParametro(json);
        Commit.EscrituraParametro(seleccionado.getValue());
        ListaDeJsons.Insertar(json);
        stagePrincipal.close();
        BotonCommit.setDisable(false);                                          ////Activacion de Commit
        seleccionado = NuevoJson;
        CreadorDeVentanas("VentanaNuevoAtributo");                              // Añadido de atributos base
    }

    @FXML
    private void Cancelar(ActionEvent event) {
        stagePrincipal.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Atributo.setDisable(true);
        Entero.setDisable(true);
        Flotante.setDisable(true);
        Cadena.setDisable(true);
        FechaHora.setDisable(true);
        Foranea.setDisable(true);
        Primaria.setDisable(true);
    }
}
