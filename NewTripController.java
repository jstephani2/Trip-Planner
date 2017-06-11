/**
 * Created by bengi on 6/8/2017.
 */

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

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

    private ArrayList<Destination> destinationArrayList = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        HBox hBox = new HBox();
        Label startLabel = new Label("Start: ");
        TextField startTextField = new TextField();
        //TODO Destination declaration and add to arraylist
    }

    //HBox with label and TextBox inside.

}