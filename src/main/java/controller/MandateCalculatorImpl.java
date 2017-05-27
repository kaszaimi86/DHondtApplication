package controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.apache.log4j.Logger;

import model.MandateForVote;
import model.Vote;
import model.Party;

/**
 * Class for a calculator which implements the D'Hondt method.
 * @author ikasza
 *
 */
public class MandateCalculatorImpl implements MandateCalculator {

	/**
	 * Info Logger for this class.
	 */
	private static Logger infoLogger = LoggerFactory.getLogger("info");


	/**
	 * Implements a calculator. The implementation is based on the D'Hondt method. The D'Hondt method is a highest averages method for
	 * allocating seats, and is thus a type of party-list proportional representation.
	 * Proportional representation systems aim to allocate seats to parties approximately in proportion to the number of votes received.
	 * For example, if a party wins one-third of the votes then it should gain about one-third of the seats. In general, exact proportionality
	 * is not possible because these divisions produce fractional numbers of seats. As a result, several methods, of which the D'Hondt method
	 * is one, have been devised which ensure that the parties' seat allocations, which are of course whole numbers, are as proportional as possible.
	 * D'Hondt slightly favours large parties and coalitions over scattered small parties.
	 * After all the votes have been tallied, successive quotients are calculated for each party. The formula for the quotient is: {@code quout = V/(s+1)}
	 * where: {@code V} is the total number of votes that party received, and {@code s} is the number of seats that party has been allocated so far,
	 * initially 0 for all parties. The total votes cast for each party in the electoral district is divided, first by 1, then by 2, then 3,
	 * up to the total number of seats to be allocated for the district/constituency. Say there are {@code p} parties and {@code s} seats. Then a grid of
	 * numbers can be created, with {@code p} rows and {@code s} columns, where the entry in the {@code i}th row and {@code j}th column is the number of votes won by the
	 * {@code i}th party, divided by {@code j}. The {@code s} winning entries are the {@code s} highest numbers in the whole grid; each party is given as many seats as
	 * there are winning entries in its row.
     *
     * @param vote The calculator calculates the mandates based on the {@code vote} parameter.
     * @return resMandate A MandateForVote instance which contains the calculated mandates for each party.
	 * @see controller.MandateCalculator#calculator(model.Vote)
	 */

	public MandateForVote calculator(Vote vote) {

		MandateForVote resMandate;
		HashMap<String,Integer> partyNameAndVotesOriginal = new HashMap<String,Integer>();
		HashMap<String,Integer> forCalculation = new HashMap<String,Integer>();
		HashMap<String,Integer> result = new HashMap<String,Integer>();

		for (Party p : vote.getParties()){
			double value = (((double)p.getVoteCount() / (double)vote.getAllCount())*100);
			if(value >= vote.getThreshold()){
				partyNameAndVotesOriginal.put(p.getName(),p.getVoteCount());
				forCalculation.put(p.getName(),p.getVoteCount());
				result.put(p.getName(),0);
				infoLogger.info(p.getName()+" has reached the threshold.");
				infoLogger.info(p.getName()+" has reached "+value+" % of the votes");
			}else{
				infoLogger.info(p.getName()+" has NOT reached the threshold.");
				infoLogger.info(p.getName()+" has reached "+value+" % of the votes");

			}
		}


		String maxKey = null;
		for(int i=1; i <= vote.getAllSeats(); i++ )
		{
			maxKey = maxKey(forCalculation);
			result.put(maxKey,result.get(maxKey)+1);
			forCalculation.put(maxKey,(partyNameAndVotesOriginal.get(maxKey)/(result.get(maxKey)+1)));
		}

		resMandate = new MandateForVote(result);
		return resMandate;
	}

	/**
	 * Gives back the key of the biggest element from a HashMap.
	 * @param hashMap A list of parties and the mandates related to a party.
	 * @return The key (the name of a party) of the element which has the maximum value.
	 */
	public String maxKey(HashMap<String,Integer> hashMap){
		String maxKey = null;
		int maxValue = 0;

		for(String key : hashMap.keySet()){
			if (hashMap.get(key) > maxValue){
				maxValue = hashMap.get(key);
				maxKey = key;
			}

		}

		return maxKey;
	}

	/**
	 * Default constructor.
	 */
	public MandateCalculatorImpl() {
		super();

	}



}
