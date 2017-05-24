package controller;

import model.MandateForVote;
import model.Vote;

/**
 * Interface for a calculator which can determine the number of mandates which should be given to a party based on the number of votes which are given to the party.
 *
 * @author ikasza
 *
 */
public interface MandateCalculator {

    /**
     * Calculates the number of mandates for a party based on the number of votes of the party.
     * @param vote Represents a vote.
     * @return List of the parties and their mandates, represented by a {@code MandatesForVote} entity.
     */
    public MandateForVote calculator(Vote vote);

}
