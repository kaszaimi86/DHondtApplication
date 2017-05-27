package controller;

/**
 * This is a validator to decide wether the given input from the GUI is okay or not.
 * @author ikasza
 *
 */

public class VoteDataValidator {

	/**
	 * This {@code errorMessage} will contain a message for the user about which field contains invalid data.
	 */
	String errorMessage;


	/**
	 * This method decides wether the given input is valid or not.
	 *
	 * @param jala Number of votes of Jalapeno Party.
	 * @param haba Number of votes of Habanero Party.
	 * @param redSav Number of votes of Red Savina Party.
	 * @param moruga Number of votes of Moruga Scorpion Party.
	 * @param carolina Number of votes of Carolina Reaper Party.
	 * @param chipotle Number of votes of Chipotle Party.
	 * @param mandates Number of mandates to be allocated.
	 * @param threshold The value of Threshold in %.
	 * @return true or false If the input is valid then true, else false.
	 */
	public boolean isValid(String jala,String haba, String redSav, String moruga, String carolina, String chipotle, String mandates, String threshold){
		errorMessage = "";
		int tempValue;

		if (jala == null || jala.length() == 0) {
            errorMessage += "No valid input for Jalapeno!\n";
        } else {
            try {
                tempValue = Integer.parseInt(jala);
                if(tempValue < 0){
                	errorMessage += "Jalapeno must be a positive number.\n";
                }
            } catch (NumberFormatException e) {
                errorMessage += "No valid input for Jalapeno (must be an integer)!\n";
            }
        }

    	if (haba == null || haba.length() == 0) {
            errorMessage += "No valid input for Habanero!\n";
        } else {
            try {
            	tempValue = Integer.parseInt(haba);
                if(tempValue < 0){
                	errorMessage += "Habanero must be a positive number.\n";
                }
            } catch (NumberFormatException e) {
                errorMessage += "No valid input for Habanero (must be an integer)!\n";
            }
        }

    	if (redSav == null || redSav.length() == 0) {
            errorMessage += "No valid input for Red Savina!\n";
        } else {
            try {
            	tempValue = Integer.parseInt(redSav);
                if(tempValue < 0){
                	errorMessage += "Red Savina must be a positive number.\n";
                }
            } catch (NumberFormatException e) {
                errorMessage += "No valid input for Red Savina (must be an integer)!\n";
            }
        }

    	if (moruga == null || moruga.length() == 0) {
            errorMessage += "No valid input for Moruga Scorpion!\n";
        } else {
            try {
            	tempValue = Integer.parseInt(moruga);
                if(tempValue < 0){
                	errorMessage += "Moruga Scorpion must be a positive number.\n";
                }
            } catch (NumberFormatException e) {
                errorMessage += "No valid input for Moruga Scorpion (must be an integer)!\n";
            }
        }

    	if (carolina == null || carolina.length() == 0) {
            errorMessage += "No valid input for Carolina Reaper!\n";
        } else {

            try {
            	tempValue = Integer.parseInt(carolina);
                if(tempValue < 0){
                	errorMessage += "Carolina Reaper must be a positive number.\n";
                }
            } catch (NumberFormatException e) {
                errorMessage += "No valid input for Carolina Reaper (must be an integer)!\n";
            }
        }

    	if (mandates == null || mandates.length() == 0) {
            errorMessage += "No valid input for Mandates!\n";
        } else {
            try {
            	tempValue = Integer.parseInt(mandates);
                if(tempValue < 0){
                	errorMessage += "Mandates must be a positive number.\n";
                }
            } catch (NumberFormatException e) {
                errorMessage += "No valid input for Mandates (must be an integer)!\n";
            }
        }

    	if (threshold == null || threshold.length() < 1 || threshold.length() > 2) {
            errorMessage += "No valid input for Threshold!\n";
        } else {

            try {
            	tempValue = Integer.parseInt(threshold);
                if(tempValue < 0){
                	errorMessage += "Threshold must be a positive number.\n";
                }
            } catch (NumberFormatException e) {
                errorMessage += "No valid input for Threshold (must be an integer)!\n";
            }
        }

    	if (chipotle == null || chipotle.length() == 0) {
            errorMessage += "No valid input for Chipotle!\n";
        } else {

            try {
            	tempValue = Integer.parseInt(chipotle);
                if(tempValue < 0){
                	errorMessage += "Chipotle must be a positive number.\n";
                }
            } catch (NumberFormatException e) {
                errorMessage += "No valid input for Chipotle (must be an integer)!\n";
            }
        }

    	if(errorMessage.length() == 0){
    		return true;
    	}else{
    		return false;
    	}

	}

	/**
	 * Returns the error message of this validator.
	 * @return errorMessage This string contains the error message or {@code null}, if ther is no erre message. {@code null} means that the input is okay.
	 */
	public String getErrorMessage() {
		return errorMessage;
	}



}
