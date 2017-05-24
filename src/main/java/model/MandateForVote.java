package model;


import java.util.HashMap;

/**
 * Represents an object which contains the name of the parties and the number of mandates of each party earned.
 * The number of mandates related to the parties.
 * Only those parties are represented which have the amount of votes which is more than the given threshold.
 * @author ikasza
 *
 */
public class MandateForVote {

	/**
	 * List of parties with their mandates.
	 */
	private HashMap<String, Integer> mandates = new HashMap<String,Integer>();

	/**
	 * Constructor to create a MandateForVote.
	 * @param mandates List of parties with their mandates.
	 */
	public MandateForVote(HashMap<String, Integer> mandates) {
		super();
		this.mandates = mandates;
	}

	/**
	 * Default constructor.
	 */
	public MandateForVote() {
		super();

	}

	/**
	 * Gets the list of given mandates related to each parties.
	 * @return The list of parties with their mandates.
	 */
	public HashMap<String, Integer> getMandates() {
		return mandates;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MandateForVote [mandates=" + mandates + "]";
	}




}
