package controller;

import java.util.HashMap;

import javafx.scene.chart.Chart;
import model.Vote;

/**
 * An interface which specifies the method which should be use to create a chart.
 * @author ikasza
 *
 */
public interface ChartCreator {
	/**
	 * The method creates a chart from the input parameters.
	 * @param map Contains the number of votes of each party.
	 * @param vote Represents a vote.
	 * @return A chart.
	 */
	public Chart createChart(HashMap<String,Integer> map, Vote vote);

}
