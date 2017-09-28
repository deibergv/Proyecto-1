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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.cell.TextFieldTreeCell;
import static GUI.CreadorDeVentanas.CreadorDeVentanas;
import javafx.scene.input.KeyCombination;

/**
 * Constructor de la clase de la Ventana Main o principal
 *
 * @author deiber
 */
public class ControladorVentanaPrincipal implements Initializable {

    private Main ProgramaPrincipal;

    public static TreeItem<String> NodoPrincipal;
    public static TreeItem<String> seleccionado;

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
            new Tabla("2017159397", "Deiber", "CE")
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ///////////////////////////////////arbol////////////////////////////////////////
        NodoPrincipal = new TreeItem<>("LinkedDB", new ImageView(IconFolder));
        NodoPrincipal.setExpanded(true);

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

/////////////////////////////////////tabla////////////////////////////////////////
        carne.setCellValueFactory(new PropertyValueFactory<Tabla, Integer>("carne"));
        nombre.setCellValueFactory(new PropertyValueFactory<Tabla, String>("nombre"));
        carrera.setCellValueFactory(new PropertyValueFactory<Tabla, String>("carrera"));

//////////////////////////////////MenuDeArbol///////////////////////////////////
        treeView.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
            /**
             * Menu de Opciones del arbol
             *
             * @author deiber
             */
            class OpcionesClickDerecho extends TextFieldTreeCell<String> {

                private final ContextMenu contextMenuPrincipal = new ContextMenu();
                private final ContextMenu contextMenuNodo = new ContextMenu();
                private final ContextMenu contextMenuHijos = new ContextMenu();

                MenuItem Buscar;
                MenuItem Actualizar;
                MenuItem Mostrar;
                SeparatorMenuItem separador1;
                SeparatorMenuItem separador2;
                SeparatorMenuItem separador3;
                MenuItem NuevoStore;
                MenuItem NuevoJson;
                Menu MenuEliminar;
                Menu MenuEliminarHijos;
                MenuItem childEliminarStoreSeleccionado;
                MenuItem childEliminarJsonSeleccionado;
                MenuItem childEliminarTodos;

