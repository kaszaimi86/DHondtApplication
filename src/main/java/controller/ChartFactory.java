package controller;

/**
 * Represents a chart factory which can create a {@code PieChartCreator} or {@code BarChartCreator}.
 * @author ikasza
 *
 */
public class ChartFactory {

	/**
	 * This factory returns a {@code PieChartCreator} or {@code BarChartCreator}. It depends on the value of {@code chartType}.
	 * @param chartType The value specifies the what kind of ChartCreator should given by the method.
	 * @return A {@code PieChartCreator} or {@code BarChartCreator}.
	 */
	public ChartCreator getChartCreator(String chartType){
		if(chartType == null){
			return null;
		}
		if(chartType.equalsIgnoreCase("PIECHART")){
			return new PieChartCreator();
		}
		if(chartType.equalsIgnoreCase("BARCHART")){
			return new BarChartCreator();
		}

		return null;
	}
}
