/**
 * Created by BeauKujath on 24/08/2017.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Domino_GUI extends Application implements EventHandler<ActionEvent> {
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 500;
    private static final int FONT_SIZE = 12;

    private Label titleLable = new Label("Domino FX");

    public void start(Stage stage) throws Exception {
        titleLable.setFont(Font.font("Verdana", FONT_SIZE));

        Circle c = new Circle();
        c.setRadius(10);

        Rectangle r = new Rectangle();
        r.setX(100);
        r.setY(100);
        r.setWidth(50);
        r.setHeight(100);
        r.setArcWidth(20);
        r.setArcHeight(10);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(titleLable, r);


        /*
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        */



        Scene scene = new Scene(vbox, WINDOW_WIDTH, WINDOW_HEIGHT);

        stage.setScene(scene);
        stage.show();
    }

    public void handle(ActionEvent var1) {
        System.out.println(var1);
    }



    public static void main(String[] args)
    {
        launch(args);
    }


}