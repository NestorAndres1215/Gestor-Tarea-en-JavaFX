package tareafx;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane; 
import javafx.scene.layout.Priority; 
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class TareaFx extends Application {

    private ObservableList<Tarea> taskList = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {

        ListView<Tarea> taskListView = new ListView<>(taskList);
        TextField taskField = new TextField();
        Button addButton = new Button("Agregar tarea");
        Button removeButton = new Button("Eliminar tarea");
        Button completeButton = new Button("Completar tarea");

        // Acción para agregar una tarea
        addButton.setOnAction((ActionEvent e) -> {
            String taskName = taskField.getText();
            if (!taskName.isEmpty()) {
                taskList.add(new Tarea(taskName));  // Usamos el texto ingresado
                taskField.clear();  // Limpiamos el campo de texto después de agregar la tarea
            }
        });

        // Acción para eliminar la tarea seleccionada
        removeButton.setOnAction(e -> {
            Tarea selectedTask = taskListView.getSelectionModel().getSelectedItem();
            if (selectedTask != null) {
                taskList.remove(selectedTask);
            }
        });

        // Acción para completar la tarea seleccionada
        completeButton.setOnAction((ActionEvent e) -> {
            Tarea selectedTask = taskListView.getSelectionModel().getSelectedItem();
            if (selectedTask != null) {
                selectedTask.setCompleto(!selectedTask.isCompleto());
                taskListView.refresh();  // Refrescar la vista para mostrar los cambios
            }
        });
       // Estilos directos
        addButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px; -fx-background-radius: 5;");
        removeButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px; -fx-background-radius: 5;");
        completeButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-size: 14px; -fx-padding: 10px; -fx-background-radius: 5;");
   // Crear título
        Label titleLabel = new Label("Gestor de Tareas");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;"); // Estilo del título

        // Disposición de los elementos
        GridPane buttonGrid = new GridPane();
        buttonGrid.setHgap(10); // Espacio horizontal entre botones
        buttonGrid.setVgap(10); // Espacio vertical entre botones
        buttonGrid.setAlignment(Pos.CENTER); // Centra todos los botones

        // Agregar botones al GridPane
        buttonGrid.add(addButton, 0, 0); // Fila 0, Columna 0
        buttonGrid.add(completeButton, 1, 0); // Fila 0, Columna 1
        buttonGrid.add(removeButton, 0, 1); // Fila 1, Columna 0

        VBox layout = new VBox(10); // Espaciado de 10 entre elementos
        layout.setAlignment(Pos.CENTER); // Centra todos los elementos
        layout.getChildren().addAll(titleLabel, taskListView, taskField, buttonGrid, new Region()); // Agrega un espaciador

        // Configura el espaciador para que crezca y empuje el botón hacia arriba
        VBox.setVgrow(new Region(), Priority.ALWAYS); // Permite que el espaciador crezca

        Scene scene = new Scene(layout, 300, 400);

        primaryStage.setTitle("Gestor de Tareas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

