/**
 * Test suit for all the tests.
 *
 * @author ikasza
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)

@Suite.SuiteClasses({
   VoteTest.class ,PartyTest.class, MandateCalculatorImplTest.class, MandateForVoteTest.class, VoteDataValidatorTest.class, ChartFactoryTest.class, VoteDaoXmlImplTest.class
})

public class TestSuite {

}
