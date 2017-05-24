/**
 *
 */


import static org.junit.Assert.*;

//import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Party;

/**
 * @author ikasza
 *
 */
public class PartyTest {
	private Party testParty;
	//private static Logger testInfoLogger = Logger.getLogger("testInfoLogger");
	private static Logger logger = LoggerFactory.getLogger("test");


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.debug("Party test has been started.");

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.debug("Party test has been finished.");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		testParty = new Party("TestParty","TestLeader",100);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}


	/**
	 * Test method for {@link model.Party#getName()}.
	 */
	@Test
	public void testGetName() {
		String name = testParty.getName();
		assertEquals("TestParty",name);
		logger.debug("getName has been successfully tested.");
	}

	/**
	 * Test method for {@link model.Party#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		testParty.setName("ModifiedName");
		assertEquals("ModifiedName",testParty.getName());
		logger.debug("setName has been successfully tested.");
	}

	/**
	 * Test method for {@link model.Party#getLeader()}.
	 */
	@Test
	public void testGetLeader() {
		String leader = testParty.getLeader();
		assertEquals("TestLeader",leader);
		logger.debug("getLeader has been successfully tested.");
	}

	/**
	 * Test method for {@link model.Party#setLeader(java.lang.String)}.
	 */
	@Test
	public void testSetLeader() {
		testParty.setLeader("ModifiedLeader");
		assertEquals("ModifiedLeader",testParty.getLeader());
		logger.debug("setLeader has been successfully tested.");
	}

	/**
	 * Test method for {@link model.Party#getVoteCount()}.
	 */
	@Test
	public void testGetVoteCount() {
		int votes = testParty.getVoteCount();
		assertEquals(100,votes);
		logger.debug("getVoteCount has been successfully tested.");
	}

	/**
	 * Test method for {@link model.Party#setVoteCount(int)}.
	 */
	@Test
	public void testSetVoteCount() {
		testParty.setVoteCount(101);
		assertEquals(101,testParty.getVoteCount());
		logger.debug("setVoteCount has been successfully tested.");
	}

	/**
	 * Test method for {@link model.Party#equals(Party)}.
	 */
	@Test
	public void testEquals() {
		Party testParty2 = new Party("TestParty","TestLeader",100);

		assertTrue(testParty.equals(testParty2));
		logger.debug("equals has been successfully tested.");
	}

	/**
	 * Test method for {@link model.Party#Party()}.
	 */
	@Test
	public void testParty() {
		Party testParty = new Party();
		assertNotNull(testParty);
		logger.debug("Party has been successfully tested.");
	}

}
