/**
 * Test class to test the functionality of ChartFactory class {@link controller.ChartFactory}.
 */


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

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.debug("ChartFactory test has been started.");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.debug("ChartFactory test has been finished.");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link controller.ChartFactory#getChartCreator(java.lang.String)}.
	 */
	@Test
	public final void testGetChartCreatorNull() {
		ChartCreator testChartCreator = testChartFactory.getChartCreator(null);
		assertNull(testChartCreator);
		logger.debug("getChatCreator has been successfully tested.");
	}

	/**
	 * Test method for {@link controller.ChartFactory#getChartCreator(java.lang.String)}.
	 */
	@Test
	public final void testGetChartCreatorNull2() {
		ChartCreator testChartCreator = testChartFactory.getChartCreator("FUBAR");
		assertNull(testChartCreator);
		logger.debug("getChatCreator has been successfully tested.");
	}

	/**
	 * Test method for {@link controller.ChartFactory#getChartCreator(java.lang.String)}.
	 */
	@Test
	public final void testGetChartCreatorPieChart() {
		ChartCreator testPieChartCreator = testChartFactory.getChartCreator("PIECHART");
		//System.out.println(testPieChartCreator.getClass());
		assertNotNull(testPieChartCreator);
		logger.debug("getChatCreator has been successfully tested.");
	}

	/**
	 * Test method for {@link controller.ChartFactory#getChartCreator(java.lang.String)}.
	 */
	@Test
	public final void testGetChartCreatorBarChart() {
		//testBarChartCreator = (BarChartCreator)testChartFactory.getChartCreator("BARCHART");
		//assertNotNull(testBarChartCreator);
		logger.debug("getChatCreatorBarChart needs to be implemented.");
	}

}
