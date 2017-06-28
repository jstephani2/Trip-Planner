/**
 * Created by bengi on 6/8/2017.
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import javax.swing.*;

/**
 * Controller for side Window Packing List
 *
 * @author bengi
 */
public class PackingListController implements Initializable {

    //load and save all items?

    public VBox vBox;
    public Pane pane;
    public TextField inputTextField;

    private ArrayList<String> itemArrayList = new ArrayList<>();


    //TODO list of labels, when hit delete convert to buttons, if button is hit it is deleted from list of labels, and the list is reupdated.
    //TODO circular buttons when delete hit?
    //TODO make joptionpane new item into its own window so can style the window instead of looking horrible.


    //TODO make it basic have textfield then when enter just adds the thing, done button. can add additional functionality later.

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        pane.setStyle("-fx-background-color: #848484");
    }

    public void inputTextField(ActionEvent event) {
        String item = inputTextField.getText();
        itemArrayList.add(item);
        labelGeneration(item);
        inputTextFieldWaiter();
    }

    public void inputTextFieldWaiter() {
        inputTextField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                labelGeneration(inputTextField.getText());
                inputTextFieldWaiter();
            }
        });
    }

    private void labelGeneration(String item) {
        itemArrayList.add(item);
        Label label = new Label("- " + item);
        label.setFont(new Font(50));
        vBox.getChildren().remove(inputTextField);
        vBox.getChildren().add(label);
        inputTextField = new TextField();
        vBox.getChildren().add(inputTextField);
    }


    //https://stackoverflow.com/questions/26811445/how-to-access-a-child-of-an-object-in-javafx



    //TODO create new addButton and layer, then modify numOfLayers respectively .

    //TODO There has to be a better way to do this. Maybe just a textfield, on enter add to list and update. then clear the textfield text.???
    //TODO Don't clear the vbox everytime, just add onto it. That way you can delete using index from selected to delete and vbox.getChildren.remove(index);

}