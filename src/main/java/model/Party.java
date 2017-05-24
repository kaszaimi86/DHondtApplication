package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a party of a vote.
 * @author ikasza
 *
 */
@XmlRootElement(name = "party")
public class Party {
	/**
	 * Name of the party.
	 */
	private String name;
	/**
	 * Leader of the party.
	 */
	private String leader;
	/**
	 * How many votes the party has.
	 */
	private int voteCount;

	/**
	 * Constructor to create a party.
	 * @param name Name of the party.
	 * @param leader Leader of the party.
	 * @param voteCount the number of votes given to the party.
	 */
	public Party(String name, String leader, int voteCount) {
		super();
		this.name = name;
		this.leader = leader;
		this.voteCount = voteCount;
	}

	/**
	 * Default constructor.
	 */
	public Party() {
		super();
	}

	/**
	 * Gets the name of a party.
	 * @return The name of this party.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of a party.
	 * @param name Set the actual value of name to the value of {@code name}
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the leader of a party.
	 * @return The leader of this party.
	 */
	public String getLeader() {
		return leader;
	}

	/**
	 * Sets the leader of a party.
	 * @param leader Set the actual value of leader to the value of {@code leader}.
	 */
	public void setLeader(String leader) {
		this.leader = leader;
	}

	/**
	 * Gets the amount of votes given to a party.
	 * @return The amount of votes given to this party.
	 */
	public int getVoteCount() {
		return voteCount;
	}

	/**
	 * Sets the amount of votes given to a party.
	 * @param voteCount Set the actual value of the number of the votes to the value of {@code voteCount}.
	 */
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Datas of the party [name=" + name + ", leader=" + leader + ", voteCount=" + voteCount + "]";
	}

	/**
	 * Decides whether the given parameter is identical with actual party or not.
	 * @param p Input party.
	 * @return result The method returns {@code TRUE} when {@code p} identical with this one. In other case it returns {@code FALSE}.
	 */
	public boolean equals(Party p){
		boolean result = false;
		if( this.name.equals(p.getName()) && this.leader.equals(p.getLeader()) && this.voteCount == p.getVoteCount()){
			result = true;
		}
		return result;
	}


}
