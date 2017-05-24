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

import controller.VoteDataValidator;

/**
 * @author ikasza
 *
 */
public class VoteDataValidatorTest {

	private VoteDataValidator testValidator =  new VoteDataValidator();

	private static Logger logger = LoggerFactory.getLogger("test");

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.debug("VoteDataValidator test has been started.");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.debug("VoteDataValidator test has been finished.");
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
	 * Test method for {@link controller.VoteDataValidator#isValid(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testIsValid() {
		String jala = "47000";
		String haba = "16000";
		String redSav = "47000";
		String moruga = "16000";
		String carolina = "47000";
		String chipotle = "16000";
		String mandates = "10";
		String threshold = "2";

		assertTrue(testValidator.isValid(jala,haba,redSav,moruga,carolina, chipotle,mandates,threshold));

		String errorMessage = testValidator.getErrorMessage();

		assertTrue(errorMessage.length() == 0);
		logger.debug("isValid has been succssfully tested.");
	}

	/**
	 * Test method for {@link controller.VoteDataValidator#isValid(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testIsValidFalse() {
		String jala = "";
		String haba = "16000";
		String redSav = "47000";
		String moruga = "16000";
		String carolina = "47000";
		String chipotle = "16000";
		String mandates = "10";
		String threshold = "2";

		assertFalse(testValidator.isValid(jala,haba,redSav,moruga,carolina, chipotle,mandates,threshold));
		String errorMessage = testValidator.getErrorMessage();

		assertTrue(errorMessage.length() != 0);
		logger.debug("isValidFalse has been succssfully tested.");
	}

	/**
	 * Test method for {@link controller.VoteDataValidator#isValid(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testIsValidFalse2() {
		String expectedErrorMessage = "No valid input for Jalapeno (must be an integer)!\n";
		String jala = "FUBAR";
		String haba = "16000";
		String redSav = "47000";
		String moruga = "16000";
		String carolina = "47000";
		String chipotle = "16000";
		String mandates = "10";
		String threshold = "2";

		assertFalse(testValidator.isValid(jala,haba,redSav,moruga,carolina, chipotle,mandates,threshold));
		String actualErrorMessage = testValidator.getErrorMessage();

		assertTrue(actualErrorMessage.length() != 0);
		assertTrue(expectedErrorMessage.equals(actualErrorMessage));
		logger.debug("isValidFalse2 has been succssfully tested.");
	}

	/**
	 * Test method for {@link controller.VoteDataValidator#isValid(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testIsValidFalse3() {
		String expectedErrorMessage = "No valid input for Jalapeno (must be an integer)!\n";
		String jala = "FUBAR";
		String haba = "FUBAR";
		String redSav = "FUBAR";
		String moruga = "FUBAR";
		String carolina = "FUBAR";
		String chipotle = "FUBAR";
		String mandates = "FUBAR";
		String threshold = "FUBAR";

		assertFalse(testValidator.isValid(jala,haba,redSav,moruga,carolina, chipotle,mandates,threshold));
		String actualErrorMessage = testValidator.getErrorMessage();

		assertTrue(actualErrorMessage.length() != 0);
		//assertTrue(expectedErrorMessage.equals(actualErrorMessage));
		logger.debug("isValidFalse3 has been succssfully tested.");
	}

	/**
	 * Test method for {@link controller.VoteDataValidator#isValid(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testIsValidFalse4() {
		String expectedErrorMessage = "No valid input for Jalapeno (must be an integer)!\n";
		String jala = "";
		String haba = "";
		String redSav = "";
		String moruga = "";
		String carolina = "";
		String chipotle = "";
		String mandates = "";
		String threshold = "";

		assertFalse(testValidator.isValid(jala,haba,redSav,moruga,carolina, chipotle,mandates,threshold));
		String actualErrorMessage = testValidator.getErrorMessage();

		assertTrue(actualErrorMessage.length() != 0);
		//assertTrue(expectedErrorMessage.equals(actualErrorMessage));
		logger.debug("isValidFalse4 has been succssfully tested.");
	}

	/**
	 * Test method for {@link controller.VoteDataValidator#getErrorMessage()}.
	 */
	@Test
	public final void testGetErrorMessage() {
		String expectedErrorMessage = "No valid input for Jalapeno!\n";
		String jala = "";
		String haba = "16000";
		String redSav = "47000";
		String moruga = "16000";
		String carolina = "47000";
		String chipotle = "16000";
		String mandates = "10";
		String threshold = "2";

		Boolean result = testValidator.isValid(jala,haba,redSav,moruga,carolina, chipotle,mandates,threshold);

		String actualErrorMessage = testValidator.getErrorMessage();
		assertTrue(expectedErrorMessage.equals(actualErrorMessage));
		logger.debug("getErrorMessage has been succssfully tested.");

	}

	/**
	 * Test method for {@link controller.VoteDataValidator#getErrorMessage()}.
	 */
	@Test
	public final void testGetErrorMessage2() {
		String expectedErrorMessage = "No valid input for Jalapeno (must be an integer)!\n";
		String jala = "FUBAR";
		String haba = "16000";
		String redSav = "47000";
		String moruga = "16000";
		String carolina = "47000";
		String chipotle = "16000";
		String mandates = "10";
		String threshold = "2";

		Boolean result = testValidator.isValid(jala,haba,redSav,moruga,carolina, chipotle,mandates,threshold);

		String actualErrorMessage = testValidator.getErrorMessage();
		assertTrue(expectedErrorMessage.equals(actualErrorMessage));
		logger.debug("getErrorMessage2 has been succssfully tested.");
	}

	/**
	 * Test method for {@link controller.VoteDataValidator#getErrorMessage()}.
	 */
	@Test
	public final void testGetErrorMessageThresholdBelow100() {

		String jala = "47000";
		String haba = "16000";
		String redSav = "47000";
		String moruga = "16000";
		String carolina = "47000";
		String chipotle = "16000";
		String mandates = "99";
		String threshold = "2";

		Boolean result = testValidator.isValid(jala,haba,redSav,moruga,carolina, chipotle,mandates,threshold);

		String actualErrorMessage = testValidator.getErrorMessage();
		assertTrue(actualErrorMessage.length() == 0);
		logger.debug("getErrorMessageThresholdBelow100 has been succssfully tested.");
	}

	/**
	 * Test method for {@link controller.VoteDataValidator#getErrorMessage()}.
	 *
	 */
	@Test
	public final void testGetErrorMessageThresholdIs100() {
		String expectedErrorMessage = "No valid input for Threshold!\n";
		String jala = "47000";
		String haba = "16000";
		String redSav = "47000";
		String moruga = "16000";
		String carolina = "47000";
		String chipotle = "16000";
		String mandates = "10";
		String threshold = "100";

		Boolean result = testValidator.isValid(jala,haba,redSav,moruga,carolina, chipotle,mandates,threshold);

		String actualErrorMessage = testValidator.getErrorMessage();

		assertTrue(expectedErrorMessage.equals(actualErrorMessage));
		logger.debug("getErrorMessageThresholdIs100 has been succssfully tested.");
	}

}
