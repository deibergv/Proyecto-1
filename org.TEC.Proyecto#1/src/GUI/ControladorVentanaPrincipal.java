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
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import javax.swing.JOptionPane;

public class ControladorVentanaPrincipal implements Initializable {

    private Main ProgramaPrincipal;

    public void setProgramaPrincipal(Main ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }

    @FXML
    private void Commit(ActionEvent event) {
        System.out.println("Commit");
    }

    //////////////////////////////////////Iconos////////////////////////////////
    Image IconFolder = new Image(
            getClass().getResourceAsStream("/img/folder.gif"));

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
            new Tabla(2017159397, "Deiber", "CE")
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ///////////////////////////////////arbol////////////////////////////////////////
        TreeItem<String> NodoPrincipal = new TreeItem<>("Base de Datos", new ImageView(IconFolder));

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
                private TextField textField;

                public OpcionesClickDerecho() {

                    MenuItem Buscar = new MenuItem("Buscar");
                    //Buscar.setAccelerator(KeyCombination.keyCombination("Ctrl+I"));
                    MenuItem Actualizar = new MenuItem("Actualizar Estudiante");
                    //Actualizar.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
                    SeparatorMenuItem separador1 = new SeparatorMenuItem();
                    MenuItem Mostrar = new MenuItem("Mostrar todos los Estudiantes");
                    //Mostrar.setAccelerator(KeyCombination.keyCombination("Ctrl+M"));
                    Menu MenuNuevo = new Menu("Nuevo");
                    //Nuevo.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
                    MenuItem childNuevoCurso = new MenuItem("Nuevo Curso");
                    //childEliminarUno.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
                    MenuItem childNuevoEstudiante = new MenuItem("Nuevo Estudiante");
                    //childEliminarTodos.setAccelerator(KeyCombination.keyCombination("Ctrl+Shift+N"));
                    MenuNuevo.getItems().addAll(childNuevoCurso, childNuevoEstudiante);
                    SeparatorMenuItem separador2 = new SeparatorMenuItem();
                    Menu MenuEliminar = new Menu("Eliminar");
                    MenuItem childEliminarSeleccionado = new MenuItem("Eliminar Curso o Estudiante seleccionado");////////////////EXTRA///////////
                    //childEliminarUno.setAccelerator(KeyCombination.keyCombination("Delete"));                    ////////////////////////////
                    MenuItem childEliminarUno = new MenuItem("Eliminar un Estudiante");
                    //childEliminarUno.setAccelerator(KeyCombination.keyCombination("Ctrl+Delete"));
                    MenuItem childEliminarTodos = new MenuItem("Eliminar todos los Estudiantes");
                    //childEliminarTodos.setAccelerator(KeyCombination.keyCombination("Shift+Delete"));
////////////////////MenuEliminar.getItems().addAll(childEliminarUno, childEliminarTodos);///////////////////////////////////////////
                    MenuEliminar.getItems().addAll(childEliminarSeleccionado, childEliminarUno, childEliminarTodos);

                    contextMenu.getItems().addAll(Buscar, Actualizar, separador1,
                            Mostrar, MenuNuevo, separador2, MenuEliminar);

                    Buscar.setOnAction(new EventHandler() {///// Funcion de la opcion de Busqueda
                        @Override
                        public void handle(Event t) {
                            ProgramaPrincipal.CreadorDeVentanas("VentanaBusqueda");
                        }
                    });

                    Actualizar.setOnAction(new EventHandler() {///// Funcion de la opcion de Actualizacion
                        @Override
                        public void handle(Event t) {
                            ProgramaPrincipal.CreadorDeVentanas("Actualizacion()");
                        }
                    });

                    Mostrar.setOnAction(new EventHandler() {///// Funcion de la opcion de Mostrar
                        @Override
                        public void handle(Event t) {
                            table.setItems(list);
                        }
                    });

                    childNuevoCurso.setOnAction(new EventHandler() {///// Funcion de la opcion de Agregar Nuevo Curso
                        @Override
                        public void handle(Event t) {
                            ProgramaPrincipal.CreadorDeVentanas("VentanaNuevoCurso()");       ///// lectura de entry para nombre de nuevo documento
                            TreeItem NuevoCurso = new TreeItem<String>("Nuevo Curso");        //hacer que se cree nuevo archivo Json (o carpeta con archivo)
                            NodoPrincipal.getChildren().add(NuevoCurso);
                        }
                    });

                    childNuevoEstudiante.setOnAction(new EventHandler() {///// Funcion de la opcion de Agregar Nuevo Objeto
                        @Override
                        public void handle(Event t) {
                            ProgramaPrincipal.CreadorDeVentanas("VentanaNuevoEstudiante()");            ///// lectura de entry para nombre de nuevo documento
                            TreeItem NuevoEstudiante = new TreeItem<String>("Nuevo Estudiante");        //hacer que se cree nuevo archivo Json (o carpeta con archivo)
                            getTreeItem().getChildren().add(NuevoEstudiante);
                        }
                    });

                    childEliminarSeleccionado.setOnAction(new EventHandler() {
                        @Override
                        public void handle(Event t) {                   ////falta agregar que borre carpeta de verdad
                            TreeItem<String> selected = getTreeItem();
                            if (selected == NodoPrincipal) {
                                JOptionPane.showMessageDialog(null, "El Sistema de almacenamiento Base no puede ser eliminado", "Error", JOptionPane.WARNING_MESSAGE);
                            } else {
                                getTreeItem().getParent().getChildren().remove(getTreeItem());
                            }
                        }
                    });

                    childEliminarUno.setOnAction(new EventHandler() {///// Funcion de la opcion de Eliminar Uno Solo por busqueda
                        @Override
                        public void handle(Event t) {        ////falta agregar que borre carpeta de verdad
                            TreeItem<String> selected = getTreeItem();
                        }               ///// FALTA ELIMINAR POR BUSQUEDA
                    });

                    childEliminarTodos.setOnAction(new EventHandler() {///// Funcion de la opcion de Eliminar Todos
                        @Override
                        public void handle(Event t) {                                   /////While o for para que borre todos?
                            NodoPrincipal.getChildren().removeAll(nodeA, nodeB, nodeC);           ///// usar mismo while de lectura para que borre cada 1
                        }
                    });
                }

/////////////////////// Menu de opciones en cada nodo //////////////////////////
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty) {
                        setText(null);
                        setGraphic(null);
                    } else {
                        if (isEditing()) {
                            if (textField != null) {
                                textField.setText(getString());
                            }
                            setText(null);
                            setGraphic(textField);
                        } else {
                            setText(getString());
                            setGraphic(getTreeItem().getGraphic());
                            if (!getTreeItem().isLeaf() && getTreeItem().getParent() != null) {
                                setContextMenu(contextMenu);
                            }
                        }
                        if (!empty && getTreeItem().getParent() == null) {
                            setContextMenu(contextMenu);
                        }
                    }
                }

//////////////////////////////// Implementacion de edicion de nombres en Arbol (no se guardan cambios) ////////////////////////////// 
                @Override
                public void startEdit() {
                    super.startEdit();
                    if (textField == null) {
                        createTextField();
                    }
                    setText(null);
                    setGraphic(textField);
                    textField.selectAll();
                }

                @Override
                public void cancelEdit() {
                    super.cancelEdit();
                    setText((String) getItem());
                    setGraphic(getTreeItem().getGraphic());
                }

                private void createTextField() {
                    textField = new TextField(getString());
                    textField.setOnKeyReleased(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent t) {
                            if (t.getCode() == KeyCode.ENTER) {
                                commitEdit(textField.getText());
                            } else if (t.getCode() == KeyCode.ESCAPE) {
                                cancelEdit();
                            }
                        }
                    });
                }

                private String getString() {
                    return getItem() == null ? "" : getItem().toString();
                }
            }

            @Override
            public TreeCell<String> call(TreeView<String> arg0) {
                return new OpcionesClickDerecho();
            }
        });
    }
}
