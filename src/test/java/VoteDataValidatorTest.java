import static org.junit.Assert.*;


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


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		logger.debug("****************************************");
		logger.debug("VoteDataValidator test has been started.");
	}


	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		logger.debug("VoteDataValidator test has been finished.");
	}


	@Before
	public void setUp() throws Exception {
	}


	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testIsValid() {
		String jala = "47000";
		String haba = "16000";
		String redSav = "15900";
		String moruga = "12000";
		String carolina = "6000";
		String chipotle = "3";
		String mandates = "10";
		String threshold = "2";

		assertTrue(testValidator.isValid(jala,haba,redSav,moruga,carolina, chipotle,mandates,threshold));
		String errorMessage = testValidator.getErrorMessage();
		assertTrue(errorMessage.length() == 0);
		logger.debug("isValid has been succssfully tested.");
	}


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


	@Test
	public final void testIsValidFalseInteger() {
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
		logger.debug("isValidFalseInteger has been succssfully tested.");
	}


	@Test
	public final void testIsValidFalsePositive() {

		String jala = "-47000";
		String haba = "-16000";
		String redSav = "-15900";
		String moruga = "-12000";
		String carolina = "-6000";
		String chipotle = "-3";
		String mandates = "-10";
		String threshold = "-2";

		assertFalse(testValidator.isValid(jala,haba,redSav,moruga,carolina, chipotle,mandates,threshold));
		String actualErrorMessage = testValidator.getErrorMessage();
		assertTrue(actualErrorMessage.length() != 0);
		logger.debug("isValidFalsePositive has been succssfully tested.");
	}

	@Test
	public final void testIsValidFalseAllInteger() {

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
		logger.debug("isValidFalseAllInteger has been succssfully tested.");
	}


	@Test
	public final void testIsValidFalseAllNull() {

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

		logger.debug("isValidFalseAllNull has been succssfully tested.");
	}


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
		System.out.println(result);
		assertFalse(result);
		assertTrue(expectedErrorMessage.equals(actualErrorMessage));
		logger.debug("getErrorMessage has been succssfully tested.");

	}


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
		System.out.println(result);
		assertFalse(result);
		assertTrue(expectedErrorMessage.equals(actualErrorMessage));
		logger.debug("getErrorMessage2 has been succssfully tested.");
	}


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
		System.out.println(result);
		assertTrue(result);
		assertTrue(actualErrorMessage.length() == 0);
		logger.debug("getErrorMessageThresholdBelow100 has been succssfully tested.");
	}


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
		System.out.println(result);
		assertFalse(result);
		assertTrue(expectedErrorMessage.equals(actualErrorMessage));
		logger.debug("getErrorMessageThresholdIs100 has been succssfully tested.");
	}

	@Test
	public final void testGetErrorMessageThresholdIsNOtValid() {
		String expectedErrorMessage = "No valid input for Threshold (must be an integer)!\n";
		String jala = "47000";
		String haba = "16000";
		String redSav = "47000";
		String moruga = "16000";
		String carolina = "47000";
		String chipotle = "16000";
		String mandates = "10";
		String threshold = "_";

		Boolean result = testValidator.isValid(jala,haba,redSav,moruga,carolina, chipotle,mandates,threshold);

		String actualErrorMessage = testValidator.getErrorMessage();
		System.out.println(result);
		assertFalse(result);
		assertTrue(expectedErrorMessage.equals(actualErrorMessage));
		logger.debug("getErrorMessageThresholdIsNOtValid has been succssfully tested.");
	}

}
