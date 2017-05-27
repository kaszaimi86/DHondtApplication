
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Vote;
import model.VoteDaoXmlImpl;


public class VoteDaoXmlImplTest {

	private static Logger logger = LoggerFactory.getLogger("test");

	@Rule
	public TemporaryFolder tempOutFolder = new TemporaryFolder();

	Vote vote = new Vote();
	VoteDaoXmlImpl xmlreaderWriter = new VoteDaoXmlImpl();

	String inputFileName = "test.xml";
	String inputJAXBErrorFileName = "bad_jaxberror_test.xml";
	String inputNotValidFileName= "bad_invalid_input.xml";


	ClassLoader classLoader = getClass().getClassLoader();
	File testInputFile = new File(classLoader.getResource(inputFileName).getFile());
	File testInputJAXBErrorFile = new File(classLoader.getResource(inputJAXBErrorFileName).getFile());
	File testInputNotValidErrorFile = new File(classLoader.getResource(inputNotValidFileName).getFile());

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.debug("*************************************");
		logger.debug("VoteDaoXmlImpl test has been started.");
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.debug("VoteDaoXmlImpl test has been finished.");
	}

	@Before
	public void setUp() throws Exception {
	}


	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSaveVote() throws IOException {

		File testOutputFile = tempOutFolder.newFile("testOutput.xml");

		Vote outputVote = xmlreaderWriter.loadVote(testInputFile);
		xmlreaderWriter.saveVote(outputVote,testOutputFile);

		Vote inputVote = xmlreaderWriter.loadVote(testOutputFile);

		assertTrue(outputVote.getThreshold() == inputVote.getThreshold());
		logger.debug("testSaveVote has been successfully tested.");

	}


	@Test
	public final void testLoadVote() {

		vote = xmlreaderWriter.loadVote(testInputFile);
		assertNotNull(vote);
		logger.debug("testLoadVote has been successfully tested.");

	}

	@Test(expected=NullPointerException.class)
	public final void testLoadVoteJAXBError() {
		vote = xmlreaderWriter.loadVote(testInputJAXBErrorFile);
		assertNull(vote.toString());
		logger.debug("testLoadVoteJAXBError has been successfully tested.");
	}

	@Test
	public final void testLoadVoteInputError() {
		vote = xmlreaderWriter.loadVote(testInputNotValidErrorFile);
		assertNotNull(vote.toString());
		logger.debug("testLoadVoteJAXBError has been successfully tested.");
	}


	@Test
	public final void testVoteDaoXmlImpl() {
		VoteDaoXmlImpl test = new VoteDaoXmlImpl();
		assertNotNull(test);
		logger.debug("testVoteDaoXmlImpl has been successfully tested.");
	}

}
