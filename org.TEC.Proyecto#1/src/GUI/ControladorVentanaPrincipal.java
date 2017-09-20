package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.util.Callback;
import javax.swing.JOptionPane;

public class ControladorVentanaPrincipal implements Initializable {

    private Main ProgramaPrincipal;
    
    public static TreeItem<String> NodoPrincipal;

    public void setProgramaPrincipal(Main ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }

    @FXML
    private Button BCommit;

    @FXML
    private void Commit(ActionEvent event) {
        Commit.LecturaCommit();                                 //// TIENE que llamar a CLASE APLICAR PETICIONES
        Commit.BorrarCommit();
        BCommit.setDisable(true);                                                //// Desactiva el boton
    }

    //////////////////////////////////////Iconos////////////////////////////////
    Image IconFolder = new Image(
            getClass().getResourceAsStream("/GUI/Img/folder.gif"));

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
            //while montaje de datos a la tabla
            new Tabla("2017159397", "Deiber", "CE")
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ///////////////////////////////////arbol////////////////////////////////////////
//        public static TreeItem<String> NodoPrincipal;
        NodoPrincipal = new TreeItem<>("LinkedDB", new ImageView(IconFolder));

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

        treeView.setRoot(NodoPrincipal);

///////////////////////////////////tabla////////////////////////////////////////
        carne.setCellValueFactory(new PropertyValueFactory<Tabla, Integer>("carne"));
        nombre.setCellValueFactory(new PropertyValueFactory<Tabla, String>("nombre"));
        carrera.setCellValueFactory(new PropertyValueFactory<Tabla, String>("carrera"));

//////////////////////////////////MenuDeArbol///////////////////////////////////
        treeView.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {

            class OpcionesClickDerecho extends TextFieldTreeCell<String> {

                private final ContextMenu contextMenu = new ContextMenu();

                public OpcionesClickDerecho() {

                    MenuItem Buscar = new MenuItem("Buscar");
                    Buscar.setAccelerator(KeyCombination.keyCombination("Ctrl+I"));
                    MenuItem Actualizar = new MenuItem("Actualizar Jsons");
                    //Actualizar.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
                    SeparatorMenuItem separador1 = new SeparatorMenuItem();
                    MenuItem Mostrar = new MenuItem("Mostrar todos los Jsons");
                    //Mostrar.setAccelerator(KeyCombination.keyCombination("Ctrl+M"));
                    Menu MenuNuevo = new Menu("Nuevo");
                    //Nuevo.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
                    MenuItem childNuevoStore = new MenuItem("Nuevo Store");
                    //childEliminarUno.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
                    MenuItem childNuevoJson = new MenuItem("Nuevo Json");
                    //childEliminarTodos.setAccelerator(KeyCombination.keyCombination("Ctrl+Shift+N"));
                    MenuNuevo.getItems().addAll(childNuevoStore, childNuevoJson);
                    SeparatorMenuItem separador2 = new SeparatorMenuItem();
                    Menu MenuEliminar = new Menu("Eliminar");
                    MenuItem childEliminarSeleccionado = new MenuItem("Eliminar Store o Json seleccionado");////////////////EXTRA///////////
                    //childEliminarUno.setAccelerator(KeyCombination.keyCombination("Delete"));                    ////////////////////////////
                    MenuItem childEliminarTodos = new MenuItem("Eliminar todos los Archivos");
                    //childEliminarTodos.setAccelerator(KeyCombination.keyCombination("Shift+Delete"));
////////////////////MenuEliminar.getItems().addAll(childEliminarUno, childEliminarTodos);///////////////////////////////////////////
                    MenuEliminar.getItems().addAll(childEliminarSeleccionado, childEliminarTodos);

                    contextMenu.getItems().addAll(Buscar, Actualizar, separador1,
                            Mostrar, MenuNuevo, separador2, MenuEliminar);

                    Buscar.setOnAction(new EventHandler() {///// Funcion de la opcion de Busqueda
                        @Override
                        public void handle(Event t) {
                            ProgramaPrincipal.CreadorDeVentanas("VentanaBusqueda");
                        }
                    });

//                    Actualizar.setOnAction(new EventHandler() {///// Funcion de la opcion de Actualizacion
//                        @Override
//                        public void handle(Event t) {
//                            ProgramaPrincipal.CreadorDeVentanas("VentanaActualizacion");
//                            BCommit.setDisable(false);                               ////Activacion de Commit
//                        }
//                    });

                    Mostrar.setOnAction(new EventHandler() {///// Funcion de la opcion de Mostrar
                        @Override
                        public void handle(Event t) {
                            table.setItems(list);
                        }
                    });

                    childNuevoStore.setOnAction(new EventHandler() {///// Funcion de la opcion de Agregar Nuevo Store
                        @Override
                        public void handle(Event t) {
                            ProgramaPrincipal.CreadorDeVentanas("VentanaNuevoStore");       ///// lectura de entry para nombre de nuevo documento
//                            TreeItem NuevoStore = new TreeItem<String>("Nuevo Store");        //hacer que se cree nuevo archivo Json (o carpeta con archivo)
//                            NodoPrincipal.getChildren().add(NuevoStore);
//                            Commit.EscrituraCommit("Json.Crear.Store()");
//                            Commit.EscrituraParametro("TEST");//                  ademas ligarlo a lista
                            BCommit.setDisable(false);                               ////Activacion de Commit
                        }
                    });

                    childNuevoJson.setOnAction(new EventHandler() {///// Funcion de la opcion de Agregar Nuevo Objeto
                        @Override
                        public void handle(Event t) {
                            ProgramaPrincipal.CreadorDeVentanas("VentanaNuevoJson");            ///// lectura de entry para nombre de nuevo documento
                            
//                            TreeItem NuevoJson = new TreeItem<String>("Nuevo Json");        //hacer que se cree nuevo archivo Json (o carpeta con archivo)
//                            hacer que lea ENTRY para saber titulo y archivo a agregar, ademas de la info
//                            getTreeItem().getChildren().add(NuevoJson);
//                            Commit.EscrituraCommit("Json.Crear.Archivo()");
//                            Commit.EscrituraParametro("TEST");
                            
                            BCommit.setDisable(false);                               ////Activacion de Commit
                        }
                    });

                    childEliminarSeleccionado.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event t) {                   ////falta agregar que borre carpeta de verdad
                            TreeItem<String> Seleccionado = getTreeItem();
                            if (Seleccionado == NodoPrincipal) {
                                JOptionPane.showMessageDialog(null, "El Sistema Base no puede ser eliminado", "Error", JOptionPane.WARNING_MESSAGE);
                            } else {
                                Seleccionado.getParent().getChildren().remove(Seleccionado);
                                Commit.EscrituraCommit("Json.Eliminar.Archivo()");
                                Commit.EscrituraParametro(Seleccionado.getValue());
                                BCommit.setDisable(false);                               ////Activacion de Commit
                            }
                        }
                    });

