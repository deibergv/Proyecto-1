package GUI;

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

/**
 * Constructor de la clase encargada de invocar una ventana Busqueda
 *
 * @author deiber
 */
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
            new Tabla("123", "Pedro", "Cuenta vacas"),
            new Tabla("456", "Leiner", "Biotecnologia"),
            new Tabla("678", "Felipe", "Computacion"),
            new Tabla("2017159397", "Deiber", "CE")
    );
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn<Tabla, String> columna = new TableColumn<>();
        columna.setText("carne");
        TableColumn<Tabla, String> columna2 = new TableColumn<>();
        columna.setText("nombre");
        TableColumn<Tabla, String> columna3 = new TableColumn<>();
        columna.setText("carrera");
        table.getColumns().addAll(columna,columna2, columna3);
        ///////////////////////////////////tabla////////////////////////////////////////
        carne.setCellValueFactory(new PropertyValueFactory<Tabla, String>("carne"));
        nombre.setCellValueFactory(new PropertyValueFactory<Tabla, String>("nombre"));
        carrera.setCellValueFactory(new PropertyValueFactory<Tabla, String>("carrera"));

        FilteredList<Tabla> DatosFiltrados = new FilteredList<>(list, p -> true); /////////////// Filtrado de tabla para solo mostrar lo buscado
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            DatosFiltrados.setPredicate(estudiante -> {
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
        SortedList<Tabla> ListaDeDatosFiltrados = new SortedList<>(DatosFiltrados);
        ListaDeDatosFiltrados.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(ListaDeDatosFiltrados);
    }
}
