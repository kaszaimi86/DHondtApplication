package view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Represents a controller for the root layout: {@code DHondtVoteRootLayout.fxml}.
 * @author ikasza
 *
 */
public class RootController {

	/**
	 * Info logger for this class.
	 */
	private static Logger logger = LoggerFactory.getLogger("info");


//    /**
//     * Reference to the main application.
//     */
//    private Main main;
//
//    /**
//     * Is called by the main application to give a reference back to itself.
//     *
//     * @param main Reference to main.
//     */
//    public void setMainApp(Main main) {
//        this.main = main;
//    }

    /**
     * Pops up a dialog for the user, so the user can read how to use the application.
     */
    @FXML
    private void handleHowTo() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("DHondt Voting Application");
        alert.setHeaderText("How to use");
        alert.setContentText("Please give the number of votes for each Party below.\n"
        					+ "The given numbers should be positive integers or else the application gives you an error message.\n"
        					+ "Then please give the threshold value in % ( 0 < threshold < 100) and the number of seats/mandates to be allocated.\n"
        					+ "These numbers should also be positive integers. If you click on 'Number of mandates in %' button\n"
        					+ "you can see what percentage of the mandates are given to each party.\n"
        					+ "When you click on 'Number of mandates' button you can see how many mandates are given to each party.\n"
        					+ "You can also save the datas to an .xml file or you can open a previously saved file.\n");

        alert.showAndWait();
    }



    /**
     * Pops up a dialog for the user, so the user can read basic information about the author of this application.
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("DHondt Voting Application");
        alert.setHeaderText("About");
        alert.setContentText("Author: Imre Kasza\nProject for the University Of Debrecen\nFaculty of Informatics.\nThis application calculates how many mandates are given to each party.\nThe calculation is based on the D'Hondt method.");

        alert.showAndWait();
    }

    /**
     * Exits from the application.
     */
    @FXML
    private void handleExit() {
    	logger.info("The application has been successfully terminated.");
        System.exit(0);
    }

}
