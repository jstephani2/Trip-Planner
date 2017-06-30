/**
 * Created by bengi on 6/8/2017.
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

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

    @FXML public Button doneButton;

    private ArrayList<String> itemArrayList = new ArrayList<>();
    public ArrayList<String> doneItemArrayList = new ArrayList<>();

    private Stage stage = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        pane.setStyle("-fx-background-color: #848484");
        if(TripPlannerController.itemArrayList.size() > 0) {
            vBox.getChildren().remove(inputTextField);
            for(String item : TripPlannerController.itemArrayList) {
                labelGeneration(item);
                inputTextFieldWaiter();
            }
        }
    }

    public void inputTextField(ActionEvent event) {
        String item = inputTextField.getText();
        labelGeneration(item);
        inputTextFieldWaiter();
    }

    public void inputTextFieldWaiter() {
        inputTextField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String item = inputTextField.getText();
                labelGeneration(item);
                inputTextFieldWaiter();
            }
        });
    }

    private void labelGeneration(String item) {
        itemArrayList.add(item);
        Label label = new Label("- " + item);
        label.setFont(new Font(70));
        labelDelWaiter(label);
        labelEnterWaiter(label);
        labelExitWaiter(label);
        vBox.getChildren().remove(inputTextField);
        vBox.getChildren().remove(doneButton);
        vBox.getChildren().add(label);
        inputTextField = new TextField();
        vBox.getChildren().add(inputTextField);
        doneButton = new Button("Done");
        doneButtonWaiter();
        vBox.getChildren().add(doneButton);
    }

    private void doneButtonWaiter() {
        doneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                doneItemArrayList = itemArrayList;
                TripPlannerController.itemArrayList = doneItemArrayList;
                stage = (Stage) doneButton.getScene().getWindow();
                stage.close();
            }
        });
    }

    private void labelDelWaiter(Label label) {
        label.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //itemArrayList Remove
                String itemRemove = label.getText().substring(2);
                int index = itemVerification(itemRemove);
                itemArrayList.remove(index);
                vBox.getChildren().remove(index);
            }
        });
    }

    private int itemVerification(String item) {
        int index = 0;
        for(String temp : itemArrayList) {
            if(item.equals(temp)) {
                return index;
            } else {
                index++;
            }
        }
        return -1;
    }

    private void labelEnterWaiter(Label label) {
        label.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                label.setTextFill(Color.RED);
            }
        });
    }

    private void labelExitWaiter(Label label) {
        label.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                label.setTextFill(Color.BLACK);
            }
        });
    }

}