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

    private ArrayList<String> itemArrayList = new ArrayList<>();

    //list of labels, when hit delete convert to buttons, if button is hit it is deleted from list of labels, and the list is reupdated.

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        // TODO
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

    }

    public void redoButton(ActionEvent event) {

    }

    private void updateVBox() {
        int size = itemArrayList.size();
        vBox.getChildren().clear();
        for(int i = 0; i < size; i++) {
            Label tempLabel = new Label("- " + itemArrayList.get(i));
            Font font = new Font(tempLabel.getFont().getSize() * 1.5);
            tempLabel.setFont(font);
            vBox.getChildren().add(tempLabel);
        }
    }
}