                /**
                 * Metodo encargado de dar un menu de opciones al arbol
                 */
                public OpcionesClickDerecho() {

                    Buscar = new MenuItem("Buscar");
                    Actualizar = new MenuItem("Actualizar Jsons");
                    Mostrar = new MenuItem("Mostrar Jsons");
                    separador1 = new SeparatorMenuItem();
                    separador2 = new SeparatorMenuItem();
                    separador3 = new SeparatorMenuItem();
                    NuevoStore = new MenuItem("Nuevo Store");
                    NuevoJson = new MenuItem("Nuevo Json");
                    MenuEliminar = new Menu("Eliminar");
                    MenuEliminarHijos = new Menu("Eliminar");
                    childEliminarStoreSeleccionado = new MenuItem("Eliminar Store seleccionado");
                    childEliminarJsonSeleccionado = new MenuItem("Eliminar Json seleccionado");
                    childEliminarTodos = new MenuItem("Eliminar todos los Archivos");


                    MenuEliminar.getItems().addAll(childEliminarStoreSeleccionado, childEliminarTodos);
                    MenuEliminarHijos.getItems().addAll(childEliminarJsonSeleccionado);

                    //Buscar.setAccelerator(KeyCombination.keyCombination("Ctrl+I"));                                           //***********************
                    //Actualizar.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
                    //Mostrar.setAccelerator(KeyCombination.keyCombination("Ctrl+M"));
                    NuevoStore.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
                    //NuevoJson.setAccelerator(KeyCombination.keyCombination("Ctrl+Shift+N"));
                    //childEliminarUno.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
                    //childEliminarTodos.setAccelerator(KeyCombination.keyCombination("Ctrl+Shift+N"));
                    //childEliminarUno.setAccelerator(KeyCombination.keyCombination("Delete"));
                    //childEliminarTodos.setAccelerator(KeyCombination.keyCombination("Shift+Delete")); 
                    
                    contextMenuPrincipal.getItems().addAll(NuevoStore);
                    contextMenuNodo.getItems().addAll(Buscar, Actualizar, Mostrar, separador2, NuevoJson, MenuEliminar);
                    contextMenuHijos.getItems().addAll(separador3, MenuEliminarHijos);      //montar "actualizar" especial
                }

/////////////////////// Menu de opciones en cada nodo //////////////////////////
                /**
                 * Metodo encargado de dar un menu de opciones al arbol en cada
                 * nodo
                 *
                 * @param item
                 * @param empty
                 */
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty) {
                        setGraphic(null);

                    } else if (!empty && getTreeItem().getParent() == null) {           // opciones de Nodo Principal //
                        NuevoStore.setOnAction(new EventHandler() {///// Funcion de la opcion de Agregar Nuevo Store
                            @Override
                            public void handle(Event t) {
                                CreadorDeVentanas("VentanaNuevoStore");
                                BCommit.setDisable(false);                      ////Activacion de Commit
                            }
                        });
                        setContextMenu(contextMenuPrincipal);

                    } else if (getTreeItem().getParent() == NodoPrincipal) {          // Opciones de Nodos //
                        Buscar.setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                CreadorDeVentanas("VentanaBusqueda");
                            }
                        });
                        Actualizar.setOnAction(new EventHandler() {///// Funcion de la opcion de Actualizacion
                            @Override
                            public void handle(Event t) {
                                CreadorDeVentanas("VentanaActualizacion");                                     //********************
                                BCommit.setDisable(false);                      ////Activacion de Commit
                            }
                        });
                        Mostrar.setOnAction(new EventHandler() {///// Funcion de la opcion de Mostrar
                            @Override
                            public void handle(Event t) {
                                table.setItems(list);                                                            // ********************
                            }
                        });
                        NuevoJson.setOnAction(new EventHandler() {///// Funcion de la opcion de Agregar Nuevo Objeto
                            @Override
                            public void handle(Event t) {
                                seleccionado = getTreeItem();
                                CreadorDeVentanas("VentanaNuevoJson");    
                                BCommit.setDisable(false);                               ////Activacion de Commit
                            }
                        });
                        childEliminarStoreSeleccionado.setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                getTreeItem().getParent().getChildren().remove(getTreeItem());
                                Commit.EscrituraCommit("Json.Eliminar.Carpeta()");
                                Commit.EscrituraParametro(getTreeItem().getValue());
                                BCommit.setDisable(false);                               ////Activacion de Commit
                            }
                        });
                        childEliminarTodos.setOnAction(new EventHandler() {///// Funcion de la opcion de Eliminar Todos los archivos de una carpeta
                            @Override
                            public void handle(Event t) {
                                TreeItem<String> Seleccionado = getTreeItem();
                                TreeItem NuevoBorrado = new TreeItem<String>(Seleccionado.getValue());              //****** ver si se puede mejorar**
                                NodoPrincipal.getChildren().add(NuevoBorrado);
                                Seleccionado.getParent().getChildren().remove(Seleccionado);
                                Commit.EscrituraCommit("Json.Eliminar.Todos()");
                                Commit.EscrituraParametro(Seleccionado.getValue());
                                BCommit.setDisable(false);                          ////Activacion de Commit

                            }
                        });
                        setContextMenu(contextMenuNodo);
                    } else if (getTreeItem().isLeaf() && getTreeItem().getParent().getParent() != null) {       // Opciones de hijos hijos //
                        childEliminarJsonSeleccionado.setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                getTreeItem().getParent().getChildren().remove(getTreeItem());
                                Commit.EscrituraCommit("Json.Eliminar.Archivo()");              
                                Commit.EscrituraParametro(getTreeItem().getValue());
                                BCommit.setDisable(false);                               ////Activacion de Commit
                            }
                        });
                        setContextMenu(contextMenuHijos);
                    } else {
                        return;
                    }
                }
            }

            /**
             * Llamado a la activacion de las opciones
             *
             * @param arg0
             * @return
             */
            @Override
            public TreeCell<String> call(TreeView<String> arg0) {
                return new OpcionesClickDerecho();
            }
        });
    }
}
