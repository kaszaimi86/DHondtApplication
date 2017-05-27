package view;

import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.scene.control.TextField;
import model.MandateForVote;
import model.Party;
import model.Vote;
import model.VoteDaoXmlImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import application.Main;
import controller.ChartCreator;
import controller.ChartFactory;
import controller.MandateCalculatorImpl;
import controller.VoteDataValidator;

/**
 * Controller class to create and show the different chart and handles user requests.
 * @author ikasza
 *
 */
@SuppressWarnings("unchecked")
public class VoteController {

	/**
	 * Local variable that represents an input field from GUI.
	 */
	@FXML
    private TextField jalapenoField;
	/**
	 * Local variable that represents an input field from GUI.
	 */
	@FXML
    private TextField chipotleField;
	/**
	 * Local variable that represents an input field from GUI.
	 */
	@FXML
    private TextField habaneroField;
	/**
	 * Local variable that represents an input field from GUI.
	 */
	@FXML
    private TextField redSavField;
	/**
	 * Local variable that represents an input field from GUI.
	 */
	@FXML
    private TextField morugaField;
	/**
	 * Local variable that represents an input field from GUI.
	 */
	@FXML
    private TextField carolinaField;
	/**
	 * Local variable that represents an input field from GUI.
	 */
	@FXML
    private TextField thresholdField;
	/**
	 * Local variable that represents an input field from GUI.
	 */
	@FXML
    private TextField mandatesField;

	/**
	 * A piechart which shows that how many percentage of the mandates are given to each party.
	 */
	@FXML
    private PieChart resultChart;
	/**
	 * A piechart which shows that how many mandates are given to each party.
	 */
	@FXML
    private BarChart<String, Number> barChart;

	/**
	 * An instance of a {@code VoteDaoXmlImpl}, you can read from a file and save to a file with it.
	 * @see model.VoteDaoXmlImpl
	 */
	private VoteDaoXmlImpl xmlReaderWriter = new VoteDaoXmlImpl();

	/**
	 * Instace of a {@code ChartFactory}.
	 * @see controller.ChartFactory
	 */
	private ChartFactory chartFactory= new ChartFactory();

	/**
	 * Instace of a {@code VoteDataValidator}.
	 * @see controller.VoteDataValidator
	 */
	private VoteDataValidator validator =  new VoteDataValidator();

	/**
	 * Reference to {@code Main} class.
	 */
	private Main main;

	/**
	 * Info logger for this class.
	 */
	private static Logger infoLogger = LoggerFactory.getLogger("info");
	/**
	 * Error logger for this class.
	 */
	private static Logger errorLogger = LoggerFactory.getLogger("error");

	/**
	 * Default constructor.
	 */
	public VoteController() {

	}

	/**
	 * Initializes {@code VoteController}.
	 */
	@FXML
    private void initialize(){
		resultChart = new PieChart();
	}

	/**
	 * Sets the value of this main to the given parameter {@code main}.
	 * @param main The given parameter. Reference to {@code Main} class.
	 */
	public void setMain(Main main){
		this.main = main;
	}

	/**
	 * Deletes the content of all the fields.
	 */
	@FXML
	private void ClearAllFields(){
		this.jalapenoField.setText(null);
		this.habaneroField.setText(null);
		this.redSavField.setText(null);
		this.morugaField.setText(null);
		this.carolinaField.setText(null);
		this.chipotleField.setText(null);
		this.thresholdField.setText(null);
		this.mandatesField.setText(null);

	}

	/**
	 * Cretes a vote from the input datas.
	 * @return vote The created {@code vote}.
	 */
	private Vote createVote(){

		Vote vote;

		Party party1 = new Party("Jalapeno", "Jalapeno Leader", Integer.parseInt(jalapenoField.getText()));
		Party party2 = new Party("Habanero", "Habanero Leader", Integer.parseInt(habaneroField.getText()));
		Party party3 = new Party("Red Savina", "Red Savina Leader", Integer.parseInt(redSavField.getText()));
		Party party4 = new Party("Moruga Scorpion", "Moruga Scorpion Leader",
				Integer.parseInt(morugaField.getText()));
		Party party5 = new Party("Carolina Reaper", "Carolina Reaper Leader",
				Integer.parseInt(carolinaField.getText()));
		Party party6 = new Party("Chipotle", "Chipotle Leader",
				Integer.parseInt(chipotleField.getText()));

		int seats = Integer.parseInt(mandatesField.getText());
		int threshold = Integer.parseInt(thresholdField.getText());
		int voteCount = (party1.getVoteCount() + party2.getVoteCount() + party3.getVoteCount()
				+ party4.getVoteCount() + party5.getVoteCount() + party6.getVoteCount() );

		ArrayList<Party> parties = new ArrayList<Party>();
		parties.add(party1);
		parties.add(party2);
		parties.add(party3);
		parties.add(party4);
		parties.add(party5);
		parties.add(party6);

		vote = new Vote(parties, threshold, voteCount, seats);

		return vote;
	}

