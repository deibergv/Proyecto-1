package GUI;

//import static GUI.ControladorVentanaPrincipal.BCommit;
//import static GUI.ControladorVentanaPrincipal.list;
//import static GUI.ControladorVentanaPrincipal.table;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.input.KeyCombination;
import javax.swing.JOptionPane;
import static GUI.CreadorDeVentanas.CreadorDeVentanas;

/**
 * Menu de Opciones del arbol
 *
 * @author deiber
 */
public class OpcionesClickDerecho {

    public static class Opciones extends TextFieldTreeCell<String> {

        private final ContextMenu contextMenu = new ContextMenu();

        public static TreeItem<String> NodoPrincipal;
        public static TreeItem<String> NodoSeleccionado;
        MenuItem Buscar;
        MenuItem Actualizar;
        MenuItem Mostrar;
        SeparatorMenuItem separador1;
        Menu MenuNuevo;
        MenuItem childNuevoStore;
        MenuItem childNuevoJson;
        Menu MenuEliminar;
        MenuItem childEliminarSeleccionado;
        MenuItem childEliminarTodos;

        /**
         * Metodo encargado de dar un menu de opciones al arbol
         */
        public Opciones(TreeItem<String> NodoPrincipal) {

            this.NodoPrincipal = NodoPrincipal;

            Buscar = new MenuItem("Buscar");
            Actualizar = new MenuItem("Actualizar Jsons");
            Mostrar = new MenuItem("Mostrar todos los Jsons");
            separador1 = new SeparatorMenuItem();
            MenuNuevo = new Menu("Nuevo");
            childNuevoStore = new MenuItem("Nuevo Store");
            childNuevoJson = new MenuItem("Nuevo Json");
            MenuEliminar = new Menu("Eliminar");
            childEliminarSeleccionado = new MenuItem("Eliminar Store o Json seleccionado");
            childEliminarTodos = new MenuItem("Eliminar todos los Archivos");

            MenuNuevo.getItems().addAll(childNuevoStore, childNuevoJson);
            MenuEliminar.getItems().addAll(childEliminarSeleccionado, childEliminarTodos);

            Buscar.setAccelerator(KeyCombination.keyCombination("Ctrl+I"));
            Actualizar.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
            Mostrar.setAccelerator(KeyCombination.keyCombination("Ctrl+M"));
//        Nuevo.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
            //childEliminarUno.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
            //childEliminarTodos.setAccelerator(KeyCombination.keyCombination("Ctrl+Shift+N"));
            //childEliminarUno.setAccelerator(KeyCombination.keyCombination("Delete"));
            //childEliminarTodos.setAccelerator(KeyCombination.keyCombination("Shift+Delete")); 

            contextMenu.getItems().addAll(Buscar, Actualizar, Mostrar, separador1, MenuNuevo, MenuEliminar);
        }

/////////////////////// Menu de opciones en cada nodo //////////////////////////
        /**
         * Metodo encargado de dar un menu de opciones al arbol en cada nodo
         *
         * @param item
         * @param empty
         */
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setGraphic(null);
            } else if (!empty && getTreeItem().getParent() == null) {
                Buscar.setOnAction(new EventHandler() {
                    @Override
                    public void handle(Event t) {
                        CreadorDeVentanas("VentanaBusqueda");
                    }
                });
                Actualizar.setOnAction(new EventHandler() {///// Funcion de la opcion de Actualizacion
                    @Override
                    public void handle(Event t) {
//                        CreadorDeVentanas("VentanaActualizacion");
                        //BCommit.setDisable(false);                               ////Activacion de Commit
                    }
                });

                Mostrar.setOnAction(new EventHandler() {///// Funcion de la opcion de Mostrar
                    @Override
                    public void handle(Event t) {
//                        table.setItems(list);
                    }
                });
                childNuevoStore.setOnAction(new EventHandler() {///// Funcion de la opcion de Agregar Nuevo Store
                    @Override
                    public void handle(Event t) {
                        CreadorDeVentanas("VentanaNuevoStore");
//                            TreeItem NuevoStore = new TreeItem<String>("Nuevo Store");        //hacer que se cree nuevo archivo Json (o carpeta con archivo)
//                            NodoPrincipal.getChildren().add(NuevoStore);
//                            Commit.EscrituraCommit("Json.Crear.Store()");
//                            Commit.EscrituraParametro("TEST");//                  ademas ligarlo a lista
                        //BCommit.setDisable(false);                          ////Activacion de Commit
                    }
                });
                childNuevoJson.setOnAction(new EventHandler() {///// Funcion de la opcion de Agregar Nuevo Objeto
                    @Override
                    public void handle(Event t) {
                        TreeItem<String> NuevoStore = new TreeItem<String>("NuevoJson");
                        NodoPrincipal.getChildren().add(NuevoStore);
                        CreadorDeVentanas("VentanaNuevoJson");            ///// lectura de entry para nombre de nuevo documento
//                            TreeItem NuevoJson = new TreeItem<String>("Nuevo Json");        //hacer que se cree nuevo archivo Json (o carpeta con archivo)
//                            hacer que lea ENTRY para saber titulo y archivo a agregar, ademas de la info
//                            getTreeItem().getChildren().add(NuevoJson);
//                            Commit.EscrituraCommit("Json.Crear.Archivo()");
//                            Commit.EscrituraParametro("TEST");
                        //BCommit.setDisable(false);                               ////Activacion de Commit
                    }
                });
                childEliminarSeleccionado.setOnAction(new EventHandler() {
                    @Override
                    public void handle(Event t) {                   ////falta agregar que borre carpeta de verdad
                        if (getTreeItem() == NodoPrincipal) {
                            JOptionPane.showMessageDialog(null, "El Sistema Base no puede ser eliminado", "Error", JOptionPane.WARNING_MESSAGE);
                        } else {
                            getTreeItem().getParent().getChildren().remove(getTreeItem());
                            Commit.EscrituraCommit("Json.Eliminar.Archivo()");
                            Commit.EscrituraParametro(getTreeItem().getValue());
                            //BCommit.setDisable(false);                               ////Activacion de Commit
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
                            //BCommit.setDisable(false);                          ////Activacion de Commit
                        }
                    }
                });
                setContextMenu(contextMenu);
            } else if (getTreeItem().getParent() == NodoPrincipal) {  ///////// Acciones de Nodos Hijo
                Buscar.setOnAction(new EventHandler() {
                    @Override
                    public void handle(Event t) {
                        CreadorDeVentanas("VentanaBusqueda");
                    }
                });
                Actualizar.setOnAction(new EventHandler() {///// Funcion de la opcion de Actualizacion
                    @Override
                    public void handle(Event t) {
//                        CreadorDeVentanas("VentanaActualizacion");
                        //BCommit.setDisable(false);                               ////Activacion de Commit
                    }
                });

                Mostrar.setOnAction(new EventHandler() {///// Funcion de la opcion de Mostrar
                    @Override
                    public void handle(Event t) {
//                        table.setItems(list);
                    }
                });
                childNuevoStore.setOnAction(new EventHandler() {///// Funcion de la opcion de Agregar Nuevo Store
                    @Override
                    public void handle(Event t) {
                        CreadorDeVentanas("VentanaNuevoStore");
//                            TreeItem NuevoStore = new TreeItem<String>("Nuevo Store");        //hacer que se cree nuevo archivo Json (o carpeta con archivo)
//                            NodoPrincipal.getChildren().add(NuevoStore);
//                            Commit.EscrituraCommit("Json.Crear.Store()");
//                            Commit.EscrituraParametro("TEST");//                  ademas ligarlo a lista
                        //BCommit.setDisable(false);                          ////Activacion de Commit
                    }
                });
                childNuevoJson.setOnAction(new EventHandler() {///// Funcion de la opcion de Agregar Nuevo Objeto
                    @Override
                    public void handle(Event t) {
                        TreeItem<String> NuevoStore = new TreeItem<String>("NuevoJson");
                        NodoPrincipal.getChildren().add(NuevoStore);
                        CreadorDeVentanas("VentanaNuevoJson");            ///// lectura de entry para nombre de nuevo documento
//                            TreeItem NuevoJson = new TreeItem<String>("Nuevo Json");        //hacer que se cree nuevo archivo Json (o carpeta con archivo)
//                            hacer que lea ENTRY para saber titulo y archivo a agregar, ademas de la info
//                            getTreeItem().getChildren().add(NuevoJson);
//                            Commit.EscrituraCommit("Json.Crear.Archivo()");
//                            Commit.EscrituraParametro("TEST");
                        //BCommit.setDisable(false);                               ////Activacion de Commit
                    }
                });
                childEliminarSeleccionado.setOnAction(new EventHandler() {
                    @Override
                    public void handle(Event t) {                   ////falta agregar que borre carpeta de verdad
                        if (getTreeItem() == NodoPrincipal) {
                            JOptionPane.showMessageDialog(null, "El Sistema Base no puede ser eliminado", "Error", JOptionPane.WARNING_MESSAGE);
                        } else {
                            getTreeItem().getParent().getChildren().remove(getTreeItem());
                            Commit.EscrituraCommit("Json.Eliminar.Archivo()");
                            Commit.EscrituraParametro(getTreeItem().getValue());
                            //BCommit.setDisable(false);                               ////Activacion de Commit
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
                            //BCommit.setDisable(false);                          ////Activacion de Commit
                        }
                    }
                });
                setContextMenu(contextMenu);
            } else if (getTreeItem().isLeaf() && getTreeItem().getParent().getParent() != null) {       ///// Opciones de hijos hijos ////
                Buscar.setOnAction(new EventHandler() {
                    @Override
                    public void handle(Event t) {
//                        CreadorDeVentanas("VentanaBusqueda");
                    }
                });
                Actualizar.setOnAction(new EventHandler() {///// Funcion de la opcion de Actualizacion
                    @Override
                    public void handle(Event t) {
//                        CreadorDeVentanas("VentanaActualizacion");
                        //BCommit.setDisable(false);                               ////Activacion de Commit
                    }
                });
                Mostrar.setOnAction(new EventHandler() {///// Funcion de la opcion de Mostrar
                    @Override
                    public void handle(Event t) {
                        //table.setItems(list);
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
                            //BCommit.setDisable(false);                               ////Activacion de Commit
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
                            //BCommit.setDisable(false);                          ////Activacion de Commit
                        }
                    }
                });
                setContextMenu(contextMenu);
            } else {
                return;
            }
        }
    }
}
