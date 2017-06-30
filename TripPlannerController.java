/**
 * Created by bengi on 6/8/2017.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * Controller for Main Window of Trip Planner Application.
 *
 * @author bengi
 */
public class TripPlannerController implements Initializable {
    /*
     * 3 windows
     * Two buttons on bottom left to open "full windows"
     * Add Button for destination
     * Top-Left is just the first destination and the last destination.
     * Main window landscape, secondary windows portrait.
     * DO NOT add list buttons on the new trip
     */

    //TODO OPEN BUTTON, SAVE TRIP AS TXT FILE AND OPEN USING FILE CHOOSER

    //CSS StyleSheet
    //http://code.makery.ch/library/javafx-8-tutorial/part4/

    //https://rterp.wordpress.com/2014/04/25/gmapsfx-add-google-maps-to-your-javafx-application/

    private static final String NEW_TRIP_FXML = "NewTrip.fxml";
    private static final String PACKING_LIST_FXML = "PackingList.fxml";
    private static final String DIRECTIONS_FXML = "Directions.fxml";

    public static Trip newTrip;
    public static ArrayList<Destination> destinationArrayList = new ArrayList<>();
    public static ArrayList<String> itemArrayList = new ArrayList<>();

    //FXML IMPORT
    public Button fullPackingListButton;
    public Button fullDirectionsButton;
    public Button newTripButton;
    public Pane pane;
    public VBox vBox;
    public Button newDestinationButton;
    public Rectangle rectangleToCopy;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle bundle) {
        //Pane Background
        pane.setStyle("-fx-background-color: #848484");
    }

    public void updateTripDisplay() {
        vBox.getChildren().removeAll();
        for(Destination des : destinationArrayList) {
            Label destinationLabel = new Label("Destination: " + des.toString());
            Label distanceLabel = new Label("Distance: ");
            Label timeLabel = new Label("Time: ");
            Rectangle rectangle = new Rectangle(371,4);
            rectangle.setStyle(rectangleToCopy.getStyle());
            rectangle.setStroke(rectangleToCopy.getStroke());
            rectangle.setArcHeight(5);
            rectangle.setArcWidth(5);
            rectangle.setFill(rectangleToCopy.getFill());
            vBox.getChildren().addAll(destinationLabel,distanceLabel,timeLabel,rectangle);
        }
    }

    public void newDestinationButton(ActionEvent event) {
        String destinationString = JOptionPane.showInputDialog(null, "Name of Destination: ");
        if(destinationString == null) {
            return;
        }
        //TODO Destination Declaration and Update Label Info
        Label destinationLabel = new Label("Destination: " + destinationString);
        Label distanceLabel = new Label("Distance: ");
        Label timeLabel = new Label("Time: ");
        Rectangle rectangle = new Rectangle(371,4);
        rectangle.setStyle(rectangleToCopy.getStyle());
        rectangle.setStroke(rectangleToCopy.getStroke());
        rectangle.setArcHeight(5);
        rectangle.setArcWidth(5);
        rectangle.setFill(rectangleToCopy.getFill());
        vBox.getChildren().addAll(destinationLabel,distanceLabel,timeLabel,rectangle);
    }

    public void fullPackingListButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(PACKING_LIST_FXML));
            Parent fullPackingListParent = fxmlLoader.load();
            Stage stage = new Stage();
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
            stage.setTitle("Directions");
            stage.setScene(new Scene(fullDirectionsParent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void newTripButton(ActionEvent event) {
        Stage stage = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(NEW_TRIP_FXML));
            Parent newTripParent = fxmlLoader.load();
            stage = new Stage();
            stage.setTitle("New Trip");
            stage.setScene(new Scene(newTripParent));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO SOLUTION TO ACTIVATE UPDATETRIPDISPLAY WHEN NEW TRIP WINDOW IS EXITED, POSSIBLY FIXED? TEST?
        if(!stage.isShowing()) {
            updateTripDisplay();
        }
    }


}