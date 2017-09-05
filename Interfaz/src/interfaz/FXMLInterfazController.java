package interfaz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FXMLInterfazController implements Initializable {

    Image IconFolder = new Image(
            getClass().getResourceAsStream("/img/folder.gif"));

    @FXML /////////////////////////////BOTON////////////////////////////////////
    private void BotonCommit(ActionEvent e) {
        System.out.println("Hola");
    }
    @FXML /////////////////////////////ARBOL////////////////////////////////////
    TreeView<String> treeView;

    @FXML /////////////////////////////TABLA////////////////////////////////////
    private TableView<Tabla> table;
    @FXML
    private TableColumn<Tabla, Integer> carne;
    @FXML
    private TableColumn<Tabla, String> nombre;
    @FXML
    private TableColumn<Tabla, String> carrera;
    public ObservableList<Tabla> list = FXCollections.observableArrayList(
            new Tabla(2017159397, "Deiber", "CE"),
            new Tabla(201117284, "Frander", "CE")
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ///////////////////////////arbol////////////////////////////////////////
        TreeItem<String> NodoPrincipal = new TreeItem<>("LinkedDB", new ImageView(IconFolder));

        TreeItem<String> nodeA = new TreeItem<>("node A", new ImageView(IconFolder));
        TreeItem<String> nodeB = new TreeItem<>("node B", new ImageView(IconFolder));
        TreeItem<String> nodeC = new TreeItem<>("node C", new ImageView(IconFolder));

        NodoPrincipal.getChildren().addAll(nodeA, nodeB, nodeC);
        ////////// o se puede separar cada uno: ///////////
        //LinkedDB.getChildren().add(nodeB);
        //LinkedDB.getChildren().add(nodeC);

        TreeItem<String> nodeA1 = new TreeItem<>("node A 1");
        TreeItem<String> nodeB1 = new TreeItem<>("node B 1");
        TreeItem<String> nodeC1 = new TreeItem<>("node C 1");
        nodeA.getChildren().addAll(nodeA1); //el addAll para agregar mas de uno a la vez
        nodeB.getChildren().add(nodeB1);
        nodeC.getChildren().add(nodeC1);
        treeView.setRoot(NodoPrincipal);

        ///////////////////////////tabla////////////////////////////////////////
        carne.setCellValueFactory(new PropertyValueFactory<Tabla, Integer>("carne"));
        nombre.setCellValueFactory(new PropertyValueFactory<Tabla, String>("nombre"));
        carrera.setCellValueFactory(new PropertyValueFactory<Tabla, String>("carrera"));
        table.setItems(list);
    }
}
