import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
//from w w  w. j a  v  a 2 s.  c om
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FlowPane example");

        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(10, 10, 10, 10));
        flowPane.setVgap(4);
        flowPane.setHgap(4);
        flowPane.setPrefWrapLength(420);

        Button btn = new Button();

        for (int i = 0; i < 8; i++) {

            btn = new Button("Button");
            btn.setPrefSize(100, 50);
            flowPane.getChildren().add(btn);

        }
        for (int j = 0; j < 8; j ++){
            Label label = new Label("Domino");
            label.setPrefSize(100,100);
            flowPane.getChildren().add(label);
        }

        Scene scene = new Scene(flowPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}