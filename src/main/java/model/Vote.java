package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Represents a vote with a list of parties {@code party}, the threshold value {@code threshold}, the number of all the votes of the parties {@code allCount} and the number of the mandates should allocated to {@code allSeats}.
 * @author ikasza
 *
 */
@XmlRootElement
@XmlType(propOrder = { "parties", "threshold", "allCount", "allSeats" })
public class Vote {

	/**
	 * The list of the parties of this vote.
	 */
	private ArrayList<Party> party;
	/**
	 * The actual threshold of this vote.
	 */
	private int threshold;
	/**
	 * How many counts all the parties have in this vote..
	 */
	private int allCount;
	/**
	 * The amount of the mandates which should be allocated.
	 */
	private int allSeats;


	/**
	 * Gets the list of {@code parties}.
	 * @return The list of parties.
	 */
	@XmlElementWrapper(name = "PartiesList")
	public ArrayList<Party> getParties() {
		return party;
	}


	/**
	 * Sets the list of {@code parties}.
	 * @param parties Set the actual value of the list of the parties of this vote to the value of {@code parties}.
	 */
	public void setParties(ArrayList<Party> parties) {
		this.party = parties;
	}

	/**
	 * Gets the value of the {@code threshold}.
	 * @return The value of the {@code threshold}.
	 */
	public int getThreshold() {
		return threshold;
	}

	/**
	 * Sets the value of the {@code threshold}.
	 * @param threshold Set the actual value of the threshold to the value of {@code threshold}.
	 */
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	/**
	 * Gets the value of the {@code allCount}.
	 * @return The value of the {@code allCount}.
	 */
	public int getAllCount() {
		return allCount;
	}

	/**
	 * Sets the value of the {@code allCount}.
	 * @param allCount Set the actual value of the number of the votes to the value of {@code allCount}.
	 */
	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}


	/**
	 * Gets the value of the {@code seats}.
	 * @return The value of the mandates to be allocated.
	 */
	public int getAllSeats() {
		return allSeats;
	}


	/**
	 * Sets the value of the {@code seats}.
	 * @param seats Set the actual value of the number of the mandates to be allocated to the value of {@code seats}.
	 */
	public void setAllSeats(int seats) {
		this.allSeats = seats;
	}


	/**
	 * Constructor which creates a vote from the given parameters.
	 * @param parties List of parties.
	 * @param threshold What is the threshold that must be passed by a party to get mandates.
	 * @param allCount The amount of votes that all party received in the list of parties.
	 * @param seats The number of mandates to be allocated.
	 */
	public Vote(ArrayList<Party> parties, int threshold, int allCount, int seats) {
		super();
		this.party = parties;
		this.threshold = threshold;
		this.allCount = allCount;
		this.allSeats = seats;
	}

	/**
	 * Default constructor.
	 */
	public Vote() {
		super();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vote [party=" + party + ", threshold=" + threshold + ", allCount=" + allCount + ", seats=" + allSeats
				+ "]";
	}

	/**
	 * Decides whether the given parameter is identical with actual vote or not.
	 * @param v Input vote.
	 * @return result The method returns {@code TRUE} when {@code v} identical with this one. In other case it returns {@code FALSE}.
	 */
	public boolean equals(Vote v){
		boolean result = false;

		if(this.threshold == v.getThreshold() && this.allCount == v.getAllCount() && this.allSeats == v.getAllSeats()){

			List<Party> thisParties = new ArrayList<Party>(this.getParties());
			List<Party> paramParties = new ArrayList<Party>(v.getParties());

			Collections.sort(thisParties, new PartyComparator());
			Collections.sort(paramParties, new PartyComparator());


			for(int i = 0; i < thisParties.size(); i++){
				if(  (thisParties.get(i).getName().equals(paramParties.get(i).getName()))  && (thisParties.get(i).getLeader().equals(paramParties.get(i).getLeader()))  && (thisParties.get(i).getVoteCount() == paramParties.get(i).getVoteCount()) ){
					result=true;
				}
				else{
					result=false;
				}
			}

		}

		return result;
	}

}
/**
 * Unnamed class which implements a comparator to compare two parties.
 *
 */
class PartyComparator implements Comparator<Party> {
	/**
	 * Compares two prties lexicographically.
	 * @param party1 A party as an imput.
	 * @param party2 A party as an imput.
	 * @return value The value 0 if the argument is a string lexicographically equal to this string; a value less than 0 if the argument is a string lexicographically greater than this string; and a value greater than 0 if the argument is a string lexicographically less than this string.
	 */
	public int compare(Party party1, Party party2) {
		return party1.getName().compareTo(party2.getName());
	}
}
