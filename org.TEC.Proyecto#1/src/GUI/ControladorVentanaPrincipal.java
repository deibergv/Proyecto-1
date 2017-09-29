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
import static Json.MontajeDeDatos.ListaDeJsons;
import static Json.MontajeDeDatos.ListaDeStores;
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
    private TableColumn<Tabla, String> carne;
    @FXML
    private TableColumn<Tabla, String> nombre;
    @FXML
    private TableColumn<Tabla, String> carrera;

    public static ObservableList<Tabla> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carne.setText("asdasd");
        
        TableColumn<Tabla, String> ajja = new TableColumn<>();
        TableColumn<Tabla, String> ajja1 = new TableColumn<>();
        TableColumn<Tabla, String> ajja2 = new TableColumn<>();
        table.getColumns().addAll(ajja, ajja1, ajja2);
        
        
        
        /////////////////////////////////////tabla////////////////////////////////////////
//        carne.setCellValueFactory(new PropertyValueFactory<Tabla, String>("carne"));
//        nombre.setCellValueFactory(new PropertyValueFactory<Tabla, String>("nombre"));
//        carrera.setCellValueFactory(new PropertyValueFactory<Tabla, String>("carrera"));
        
        
        ///////////////////////////////////arbol////////////////////////////////////////
        NodoPrincipal = new TreeItem<>("LinkedDB", new ImageView(IconFolder));
        NodoPrincipal.setExpanded(true);
        treeView.setRoot(NodoPrincipal);

//        TreeItem<String> Store = new TreeItem<>("CE-1103", new ImageView(IconFolder));
//        NodoPrincipal.getChildren().addAll(Store);
//        TreeItem<String> Atributo = new TreeItem<>("Carné");
//        Store.getChildren().add(Atributo);

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
                Menu MenuNuevo;
                MenuItem NuevoAtributo;
                MenuItem NuevoObjeto;
                Menu MenuEliminar;
                MenuItem childEliminarStoreSeleccionado;
                MenuItem EliminarJsonSeleccionado;
                MenuItem childEliminarTodos;

                /**
                 * Metodo encargado de dar un menu de opciones al arbol
                 */
                public OpcionesClickDerecho() {

                    Buscar = new MenuItem("Buscar");
                    Actualizar = new MenuItem("Actualizar Jsons");
                    Mostrar = new MenuItem("Mostrar Objetos");
                    separador1 = new SeparatorMenuItem();
                    separador2 = new SeparatorMenuItem();
                    separador3 = new SeparatorMenuItem();
                    NuevoStore = new MenuItem("Nuevo Store");
                    NuevoJson = new MenuItem("Nuevo Json");
                    MenuNuevo = new Menu("Nuevo");
                    NuevoAtributo = new MenuItem("Nuevo Atributo");
                    NuevoObjeto = new MenuItem("Nuevo Objeto");
                    MenuEliminar = new Menu("Eliminar");
                    childEliminarStoreSeleccionado = new MenuItem("Eliminar Store seleccionado");
                    EliminarJsonSeleccionado = new MenuItem("Eliminar Json seleccionado");
                    childEliminarTodos = new MenuItem("Eliminar todos los Archivos");
                    MenuEliminar.getItems().addAll(childEliminarStoreSeleccionado, childEliminarTodos);
                    MenuNuevo.getItems().addAll(NuevoAtributo, NuevoObjeto);

                    NuevoStore.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));

                    contextMenuPrincipal.getItems().addAll(NuevoStore);
                    contextMenuNodo.getItems().addAll(Buscar, Actualizar, Mostrar, separador2, NuevoJson, MenuEliminar);
                    contextMenuHijos.getItems().addAll(MenuNuevo, separador3, EliminarJsonSeleccionado);
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
                        setContextMenu(contextMenuPrincipal);
                        NuevoStore.setOnAction(new EventHandler() {///// Funcion de la opcion de Agregar Nuevo Store
                            @Override
                            public void handle(Event t) {
                                CreadorDeVentanas("VentanaNuevoStore");
                                BCommit.setDisable(false);                      ////Activacion de Commit
                            }
                        });

                    } else if (getTreeItem().getParent() == NodoPrincipal) {          // Opciones de Nodos //
                        setContextMenu(contextMenuNodo);
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
                                BCommit.setDisable(false);                      ////Activacion de Commit
                            }
                        });
                        childEliminarStoreSeleccionado.setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                seleccionado = getTreeItem();
                                ListaDeStores.Borrar(seleccionado.getValue());
                                Commit.EscrituraCommit("Json.Eliminar.Carpeta()");
                                Commit.EscrituraParametro(seleccionado.getValue());
                                seleccionado.getParent().getChildren().remove(getTreeItem());
                                BCommit.setDisable(false);                      ////Activacion de Commit
                            }
                        });
                        childEliminarTodos.setOnAction(new EventHandler() {///// Funcion de la opcion de Eliminar Todos los archivos de una carpeta
                            @Override
                            public void handle(Event t) {
                                seleccionado = getTreeItem();
                                TreeItem NuevoBorrado = new TreeItem<String>(seleccionado.getValue());              //****** ver si se puede mejorar**
                                Commit.EscrituraCommit("Json.Eliminar.Todos()");
                                Commit.EscrituraParametro(seleccionado.getValue());
                                ListaDeJsons.Borrar(getTreeItem().getValue());                         //// hacer que elimine todos los Jsons de adentro
                                NodoPrincipal.getChildren().add(NuevoBorrado);
                                seleccionado.getParent().getChildren().remove(seleccionado);
                                BCommit.setDisable(false);                      ////Activacion de Commit

                            }
                        });

                    } else if (getTreeItem().getParent().getParent() == NodoPrincipal) {       // Opciones de hijos //
                        setContextMenu(contextMenuHijos);
                        EliminarJsonSeleccionado.setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                seleccionado = getTreeItem();
                                Commit.EscrituraCommit("Json.Eliminar.Archivo()");
                                Commit.EscrituraParametro(getTreeItem().getValue());
                                Commit.EscrituraParametro(getTreeItem().getParent().getValue());
                                seleccionado.getParent().getChildren().remove(seleccionado);
                                ListaDeJsons.Borrar(getTreeItem().getValue());
                                BCommit.setDisable(false);                      ////Activacion de Commit
                            }
                        });
                        NuevoAtributo.setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                seleccionado = getTreeItem();
                                CreadorDeVentanas("VentanaNuevoAtributo");
                                BCommit.setDisable(false);                      ////Activacion de Commit
                            }
                        });
                        NuevoObjeto.setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                seleccionado = getTreeItem();
                                CreadorDeVentanas("VentanaNuevoObjeto");   ////TIENE que agarrar columnas y segun eso permitir o no info de entrada
                                BCommit.setDisable(false);                      ////Activacion de Commit
                            }
                        });

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
