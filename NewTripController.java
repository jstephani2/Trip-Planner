/**
 * Created by bengi on 6/8/2017.
 */

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML private Button doneButton;

    private ArrayList<Destination> destinationArrayList = new ArrayList<>();
    private int numOfStops = 0;

    //TODO Create button on bottom? done? textfields are already editable. could create temp doc of locations
    //TODO stylesheet

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle bundle) {

    }

    private void doneButtonWaiter() {
        doneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO create Trip, then access and update the front.
                //update to the global trip
                TripPlannerController.newTrip = new Trip("tempTrip", destinationArrayList);
                TripPlannerController.destinationArrayList = destinationArrayList;
                Platform.exit();
            }
        });
    }

    public void startTextField(ActionEvent event) {
        String temp = startTextField.getText();
        generateNew();
        textBoxWaiter();
    }

    private void textBoxWaiter() {
        embedTextField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO Destination declaration and add to the arraylist for later access.
                String temp = embedTextField.getText();
               vBox.getChildren().remove(numOfStops);
               vBox.getChildren().remove(numOfStops);
               HBox hBox = new HBox();
               hBox.setPrefWidth(400);
               hBox.setPrefHeight(40);
               Label label = new Label("Stop #" + numOfStops + ": ");
               TextField localTextField = new TextField();
               localTextField.setText(temp);
               hBox.getChildren().addAll(label, localTextField);
               hBox.setAlignment(Pos.CENTER_LEFT);
               vBox.getChildren().add(hBox);
               generateNew();
               doneButtonWaiter();
               textBoxWaiter();
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
        doneButton = new Button("Done");
        vBox.getChildren().addAll(hBox,doneButton);
        numOfStops++;
    }

}