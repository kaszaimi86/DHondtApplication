/**
 * Test class to test the functionality of MandateForVote class {@link model.MandateForVote}.
 */

import static org.junit.Assert.*;

import java.util.HashMap;

//import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.MandateForVote;

public class MandateForVoteTest {

	private MandateForVote testMFV;
	private HashMap<String,Integer> testMandates = new HashMap<String,Integer>();

	//private static Logger testInfoLogger = Logger.getLogger("testInfoLogger");
	private static Logger logger = LoggerFactory.getLogger("test");


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.debug("MandateForVote test has been started.");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.debug("MandateForVote test has been finished.");
	}

	@Before
	public void setUp() throws Exception {
		testMandates.put("Yellows",6);
		testMandates.put("Greens",4);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMandateForVoteHashMapOfStringInteger() {
		testMFV = new MandateForVote(testMandates);
		HashMap<String, Integer> testHMAp = testMFV.getMandates();
		assertNotNull(testMFV);
		assertTrue(testMandates.equals(testHMAp));
		logger.debug("MandateForVote(HashMap) has been successfully tested.");
	}

	@Test
	public void testMandateForVote() {
		MandateForVote testMFV = new MandateForVote();
		assertNotNull(testMFV);
		logger.debug("MandateForVote has been successfully tested.");
	}

	@Test
	public void testGetMandates() {
		testMFV = new MandateForVote(testMandates);
		HashMap<String, Integer> testHMAp = testMFV.getMandates();

		assertTrue(testMandates.equals(testHMAp));
		logger.debug("GetMandates has been successfully tested.");

	}

	@Test
	public void testToString() {
		testMFV = new MandateForVote(testMandates);
		String testString = "MandateForVote [mandates={Yellows=6, Greens=4}]";
		assertEquals(testString,testMFV.toString());
		logger.info("ToString has been successfully tested.");

	}

}
