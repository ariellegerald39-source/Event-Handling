import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.geometry.Pos;


public class CalcPane extends BorderPane {
    private GridPane buttonPane;
    private HBox functionPane;
    private TextField textDisplay;
    private Button btnSquareRoot;
    private Button btnSquare;
    private Button btnClear;


    public CalcPane() {
        // TextField at the top
        textDisplay = new TextField();
        textDisplay.setEditable(false);
        setTop(textDisplay);


        // GridPane in the center
        buttonPane = new GridPane();
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.setHgap(10);
        buttonPane.setVgap(10);


        // Instantiate event handler inner class
        CircleButtonHandler handler = new CircleButtonHandler();


        // Nested for-loops to create numbers 1 through 9
        int count = 1;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                CircleButton btn = new CircleButton(String.valueOf(count));
                btn.setPrefSize(100, 100);


                // Register mouse press and release events
                btn.setOnMousePressed(handler);
                btn.setOnMouseReleased(handler);


                buttonPane.add(btn, col, row);
                count++;
            }
        }
        setCenter(buttonPane);


        // Bottom function buttons
        btnSquare = new Button("x^2");
        btnSquareRoot = new Button("sqrt");
        btnClear = new Button("Clear");


        btnSquare.setMinWidth(75);
        btnSquareRoot.setMinWidth(75);
        btnClear.setMinWidth(75);


        // Lambda expressions for command buttons
        btnSquare.setOnAction(e -> {
            if (!textDisplay.getText().isEmpty()) {
                double val = Double.parseDouble(textDisplay.getText());
                textDisplay.setText(Math.pow(val, 2) + "");
            }
        });


        btnSquareRoot.setOnAction(e -> {
            if (!textDisplay.getText().isEmpty()) {
                double val = Double.parseDouble(textDisplay.getText());
                textDisplay.setText(Math.sqrt(val) + "");
            }
        });


        btnClear.setOnAction(e -> {
            textDisplay.setText("");
        });


        // HBox at the bottom
        functionPane = new HBox(10);
        functionPane.setAlignment(Pos.CENTER);
        functionPane.getChildren().addAll(btnSquare, btnSquareRoot, btnClear);
        setBottom(functionPane);
    }


    // Inner class implementing EventHandler for mouse events
    private class CircleButtonHandler implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent event) {
            CircleButton btn = (CircleButton) event.getSource();


            // Toggle color on press and append text; return to white on release
            if (btn.getColor().equals(Color.WHITE)) {
                btn.setColor(Color.YELLOW);
                textDisplay.setText(textDisplay.getText() + btn.getValue());
            } else {
                btn.setColor(Color.WHITE);
            }
        }
    }
}
