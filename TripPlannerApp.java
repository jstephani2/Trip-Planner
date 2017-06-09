import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class TripPlannerApp extends Application {
    private static final String SCENE_TITLE = "Trip Planner";
    private static final double SCENE_WIDTH = 800;
    private static final double SCENE_HEIGHT = 600;
    private static final String SCENE_FXML = "TripPlanner.fxml";
    
    public static void main(String[] args) {
		launch(args);
	}

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(SCENE_FXML));
            primaryStage.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
            primaryStage.setTitle(SCENE_TITLE);
            //primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Starting Program",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}