package model;

import java.io.File;

/**
 * An interface which specifies the methods which should be use to save/load votes to/from file.
 * @author ikasza
 *
 */
public interface VoteDAO {

	/**
	 * Saves a vote to a given file.
	 * @param vote The content of this parameter will be saved into file
	 * @param file Destination where the content will be saved
	 */
	public void saveVote(Vote vote, File file);

	/**
	 * Loads the content of the file into a vote.
	 * @param file The content of this will be loaded
	 * @return the Content of the file as a vote
	 */
	public Vote loadVote(File file);

}
