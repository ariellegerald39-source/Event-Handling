import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class CircleButton extends StackPane {
    private Label lblValue;
    private Circle circle;


    // No-arg constructor
    public CircleButton() {
        this("");
    }


    // Constructor with String parameter
    public CircleButton(String val) {
        lblValue = new Label(val);
        circle = new Circle(45); // 45 pixel radius


        // Default styling: white fill, black outline
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);


        setPrefSize(100, 100);


        // Add both objects to the StackPane
        getChildren().addAll(circle, lblValue);
    }


    public void setColor(Color color) {
        circle.setFill(color);
    }


    public Color getColor() {
        return (Color) circle.getFill();
    }


    public String getValue() {
        return lblValue.getText();
    }
}
