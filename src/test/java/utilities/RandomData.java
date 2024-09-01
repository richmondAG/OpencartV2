package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {
	
	public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
	
	
	public String fullname() {
		 String aph=RandomStringUtils.randomAlphabetic(8);	
		 return capitalizeFirstLetter(aph);
	}
	
	public String email() {
		String emailS= capitalizeFirstLetter(RandomStringUtils.randomAlphabetic(6));	
		String emailN= RandomStringUtils.randomNumeric(2);	
		return(emailS+emailN+"@gmail.com");
	}
	
	public String telephone() {
		return RandomStringUtils.randomNumeric(10);		
	}
	
	public String password() {
		String passwordS= RandomStringUtils.randomAlphabetic(6);	
		String passwordN= RandomStringUtils.randomNumeric(2);	
		return(passwordS+passwordN+"@$");
	}
}
