package controller;

import java.util.HashMap;
import java.util.Map.Entry;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import model.Vote;

/**
 * Implements a {@code ChartCreator}.
 * Represents a special chart: Bar chart.
 * @author ikasza
 *
 */
public class BarChartCreator implements ChartCreator {


	/**
	 * X axis for the bar chart. Represents the parties.
	 */
	private CategoryAxis xAxis =new CategoryAxis();
    /**
     * Y axis for the bar chart. Represents the number of votes of each party.
     */
    private NumberAxis yAxis = new NumberAxis();

    /**
	 * Temporary variable for Party names.
	 */
    private String partyName= null;

    /**
	 * Temporary variable for mandates.
	 */
	private int mandates = 0;


	/**
	 * Creates a bar chart from a map which contains the mandates of those parties which have more than {@code threshold} % of all the votes.
	 *
	 * @param map Contains parties and the mandates of the parties.
	 * @param vote Represents a vote.
	 * @return barChart The created barchart.
	 * @see controller.ChartCreator#createChart(java.util.HashMap, model.Vote)
	 */
	//@Override
	public Chart createChart(HashMap <String,Integer> map, Vote vote) {

		xAxis.setLabel("Parties");
		yAxis.setLabel("Mandates");

		XYChart.Series <String, Number> barChartSeries = new XYChart.Series<String,Number>();
		barChartSeries.setName("Mandates");
		BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);

		for(Entry<String, Integer> entry : map.entrySet()) {
		    partyName =  entry.getKey();
		    mandates = entry.getValue();
		    barChartSeries.getData().add(new XYChart.Data<String, Number>(partyName+" - "+mandates,mandates));
		}

		barChart.getData().add(barChartSeries);
		return barChart;
	}
}
