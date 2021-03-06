package model;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Implements the VoteDAO interface.
 * @author ikasza
 *
 */
public class VoteDaoXmlImpl implements VoteDAO {

	/**
	 * Info Logger for this class.
	 */
	private static Logger infoLogger = LoggerFactory.getLogger("info");
	/**
	 * Error logger for this class.
	 */
	private static Logger errorLogger = LoggerFactory.getLogger("error");



	/**
	 * Saves the content of a vote into an XML file.
	 * @param vote The vote which should be saved.
	 * @param file The given vote should be saved into this file.
	 * @see model.VoteDAO#saveVote(model.Vote, java.io.File)
	 */
	public void saveVote(Vote vote, File file) {

		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Vote.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			infoLogger.info("Save to file: "+file.getAbsolutePath());
			m.marshal(vote, file);
			infoLogger.info("Successsfully saved to file");

		} catch (JAXBException e) {
			errorLogger.error("Unsuccessfully save attempt to file.");
			errorLogger.error("JAXB Error at file write.");
			errorLogger.error(e.getMessage());

		}
	}


	/**
	 * Creates a vote from an XML file.
	 * @param file The vote should be loaded from here
	 * @return vote The method will give back a vote which is loaded from the given file.
	 * @see model.VoteDAO#loadVote(java.io.File)
	 */
	public Vote loadVote(File file) {
		Vote vote = new Vote();
		try {
			JAXBContext context = JAXBContext.newInstance(Vote.class);
			Unmarshaller um = context.createUnmarshaller();
			vote = (Vote) um.unmarshal(file);
			infoLogger.info("Successfully load from file: "+file.getAbsolutePath());
			return vote;
		} catch (JAXBException e) {
			errorLogger.error("Unsuccessfully read attempt from file.");
			errorLogger.error("JAXB Error at file read.");
			errorLogger.error(e.getMessage());
		}

		return null;
	}

	/**
	 * Default controller.
	 */
	public VoteDaoXmlImpl() {
		super();

	}


}
