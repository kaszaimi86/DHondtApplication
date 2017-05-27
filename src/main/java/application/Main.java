package application;


import java.io.IOException;

//import org.apache.log4j.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import view.VoteController;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * This is the {@code Main} class which starts the application.
 * @author ikasza
 *
 */
public class Main extends Application {

	/**
	 * Primary stage of the application.
	 */
	private Stage primaryStage;
	/**
	 * Primary stage of the application.
	 */
    private BorderPane rootLayout;
    /**
	 * The chart contains that how many percentage of the mandates are own by parties.
	 */
    private PieChart pieChart;
    /**
	 * The chart contains that how many mandates are own by parties.
	 */
	private BarChart<String,Number> barChart;

    /**
     * Default constructror. Returns a Main.
     */
    public Main(){

    }

	/**
	 * Info logger for Main class.
	 */
    private static Logger infoLogger = LoggerFactory.getLogger("info");
    /**
	 * Error logger for Main class.
	 */
    private static Logger errorLogger = LoggerFactory.getLogger("error");


	/**
     * Creates a stage and places the root layout and basic vote overview on it.
     */
	@Override
	public void start(Stage primaryStage) {
		try {
			infoLogger.info("******************************************");
			infoLogger.info("The application has been started.");
			this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("DHondt Voting Application");

	        initRootLayout();

	        showVoteOverview();
		} catch(Exception e) {
			errorLogger.error(e.getMessage());

		}
	}

	/**
     * Initalizes and shows the root layout from {@code DHondtVoteRootLayout.fxml}.
     */
	public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/DHondtVoteRootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
        	errorLogger.error(e.getMessage());
        }
    }

	/**
     * Initalizes and shows the basic view overview layout from {@code DHondtVote.fxml}.
     */
	public void showVoteOverview() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/fxml/DHondtVote.fxml"));
            AnchorPane voteOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(voteOverview);
            VoteController voteController = loader.getController();
            voteController.setMain(this);
        } catch (IOException e) {
        	errorLogger.error(e.getMessage());
        }
    }

	/**
     * Initalizes and shows a piechart layout from {@code DHondtPieChart.fxml}.
     */
	public void showPieChartStatistics() {
	    try {

	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("/fxml/DHondtPieChart.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();
	        Stage dialogStage = new Stage();

	        dialogStage.setTitle("Pie chart for the vote");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page,800,600);

	        pieChart.setTitle("Mandates for parties in %");
	        pieChart.setLabelLineLength(16);
	        pieChart.setLegendVisible(true);
	        pieChart.setMinHeight(400);
	        pieChart.setMinWidth(800);
	        pieChart.setCenterShape(true);
	        ((AnchorPane) scene.getRoot()).getChildren().add(pieChart);

	        dialogStage.setScene(scene);
	        dialogStage.show();


	    } catch (Exception e) {
	    	errorLogger.error("Error happened during showPieChartStatistics in "+Main.class.toString());
	    	errorLogger.error(e.getMessage());
	    }
	}

	/**
     * Initalizes and shows a barchart layout from {@code DHondtBarChart.fxml}.
     */
	public void showBarChartStatistics() {
	    try {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(Main.class.getResource("/fxml/DHondtBarChart.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Mandates per Parties.");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);


	        barChart.setTitle("Mandates for each party");
	        barChart.setMinHeight(400);
	        barChart.setMinWidth(800);
	        barChart.setCenterShape(true);

	        ((AnchorPane) scene.getRoot()).getChildren().add(barChart);
	        dialogStage.setScene(scene);
	        dialogStage.show();

	    } catch (Exception e) {
	    	errorLogger.error("Error happened during showBarChartStatistics in "+Main.class.toString());
	    	errorLogger.error(e.getMessage());
	    }
	}

	/**
     * Sets the value of the piechart of this Main to the given parameter chart.
     * @param chart Represents a piechart.
     *
     */
	public void setPieChart(PieChart chart){
		this.pieChart = chart;
	}

	/**
     * Sets the value of the barchart of this Main to the given parameter chart.
     * @param chart Represents a barchart.
     *
     */
	public void setBarChart(BarChart<String,Number> chart){
		this.barChart = chart;
	}

	/**
     * Returns a the primary stage of this Main.
     * @return primaryStage The priamry stage of this Main.
     */
	public Stage getPrimaryStage() {
        return primaryStage;
    }

	/**
     * Launches the application itself.
     * @param args Lsit of input parameters. Not used in this application.
     *
     */
	public static void main(String[] args) {
		launch(args);
	}
}