                    childEliminarTodos.setOnAction(new EventHandler() {///// Funcion de la opcion de Eliminar Todos los archivos de una carpeta
                        @Override
                        public void handle(Event t) {
                            TreeItem<String> Seleccionado = getTreeItem();
                            if (Seleccionado == NodoPrincipal) {
                                JOptionPane.showMessageDialog(null, "El Sistema Base no puede ser vaciado", "Error", JOptionPane.WARNING_MESSAGE);
                            } else {
                                TreeItem NuevoBorrado = new TreeItem<String>(Seleccionado.getValue());
                                NodoPrincipal.getChildren().add(NuevoBorrado);
                                Seleccionado.getParent().getChildren().remove(Seleccionado);
                                Commit.EscrituraCommit("Json.Eliminar.Todos()");
                                Commit.EscrituraParametro(Seleccionado.getValue());
                                BCommit.setDisable(false);                          ////Activacion de Commit
                            }
                        }
                    });
                }

/////////////////////// Menu de opciones en cada nodo //////////////////////////
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(getTreeItem().getGraphic());
                        if (!getTreeItem().isLeaf() && getTreeItem().getParent() != null) {
                            setContextMenu(contextMenu);
                        }
                        if (!empty && getTreeItem().getParent() == null) {
                            setContextMenu(contextMenu);
                        }
                    }
                }
            }

            @Override
            public TreeCell<String> call(TreeView<String> arg0) {
                return new OpcionesClickDerecho();
            }
        });
    }
}