	/**
	 * Pops up a file chooser dialog where the user can choose where he wants to save to.
	 * Then the method tries to save the the vote into the file.
	 */
	@FXML
    private void saveVote(){

		if (isInputValid()) {
			Vote vote = createVote();
			FileChooser fileChooser = new FileChooser();

	        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
	                "XML files (*.xml)", "*.xml");
	        fileChooser.getExtensionFilters().add(extFilter);

	        File file = fileChooser.showSaveDialog(main.getPrimaryStage());

	        if (file != null) {

	            if (!file.getPath().endsWith(".xml")) {
	                file = new File(file.getPath() + ".xml");
	            }
	          xmlReaderWriter.saveVote(vote,file);

	        }
		}
	}

	/**
	 * Pops up a file chooser dialog where the user can choose the file where he wants to load from.
	 * Then the method tries to open the file and load tha data from ther.
	 */
	@FXML
    private void loadVote(){
		try{
			FileChooser fileChooserLoad = new FileChooser();

			FileChooser.ExtensionFilter extFilterLoad = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
			fileChooserLoad.getExtensionFilters().add(extFilterLoad);

			File file = fileChooserLoad.showOpenDialog(main.getPrimaryStage());

			try {
				Vote vote = xmlReaderWriter.loadVote(file);

	        	ArrayList<Party> parties = new ArrayList<Party>();
	        	parties = vote.getParties();

	        	String partyName = null;
	        	int votes = 0;

	        	this.jalapenoField.setText("Error");
	    		this.habaneroField.setText("Error");
	    		this.redSavField.setText("Error");
	    		this.morugaField.setText("Error");
	    		this.carolinaField.setText("Error");
	    		this.chipotleField.setText("Error");
	    		this.thresholdField.setText("Error");
	    		this.mandatesField.setText("Error");

	        	for(Party p : parties){
	        		partyName = p.getName();
	        		votes =p.getVoteCount();
	        		if (partyName.equals("Jalapeno")){
	        			jalapenoField.setText(Integer.toString(votes));
	        		}
	        		if (partyName.equals("Habanero")){
	        			habaneroField.setText(Integer.toString(votes));
	        		}
	        		if (partyName.equals("Red Savina")){
	        			redSavField.setText(Integer.toString(votes));
	        		}
	        		if (partyName.equals("Moruga Scorpion")){
	        			morugaField.setText(Integer.toString(votes));
	        		}
	        		if (partyName.equals("Carolina Reaper")){
	        			carolinaField.setText(Integer.toString(votes));
	        		}
	        		if (partyName.equals("Chipotle")){
	        			chipotleField.setText(Integer.toString(votes));
	        		}
	        	}
	        	thresholdField.setText(Integer.toString(vote.getThreshold()));
	    		mandatesField.setText(Integer.toString(vote.getAllSeats()));
	    	}catch(Exception e){
	    		errorLogger.error("No file has been chosen or file is invalid.");
	    		errorLogger.error(e.getMessage());
	        	Alert alert = new Alert(AlertType.ERROR);
	    		alert.initOwner(main.getPrimaryStage());
	    		alert.setTitle("No file has been chosen or file is invalid.");
	    		alert.setHeaderText("Faulty datas.");
	    		alert.setContentText("Please check the file you chose. No file has been chosen or file is invalid.");
	    		alert.showAndWait();
	    	}

	        if(isInputValid() == false){
	        	errorLogger.error("Error in the input file:" + file.getAbsolutePath());
	    		errorLogger.error("Faulty datas.");
	        	Alert alert = new Alert(AlertType.ERROR);
	    		alert.initOwner(main.getPrimaryStage());
	    		alert.setTitle("Error in the input file.");
	    		alert.setHeaderText("Faulty datas.");
	    		alert.setContentText("Please check the file you chose. Probably the file contains faulty datas. Please try to correct the error in the file or choose another file.");
	    		alert.showAndWait();
	        }
		}catch(Exception e){
			errorLogger.error("Error happened during file load.");

		}
	}


	/**
	 * Creates a piechar or a barchart, depends on the content of the given parameter {@code charType} or creates an empty chart and pops up a dialog.
	 * @param chartType If the value of this parameter is "PIECHART" then the method cretes a piechart, if the value is "BARCHART", then a barchart.
	 */
    private void createCharts(String chartType){

    	try{

	        if (isInputValid()) {

	        	resultChart = new PieChart();
	        	infoLogger.info("Valid input");
				Vote vote = createVote();
				infoLogger.info("Vote has been created.");
				infoLogger.info(vote.toString());
				MandateCalculatorImpl calc = new MandateCalculatorImpl();
				MandateForVote mandate = calc.calculator(vote);

				infoLogger.info("Mandates have been calculated.");

				HashMap<String, Integer> mandates = mandate.getMandates();

				if(chartType.equalsIgnoreCase("PIECHART")){
					ChartCreator pieChartCreator = chartFactory.getChartCreator("PIECHART");
					resultChart = (PieChart) pieChartCreator.createChart(mandates,vote);
					infoLogger.info("A piechart has been created.");
				}

				if(chartType.equalsIgnoreCase("BARCHART")){
					ChartCreator barChartCreator = chartFactory.getChartCreator("BARCHART");
					barChart = (BarChart<String, Number>) barChartCreator.createChart(mandates,vote);
					infoLogger.info("A bar chart has been created.");
				}

			}else{
				resultChart = null;
				barChart=null;

				errorLogger.error("Cannot create chart.");
	    		errorLogger.error("Faulty datas.");
				Alert alert = new Alert(AlertType.ERROR);
	    		alert.initOwner(main.getPrimaryStage());
	    		alert.setTitle("Cannot create chart");
	    		alert.setHeaderText("Faulty datas.");
	    		alert.setContentText("The application cannot generate a chart from not appropriate datas.");
	    		alert.showAndWait();
			}
    	}catch(Exception e){
    		resultChart = null;
			barChart=null;
    		errorLogger.error("Cannot create chart.");
    		errorLogger.error("Faulty datas.");
			Alert alert = new Alert(AlertType.ERROR);
    		alert.initOwner(main.getPrimaryStage());
    		alert.setTitle("Cannot create chart");
    		alert.setHeaderText("Faulty datas.");
    		alert.setContentText("The application cannot generate a chart from not appropriate datas.");
    		alert.showAndWait();
    	}
    }

	/**
	 * This is a handler which listens to user interaction and creates, shows a pie chart  when called.
	 */
	@FXML
	private void handleShowBarChartStatistics() {
		createCharts("BARCHART");
		main.setBarChart(barChart);
		main.showBarChartStatistics();
	}

	/**
	 * This is a handler which listens to user interaction and creates, shows a pie chart  when called.
	 */
	@FXML
	private void handleShowPieChartStatistics(){
		createCharts("PIECHART");
		main.setPieChart(resultChart);
		main.showPieChartStatistics();
	}

	/**
	 * Returns the piechart of this.
	 * @return resultChart
	 */
	public PieChart getPieChart(){
		return this.resultChart;
	}

	/**
	 * Returns the barchart of this.
	 * @return barChart
	 */
	public BarChart<String, Number> getBarChart(){
		return this.barChart;
	}

	/**
	 * Sets the value of the piechart of the actual instace to the given piechart.
	 * @param chart The given piechart.
	 */
	public void setPieChart(PieChart chart){
		this.resultChart = chart;
	}

	/**
	 * Sets the value of the barchart of the actual instace to the given barchart.
	 * @param chart The given barchart.
	 */
	public void setBarChart(BarChart<String, Number> chart){
		this.barChart = chart;
	}

	/**
	 * Decides wether the input is valid or not with a {@code validator}.
	 * @return true/false If the input is valid then {@code true} else pops up a dialog and returns {@code false}.
	 */
	public boolean isInputValid(){

		if (validator.isValid(jalapenoField.getText(), habaneroField.getText(), redSavField.getText(), morugaField.getText(), carolinaField.getText(), chipotleField.getText(), mandatesField.getText(),  thresholdField.getText())){
			return true;
		}
    	else{
    		errorLogger.error("Invalid input");
    		errorLogger.error(validator.getErrorMessage());
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.initOwner(main.getPrimaryStage());
    		alert.setTitle("Invalid Fields");
    		alert.setHeaderText("Please correct invalid fields!");
    		alert.setContentText(validator.getErrorMessage());
    		alert.showAndWait();
    		return false;
    	}
    }

	/**
	 * This is a handler which listens to user interaction and succesfully terminates the application when called.
	 */
	@FXML
    private void handleExit() {
		infoLogger.info("The application has been successfully terminated.");
        System.exit(0);
    }


}
