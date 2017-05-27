import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.BarChartCreator;
import controller.ChartCreator;
import controller.ChartFactory;

/**
 * @author ikasza
 *
 */
public class ChartFactoryTest {

	ChartFactory testChartFactory = new ChartFactory();
	BarChartCreator testBarChartCreator;
	private static Logger logger = LoggerFactory.getLogger("test");


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.debug("**********************************");
		logger.debug("ChartFactory test has been started.");
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.debug("ChartFactory test has been finished.");
	}


	@Before
	public void setUp() throws Exception {
	}


	@After
	public void tearDown() throws Exception {
	}


	@Test
	public final void testGetChartCreatorNull() {
		ChartCreator testChartCreator = testChartFactory.getChartCreator(null);
		assertNull(testChartCreator);
		logger.debug("getChatCreator has been successfully tested.");
	}


	@Test
	public final void testGetChartCreatorNull2() {
		ChartCreator testChartCreator = testChartFactory.getChartCreator("FUBAR");
		assertNull(testChartCreator);
		logger.debug("getChatCreator has been successfully tested.");
	}


	@Test
	public final void testGetChartCreatorPieChart() {
		ChartCreator testPieChartCreator = testChartFactory.getChartCreator("PIECHART");

		assertNotNull(testPieChartCreator);
		logger.debug("getChatCreator has been successfully tested.");
	}


	@Test
	public final void testGetChartCreatorBarChart() {
		ChartCreator testBarChartCreator = testChartFactory.getChartCreator("BARCHART");
		assertNotNull(testBarChartCreator);
		logger.debug("getChatCreatorBarChart needs to be implemented.");
	}

}
