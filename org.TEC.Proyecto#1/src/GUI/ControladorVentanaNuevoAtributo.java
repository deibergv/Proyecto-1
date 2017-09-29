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
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.stage.Stage;

/**
 * Constructor de la clase Nuevo Atributo que se encarga de la creacion de los
 * atributos
 *
 * @author deiber
 */
public class ControladorVentanaNuevoAtributo implements Initializable {

    private Stage stagePrincipal;

    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }

    @FXML
    private TextField Json;
    @FXML
    private TextField Atributo;

    final ToggleGroup TipoDeAtributo = new ToggleGroup();
    @FXML
    private RadioButton Entero;
    @FXML
    private RadioButton Flotante;
    @FXML
    private RadioButton Cadena;
    @FXML
    private RadioButton FechaHora;

    final ToggleGroup TipoEspecial = new ToggleGroup();
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
        Commit.EscrituraCommit("Json.Crear.Archivo()");     //// creacion de atributo
        Commit.EscrituraParametro(json);                        ///// arreglar entrada de info
        ListaDeJsons.Insertar(json);
        
        stagePrincipal.close();
        CreadorDeVentanas("VentanaNuevoAtributo");
        
        // hacer que se haga una nueva columna con atributo....................
        
        ////                         hacer que hojas permitan agregar objetos segun atributos dados.....
        Tabla tabla1 = new Tabla("123", "asd", "asd");              //// esto es de nuevo OBJETOS
        list.add(tabla1);
        
    }

    @FXML
    private void Cancelar(ActionEvent event) {
        stagePrincipal.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Json.setDisable(true);
        Entero.setToggleGroup(TipoDeAtributo);
        Flotante.setToggleGroup(TipoDeAtributo);
        Cadena.setToggleGroup(TipoDeAtributo);
        Cadena.setSelected(true);
        FechaHora.setToggleGroup(TipoDeAtributo);
        Foranea.setToggleGroup(TipoEspecial);
        Primaria.setToggleGroup(TipoEspecial);
        Foranea.setSelected(true);
    }
}
