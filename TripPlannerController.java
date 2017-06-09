/**
 * Created by bengi on 6/8/2017.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * TODO Add Class Javadocs
 *
 * @author bengi
 */
public class TripPlannerController implements Initializable {
    /*
     * 3 windows
     * Menu Bar on Window 1
     * Two buttons on bottom left to open "full windows"
     * Add Button for destination
     * Top-Left is just the first destination and the last destination.
     * Main window landscape, secondary windows portrait.
     * DO NOT add list buttons on the new trip
     */

    //https://rterp.wordpress.com/2014/04/25/gmapsfx-add-google-maps-to-your-javafx-application/

    private static final String NEW_TRIP_FXML = "NewTrip.fxml";
    private static final String PACKING_LIST_FXML = "PackingList.fxml";
    private static final String DIRECTIONS_FXML = "Directions.fxml";

    //FXML IMPORT
    public Button fullPackingListButton;
    public Button fullDirectionsButton;
    public Button newTripButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle bundle) {

    }

    public void fullPackingListButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PACKING_LIST_FXML));
            Parent fullPackingListParent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Packing List");
            stage.setScene(new Scene(fullPackingListParent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fullDirectionsButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DIRECTIONS_FXML));
            Parent fullDirectionsParent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Directions");
            stage.setScene(new Scene(fullDirectionsParent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newTripButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(NEW_TRIP_FXML));
            Parent newTripParent = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("New Trip");
            stage.setScene(new Scene(newTripParent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}