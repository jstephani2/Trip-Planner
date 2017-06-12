/**
 * Created by bengi on 6/8/2017.
 */

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Controller for the New Trip Window
 *
 * @author bengi
 */
public class NewTripController implements Initializable {

    //FXML import
    public VBox vBox;
    public TextField startTextField;

    @FXML private TextField embedTextField;

    private ArrayList<Destination> destinationArrayList = new ArrayList<>();
    private int numOfStops = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle bundle) {

    }

    public void startTextField(ActionEvent event) {
        String temp = startTextField.getText();
        generateNew();
        numOfStops++;
        textBoxWaiter();
    }

    private void textBoxWaiter() {
        embedTextField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               vBox.getChildren().remove(numOfStops);
               HBox hBox = new HBox();
               hBox.setPrefWidth(400);
               hBox.setPrefHeight(40);
               Label label = new Label("Stop #1: " + embedTextField.getText());
               embedTextField = new TextField();
               hBox.getChildren().addAll(label, embedTextField);
               hBox.setAlignment(Pos.CENTER_LEFT);
               vBox.getChildren().add(hBox);
            }
        });
    }

    private void generateNew() {
        HBox hBox = new HBox();
        hBox.setPrefHeight(40);
        hBox.setPrefWidth(400);
        Label label = new Label("Add Stop: ");
        embedTextField = new TextField();
        hBox.getChildren().addAll(label, embedTextField);
        hBox.setAlignment(Pos.CENTER_LEFT);
        vBox.getChildren().add(hBox);
    }

    //HBox with label and TextBox inside.

}