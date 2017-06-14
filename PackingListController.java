/**
 * Created by bengi on 6/8/2017.
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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


    public Button newButton;
    public Button deleteButton;
    public Button undoButton;
    public Button redoButton;
    public VBox vBox;
    public Pane pane;

    private ArrayList<String> itemArrayList = new ArrayList<>();

    //TODO list of labels, when hit delete convert to buttons, if button is hit it is deleted from list of labels, and the list is reupdated.
    ///TODO circular buttons when delete hit?


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        //
    }

    //need different names for labels.
    public void newButton(ActionEvent event) {
        String text = JOptionPane.showInputDialog(null, "New Item: ");
        //Label tempLabel = new Label("- " + text);
        itemArrayList.add(text);
        updateVBox();
    }

    public void deleteButton(ActionEvent event) {

    }

    public void undoButton(ActionEvent event) {
        //TODO remove the last index from list and vbox. Store in stack
    }

    public void redoButton(ActionEvent event) {
        //TODO store in stack, calls back off the top of the stack and adds to the vbox
    }

    //TODO There has to be a better way to do this. Maybe just a textfield, on enter add to list and upate. then clear the textfield text.???
    //TODO Don't clear the vbox everytime, just add onto it. That way you can delete using index from selected to delete and vbox.getChildren.remove(index);
    private void updateVBox() {
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
    }
}