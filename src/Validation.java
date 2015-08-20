/* Program for Data entry by asv130130 (Name:- AMOL VAZE )*/
// Code for validating email address being entered into textfield 
public class Validation {

	public static boolean isValidEmailAddress(String email) {
		boolean value = true;
		String valueString = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
		String laxString = ".+@.+\\.[A-Za-z]{2}[A-Za-z]*";
		String emailRegex = value ? valueString : laxString;
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(emailRegex);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

}