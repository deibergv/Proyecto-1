package GUI;

import Json.MontajeDeDatos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControladorVentanaBusqueda implements Initializable {

    private Stage stagePrincipal;
    
    public void setStagePrincipal(Stage stagePrincipal) {
        this.stagePrincipal = stagePrincipal;
    }

    @FXML /////////////////////////////TABLA////////////////////////////////////
    private TableView<Tabla> table;
    @FXML
    private TableColumn<Tabla, String> carne;
    @FXML
    private TableColumn<Tabla, String> nombre;
    @FXML
    private TableColumn<Tabla, String> carrera;
    @FXML
    private TextField filterField;
    
    public ObservableList<Tabla> list = FXCollections.observableArrayList(
//            String[] array = Json.Metadata.StoreToString(Json.Metadata.StringToStore("a-b-c-d-f-g")).split("-",0));
            new Tabla("213",MontajeDeDatos.MontajeDeDatos("Nombre"),"CE"),
            new Tabla("123", "Pedro", "Cuenta vacas"),
            new Tabla("456", "Leiner", "Biotecnologia"),
            new Tabla("678", "Felipe", "Computacion")
    );
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    ///////////////////////////////////tabla////////////////////////////////////////
        carne.setCellValueFactory(new PropertyValueFactory<Tabla, String>("carne"));
        nombre.setCellValueFactory(new PropertyValueFactory<Tabla, String>("nombre"));
        carrera.setCellValueFactory(new PropertyValueFactory<Tabla, String>("carrera"));
        table.setItems(list);

        FilteredList<Tabla> filteredData = new FilteredList<>(list, p -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(estudiante -> {
                // Si el filtro de busqueda esta vacio, muestra todo
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                //Comparaciones
                if (estudiante.getCarne().toString().contains(lowerCaseFilter)) {
                    return true;
                } else if (estudiante.getNombre().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (estudiante.getCarrera().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        }); 
        SortedList<Tabla> DatosFiltrados = new SortedList<>(filteredData);
        DatosFiltrados.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(DatosFiltrados);
    }
}
