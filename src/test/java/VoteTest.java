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


	private static Logger logger = LoggerFactory.getLogger("test");


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.debug("***************************");
		logger.debug("Vote test has been started.");
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.debug("Vote test has been finished.");
	}


	@Before
	public void setUp() throws Exception {

		parties.add(testParty1);
		parties.add(testParty2);
		parties.add(testParty3);
		testVote = new Vote (parties,threshold,votes,seats);

	}


	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testGetParties() {
		ArrayList<Party> testPartyList =testVote.getParties();
		assertTrue(parties.equals(testPartyList));
		logger.debug("getParties has been successfully tested.");
	}


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


	@Test
	public void testGetThreshold() {
		assertEquals(2,testVote.getThreshold());
		logger.debug("getThreshold has been successfully tested.");
	}


	@Test
	public void testSetThreshold() {
		testVote.setThreshold(15);
		assertEquals(15,testVote.getThreshold());
		logger.debug("setThreshold has been successfully tested.");
	}


	@Test
	public void testGetAllCount() {
		assertEquals(600,testVote.getAllCount());
		logger.debug("getAllCount has been successfully tested.");
	}


	@Test
	public void testSetAllCount() {
		testVote.setAllCount(300);
		assertEquals(300,testVote.getAllCount());
		logger.debug("setAllCount has been successfully tested.");
	}


	@Test
	public void testGetAllSeats() {
		assertEquals(10,testVote.getAllSeats());
		logger.debug("getAllSeats has been successfully tested.");
	}


	@Test
	public void testSetAllSeats() {
		testVote.setAllSeats(358);
		assertEquals(358,testVote.getAllSeats());
		logger.debug("setAllSeats has been successfully tested.");
	}


	@Test
	public void testVoteArrayListOfPartyIntIntInt() {
		Vote testVoteEqual = new Vote (parties,threshold,votes,seats);
		assertTrue(testVote.equals(testVoteEqual));
		logger.debug("Constructor has been successfully tested.");

	}


	@Test
	public void testToString() {
		String testString = "Vote [party=[Datas of the party [name=TestParty1, leader=TestLeader1, voteCount=100], Datas of the party [name=TestParty2, leader=TestLeader2, voteCount=200], Datas of the party [name=TestParty3, leader=TestLeader3, voteCount=300]], threshold=2, allCount=600, seats=10]";
		assertEquals(testString,testVote.toString());
		logger.debug("toString has been successfully tested.");
	}


	@Test
	public void testVote() {
		Vote testVote= new Vote();
		assertNotNull(testVote);
		logger.debug("Vote has been successfully tested.");
	}

	@Test
	public void testEquals() {
		Vote test2Vote= new Vote();
		Party test2Party1 = new Party("TestParty1","TestLeader1",100);
		Party test2Party2 = new Party("TestParty2","TestLeader2",200);
		Party test2Party3 = new Party("TestParty3","TestLeader3",300);
		ArrayList<Party> parties2 = new ArrayList<Party>();
		int threshold2 =2;
		int votes2 = 600;
		int seats2 = 10;

		parties2.add(test2Party1);
		parties2.add(test2Party2);
		parties2.add(test2Party3);

		test2Vote = new Vote(parties2,threshold2,votes2,seats2);

		assertTrue(testVote.equals(test2Vote));


		logger.debug("Vote has been successfully tested.");
	}


	@Test
	public void testEqualsFalse() {
		Vote test2Vote= new Vote();
		Party test2Party1 = new Party("TestParty1","TestLeader1",100);
		Party test2Party2 = new Party("TestParty2","TestLeader2",200);
		Party test2Party3 = new Party("TestParty3","TestLeader3",300);
		ArrayList<Party> parties2 = new ArrayList<Party>();
		int threshold2 =6;
		int votes2 = 601;
		int seats2 = 10;

		parties2.add(test2Party1);
		parties2.add(test2Party2);
		parties2.add(test2Party3);

		test2Vote = new Vote(parties2,threshold2,votes2,seats2);
		assertFalse(testVote.equals(test2Vote));
		logger.debug("Vote has been successfully tested.");
	}


	@Test
	public void testEqualsFalse2() {
		Vote test2Vote= new Vote();
		Party test2Party1 = new Party("TestParty1","TestLeader1",101);
		Party test2Party2 = new Party("TestParty2","TestLeader2",201);
		Party test2Party3 = new Party("TestParty3","TestLeader3",301);
		ArrayList<Party> parties2 = new ArrayList<Party>();
		int threshold2 =2;
		int votes2 = 600;
		int seats2 = 10;

		parties2.add(test2Party1);
		parties2.add(test2Party2);
		parties2.add(test2Party3);

		test2Vote = new Vote(parties2,threshold2,votes2,seats2);
		assertFalse(testVote.equals(test2Vote));
		logger.debug("Vote has been successfully tested.");
	}


	@Test
	public void testEqualsFalse3() {
		Vote test2Vote= new Vote();
		Party test2Party1 = new Party("TestParty1","TestLeader1",100);
		Party test2Party2 = new Party("TestParty2","TestLeader2",200);
		Party test2Party3 = new Party("TestParty3","TestLeader3",300);
		ArrayList<Party> parties2 = new ArrayList<Party>();
		int threshold2 =56;
		int votes2 = 603;
		int seats2 = 10234;

		parties2.add(test2Party1);
		parties2.add(test2Party2);
		parties2.add(test2Party3);

		test2Vote = new Vote(parties2,threshold2,votes2,seats2);

		assertFalse(testVote.equals(test2Vote));
		logger.debug("Vote has been successfully tested.");
	}

}
