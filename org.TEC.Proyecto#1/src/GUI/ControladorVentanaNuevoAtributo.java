package GUI;

import static GUI.ControladorVentanaPrincipal.*;
import static GUI.CreadorDeVentanas.CreadorDeVentanas;
import static Json.MontajeDeDatos.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
        String json = (Atributo.getText());
//        Commit.EscrituraCommit("Json.Crear.Atributo()");     //// creacion de atributo                //// deberia escribir un renglon con atributo
//        Commit.EscrituraParametro(json);                        ///// arreglar entrada de info
        ListaDeAtributos.add(json);

        TableColumn<Tabla, String> columna = new TableColumn<>();
        columna.setText(json);
        tabla.getColumns().add(columna);

        /// segun boton marcado, agregar eso a lista
        if (TipoDeAtributo.getSelectedToggle() != null) {
            String AtributoApretado = TipoDeAtributo.getSelectedToggle().getUserData().toString();
            TipoDeAtributos.add(AtributoApretado);
        }

        if (TipoEspecial.getSelectedToggle() != null) {
            String LlaveApretada = TipoEspecial.getSelectedToggle().getUserData().toString();
            TiposEspecial.add(LlaveApretada);
        }
        stagePrincipal.close();
        CreadorDeVentanas("VentanaNuevoAtributo");
        BotonCommit.setDisable(false);                                          ////Activacion de Commit
    }

    @FXML
    private void Cancelar(ActionEvent event) {
        stagePrincipal.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Entero.setUserData("I");                                                //Integer
        Flotante.setUserData("F");                                              //Float
        Cadena.setUserData("S");                                                //String
        FechaHora.setUserData("FH");                                            //Fecha-Hora
        Foranea.setUserData("Foran");                                             //Llave Foranea
        Primaria.setUserData("Prima");                                            //Llave Primaria
        Json.setDisable(true);
        Cadena.setSelected(true);
        Foranea.setSelected(true);
        Entero.setToggleGroup(TipoDeAtributo);
        Flotante.setToggleGroup(TipoDeAtributo);
        Cadena.setToggleGroup(TipoDeAtributo);
        FechaHora.setToggleGroup(TipoDeAtributo);
        Foranea.setToggleGroup(TipoEspecial);
        Primaria.setToggleGroup(TipoEspecial);
    }
}
