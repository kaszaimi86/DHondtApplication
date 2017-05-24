/**
 *
 */


import static org.junit.Assert.*;

import java.util.ArrayList;

//import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Party;
import model.Vote;

/**
 * @author ikasza
 *
 */
public class VoteTest {

	private Vote testVote;
	private Party testParty1 = new Party("TestParty1","TestLeader1",100);
	private Party testParty2 = new Party("TestParty2","TestLeader2",200);
	private Party testParty3 = new Party("TestParty3","TestLeader3",300);
	private ArrayList<Party> parties = new ArrayList<Party>();
	private int threshold =2;
	private int votes = 600;
	private int seats = 10;
	//private static Logger testInfoLogger = Logger.getLogger("testInfoLogger");

	private static Logger logger = LoggerFactory.getLogger("test");

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.debug("Vote test has been started.");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.debug("Vote test has been finished.");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		parties.add(testParty1);
		parties.add(testParty2);
		parties.add(testParty3);
		testVote = new Vote (parties,threshold,votes,seats);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.Vote#getParties()}.
	 */
	@Test
	public void testGetParties() {
		ArrayList<Party> testPartyList =testVote.getParties();
		assertTrue(parties.equals(testPartyList));
		logger.debug("getParties has been successfully tested.");
	}

	/**
	 * Test method for {@link model.Vote#setParties(java.util.ArrayList)}.
	 */
	@Test
	public void testSetParties() {
		ArrayList<Party> testInputPartyList = new ArrayList<Party> ();
		Party testInputParty1 = new Party("TestInputParty1","TestInputLeader1",100);
		Party testInputParty2 = new Party("TestInputParty2","TestInputLeader2",100);
		Party testInputParty3 = new Party("TestInputParty2","TestInputLeader3",100);

		testInputPartyList.add(testInputParty1);
		testInputPartyList.add(testInputParty2);
		testInputPartyList.add(testInputParty3);

		testVote.setParties(testInputPartyList);

		ArrayList<Party> testOutputPartyList =testVote.getParties();

		assertTrue(testInputPartyList.equals(testOutputPartyList));
		logger.debug("setParties has been successfully tested.");
	}

	/**
	 * Test method for {@link model.Vote#getThreshold()}.
	 */
	@Test
	public void testGetThreshold() {
		assertEquals(2,testVote.getThreshold());
		logger.debug("getThreshold has been successfully tested.");
	}

	/**
	 * Test method for {@link model.Vote#setThreshold(int)}.
	 */
	@Test
	public void testSetThreshold() {
		testVote.setThreshold(15);
		assertEquals(15,testVote.getThreshold());
		logger.debug("setThreshold has been successfully tested.");
	}

	/**
	 * Test method for {@link model.Vote#getAllCount()}.
	 */
	@Test
	public void testGetAllCount() {
		assertEquals(600,testVote.getAllCount());
		logger.debug("getAllCount has been successfully tested.");
	}

	/**
	 * Test method for {@link model.Vote#setAllCount(int)}.
	 */
	@Test
	public void testSetAllCount() {
		testVote.setAllCount(300);
		assertEquals(300,testVote.getAllCount());
		logger.debug("setAllCount has been successfully tested.");
	}

	/**
	 * Test method for {@link model.Vote#getAllSeats()}.
	 */
	@Test
	public void testGetAllSeats() {
		assertEquals(10,testVote.getAllSeats());
		logger.debug("getAllSeats has been successfully tested.");
	}

	/**
	 * Test method for {@link model.Vote#setAllSeats(int)}.
	 */
	@Test
	public void testSetAllSeats() {
		testVote.setAllSeats(358);
		assertEquals(358,testVote.getAllSeats());
		logger.debug("setAllSeats has been successfully tested.");
	}

	/**
	 * Test method for {@link model.Vote#Vote(java.util.ArrayList, int, int, int)}.
	 */
	@Test
	public void testVoteArrayListOfPartyIntIntInt() {
		Vote testVoteEqual = new Vote (parties,threshold,votes,seats);
		assertTrue(testVote.equals(testVoteEqual));
		logger.debug("Constructor has been successfully tested.");

	}

	/**
	 * Test method for {@link model.Vote#toString()}.
	 */
	@Test
	public void testToString() {
		String testString = "Vote [party=[Datas of the party [name=TestParty1, leader=TestLeader1, voteCount=100], Datas of the party [name=TestParty2, leader=TestLeader2, voteCount=200], Datas of the party [name=TestParty3, leader=TestLeader3, voteCount=300]], threshold=2, allCount=600, seats=10]";
		assertEquals(testString,testVote.toString());
		logger.debug("toString has been successfully tested.");
	}

	/**
	 * Test method for {@link model.Vote#Vote()}.
	 */
	@Test
	public void testVote() {
		Vote testVote= new Vote();
		assertNotNull(testVote);
		logger.debug("Vote has been successfully tested.");
	}

}
