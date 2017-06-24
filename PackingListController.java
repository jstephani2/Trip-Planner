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

    @FXML public Button addButton;
    @FXML public TextField inputTextField;

    private ArrayList<String> itemArrayList = new ArrayList<>();
    private int numOfLayers = 0;

    //TODO list of labels, when hit delete convert to buttons, if button is hit it is deleted from list of labels, and the list is reupdated.
    ///TODO circular buttons when delete hit?
    //TODO make joptionpane new item into its own window so can style the window instead of looking horrible.


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        pane.setStyle("-fx-background-color: #848484");
        //HBox hBox = new HBox();
        addButton = new Button(" + ");
        //hBox.getChildren().add(addButton);
        vBox.getChildren().add(addButton);
        addButtonListener();
    }

    //https://stackoverflow.com/questions/26811445/how-to-access-a-child-of-an-object-in-javafx

    public void addButtonListener() {
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Node nodeOut = vBox.getChildren().get(numOfLayers);
                vBox.getChildren().remove(numOfLayers);
                inputTextField = new TextField();
                inputTextField.setPrefWidth(400);
                vBox.getChildren().add(numOfLayers,inputTextField);
                inputTextFieldListener();
            }
        });
    }

    public void inputTextFieldListener() {
        inputTextField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Has to go in hbox so i can delete and have label on same layer.
                HBox hBox = new HBox();
                Label itemLabel = new Label("- " + inputTextField.getText());
                itemLabel.setFont(new Font(30));
                Button deleteButton = new Button(" X ");
                deleteButton.setAlignment(Pos.CENTER_RIGHT);
                hBox.getChildren().addAll(itemLabel,deleteButton);
                vBox.getChildren().remove(numOfLayers);
                vBox.getChildren().add(numOfLayers,hBox);
            }
        });
    }

    //TODO create new addButton and layer, then modify numOfLayers respectively .

    //TODO There has to be a better way to do this. Maybe just a textfield, on enter add to list and update. then clear the textfield text.???
    //TODO Don't clear the vbox everytime, just add onto it. That way you can delete using index from selected to delete and vbox.getChildren.remove(index);
    private void updateVBox() {

        /*
        int size = itemArrayList.size();
        vBox.getChildren().clear();
        for(int i = 0; i < size; i++) {
            Label tempLabel = new Label("- " + itemArrayList.get(i));
            Font font = new Font(tempLabel.getFont().getSize() * 1.5);
            tempLabel.setFont(font);
            vBox.getChildren().add(tempLabel);
        }
        String text = JOptionPane.showInputDialog(null, "New Item: ");
        if(text == null || text.replaceAll("\\s+","").equals("")) {
            return;
        }
        //Label tempLabel = new Label("- " + text);
        itemArrayList.add(text);
        pane.toFront();
        updateVBox();
        */
    }
}