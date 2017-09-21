package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import GUI.OpcionesClickDerecho.Opciones;

/**
 * Constructor de la clase de la Ventana Main o principal
 *
 * @author deiber
 */
public class ControladorVentanaPrincipal implements Initializable {

    private Main ProgramaPrincipal;

    public TreeItem<String> NodoPrincipal;
    @FXML
    private Button BCommit;
    @FXML
    private TableView<Tabla> table;
    @FXML
    private TreeView<String> treeView;

    public void setProgramaPrincipal(Main ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;

    }
    //////////////////////////////////////Iconos////////////////////////////////
    Image IconFolder = new Image(getClass().getResourceAsStream("/GUI/Img/folder.gif"));

    /**
     * Respectiva accion al boton commit
     *
     * @param event
     */
    @FXML       /// Accion del boton Commit ///
    private void Commit(ActionEvent event) {
        Commit.LecturaCommit();
        Commit.BorrarCommit();
        BCommit.setDisable(true);                                                //// Desactiva el boton ///
    }
    @FXML
    private TableColumn<Tabla, Integer> carne;
    @FXML
    private TableColumn<Tabla, String> nombre;
    @FXML
    private TableColumn<Tabla, String> carrera;

    public static ObservableList<Tabla> list = FXCollections.observableArrayList(
            //while montaje de datos a la tabla
            new Tabla("2017159397", "Deiber", "CE")
    );
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ///////////////////////////////////arbol////////////////////////////////////////
        NodoPrincipal = new TreeItem<>("LinkedDB", new ImageView(IconFolder));
                                                                                    table.setItems(list);//// lo permite con lista statica pero no con tabla estatica
        TreeItem<String> nodeA = new TreeItem<>("CE-1103", new ImageView(IconFolder));
        TreeItem<String> nodeB = new TreeItem<>("Int. al bostezo", new ImageView(IconFolder));
        TreeItem<String> nodeC = new TreeItem<>("node C", new ImageView(IconFolder));

        NodoPrincipal.getChildren().addAll(nodeA, nodeB, nodeC);
        ////////// o se puede separar cada uno: ///////////
        //LinkedDB.getChildren().add(nodeB);
        //LinkedDB.getChildren().add(nodeC);

        TreeItem<String> nodeA1 = new TreeItem<>("Juan");
        TreeItem<String> nodeB1 = new TreeItem<>("Isaac");
        TreeItem<String> nodeC1 = new TreeItem<>("Ricardo");
        nodeA.getChildren().addAll(nodeA1);
        nodeB.getChildren().add(nodeB1);
        nodeC.getChildren().add(nodeC1);

        NodoPrincipal.setExpanded(true);
        treeView.setRoot(NodoPrincipal);

/////////////////////////////////////tabla////////////////////////////////////////
        carne.setCellValueFactory(new PropertyValueFactory<Tabla, Integer>("carne"));
        nombre.setCellValueFactory(new PropertyValueFactory<Tabla, String>("nombre"));
        carrera.setCellValueFactory(new PropertyValueFactory<Tabla, String>("carrera"));

//////////////////////////////////MenuDeArbol///////////////////////////////////
        treeView.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
            /**
             * Llamado a la activacion de las opciones
             *
             * @param arg0
             * @return
             */
            @Override
            public TreeCell<String> call(TreeView<String> arg0) {
                return new Opciones(NodoPrincipal);
            }
        });
    }
}
