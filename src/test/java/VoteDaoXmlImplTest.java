/**
 *
 */


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

/**
 * @author ikasza
 *
 */
public class VoteDaoXmlImplTest {
	//http://howtodoinjava.com/junit/junit-creating-temporary-filefolder-using-temporaryfolder-rule/
	private static Logger logger = LoggerFactory.getLogger("test");

	@Rule
	public TemporaryFolder tempOutFolder = new TemporaryFolder();

	Vote vote = new Vote();
	VoteDaoXmlImpl xmlreaderWriter = new VoteDaoXmlImpl();

	String inputFileName = "test.xml";
	String outputFileName ="testOutput.xml";

	ClassLoader classLoader = getClass().getClassLoader();
	File testInputFile = new File(classLoader.getResource(inputFileName).getFile());
	//File testOutputFile = new File(classLoader.getResource(outputFileName).getFile());


	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.debug("VoteDaoXmlImpl test has been started.");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.debug("VoteDaoXmlImpl test has been finished.");
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
	 * Test method for {@link model.VoteDaoXmlImpl#saveVote(model.Vote, java.io.File)}.
	 */
	@Test
	public final void testSaveVote() {

		File testOutputFile = new File(outputFileName);

		Vote outputVote = xmlreaderWriter.loadVote(testInputFile);
		xmlreaderWriter.saveVote(outputVote,testOutputFile);

		Vote inputVote = xmlreaderWriter.loadVote(testOutputFile);

		assertTrue(outputVote.getThreshold() == inputVote.getThreshold());
		logger.debug("testSaveVote has been successfully tested.");

	}

	/**
	 * Test method for {@link model.VoteDaoXmlImpl#loadVote(java.io.File)}.
	 */
	@Test
	public final void testLoadVote() {

		vote = xmlreaderWriter.loadVote(testInputFile);
		assertNotNull(vote);
		logger.debug("testLoadVote has been successfully tested.");

	}

	/**
	 * Test method for {@link model.VoteDaoXmlImpl#VoteDaoXmlImpl()}.
	 */
	@Test
	public final void testVoteDaoXmlImpl() {
		VoteDaoXmlImpl test = new VoteDaoXmlImpl();
		assertNotNull(test);
		logger.debug("testVoteDaoXmlImpl has been successfully tested.");

	}

}
