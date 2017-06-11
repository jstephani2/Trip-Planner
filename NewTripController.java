/**
 * Created by bengi on 6/8/2017.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * Controller for the New Trip Window
 *
 * @author bengi
 */
public class NewTripController implements Initializable {

    /*
     * Get start layout y , when adding under it add the stop 20 under the start y, move the add stop down 20.
     * and resize pane by 20. limit pane max size.
     *
     */

    private int numOfStops = 1;

    //FXML import
    public TextField startTextField;
    public TextField addStopTextField;
    public TextField endTextField;
    public Pane pane;
    public Label startLabel;
    public Label addStopLabel;
    public Label endLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle bundle) {

    }

    //create new stop


    public void addStopTextField(ActionEvent event) {
        //pane resize
        double sizeBeforeResize = pane.getHeight();
        pane.setPrefHeight(sizeBeforeResize + 20);
        //stop generation
        Label label = new Label("Stop:");
        label.setLayoutX(startLabel.getLayoutX());
        label.setLayoutY(startLabel.getLayoutY() + 20 * numOfStops);
        label.setText("Stop:");
        TextField textField = new TextField();
        textField.setLayoutX(startTextField.getLayoutX() - 5);
        textField.setLayoutY(startTextField.getLayoutY() + 20);
        textField.setText(addStopTextField.getText());
        //move addstop and end
        addStopLabel.setLayoutY(addStopLabel.getLayoutY() + 20);
        addStopTextField.setLayoutY(addStopTextField.getLayoutY() + 20);
        endLabel.setLayoutY(endLabel.getLayoutY() + 20);
        endTextField.setLayoutY(endTextField.getLayoutY() + 20);
        //update
        numOfStops++;
        //if entered, then pane size y + 20, addstop and end moved down 20.
    }

    public void endTextField(ActionEvent event) {

    }
}