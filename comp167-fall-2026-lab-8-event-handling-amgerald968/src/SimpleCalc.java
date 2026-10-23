import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SimpleCalc extends Application {


    @Override
    public void start(Stage primaryStage) {
        CalcPane calcPane = new CalcPane();
        Scene scene = new Scene(calcPane, 350, 420);


        primaryStage.setTitle("JavaFX Calculator Lab");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
