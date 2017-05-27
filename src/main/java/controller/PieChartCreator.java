package controller;

import java.util.HashMap;
import java.util.Map.Entry;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.Chart;
import javafx.scene.chart.PieChart;

import model.Vote;

/**
 * Implements {@code ChartCreator}.
 * Represents a special chart: Pie chart.
 * @author ikasza
 *
 */
public class PieChartCreator implements ChartCreator {

	/**
	 * Temporary variable for Party names.
	 */
	private String partyName= null;
	/**
	 * Temporary variable for percentages.
	 */
	private double percentage = 0.0;

	/**
	 * The result pie chart is stored here.
	 */
	PieChart resultChart;

	/**
	 * Creates a pie chart from a map which contains the mandates of those parties which have more than {@code threshold} % of all the votes and from a {@code vote}.
	 *
	 * @param map Contains parties and the mandates of the parties.
	 * @param vote Represents a vote.
	 * @return resultChart The created pie chart.
	 * @see controller.ChartCreator#createChart(java.util.HashMap, model.Vote)
	 *
	 */

	public Chart createChart(HashMap <String,Integer> map, Vote vote) {

		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

		for (Entry<String, Integer> entry : map.entrySet()) {

		    partyName =  entry.getKey();
		    percentage = (entry.getValue()/(double)vote.getAllSeats()) *100;
		    pieChartData.add(new PieChart.Data(partyName +"-"+percentage+"%", percentage ));
		}

		resultChart = new PieChart(pieChartData);

		return resultChart;
	}

}
