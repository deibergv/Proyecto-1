package GUI;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

//class OpcionesClickDerecho extends TextFieldTreeCell<String> {
//
//    private Main ProgramaPrincipal;
//
//    public void setProgramaPrincipal(Main ProgramaPrincipal) {
//        this.ProgramaPrincipal = ProgramaPrincipal;
//    }
//    private final ContextMenu contextMenu = new ContextMenu();
//    private TextField textField;
//
//    public OpcionesClickDerecho() {
//
//        MenuItem Buscar = new MenuItem("Buscar");
//        Buscar.setAccelerator(KeyCombination.keyCombination("Ctrl+I"));
//        MenuItem Actualizar = new MenuItem("Actualizar Estudiante");
//        Actualizar.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
//        SeparatorMenuItem separador1 = new SeparatorMenuItem();
//        MenuItem Mostrar = new MenuItem("Mostrar todos los Estudiantes");
//        Mostrar.setAccelerator(KeyCombination.keyCombination("Ctrl+M"));
//        MenuItem Nuevo = new MenuItem("Agregar nuevo Estudiante");
//        Nuevo.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
//        SeparatorMenuItem separador2 = new SeparatorMenuItem();
//        Menu MenuEliminar = new Menu("Eliminar");
//        MenuItem childEliminarUno = new MenuItem("Eliminar un Estudiante");
//        childEliminarUno.setAccelerator(KeyCombination.keyCombination("Delete"));
//        MenuItem childEliminarTodos = new MenuItem("Eliminar todos los Estudiantes");
//        childEliminarTodos.setAccelerator(KeyCombination.keyCombination("Shift+Delete"));
//        MenuEliminar.getItems().addAll(childEliminarUno, childEliminarTodos);
//
//        Buscar.setOnAction(new EventHandler() {///// Funcion de la opcion de Busqueda
//            @Override
//            public void handle(Event t) {
//
//            }
//        });
//
//        Actualizar.setOnAction(new EventHandler() {///// Funcion de la opcion de Actualizacion
//            @Override
//            public void handle(Event t) {
//
//            }
//        });
//
//        Mostrar.setOnAction(new EventHandler() {///// Funcion de la opcion de Mostrar
//
//            @Override
//            public void handle(Event t) {
//                ProgramaPrincipal.MostrarVentanaSecundaria();
//            }
//        });
//
//        Nuevo.setOnAction(new EventHandler() {///// Funcion de la opcion de Agregar Nuevo
//            @Override
//            public void handle(Event t) {
//                TreeItem NuevoEstudiante
//                        = new TreeItem<String>("Nuevo");        //hacer que se cree nuevo archivo Json (o carpeta con archivo)
//                getTreeItem().getChildren().add(NuevoEstudiante);
//            }
//        });
//
//        MenuItem BORRADOR = new MenuItem("Remove");
//        childEliminarUno.setOnAction(new EventHandler() {///// Funcion de la opcion de Eliminar Uno Solo
//            @Override
//            public void handle(Event t) {
//                TreeItem c = getTreeItem();
//                boolean remove = c.getParent().getChildren().remove(c);
//            }
//        });
//
//        childEliminarUno.setOnAction(new EventHandler() {///// Funcion de la opcion de Eliminar Uno Solo
//            @Override
//            public void handle(Event t) {
//                TreeItem<String> selected = getTreeItem();
//                selected.getParent().getChildren().remove(selected);        ////agregar que borre carpeta de verdad
//            }
//        });
//
//        childEliminarTodos.setOnAction(new EventHandler() {///// Funcion de la opcion de Eliminar Todos
//            @Override
//            public void handle(Event t) {
//                TreeItem<String> selected = getTreeItem();
//                selected.getParent().getChildren().remove(selected);
//            }
//        });
//
//        contextMenu.getItems().addAll(Buscar, Actualizar, separador1,
//                Mostrar, Nuevo, separador2, MenuEliminar);
//    }
//
//    /////////////////////// Menu de opciones en cada nodo //////////////////////
//    @Override
//    public void updateItem(String item, boolean empty) {
//        super.updateItem(item, empty);
//
//        if (empty) {
//            setText(null);
//            setGraphic(null);
//        } else {
//            if (isEditing()) {
//                if (textField != null) {
//                    textField.setText(getString());
//                }
//                setText(null);
//                setGraphic(textField);
//            } else {
//                setText(getString());
//                setGraphic(getTreeItem().getGraphic());
//                if (!getTreeItem().isLeaf() && getTreeItem().getParent() != null) {
//                    setContextMenu(contextMenu);
//                }
//            }
//            if (!empty && getTreeItem().getParent() == null) {
//                setContextMenu(contextMenu);
//            }
//
//        }
//    }
/////////////////////////////Con este otro solo da opiones al NODO PRINCIPAL pero deja usar lo blinds /////////////////
///*    @Override
//    public void updateItem(String item, boolean empty) {
//        super.updateItem(item, empty);
//
//        // if the item is not empty and is a root...
//        if (!empty && getTreeItem().getParent() == null) {
//            setContextMenu(contextMenu);
//        }
//
//        if (empty) {
//            setText(null);
//            setGraphic(null);
//        } else {
//            if (isEditing()) {
//                if (textField != null) {
//                    textField.setText(getString());
//                }
//                setText(null);
//                setGraphic(textField);
//            } else {
//                setText(getString());
//                setGraphic(getTreeItem().getGraphic());
//            }
//        }
//    }
//     */
//    @Override
//    public void startEdit() {
//        super.startEdit();
//
//        if (textField == null) {
//            createTextField();
//        }
//        setText(null);
//        setGraphic(textField);
//        textField.selectAll();
//    }
//
//    @Override
//    public void cancelEdit() {
//        super.cancelEdit();
//        setText((String) getItem());
//        setGraphic(getTreeItem().getGraphic());
//    }
//
//    private void createTextField() {
//        textField = new TextField(getString());
//        textField.setOnKeyReleased(new EventHandler<KeyEvent>() {
//
//            @Override
//            public void handle(KeyEvent t) {
//                if (t.getCode() == KeyCode.ENTER) {
//                    commitEdit(textField.getText());
//                } else if (t.getCode() == KeyCode.ESCAPE) {
//                    cancelEdit();
//                }
//            }
//        });
//    }
//
//    private String getString() {
//        return getItem() == null ? "" : getItem().toString();
//    }
//}
