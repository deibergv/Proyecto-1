package GUI;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage stagePrincipal;
    private AnchorPane rootPane;

    public void CreadorDeVentanas(String NombreDeVentana) {

        if ("VentanaPrincipal".equals(NombreDeVentana)) {
            try {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("VentanaPrincipal.fxml"));
                rootPane = (AnchorPane) loader.load();
                Scene scene = new Scene(rootPane);
                stagePrincipal.setResizable(false);
                stagePrincipal.setScene(scene);
                stagePrincipal.setTitle("Sistema Estudiantil");
                ControladorVentanaPrincipal controller = loader.getController();
                controller.setProgramaPrincipal(this);
                stagePrincipal.setTitle("Busqueda");
                stagePrincipal.show();
            } catch (IOException ex) {
                System.out.println(ex.toString());
                System.out.println("Error con la Ventana");
            }
        } else {
            String Ventana = NombreDeVentana;
            try {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource(Ventana + ".fxml"));
                AnchorPane ventanaDos = (AnchorPane) loader.load();
                Stage ventana = new Stage();
                ventana.setResizable(false);
                ventana.initModality(Modality.WINDOW_MODAL);
                ventana.initOwner(stagePrincipal);
                Scene scene = new Scene(ventanaDos);
                ventana.setScene(scene);
                if ("VentanaBusqueda".equals(NombreDeVentana)) {
                    ventana.setTitle("Busqueda");
                    ControladorVentanaBusqueda controller = loader.getController();
                    controller.setStagePrincipal(ventana);
                } else if ("VentanaActualizacion".equals(NombreDeVentana)) {
                    ventana.setTitle("Actualizacion");
                    ControladorVentanaActualizacion controller = loader.getController();
                    controller.setStagePrincipal(ventana);
                } else if ("VentanaNuevoCurso".equals(NombreDeVentana)) {
                    ventana.setTitle("Nuevo Curso");
                    ControladorVentanaNuevoCurso controller = loader.getController();        ///// cambiar titulos
                    controller.setStagePrincipal(ventana);
                } else if ("VentanaNuevoEstudiante".equals(NombreDeVentana)) {
                    ventana.setTitle("Nuevo Estudiante");
                    ControladorVentanaNuevoEstudiante controller = loader.getController();
                    controller.setStagePrincipal(ventana);
                }
                ventana.show();
            } catch (IOException ex) {
                System.out.println(ex.toString());
                System.out.println("Error en Ventana");
            }
        }
    }

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        this.stagePrincipal = stagePrincipal;
        CreadorDeVentanas("VentanaPrincipal");
    }

    public static void main(String[] args) {
        System.out.println("Antes del launch");                             /////////////// BORRAR LUEGO///////
        launch(args);
    }

}

//    public void MostrarVentanaPrincipal() {
//        try {
//            FXMLLoader loader = new FXMLLoader(Main.class.getResource("VentanaPrincipal.fxml"));
//            rootPane = (AnchorPane) loader.load();
//            Scene scene = new Scene(rootPane);
//            stagePrincipal.setTitle("Sistema Estudiantil");
//            stagePrincipal.setResizable(false);
//            stagePrincipal.setScene(scene);
//            ControladorVentanaPrincipal controller = loader.getController();
//            controller.setProgramaPrincipal(this);
//            stagePrincipal.show();
//        } catch (IOException ex) {
//            System.out.println(ex.toString());
//            System.out.println("Error con la Ventana");
//        }
//    }
//
//    public void MostrarVentanaBusqueda() {
//        try {
//            FXMLLoader loader = new FXMLLoader(Main.class.getResource("VentanaBusqueda.fxml"));
//            AnchorPane ventanaDos = (AnchorPane) loader.load();
//            Stage ventana = new Stage();
//            ventana.setTitle("Busqueda");
//            ventana.setResizable(false);
//            ventana.initModality(Modality.WINDOW_MODAL);
//            ventana.initOwner(stagePrincipal);
//            Scene scene = new Scene(ventanaDos);
//            ventana.setScene(scene);
//            ControladorVentanaBusqueda controller = loader.getController();
//            controller.setStagePrincipal(ventana);
//            ventana.show();
//        } catch (IOException ex) {
//            System.out.println(ex.toString());
//            System.out.println("Error en Ventana");
//        }
//    }
//
//    public void MostrarVentanaActualizacion() {
//        try {
//            FXMLLoader loader = new FXMLLoader(Main.class.getResource("VentanaActualizacion.fxml"));
//            AnchorPane ventanaDos = (AnchorPane) loader.load();
//            Stage ventana = new Stage();
//            ventana.setTitle("Actualizacion");
//            ventana.setResizable(false);
//            ventana.initModality(Modality.WINDOW_MODAL);
//            ventana.initOwner(stagePrincipal);
//            Scene scene = new Scene(ventanaDos);
//            ventana.setScene(scene);
//            ControladorVentanaActualizacion controller = loader.getController();
//            controller.setStagePrincipal(ventana);
//            ventana.show();
//        } catch (IOException ex) {
//            System.out.println(ex.toString());
//            System.out.println("Error en Ventana");
//        }
//    }
//
//    public void MostrarVentanaNuevoCurso() {
//        try {
//            FXMLLoader loader = new FXMLLoader(Main.class.getResource("VentanaNuevoCurso.fxml"));
//            AnchorPane ventanaDos = (AnchorPane) loader.load();
//            Stage ventana = new Stage();
//            ventana.setTitle("Nuevo Curso");
//            ventana.setResizable(false);
//            ventana.initModality(Modality.WINDOW_MODAL);
//            ventana.initOwner(stagePrincipal);
//            Scene scene = new Scene(ventanaDos);
//            ventana.setScene(scene);
//            ControladorVentanaNuevoCurso controller = loader.getController();
//            controller.setStagePrincipal(ventana);
//            ventana.show();
//        } catch (IOException ex) {
//            System.out.println(ex.toString());
//            System.out.println("Error en Ventana");
//        }
//    }
//
//    public void MostrarVentanaNuevoEstudiante() {
//        try {
//            FXMLLoader loader = new FXMLLoader(Main.class.getResource("VentanaNuevoEstudiante.fxml"));
//            AnchorPane ventanaDos = (AnchorPane) loader.load();
//            Stage ventana = new Stage();
//            ventana.setTitle("Nuevo Estudiante");
//            ventana.setResizable(false);
//            ventana.initModality(Modality.WINDOW_MODAL);
//            ventana.initOwner(stagePrincipal);
//            Scene scene = new Scene(ventanaDos);
//            ventana.setScene(scene);
//            ControladorVentanaNuevoEstudiante controller = loader.getController();
//            controller.setStagePrincipal(ventana);
//            ventana.show();
//        } catch (IOException ex) {
//            System.out.println(ex.toString());
//            System.out.println("Error en Ventana");
//        }
//    }
//    @Override
//    public void start(Stage stagePrincipal) throws Exception {
//        this.stagePrincipal = stagePrincipal;
//        MostrarVentanaPrincipal();
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Antes del launch");                             /////////////// BORRAR LUEGO///////
//        launch(args);
//    }
//
//}
