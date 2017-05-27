import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.MandateCalculatorImpl;
import model.MandateForVote;
import model.Party;
import model.Vote;

/**
 * @author ikasza
 *
 */
public class MandateCalculatorImplTest {

	private static Logger logger = LoggerFactory.getLogger("test");

	private MandateCalculatorImpl calc;
	private Vote testVote;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.debug("****************************************");
		logger.debug("MandateCalculator test has been started.");
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.debug("MandateCalculator test has been finished.");
	}


	@Before
	public void setUp() throws Exception {
		calc = new MandateCalculatorImpl();
		Party party1 = new Party("Yellows","Yellow Leader",47000);
		Party party2 = new Party("Whites","White Leader",16000);
		Party party3 = new Party("Reds","Red Leader",15900);
		Party party4 = new Party("Greens","Green Leader",12000);
		Party party5 = new Party("Blues","Blue Leader",6000);
		Party party6 = new Party("Browns","Brown Leader",3100);

		ArrayList<Party> testParties = new ArrayList<Party>();

		testParties.add(party1);
		testParties.add(party2);
		testParties.add(party3);
		testParties.add(party4);
		testParties.add(party5);
		testParties.add(party6);

		testVote = new Vote(testParties,5,100000,10);
	}


	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testCalculator() {
		MandateForVote testMfV = calc.calculator(testVote);
		HashMap<String,Integer> testMap = new HashMap<String,Integer> ();
		HashMap<String,Integer> testMap2 = new HashMap<String,Integer> ();

		testMap = testMfV.getMandates();

		testMap2.put("Reds",2);
		testMap2.put("Yellows",5);
		testMap2.put("Whites",2);
		testMap2.put("Greens",1);
		testMap2.put("Blues",0);

		Map<String,Integer> map = new TreeMap<String,Integer>(testMap);
		Map<String,Integer> map2 = new TreeMap<String,Integer>(testMap2);

		assertTrue(map.equals(map2));
		logger.debug("Calculator has successfully been tested.");

	}


	@Test
	public void testCalculatorFalse() {
		MandateForVote testMfV = calc.calculator(testVote);
		HashMap<String,Integer> testMap = new HashMap<String,Integer> ();
		HashMap<String,Integer> testMap2 = new HashMap<String,Integer> ();

		testMap = testMfV.getMandates();

		testMap2.put("Reds",2);
		testMap2.put("Yellows",5);
		testMap2.put("Whites",2);
		testMap2.put("Greens",1);
		testMap2.put("Blues",0);
		testMap2.put("Browns",0);

		Map<String,Integer> map = new TreeMap<String,Integer>(testMap);
		Map<String,Integer> map2 = new TreeMap<String,Integer>(testMap2);

		assertFalse(map.equals(map2));
		logger.debug("CalculatorFalse has successfully been tested.");

	}


	@Test
	public void testCalculatorExact() {
		Party party1 = new Party("Yellows","Yellow Leader",501);
		Party party2 = new Party("Whites","White Leader",400);
		Party party3 = new Party("Reds","Red Leader",50);
		Party party4 = new Party("Greens","Green Leader",49);

		ArrayList<Party> testParties = new ArrayList<Party>();

		testParties.add(party1);
		testParties.add(party2);
		testParties.add(party3);
		testParties.add(party4);

		testVote = new Vote(testParties,5,1000,10);

		MandateForVote testMfV = calc.calculator(testVote);
		HashMap<String,Integer> testMap = new HashMap<String,Integer> ();
		HashMap<String,Integer> testMap2 = new HashMap<String,Integer> ();

		testMap = testMfV.getMandates();

		testMap2.put("Reds",0);
		testMap2.put("Yellows",6);
		testMap2.put("Whites",4);


		Map<String,Integer> map = new TreeMap<String,Integer>(testMap);
		Map<String,Integer> map2 = new TreeMap<String,Integer>(testMap2);

		assertTrue(map.equals(map2));
		logger.debug("CalculatorExact has successfully been tested.");

	}


	@Test
	public void testMaxKey() {
		HashMap<String,Integer> testMap = new HashMap<String,Integer> ();
		testMap.put("Max",10);
		testMap.put("Min",5);

		assertEquals("Max",calc.maxKey(testMap));
		logger.debug("maxKey has successfully been tested.");
	}

	@Test
	public void testMaxKeyFalse() {
		HashMap<String,Integer> testMap = new HashMap<String,Integer> ();
		testMap.put("Max",10);
		testMap.put("Min",5);

		assertNotSame("Min",calc.maxKey(testMap));
		logger.info("maxKeyFalse successfully has been tested.");
	}


}
